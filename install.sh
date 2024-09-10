#!/bin/bash

# Install Scala
echo "Installing Scala..."
sudo apt-get update
sudo apt-get install -y scala

# Install sbt
echo "Installing sbt..."
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x99E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install -y sbt

# Install com.typesafe.config library
echo "Installing com.typesafe.config library..."
mkdir -p lib
cd lib
curl -L -o typesafe-config.jar https://repo1.maven.org/maven2/com/typesafe/config/1.4.1/config-1.4.1.jar
cd ..

echo "Installation completed."
