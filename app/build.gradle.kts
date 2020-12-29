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
    implementation(SupportLibs.ANDROIDX_CORE_KTX)
    implementation(SupportLibs.ANDROIDX_APPCOMPAT)
    implementation(SupportLibs.ANDROIDX_CONSTRAINT_LAYOUT)

//     material lib
    implementation(UILibs.MATERIAL)

//     debug libs
    debugImplementation(DebugLibs.LEAK_CANARY)

//     test libs
    testImplementation(TestingLib.JUNIT)
    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_RULES)
    androidTestImplementation(AndroidTestingLib.ESPRESSO_CORE)
}
