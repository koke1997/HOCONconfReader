package com.example

import org.scalatest.funsuite.AnyFunSuite
import com.typesafe.config.ConfigFactory
import java.io.File

class HOCONParserTest extends AnyFunSuite {

  test("HOCONParser should return all unique keys from a sample Play Framework .conf file") {
    val sampleConfig =
      """
        |play {
        |  application {
        |    name = "example"
        |    version = "1.0"
        |  }
        |  http {
        |    port = 9000
        |  }
        |}
        |""".stripMargin

    val config = ConfigFactory.parseString(sampleConfig)
    val uniqueKeys = HOCONParser.getAllKeys(config)

    val expectedKeys = Set(
      "play.application.name",
      "play.application.version",
      "play.http.port"
    )

    assert(uniqueKeys == expectedKeys)
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

    assert(uniqueKeys == expectedKeys)
  }
}
