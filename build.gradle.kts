buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath(kotlin("gradle-plugin", version = "1.8.20"))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
