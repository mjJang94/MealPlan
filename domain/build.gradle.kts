plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

    implementation(project(":firebase"))

    implementation ("androidx.core:core-ktx:${VERSION.CORE}")
    implementation ("androidx.appcompat:appcompat:${VERSION.APP_COMPAT}")
    implementation ("com.google.android.material:material:${VERSION.MATERIAL}")
    implementation ("androidx.paging:paging-runtime-ktx:${VERSION.PAGING}")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //Retrofit2
    implementation ("com.squareup.retrofit2:retrofit:${VERSION.RETROFIT}")
    implementation ("com.squareup.retrofit2:converter-gson:${VERSION.RETROFIT}")
    implementation ("com.squareup.okhttp3:logging-interceptor:${VERSION.RETROFIT_LOGGING}")

    //hilt
    implementation ("com.google.dagger:hilt-android:${VERSION.HILT}")
    kapt ("com.google.dagger:hilt-compiler:${VERSION.HILT}")

    //Log
    implementation ("com.jakewharton.timber:timber:${VERSION.TIMBER}")

    //firebase
    implementation (platform("com.google.firebase:firebase-bom:${VERSION.FIREBASE_REAL_TIME_DATABASE}"))
    implementation("com.google.firebase:firebase-database-ktx")
}