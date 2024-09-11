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

### Running the File Selector

To run the file selector via terminal, follow these steps:

1. Ensure you have Scala installed on your system.
2. Compile the Scala files using `scalac`.
3. Run the `FileSelector` object using `scala`.

```sh
scalac -cp "path/to/typesafe-config.jar" src/main/scala/com/example/HOCONParser.scala src/main/scala/com/example/FileSelector.scala
scala -cp "path/to/typesafe-config.jar:." com.example.FileSelector
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

### Java Installation Instructions

To install the necessary dependencies for Java, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Create a `pom.xml` file in the root directory of your project.
3. Add the following content to the `pom.xml` file:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/POM/4.0.0">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>HOCONconfReader</artifactId>
    <version>0.1</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.typesafe</groupId>
            <artifactId>config</artifactId>
            <version>1.4.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

4. Run `mvn clean install` to download and install the dependencies.

### Python Installation Instructions

To install the necessary dependencies for Python, follow these steps:

1. Ensure you have Python installed on your system.
2. Create a `requirements.txt` file in the root directory of your project.
3. Add the following content to the `requirements.txt` file:

```
pyhocon
```

4. Run `pip install -r requirements.txt` to download and install the dependencies.

### Running the Installation Scripts

To run the installation scripts for Windows and Unix-based systems, follow these steps:

#### Windows

1. Open PowerShell as an administrator.
2. Navigate to the root directory of your project.
3. Run the following command:

```sh
.\install.ps1
```

#### Unix-based Systems

1. Open a terminal.
2. Navigate to the root directory of your project.
3. Run the following command:

```sh
./install.sh
```
