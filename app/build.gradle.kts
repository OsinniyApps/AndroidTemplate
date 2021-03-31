import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    signingConfigs {
        create("upload") {
            with(Properties()) {
                load(rootProject.file("keystore.properties").inputStream())

                storeFile = file(get("storeFile") as String)
                storePassword = get("storePassword") as String
                keyAlias = get("keyAlias") as String
                keyPassword = get("keyPassword") as String
            }
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
        fatal("StopShip")
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":library-android"))
    implementation(project(":library-kotlin"))

    implementation(KotlinLibs.KOTLINX_COROUTINES)

    implementation(AndroidxLibs.ANDROIDX_CORE_KTX)
    implementation(AndroidxLibs.ANDROIDX_APPCOMPAT)
    implementation(AndroidxLibs.ANDROIDX_CONSTRAINT_LAYOUT)

    implementation(UiLibs.MATERIAL)

    debugImplementation(DebugLibs.LEAK_CANARY)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_RULES)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_RUNNER)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO_CORE)
}
