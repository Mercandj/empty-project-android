plugins {
    id("com.android.application")
    kotlin("android")
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
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.8.0")
}
