package dev.taleroangel.telesphoros.presentation.ui.views

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.taleroangel.telesphoros.R
import dev.taleroangel.telesphoros.domain.model.Medicine
import dev.taleroangel.telesphoros.presentation.ui.composables.MedicineTile
import dev.taleroangel.telesphoros.presentation.ui.theme.ApplicationTheme
import dev.taleroangel.telesphoros.tools.mock.MockGenerator.mockMany

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicinesView(
    modifier: Modifier = Modifier,
    medicines: List<Medicine>,
    onCreate: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.medicines))
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onCreate) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.add_medicine),
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(medicines) { medicine ->
                MedicineTile(medicine = medicine)
            }
        }
    }
}

@Composable
@Preview
fun MedicinesViewPreview() {
    ApplicationTheme {
        MedicinesView(medicines = Medicine.mockMany(10))
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MedicinesViewDarkPreview() {
    MedicinesViewPreview()
}