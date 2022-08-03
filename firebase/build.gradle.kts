plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = VERSION.COMPILE_SDK

    defaultConfig {
        minSdk = 24
        targetSdk = VERSION.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${VERSION.COROUTINE}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${VERSION.COROUTINE}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:${VERSION.COROUTINE}")

    //hilt
    implementation ("com.google.dagger:hilt-android:${VERSION.HILT}")
    kapt ("com.google.dagger:hilt-compiler:${VERSION.HILT}")

    //Log
    implementation ("com.jakewharton.timber:timber:${VERSION.TIMBER}")

    //firebase
    implementation (platform("com.google.firebase:firebase-bom:${VERSION.FIREBASE_REAL_TIME_DATABASE}"))
    implementation("com.google.firebase:firebase-database-ktx")
    implementation ("com.google.firebase:firebase-auth-ktx")
}