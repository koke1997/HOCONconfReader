# PowerShell script to install necessary dependencies for Windows systems

# Install Scala
Write-Host "Installing Scala..."
choco install scala -y

# Install sbt
Write-Host "Installing sbt..."
choco install sbt -y

# Install com.typesafe.config library
Write-Host "Installing com.typesafe.config library..."
New-Item -ItemType Directory -Force -Path "lib"
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/com/typesafe/config/1.4.1/config-1.4.1.jar" -OutFile "lib\typesafe-config.jar"

Write-Host "Installation completed."
