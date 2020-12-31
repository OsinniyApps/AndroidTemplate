version = LibraryAndroidCoordinates.LIBRARY_VERSION

plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

android {
    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        versionCode = LibraryAndroidCoordinates.LIBRARY_VERSION_CODE
        versionName = LibraryAndroidCoordinates.LIBRARY_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
//     kotlin std lib
    implementation(kotlin("stdlib"))

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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
            }
        }
    }
}
