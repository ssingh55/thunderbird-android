package net.thunderbird.feature.widget.message.list

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class MessageListWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MessageListWidget()

    override fun onReceive(context: Context, intent: Intent) {
        // Validate the intent action to ensure it's the expected APPWIDGET_UPDATE
        if (intent.action != AppWidgetManager.ACTION_APPWIDGET_UPDATE) {
            // Log or ignore intents with unexpected actions
            return
        }

        // Validate any specific extras if they are used by the widget logic.
        // For APPWIDGET_UPDATE, AppWidgetManager.EXTRA_APPWIDGET_IDS is common.
        // Ensure it's present and not empty if your widget logic relies on it.
        val appWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS)
        if (appWidgetIds == null || appWidgetIds.isEmpty()) {
            // Log or ignore intents without valid widget IDs if they are critical
            return
        }

        // If the intent is valid, proceed with the superclass's handling
        super.onReceive(context, intent)
    }
}
