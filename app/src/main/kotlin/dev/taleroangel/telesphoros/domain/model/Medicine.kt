package dev.taleroangel.telesphoros.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.taleroangel.telesphoros.infrastructure.parceler.LocalDateTimeParceler
import dev.taleroangel.telesphoros.tools.adapters.RoomTypeConverters
import kotlinx.datetime.LocalDateTime
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.parcelize.TypeParceler

/**
 * Representation of a medicine
 */
@Entity
@Parcelize
@TypeConverters(RoomTypeConverters::class)
@TypeParceler<LocalDateTime, LocalDateTimeParceler>()
data class Medicine(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("type") val type: String? = null,
    @ColumnInfo("days_t") val daysTotal: Int,
    @ColumnInfo("days_c") val daysCurrent: Int,
    @ColumnInfo("each_hrs") val eachHrs: Int,
    @ColumnInfo("image") val image: LocalFilePath? = null,
    @ColumnInfo("next_at") val nextAt: LocalDateTime,
    @ColumnInfo("delayed_to") val delayedTo: @RawValue LocalDateTime? = null,
    @ColumnInfo("taken_at") val takenAt: LocalDateTime,
    @ColumnInfo("finished") val finished: Boolean = false,
) : Parcelable {
    /**
     * Provided only for extension functions
     */
    companion object
}