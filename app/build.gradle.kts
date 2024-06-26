import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.androidx.room)
}



android {
    namespace = "dev.taleroangel.telesphoros"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.taleroangel.telesphoros"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_1_8)
    }
}

dependencies {

    /* Android */
    implementation(libs.androidx.core.ktx)

    /* Kotlinx */
    implementation(libs.bundles.kotlinx)

    /* Jetpack Hilt */
    implementation(libs.bundles.androidx.hilt)

    /* Jetpack Lifecycle */
    implementation(libs.bundles.androidx.lifecycle)

    /* Jetpack Compose */
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.androidx.compose)
    debugImplementation(libs.bundles.androidx.compose.debug)

    /* Jetpack Navigation */
    implementation(libs.bundles.androidx.navigation)

    /* Jetpack Room */
    implementation(libs.bundles.androidx.room)

    /* Other Libraries */
    implementation(libs.faker)

    /* KSP */
    ksp(libs.bundles.ksp)
}