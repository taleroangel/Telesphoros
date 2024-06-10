package dev.taleroangel.telesphoros.infrastructure.parceler

import android.os.Parcel
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.parcelize.Parceler

/**
 * [Parcel] implementation for [LocalDateTime]
 */
class LocalDateTimeParceler : Parceler<LocalDateTime> {
    /**
     * Transform [LocalDateTime] a into a [Parcel] using unix time
     */
    override fun LocalDateTime.write(parcel: Parcel, flags: Int) {
        parcel.writeLong(this.toInstant(TimeZone.UTC).toEpochMilliseconds())
    }

    /**
     * Parse a UTC Unix timestamp into [LocalDateTime]
     */
    override fun create(parcel: Parcel): LocalDateTime {
        return Instant.fromEpochMilliseconds(parcel.readLong()).toLocalDateTime(TimeZone.UTC)
    }
}