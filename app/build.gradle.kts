plugins {
    id("com.android.application")
    kotlin("android")

    // [Announce] https://android-developers.googleblog.com/2021/02/announcing-kotlin-symbol-processing-ksp.html
    // [v1] https://android-developers.googleblog.com/2021/09/accelerated-kotlin-build-times-with.html
    // [SupportedLib] https://kotlinlang.org/docs/ksp-overview.html#supported-libraries
    // [GitHub] https://github.com/google/ksp
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.app"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.app"
        minSdk = 21
        targetSdk = 33
        versionCode = 1_00_00
        versionName = "1.00.00"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            versionNameSuffix = ".dev"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    // Jetpack Compose
    buildFeatures {
        compose = true
    }
    composeOptions {
        // https://developer.android.com/jetpack/androidx/releases/compose-kotlin#pre-release_kotlin_compatibility
        // https://github.com/jimgoog/ComposeAppUsingPrereleaseComposeCompiler#project-configuration
        kotlinCompilerExtensionVersion = "1.4.5"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")

    // AndroidX - Room
    implementation("androidx.room:room-runtime:2.5.1")
    implementation("androidx.room:room-ktx:2.5.1")
    ksp("androidx.room:room-compiler:2.5.1")

    // JetPack Compose
    // https://developer.android.com/jetpack/androidx/releases/compose-kotlin#pre-release_kotlin_compatibility
    implementation("androidx.compose.ui:ui:1.4.1")
    // https://developer.android.com/jetpack/compose/tooling
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.1")
    // https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary
    implementation("androidx.compose.material:material-icons-extended:1.4.1")
    implementation("androidx.compose.ui:ui-text-google-fonts:1.4.1")
    // https://developer.android.com/jetpack/androidx/releases/compose-foundation
    implementation("androidx.compose.foundation:foundation:1.4.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    // https://developer.android.com/jetpack/androidx/releases/compose-material3
    implementation("androidx.compose.material3:material3:1.0.1")

    // JetPack Compose - ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01") {
        because("To have viewModel dependency and extension function for Compose")
    }

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("android.arch.core:core-testing:1.1.1")
}
