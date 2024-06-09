package dev.taleroangel.telesphoros.domain.repository

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import dev.taleroangel.telesphoros.domain.model.Medicine
import kotlinx.coroutines.flow.Flow

/**
 * Manipulate [Medicine] data from the database
 */
@Dao
interface MedicineRepository {
    /**
     * Get all [Medicine] stored in the database
     */
    @Query("SELECT * FROM medicine WHERE 1")
    fun getAllMedicines(): Flow<List<Medicine>>

    /**
     * Get a specific [Medicine] by its [Medicine.uid]
     */
    @Query("SELECT * FROM medicine WHERE uid = :uid")
    fun getMedicineById(uid: Int): Flow<Medicine>

    /**
     * Insert a new [Medicine] or replace an existing one
     */
    @Upsert
    suspend fun insertOrUpdateMedicine(medicine: Medicine)
}