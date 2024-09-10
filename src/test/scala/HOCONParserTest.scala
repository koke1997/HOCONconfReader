package com.example

import org.scalatest.funsuite.AnyFunSuite
import com.typesafe.config.ConfigFactory

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
}
