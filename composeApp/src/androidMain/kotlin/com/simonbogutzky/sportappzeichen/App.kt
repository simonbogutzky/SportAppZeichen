package com.simonbogutzky.sportappzeichen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.simonbogutzky.sportappzeichen.usecases.DisciplineProvider

@Composable
fun App() {
    val disciplines by produceState(emptyList()) {
        value = DisciplineProvider().fetchDisciplines()
    }

    MaterialTheme {
        if (disciplines.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(disciplines) { Text(it.name) }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Lade Disziplinen...")
            }
        }
    }
}