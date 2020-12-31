import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    signingConfigs {
        create("upload") {
            val keystorePropertiesFile = rootProject.file("keystore.properties")
            val keystoreProperties = Properties()
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))

            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
        }
    }

    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        applicationId = AppCoordinates.APP_ID
        versionCode = AppCoordinates.APP_VERSION_CODE
        versionName = AppCoordinates.APP_VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
//     kotlin std lib
    implementation(kotlin("stdlib"))

    implementation(project(":library-android"))
    implementation(project(":library-kotlin"))

//     androidx libs
    implementation(AndroidxLibs.ANDROIDX_CORE_KTX)
    implementation(AndroidxLibs.ANDROIDX_APPCOMPAT)
    implementation(AndroidxLibs.ANDROIDX_CONSTRAINT_LAYOUT)

//     material lib
    implementation(UiLibs.MATERIAL)

//     debug libs
    debugImplementation(DebugLibs.LEAK_CANARY)

//     test libs
    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_RULES)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_RUNNER)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO_CORE)
}
