object Deps {

    object Kotlin {

        private const val JB_KOTLIN = "org.jetbrains.kotlin"
        private const val JB_KTX = "org.jetbrains.kotlinx"
        private const val KTX_COROUTINES = "kotlinx-coroutines"

        const val KOTLIN_BOM = "$JB_KOTLIN:kotlin-bom:${Versions.Kotlin.BOM}"
        const val KOTLIN_JDK8 = "$JB_KOTLIN:kotlin-stdlib-jdk8"
        const val COROUTINES_BOM = "$JB_KTX:$KTX_COROUTINES-bom:${Versions.Kotlin.COROUTINES_BOM}"
        const val COROUTINES_CORE = "$JB_KTX:$KTX_COROUTINES-core"
        const val COROUTINES_ANDROID = "$JB_KTX:$KTX_COROUTINES-android"
    }

    object Android {

        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.Android.APPCOMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.Android.MATERIAL}"

        const val VIEW_MODEL =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.LIFECYCLE}"
        const val VIEW_MODEL_COMPOSE =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Android.LIFECYCLE}"
        const val VIEW_MODEL_JDK8 =
            "androidx.lifecycle:lifecycle-common-java8:${Versions.Android.LIFECYCLE}"
        const val VIEW_MODEL_STATE = "" +
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Android.LIFECYCLE}"

    }

    object AndroidKtx {

        const val CORE = "androidx.core:core-ktx:1.8.0"
        const val ACTIVITY = "androidx.activity:activity-ktx:1.5.1"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:1.5.1"
    }

}