import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id ("com.android.library")
}

android {
    compileSdk = 37

    namespace = "org.kman.jobintentservicex"

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility (JavaVersion.VERSION_11)
        targetCompatibility (JavaVersion.VERSION_11)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // Kotlin
    testImplementation ("junit:junit:4.13.2")

    androidTestImplementation ("androidx.test.ext:junit:1.3.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.7.0")
}
