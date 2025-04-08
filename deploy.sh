#!/bin/bash

# Définir les répertoire
PROJECT_NAME="ETU003104"
echo $PROJECT_NAME
TEMP_DIR="build"
SOURCE_FOLDER="src"
CLASSES_FOLDER="src/main/webapp/WEB-INF/classes"
LIB_FOLDER="lib"
TOMCAT_DIR=


if [ -d "$TEMP_DIR" ]; then
    rm -r "$TEMP_DIR"
fi

mkdir -p "$TEMP_DIR"

mkdir -p "$CLASSES_FOLDER"

rm -rf "$CLASSES_FOLDER"/*

javac -d "$CLASSES_FOLDER" $(find "$SOURCE_FOLDER" -name "*.java") -cp "$LIB_FOLDER/*"

cp -r "src/main/webapp/." "$TEMP_DIR"

jar -cvf $PROJECT_NAME".war" -C "$TEMP_DIR" .

rm -r $TEMP_DIR
rm /opt/apache-tomcat-10.1.28/webapps/*.war

cp $PROJECT_NAME.war /opt/apache-tomcat-10.1.28/webapps
echo "war file copied to tomcat"

/opt/apache-tomcat-10.1.28/bin/shutdown.sh
/opt/apache-tomcat-10.1.28/bin/startup.sh

firefox localhost:8080/manager