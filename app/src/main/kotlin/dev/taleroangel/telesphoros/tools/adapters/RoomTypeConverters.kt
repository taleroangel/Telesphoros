package dev.taleroangel.telesphoros.tools.adapters

import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

/**
 * [TypeConverter] definitions for room
 */
class RoomTypeConverters {
    /**
     * Transform a [LocalDateTime] into unix time
     */
    @TypeConverter
    fun localDateTimeTypeConverter(localDateTime: LocalDateTime): Long =
        localDateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()

    /**
     * Transforms unix time into [LocalDateTime]
     */
    @TypeConverter
    fun localDateTimeTypeConverter(unixTime: Long): LocalDateTime =
        Instant.fromEpochMilliseconds(unixTime).toLocalDateTime(TimeZone.currentSystemDefault())
}