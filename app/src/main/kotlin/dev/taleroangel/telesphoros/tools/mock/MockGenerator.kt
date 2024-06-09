package dev.taleroangel.telesphoros.tools.mock

import dev.taleroangel.telesphoros.domain.model.Medicine
import io.bloco.faker.Faker

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
        return Medicine(
            name = faker.lorem.word(),
            daysTotal = daysTotal,
            daysCurrent = faker.number.between(0, daysTotal),
        )
    }
}