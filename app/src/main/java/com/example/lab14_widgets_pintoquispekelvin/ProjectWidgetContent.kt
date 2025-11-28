package com.example.lab14_widgets_pintoquispekelvin

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.*
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
        val statusColor = if (gasValue < 10) "#00FF88" else "#FF4D4D"

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(12.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text("SafeMine IoT", style = TextStyle(fontSize = 18.sp))
            Spacer(GlanceModifier.height(6.dp))

            Text(
                text = "H₂S: $gasValue ppm",
                style = TextStyle(fontSize = 16.sp)
            )

            Text(
                text = "Estado: $status",
                style = TextStyle(color = ColorProvider(statusColor), fontSize = 16.sp)
            )

            Spacer(GlanceModifier.height(8.dp))
            Text("Última actualización: Hace 2 min", style = TextStyle(fontSize = 12.sp))

            Spacer(GlanceModifier.height(10.dp))

            Row(horizontalAlignment = Alignment.CenterHorizontally) {

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
