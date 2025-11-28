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

class ProjectWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                ProjectWidgetUI()
            }
        }
    }

    @Composable
    private fun ProjectWidgetUI() {

        // Datos simulados
        val gasValue = 7.4
        val status = if (gasValue < 10) "SEGURO" else "ALERTA"

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(12.dp),   // ✔ dp ya funciona
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = "SafeMine IoT")

            Spacer(GlanceModifier.height(6.dp))

            Text(text = "H₂S: $gasValue ppm")
            Text(text = "Estado: $status")

            Spacer(GlanceModifier.height(8.dp))

            Text(text = "Última actualización: Hace 2 min")

            Spacer(GlanceModifier.height(10.dp))

            Row(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    text = "Alertas",
                    onClick = actionStartActivity<SecondActivity>()
                )

                Spacer(GlanceModifier.width(8.dp))

                Button(
                    text = "Dashboard",
                    onClick = actionStartActivity<MainActivity>()
                )
            }
        }
    }
}
