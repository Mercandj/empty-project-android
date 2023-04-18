plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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
        // For Room database testing
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
    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")

    // Room Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("com.google.truth:truth:1.0.1")
    androidTestImplementation ("android.arch.core:core-testing:1.0.0")

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
