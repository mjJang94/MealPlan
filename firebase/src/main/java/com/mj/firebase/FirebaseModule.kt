package com.mj.firebase

import com.google.firebase.database.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
class FirebaseModule {

    companion object{
        const val PATH = "meal"
    }

    @Provides
    @Singleton
    fun provideDataBaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference.child(PATH)
    }

    @Provides
    @Singleton
    fun provideFirebaseRepository(databaseReference: DatabaseReference): FirebaseRepository = FirebaseRepository(databaseReference)
}