plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}


android {
    compileSdk = VERSION.COMPILE_SDK
    buildToolsVersion = VERSION.BUILD_TOOLS

    defaultConfig {
        applicationId = "com.mj.family_meal_planner"
        minSdk = 24
        targetSdk = VERSION.TARGET_SDK
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":firebase"))
    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:${VERSION.CORE}")
    implementation("androidx.appcompat:appcompat:${VERSION.APP_COMPAT}")
    implementation("androidx.constraintlayout:constraintlayout:${VERSION.CONSTRAINT_LAYOUT}")
    implementation("androidx.activity:activity-ktx:${VERSION.ACTIVITY}")
    implementation("androidx.fragment:fragment-ktx:${VERSION.FRAGMENT}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${VERSION.LIFECYCLE}")
    implementation("androidx.recyclerview:recyclerview:${VERSION.RECYCLERVIEW}")
    implementation("androidx.paging:paging-runtime-ktx:${VERSION.PAGING}")

    implementation("com.google.android.material:material:${VERSION.MATERIAL}")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${VERSION.COROUTINE}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${VERSION.COROUTINE}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:${VERSION.COROUTINE}")

    //hilt
    implementation("com.google.dagger:hilt-android:${VERSION.HILT}")
    kapt("com.google.dagger:hilt-compiler:${VERSION.HILT}")

    //glide
    implementation("com.github.bumptech.glide:glide:${VERSION.GLIDE}")
    annotationProcessor("com.github.bumptech.glide:compiler:${VERSION.GLIDE}")

    //Log
    implementation("com.jakewharton.timber:timber:${VERSION.TIMBER}")

    //firebase
    implementation (platform("com.google.firebase:firebase-bom:${VERSION.FIREBASE_REAL_TIME_DATABASE}"))
    implementation("com.google.firebase:firebase-database-ktx")
}