plugins {
    id("com.android.application")
    id("kotlin-parcelize")
    kotlin("android")
}

android {

    compileSdk = 32

    defaultConfig {
        applicationId = "dev.hirogakatageri.esper.demo"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(project(":library"))

    implementation(platform(Deps.Kotlin.COROUTINES_BOM))
    implementation(Deps.Kotlin.COROUTINES_ANDROID)

    implementation(Deps.AndroidKtx.CORE)
    implementation(Deps.AndroidKtx.ACTIVITY)
    implementation(Deps.AndroidKtx.FRAGMENT)

    implementation(Deps.Android.APPCOMPAT)
    implementation(Deps.Android.MATERIAL)

    implementation(Deps.Android.VIEW_MODEL)
    implementation(Deps.Android.VIEW_MODEL_JDK8)
}
