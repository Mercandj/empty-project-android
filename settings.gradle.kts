rootProject.name = "empty-project"
rootProject.buildFileName = "build.gradle.kts"
include(
    ":app"
)
pluginManagement {
    plugins {

        // [Announce] https://android-developers.googleblog.com/2021/02/announcing-kotlin-symbol-processing-ksp.html
        // [v1] https://android-developers.googleblog.com/2021/09/accelerated-kotlin-build-times-with.html
        // [SupportedLib] https://kotlinlang.org/docs/ksp-overview.html#supported-libraries
        // [GitHub] https://github.com/google/ksp
        id("com.google.devtools.ksp") version "1.8.20-1.0.10"
    }
}
