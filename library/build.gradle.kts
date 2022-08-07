plugins {
    kotlin("multiplatform")
    id("maven-publish")
    id("com.android.library")
}

group = "dev.hirogakatageri.esper"
version = "0.1.0"

kotlin {
    targets {
        jvm()
        android()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project.dependencies.platform(Deps.Kotlin.COROUTINES_BOM))
                implementation(Deps.Kotlin.COROUTINES_CORE)
            }
        }
    }
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
