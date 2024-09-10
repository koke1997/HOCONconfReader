# HOCONconfReader
Reader for hocon files which iterates trough the folders and returns back the hash map

## HOCON Parser

This project includes a HOCON parser that reads a Play Framework `.conf` file and returns all unique keys.

### Usage

To use the HOCON parser, follow these steps:

1. Add the `com.typesafe.config` library to your project dependencies.
2. Create a Scala object to call the parser.

```scala
import com.example.HOCONParser

object Main extends App {
  val filePath = "path/to/your/application.conf"
  val uniqueKeys = HOCONParser.parseConfig(filePath)
  println(s"Unique keys: ${uniqueKeys.mkString(", ")}")
}
```

### Example

Given the following `application.conf` file:

```
play {
  application {
    name = "example"
    version = "1.0"
  }
  http {
    port = 9000
  }
}
```

The parser will return the following unique keys:

```
play.application.name
play.application.version
play.http.port
```

### Running the Standalone App

To run the standalone app via terminal, follow these steps:

1. Ensure you have Scala installed on your system.
2. Compile the Scala files using `scalac`.
3. Run the `Main` object using `scala`.

```sh
scalac -cp "path/to/typesafe-config.jar" src/main/scala/com/example/HOCONParser.scala src/main/scala/com/example/Main.scala
scala -cp "path/to/typesafe-config.jar:." com.example.Main
```

### Installation

To install the necessary dependencies, follow these steps:

1. Create a `build.sbt` file in the root directory of your project.
2. Add the following content to the `build.sbt` file:

```sbt
name := "HOCONconfReader"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies += "com.typesafe" % "config" % "1.4.1"
```

3. Run `sbt update` to download and install the dependencies.
