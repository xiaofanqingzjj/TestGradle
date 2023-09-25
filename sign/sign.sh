
#if [ $#  ]

# password tciegxy

inputFile=$1
outputFile=$2
withV2=$3

#v2=false
#
#if [ $3  true ]
#than
#  v2=true
#fi


apkSigner=$ANDROID_HOME/build-tools/25.0.0/apkSigner

echo "input:$inputFile, outputFile:$outputFile"

${apkSigner} sign  --ks xy.keystore --out ${outputFile} -v --v1-signing-enabled true --v2-signing-enabled false ${inputFile}

${apkSigner} verify -v --print-certs ${outputFile}