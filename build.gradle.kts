// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${VERSION.GRADLE}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${VERSION.HILT}")
        classpath ("com.google.gms:google-services:${VERSION.GOOGLE_GMS}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}


