package dev.taleroangel.telesphoros.infrastructure.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.taleroangel.telesphoros.domain.model.Medicine
import dev.taleroangel.telesphoros.domain.repository.MedicineRepository

/**
 * Database name
 */
const val DATABASE_NAME = "dev.taleroangel.telesphoros.database"

/**
 * Application database definition
 */
@Database(entities = [Medicine::class], version = 1)
abstract class ApplicationDatabase: RoomDatabase() {
    /**
     * Provide the DAO for accessing [Medicine]
     */
    abstract fun medicineRepository(): MedicineRepository
}