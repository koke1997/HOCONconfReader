package com.example

import org.scalatest.funsuite.AnyFunSuite
import com.typesafe.config.ConfigFactory
import java.io.File

class HOCONParserTest extends AnyFunSuite {

  test("HOCONParser should return all unique keys from a sample Play Framework .conf file") {
    val config = ConfigFactory.parseFile(new File("src/test/resources/test.conf"))
    val uniqueKeys = HOCONParser.parseConfig("src/test/resources/test.conf")

    val expectedKeys = Set(
      "included.settingA",
      "included.settingB",
      "main.setting1",
      "main.setting2"
    )

    val expectedValues = Map(
      "included.settingA" -> "valueA",
      "included.settingB" -> "valueB",
      "main.setting1" -> "value1",
      "main.setting2" -> "value2"
    )

    assert(uniqueKeys == expectedKeys, s"Actual: $uniqueKeys, expected: $expectedKeys")

    expectedKeys.foreach { key =>
      val actualValue = config.getString(key)
      val expectedValue = expectedValues(key)
      assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    }
  }

  test("HOCONParser should correctly parse included configuration files") {
    val config = ConfigFactory.parseFile(new File("src/test/resources/test.conf"))
    val uniqueKeys = HOCONParser.parseConfig("src/test/resources/test.conf")

    val expectedKeys = Set(
      "included.settingA",
      "included.settingB",
      "main.setting1",
      "main.setting2"
    )

    val expectedValues = Map(
      "included.settingA" -> "valueA",
      "included.settingB" -> "valueB",
      "main.setting1" -> "value1",
      "main.setting2" -> "value2"
    )

    assert(uniqueKeys == expectedKeys, s"Actual: $uniqueKeys, expected: $expectedKeys")

    expectedKeys.foreach { key =>
      val actualValue = config.getString(key)
      val expectedValue = expectedValues(key)
      assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    }
  }

  test("HOCONParser should correctly parse a sample Play Framework .conf file") {
    val config = ConfigFactory.parseFile(new File("src/test/resources/test.conf"))
    val uniqueKeys = HOCONParser.parseConfig("src/test/resources/test.conf")

    val expectedKeys = Set(
      "included.settingA",
      "included.settingB",
      "main.setting1",
      "main.setting2"
    )

    val expectedValues = Map(
      "included.settingA" -> "valueA",
      "included.settingB" -> "valueB",
      "main.setting1" -> "value1",
      "main.setting2" -> "value2"
    )

    assert(uniqueKeys == expectedKeys, s"Actual: $uniqueKeys, expected: $expectedKeys")

    expectedKeys.foreach { key =>
      val actualValue = config.getString(key)
      val expectedValue = expectedValues(key)
      assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    }
  }
}
