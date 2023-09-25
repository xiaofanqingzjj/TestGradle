#!/usr/bin/env bash

if [ $# -lt 1 ]; then
    echo "Usage: sign <input.apk>"
    exit 1
fi

# password tciegxy

inputFile=$1
outputFile="${inputFile%.*}_signed.apk"


if [ -z ${ANDROID_HOME} ]; then #先判断是否有ANDROID_HOME环境变量
    echo "You should set \$ANDROID_HOME env"
    exit 1
fi



apkSigner=$ANDROID_HOME/build-tools/25.0.0/apkSigner

echo "input:$inputFile, outputFile:$outputFile"

${apkSigner} sign  --ks xy.keystore --out ${outputFile} -v --v1-signing-enabled true --v2-signing-enabled false ${inputFile}

# auto input password



${apkSigner} verify ${outputFile}