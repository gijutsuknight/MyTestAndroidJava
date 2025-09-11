# Android Release

- Please checkout the file ./app/build.gradle -> android -> signingConfigs -> release. Fill in the details for the password.
- The password will be hold by the owner and will not be uploaded in the git.
```
./gradlew clean
./gradlew bundleRelease
./gradlew assembleRelease
```

# Generate Keystore
```agsl
keytool -genkey -v -keystore release.keystore -keyalg RSA -keysize 2048 -validity 10000 -alias mytestandroidjava-release-key
```