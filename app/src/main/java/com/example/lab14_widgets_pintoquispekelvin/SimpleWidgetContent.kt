package com.example.lab14_widgets_pintoquispekelvin

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.Text

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿A dónde quieres dirigirte?",
                modifier = GlanceModifier.padding(12.dp)
            )

            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.padding(vertical = 8.dp)
            ) {
                // Botón 1 → abre MainActivity
                Button(
                    text = "Página Principal",
                    onClick = actionStartActivity<MainActivity>()
                )

                Spacer(modifier = GlanceModifier.width(8.dp))

                // Botón 2 → abre SecondActivity (PASO 8)
                Button(
                    text = "Otra Vista",
                    onClick = actionStartActivity<SecondActivity>()
                )
            }
        }
    }
}
