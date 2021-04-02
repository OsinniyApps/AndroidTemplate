import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    signingConfigs.load()

    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        applicationId = AppCoordinates.APP_ID
        versionCode = AppCoordinates.APP_VERSION_CODE
        versionName = AppCoordinates.APP_VERSION_NAME

        resConfigs("en")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

//            uncomment when keystore will be ready
//            signingConfig = signingConfigs.getByName("upload")
        }

        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
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

    implementation(KotlinLibs.KOTLINX_COROUTINES_ANDROID)

    implementation(AndroidxLibs.ANDROIDX_CORE_KTX)
    implementation(AndroidxLibs.ANDROIDX_APPCOMPAT)
    implementation(AndroidxLibs.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(AndroidxLibs.ANDROIDX_LIFECYCLE_KTX)
    implementation(AndroidxLibs.ANDROIDX_VIEW_MODEL_KTX)
    implementation(AndroidxLibs.ANDROIDX_ACTIVITY_KTX)
    implementation(AndroidxLibs.ANDROIDX_FRAGMENT_KTX)

    implementation(UiLibs.MATERIAL)

    debugImplementation(DebugLibs.LEAK_CANARY)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_RULES)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_RUNNER)
    androidTestImplementation(TestLibs.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO_CORE)
}

fun NamedDomainObjectContainer<com.android.build.gradle.internal.dsl.SigningConfig>.load() {
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
