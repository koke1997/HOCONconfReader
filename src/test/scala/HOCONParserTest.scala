package com.example

import org.scalatest.funsuite.AnyFunSuite
import com.typesafe.config.ConfigFactory
import java.io.File

class HOCONParserTest extends AnyFunSuite {

  test("HOCONParser should return all unique keys from a sample Play Framework .conf file") {
    println("Starting test: HOCONParser should return all unique keys from a sample Play Framework .conf file")
    val config = ConfigFactory.parseFile(new File("src/test/resources/test.conf"))
    val uniqueKeys = HOCONParser.parseConfig("src/test/resources/test.conf")

    println(s"Unique keys read: $uniqueKeys")

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
      println(s"Asserting key: $key, Actual value: $actualValue, Expected value: $expectedValue")
      assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    }
    println("Finished test: HOCONParser should return all unique keys from a sample Play Framework .conf file")
  }

  test("HOCONParser should correctly parse included configuration files") {
    println("Starting test: HOCONParser should correctly parse included configuration files")
    val config = ConfigFactory.parseFile(new File("src/test/resources/test.conf"))
    val uniqueKeys = HOCONParser.parseConfig("src/test/resources/test.conf")

    println(s"Unique keys read: $uniqueKeys")

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
      println(s"Asserting key: $key, Actual value: $actualValue, Expected value: $expectedValue")
      assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    }
    println("Finished test: HOCONParser should correctly parse included configuration files")
  }

  test("HOCONParser should correctly parse a sample Play Framework .conf file") {
    println("Starting test: HOCONParser should correctly parse a sample Play Framework .conf file")
    val config = ConfigFactory.parseFile(new File("src/test/resources/test.conf"))
    val uniqueKeys = HOCONParser.parseConfig("src/test/resources/test.conf")

    println(s"Unique keys read: $uniqueKeys")

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
      println(s"Asserting key: $key, Actual value: $actualValue, Expected value: $expectedValue")
      assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    }
    println("Finished test: HOCONParser should correctly parse a sample Play Framework .conf file")
  }

  test("HOCONParser should return the correct value for a given key") {
    println("Starting test: HOCONParser should return the correct value for a given key")
    val filePath = "src/test/resources/test.conf"
    val key = "main.setting1"
    val expectedValue = "value1"
    val actualValue = HOCONParser.getConfigValue(filePath, key)
    println(s"Asserting key: $key, Actual value: $actualValue, Expected value: $expectedValue")
    assert(actualValue == expectedValue, s"Actual: $actualValue, expected: $expectedValue")
    println("Finished test: HOCONParser should return the correct value for a given key")
  }
}
