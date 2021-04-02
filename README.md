# AndroidTemplate 🤖

[![Use this template](https://img.shields.io/badge/from-AndroidTemplate-brightgreen?logo=dropbox)](https://github.com/OsinniyApps/AndroidTemplate/generate) ![CI](https://github.com/OsinniyApps/AndroidTemplate/workflows/CI/badge.svg)  ![License](https://img.shields.io/github/license/OsinniyApps/AndroidTemplate.svg) ![Language](https://img.shields.io/github/languages/top/OsinniyApps/AndroidTemplate?color=blue&logo=kotlin)

A simple Github template that lets you create an **Android/Kotlin** project and be up and running in a **few seconds**. 

This template is focused on delivering a project with **static analysis** and **continuous integration** already in place.

## How to use 👣

Just click on [![Use this template](https://img.shields.io/badge/-Use%20this%20template-brightgreen)](https://github.com/OsinniyApps/AndroidTemplate/generate) button to create a new repo starting from this template.

Once created don't forget to update the:
- [App ID](buildSrc/src/main/java/Coordinates.kt)
- AndroidManifest ([here](app/src/main/AndroidManifest.xml) and [here](library-android/src/main/AndroidManifest.xml))
- Package of the source files
- [Keystore properties](keystore.properties)

## Features 🎨

- **100% Kotlin-only template**.
- 3 Sample modules (Android app, Android library, Kotlin library) or [**single module**](https://github.com/OsinniyApps/AndroidTemplate/tree/single-module).
- Sample Espresso, Instrumentation & JUnit tests.
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- CI Setup with GitHub Actions.
- Kotlin Static Analysis via `ktlint` and `detekt`.
- Publishing Ready.
- Issues Template (bug report + feature request).
- Pull Request Template.

## Gradle Setup 🐘

This template is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the [Dependencies.kt](buildSrc/src/main/java/Dependencies.kt) file in the `buildSrc` folder. This provides convenient auto-completion when writing your gradle files.

## Static Analysis 🔍

This template is using [**ktlint**](https://github.com/pinterest/ktlint) with the [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle) plugin to format your code. To reformat all the source code as well as the buildscript you can run the `ktlintFormat` gradle task.

This template is also using [**detekt**](https://github.com/detekt/detekt) to analyze the source code, with the configuration that is stored in the [detekt.yml](config/detekt/detekt.yml) file (the file has been generated with the `detektGenerateConfig` task).

## CI ⚙️

This template is using [**GitHub Actions**](https://github.com/OsinniyApps/AndroidTemplate/actions) as CI. You don't need to setup any external service and you should have a running CI once you start using this template.

There are currently the following workflows available:
- [CI](.github/workflows/ci.yaml) - Build (`assemble`, `publishToMavenLocal`), Lint (`detekt`, `ktlintCheck`), Dependencies checks (`dependencies`, `dependencyUpdates`), Unit (`test`) & Instrumentation (`connectedDebugAndroidTest`) tests

## Publishing 🚀

The template is setup to be **ready to publish** a library/artifact on a Maven Repository. If you're using JitPack, you don't need any further configuration and you can just configure the repo on JitPack. If you're using another repository (MavenCentral/JCenter/etc.), you need to specify the publishing coordinates.

## Contributing 🤝

Feel free to open a issue or submit a pull request for any bugs/improvements.
