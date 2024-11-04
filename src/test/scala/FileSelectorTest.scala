package com.example

import org.scalatest.funsuite.AnyFunSuite
import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

class FileSelectorTest extends AnyFunSuite {

  test("FileSelector should correctly read and print unique keys and their values from a HOCON file") {
    val input = "src/test/resources/test.conf\n"
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

    assert(output.toString == expectedOutput)
  }
}
