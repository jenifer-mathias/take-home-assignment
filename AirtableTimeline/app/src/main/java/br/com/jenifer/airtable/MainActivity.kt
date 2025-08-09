package br.com.jenifer.airtable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.jenifer.airtable.navigation.NavigationWrapper
import br.com.jenifer.airtable.ui.theme.AirtableTimelineTheme
import br.com.jenifer.airtable.ui.theme.DarkBlue
import br.com.jenifer.airtable.ui.widget.StatusBarColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirtableTimelineTheme {
                StatusBarColor(color = DarkBlue, darkIcons = true)
                NavigationWrapper()
            }
        }
    }
}
