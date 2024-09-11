package com.example

import com.typesafe.config.{Config, ConfigFactory, ConfigValueType}
import scala.jdk.CollectionConverters._

object HOCONParser {
  def parseConfig(filePath: String): Set[String] = {
    val config = ConfigFactory.parseFile(new java.io.File(filePath))
    config.entrySet().asScala.map(_.getKey).toSet
  }

  def getConfigValue(filePath: String, key: String): String = {
    val config = ConfigFactory.parseFile(new java.io.File(filePath))
    if (config.hasPath(key)) {
      val value = config.getValue(key)
      value.valueType() match {
        case ConfigValueType.STRING => config.getString(key)
        case ConfigValueType.LIST => config.getList(key).unwrapped().toString
        case ConfigValueType.NUMBER => config.getNumber(key).toString
        case ConfigValueType.BOOLEAN => config.getBoolean(key).toString
        case ConfigValueType.OBJECT => config.getObject(key).unwrapped().toString
        case ConfigValueType.NULL => "null"
        case _ => s"Unsupported type: ${value.valueType()}"
      }
    } else {
      s"Key not found: $key"
    }
  }
}
