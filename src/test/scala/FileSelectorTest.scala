package com.example

import org.scalatest.funsuite.AnyFunSuite
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}

class FileSelectorTest extends AnyFunSuite {

  test("FileSelector should correctly read and print unique keys and their values from a HOCON file") {
    // Ensure the test files exist
    val testFilePath = "src/test/resources/test.conf"
    val includedFilePath = "src/test/resources/included.conf"

    val testFile = new File(testFilePath)
    if (!testFile.exists()) {
      testFile.getParentFile.mkdirs()
      testFile.createNewFile()
      import java.nio.file.Files
      import java.nio.file.Paths
      Files.write(Paths.get(testFilePath),
        """included {
          |  settingA = valueA
          |  settingB = valueB
          |}
          |
          |main {
          |  setting1 = value1
          |  setting2 = value2
          |  include required("src/test/resources/included.conf")
          |}
          |""".stripMargin.getBytes)
    }

    val includedFile = new File(includedFilePath)
    if (!includedFile.exists()) {
      includedFile.getParentFile.mkdirs()
      includedFile.createNewFile()
      Files.write(Paths.get(includedFilePath),
        """included {
          |  settingA = valueA_from_included
          |  settingB = valueB_from_included
          |}
          |""".stripMargin.getBytes)
    }

    // Run the FileSelector test
    val input = s"$testFilePath\n"
    System.setIn(new ByteArrayInputStream(input.getBytes))

    val output = new ByteArrayOutputStream()
    Console.withOut(output) {
      FileSelector.main(Array.empty)
    }

    val expectedOutput =
      """Please enter the path to the HOCON file you want to read:
        |included.settingA: valueA
        |included.settingB: valueB
        |main.setting1: value1
        |main.setting2: value2
        |""".stripMargin

    assert(output.toString.trim == expectedOutput.trim)

    // Clean up test files
    testFile.delete()
    includedFile.delete()
  }
}
