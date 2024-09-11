package com.example

import scala.io.StdIn.readLine

object FileSelector {
  def main(args: Array[String]): Unit = {
    println("Please enter the path to the HOCON file you want to read:")
    val filePath = readLine()
    val uniqueKeys = HOCONParser.parseConfig(filePath).toList.sorted

    // Group keys by their prefix after sorting
    val groupedKeys = uniqueKeys.groupBy(_.split("\\.").head).toSeq.sortBy(_._1)

    // ANSI escape codes for colors
    val colors = List("\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m")
    val resetColor = "\u001B[0m"

    groupedKeys.zipWithIndex.foreach { case ((prefix, keys), index) =>
      val color = colors(index % colors.length)
      keys.sorted.foreach { key =>
        val value = HOCONParser.getConfigValue(filePath, key)
        println(s"$color$key: $value$resetColor")
      }
      println() // Add a newline between different groups
    }
  }
}
