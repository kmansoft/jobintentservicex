import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id ("com.android.library")
    id ("kotlin-android")
}

android {
    compileSdk = 36

    namespace = "org.kman.jobintentservicex"

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility (JavaVersion.VERSION_11)
        targetCompatibility (JavaVersion.VERSION_11)
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // Kotlin
    testImplementation ("junit:junit:4.13.2")

    androidTestImplementation ("androidx.test.ext:junit:1.3.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.7.0")
}
