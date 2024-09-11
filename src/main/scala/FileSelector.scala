package com.example

import scala.io.StdIn.readLine

object FileSelector {
  def main(args: Array[String]): Unit = {
    println("Please enter the path to the HOCON file you want to read:")
    val filePath = readLine()
    val uniqueKeys = HOCONParser.parseConfig(filePath).toList.sorted
    uniqueKeys.foreach { key =>
      val value = HOCONParser.getConfigValue(filePath, key)
      println(s"$key: $value")
    }
  }
}
