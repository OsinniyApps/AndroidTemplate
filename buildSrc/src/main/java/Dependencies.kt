object Sdk {
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 30
    const val COMPILE_SDK_VERSION = 30
}

object BuildPluginsVersion {
    const val KTLINT = "0.40.0"
    const val KTLINT_GRADLE = "10.0.0"
    const val DETEKT = "1.16.0"
    const val VERSIONS_PLUGIN = "0.38.0"
}

object KotlinLibs {
    const val KOTLINX_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.4.2"
}

object AndroidxLibs {
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:1.3.2"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "com.android.support.constraint:constraint-layout:2.0.4"
}

object UiLibs {
    const val MATERIAL = "com.google.android.material:material:1.2.1"
}

object DebugLibs {
    const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:2.7"
}

object TestLibs {
    const val JUNIT = "junit:junit:4.13.2"
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:1.3.0"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:1.3.0"
    const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:1.1.2"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.3.0"
}
