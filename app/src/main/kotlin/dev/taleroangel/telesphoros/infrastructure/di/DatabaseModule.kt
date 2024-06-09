package dev.taleroangel.telesphoros.infrastructure.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.taleroangel.telesphoros.domain.repository.MedicineRepository
import dev.taleroangel.telesphoros.infrastructure.persistance.ApplicationDatabase
import dev.taleroangel.telesphoros.infrastructure.persistance.DATABASE_NAME

/**
 * Provide database repositories
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    /**
     * Provide raw database access
     */
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ApplicationDatabase =
        Room.databaseBuilder(context, ApplicationDatabase::class.java, DATABASE_NAME).build()

    /**
     * Provide the [MedicineRepository]
     */
    @Provides
    fun provideMedicineRepository(database: ApplicationDatabase): MedicineRepository =
        database.medicineRepository()
}