# Jibo Revived App Archive

This repository collects the work around bringing back and understanding the original Jibo mobile app experience.

It contains a new React Native app for the Jibo Revival project, the original Android APK, reverse-engineered sources used to study how the old app talked to Jibo services, and a modified APK that lets people explore the original app UI without needing an active historical Jibo account.

## What Is In This Repository

### React Native Jibo Revival App

The active modern app project, built with React Native and Expo.

Path: [`Jibo_APP/`](Jibo_APP/)

### Original Android Jibo App

The original Android app, kept here for preservation and reverse-engineering work.

APK file: [`Original_app.apk`](Original_app.apk)

Source code: [`og_app_source_code/`](og_app_source_code/)

The decompiled source is useful for understanding the original app structure, API calls, endpoint usage, request parameters, and general app behavior.

### Modified Jibo App

A patched version of the original Android app that includes a local mock login path.

APK file: [`app_mod.apk`](app_mod.apk)

Source code: [`Modified_og_app/`](Modified_og_app/)

### More

Original media assets extracted from the Android app: [`Media/`](Media/)

## Modified Original App

The modified APK includes a local mock login path. Use these credentials:

```text
Email: jibo@jiborevival.com
Password: Jibo12345678
```

Logging in with those credentials opens a local mock account with a Jibo shown as connected. This makes it possible to explore what the original app looked and felt like, even for people who did not own a Jibo while the original service was still running.

The mock account is local to the modified app. It is intended for preservation, research, and UI exploration.

## React Native App

The modern Jibo Revival app lives in `Jibo_APP/`.

See [`Jibo_APP/README.md`](Jibo_APP/README.md) for setup, development commands, validation steps, and technical notes.

## Reverse Engineering Notes

The reverse-engineered material is included so the community can inspect how the original app interacted with backend services:

- which endpoints were called
- which parameters were sent
- how requests were structured
- how the original flows were organized

This is meant to support documentation, compatibility work, and preservation of the Jibo ecosystem.

## Purpose

Jibo is no longer supported by its original cloud services, but many people still care about the robot, its design, and the experience around it. This repository is part archive, part research workspace, and part foundation for a revived companion app.

The goal is to make the old app understandable, preserve the original experience where possible, and build a modern replacement that can help Jibo owners and enthusiasts keep exploring.

## Disclaimer

This is an independent preservation and revival project. It is not affiliated with the original Jibo company or any current rights holder.

The APKs and reverse-engineered sources are provided here for research, interoperability, and archival purposes.

## License

This project is licensed under the [MIT License](LICENSE).
