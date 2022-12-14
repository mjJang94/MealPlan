# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#noinspection ShrinkerUnresolvedReference

-dontobfuscate # http://kunny.github.io/lecture/proguard/2017/02/16/reduce-method-count-with-proguard/
-dontoptimize  # http://blog.cnagune.pe.kr/2014/07/proguard-optimize.html
-keepattributes SourceFile,LineNumberTable
-keepattributes Signature,InnerClasses, EnclosingMethod
-keepattributes *Annotation*


#okhttp3
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**

-keep class com.squareup.** { *; }
#Google
-dontwarn com.google.android.gms.**
-keep class com.google.android.gms.** { *; }

-dontwarn android.support.v4.**,org.slf4j.**,com.google.android.gms.**

-keep class io.kiwiplus.app.kiwisenior.repo.** { *; }
-keepclassmembers class io.kiwiplus.app.kiwisenior.repo.** { *; }

-keep class io.kiwiplus.app.kiwisenior.core.** { *; }
-keepclassmembers class io.kiwiplus.app.kiwisenior.core.** { *; }

#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**`
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { <fields>; }

# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# RemoteControl (RVAgent)
 -keep class com.rsupport.** { *; }
 -keep class control.** { *; }
 -keep class config.** { *; }
 -keep class android.hardware.input.** { *; }
 -keep class android.view.** { *; }
 -keep class org.eclipse.paho.client.mqttv3.** { *; }

##---------------End: proguard configuration for Gson  ----------

-ignorewarnings
