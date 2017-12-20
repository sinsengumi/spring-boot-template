#!/bin/sh

# 環境の設定
env=${1:-"dev"}
port=${2:-"8080"}

JVM_OPTS="--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED"

# 起動
mvn spring-boot:run -Dspring-boot.run.jvmArguments="${JVM_OPTS} -Dspring.profiles.active=${env} -Dserver.port=${port}"
