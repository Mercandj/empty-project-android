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
        jvmTarget = "11"
    }

    // Jetpack Compose
    buildFeatures {
        compose = true
    }
    composeOptions {
        // https://developer.android.com/jetpack/androidx/releases/compose-kotlin#pre-release_kotlin_compatibility
        // https://github.com/jimgoog/ComposeAppUsingPrereleaseComposeCompiler#project-configuration
        kotlinCompilerExtensionVersion = "1.4.0-alpha02"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.8.0")

    // AndroidX - Room
    implementation("androidx.room:room-runtime:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")

    // JetPack Compose
    // https://developer.android.com/jetpack/androidx/releases/compose-kotlin#pre-release_kotlin_compatibility
    implementation("androidx.compose.ui:ui:1.3.3")
    // https://developer.android.com/jetpack/compose/tooling
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    // https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary
    implementation("androidx.compose.material:material-icons-extended:1.3.1")
    implementation("androidx.compose.ui:ui-text-google-fonts:1.3.3")
    // https://developer.android.com/jetpack/androidx/releases/compose-foundation
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    // https://developer.android.com/jetpack/androidx/releases/compose-material3
    implementation("androidx.compose.material3:material3:1.0.1")

    // JetPack Compose - ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01") {
        because("To have viewModel dependency and extension function for Compose")
    }

    // JetPack Compose - Accompanist
    // https://github.com/google/accompanist
    // https://google.github.io/accompanist
    // JetPack Compose - Accompanist - ViewPager
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    // JetPack Compose - Accompanist - Web - https://google.github.io/accompanist/webview
    implementation("com.google.accompanist:accompanist-webview:0.28.0")
}
