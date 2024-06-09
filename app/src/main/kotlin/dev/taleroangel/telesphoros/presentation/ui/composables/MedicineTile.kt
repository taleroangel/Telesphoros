package dev.taleroangel.telesphoros.presentation.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import dev.taleroangel.telesphoros.domain.model.Medicine
import dev.taleroangel.telesphoros.tools.mock.MockGenerator.mock
import dev.taleroangel.telesphoros.presentation.ui.theme.ApplicationTheme

@Composable
fun MedicineTile(medicine: Medicine) {
    ListItem(
        trailingContent = {
            Box(modifier = Modifier
                .clip(CircleShape)
                .fillMaxHeight()
            )
        },
        headlineContent = {
            Text(text = medicine.name)
        })
}

@Composable
@Preview
fun MedicineTilePreview() {
    ApplicationTheme {
        MedicineTile(
            medicine = Medicine.mock()
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MedicineTileDartPreview() {
    MedicineTilePreview()
}