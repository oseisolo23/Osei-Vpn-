# SETUP

This document contains quick setup instructions for developers.

## Prerequisites
- Android Studio Flamingo or later
- JDK 17
- Visual Studio 2022/2023 with NET 8 support (for Windows app)
- Android SDK for API 26+

## Android
1. Open the `android` folder in Android Studio.
2. Configure your local keystore in `~/.gradle/keystore.properties` or GitHub Secrets for CI.
3. Build: `./gradlew assembleDebug`

## Windows
1. Open the `windows/OseiVPN.Windows.sln` in Visual Studio.
2. Restore NuGet packages and build.

Notes: This repo contains skeletons and placeholders for VPN protocols and servers. Do not ship private keys or credentials.
