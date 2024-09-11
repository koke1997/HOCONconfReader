package com.example

import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConverters._

object HOCONParser {
  def parseConfig(filePath: String): Set[String] = {
    val config: Config = ConfigFactory.parseFile(new java.io.File(filePath))
    getAllKeys(config).toSet
  }

  private def getAllKeys(config: Config, parentKey: String = ""): Set[String] = {
    config.entrySet().asScala.flatMap { entry =>
      val key = if (parentKey.isEmpty) entry.getKey else s"$parentKey.${entry.getKey}"
      entry.getValue.valueType() match {
        case com.typesafe.config.ConfigValueType.OBJECT =>
          getAllKeys(config.getConfig(entry.getKey), key)
        case _ =>
          Set(key)
      }
    }.toSet
  }

  def getConfigValue(filePath: String, key: String): String = {
    val config: Config = ConfigFactory.parseFile(new java.io.File(filePath))
    config.getString(key)
  }
}
