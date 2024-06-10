package dev.taleroangel.telesphoros.tools.mock

import dev.taleroangel.telesphoros.domain.model.Medicine
import io.bloco.faker.Faker
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toKotlinInstant
import kotlinx.datetime.toLocalDateTime

/**
 * Generate mock implementations of models in [dev.taleroangel.telesphoros.domain.model]
 */
object MockGenerator {

    /**
     * Fake data generator
     */
    private val faker = Faker()

    /**
     * Generate a [Medicine] model with mock values
     */
    fun Medicine.Companion.mock(): Medicine {

        val daysTotal = faker.number.between(1, 10)
        val minimumDate = faker.date.backward()
        val maximumDate = faker.date.forward()

        val tz = TimeZone.currentSystemDefault()
        val takenAt = faker.date.between(minimumDate, maximumDate).toInstant().toKotlinInstant()
        val nextAt = takenAt.plus(faker.number.between(1, 12), DateTimeUnit.HOUR)

        return Medicine(
            name = faker.lorem.word(),
            type = if (faker.bool.bool()) faker.lorem.sentence() else null,
            daysTotal = daysTotal,
            daysCurrent = faker.number.between(1, daysTotal),
            eachHrs = faker.number.between(2, 12),
            takenAt = takenAt.toLocalDateTime(tz),
            nextAt = nextAt.toLocalDateTime(tz),
        )
    }

    /**
     * Generate many [Medicine] in a list using [mock]
     */
    fun Medicine.Companion.mockMany(items: Int = faker.number.between(0, 10)): List<Medicine> =
        List(items) {
            Medicine.mock()
        }
}