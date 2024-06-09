package dev.taleroangel.telesphoros.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Representation of a medicine
 */
@Parcelize
@Entity
data class Medicine(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("days_t") val daysTotal: Int,
    @ColumnInfo("days_c") val daysCurrent: Int,
) : Parcelable
