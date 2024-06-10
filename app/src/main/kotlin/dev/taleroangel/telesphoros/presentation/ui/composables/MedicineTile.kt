package dev.taleroangel.telesphoros.presentation.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Alarm
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.taleroangel.telesphoros.R
import dev.taleroangel.telesphoros.domain.model.Medicine
import dev.taleroangel.telesphoros.tools.mock.MockGenerator.mock
import dev.taleroangel.telesphoros.presentation.ui.theme.ApplicationTheme

@Composable
fun MedicineTile(
    modifier: Modifier = Modifier,
    medicine: Medicine,
    onClick: () -> Unit = {},
) {
    OutlinedCard(modifier = modifier) {
        ListItem(
            modifier = Modifier
                .clickable { onClick() },
            leadingContent = {
                Image(
                    painter = painterResource(id = R.drawable.image_placeholder),
                    contentDescription = stringResource(id = R.string.image_missing),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            },
            headlineContent = {
                Text(text = medicine.name)
            },
            trailingContent = {
                Text(
                    text = stringResource(
                        id = R.string.hours, medicine.eachHrs
                    )
                )
            },
            supportingContent = {
                Text(
                    text = stringResource(
                        id = R.string.medicine_days_of,
                        medicine.daysCurrent,
                        medicine.daysTotal
                    )
                )
            },
            overlineContent = {
                if (medicine.type != null) {
                    Text(text = medicine.type)
                }
            }
        )
    }
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
fun MedicineTileDarkPreview() {
    MedicineTilePreview()
}