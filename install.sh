#!/bin/bash

# Install Scala
echo "Installing Scala..."
sudo apt-get update
sudo apt-get install -y scala

# Install sbt
echo "Installing sbt..."
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823
sudo apt-get update
sudo apt-get install -y sbt

# Install com.typesafe.config library
echo "Installing com.typesafe.config library..."
mkdir -p lib
cd lib
curl -L -o typesafe-config.jar https://repo1.maven.org/maven2/com/typesafe/config/1.4.1/config-1.4.1.jar
cd ..

echo "Installation completed."
