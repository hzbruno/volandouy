#!/bin/bash

# Moverse a la carpeta tarea1/target
cd CentralServer/target || { echo "La carpeta tarea1/target no existe."; exit 1; }

# Ejecutar el archivo JAR
java -jar tpgr25-master-0.0.1-SNAPSHOT-jar-with-dependencies.jar
