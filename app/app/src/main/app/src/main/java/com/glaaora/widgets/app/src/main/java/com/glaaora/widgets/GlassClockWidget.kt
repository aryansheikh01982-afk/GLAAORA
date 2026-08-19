package com.glaaora.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GlassClockWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateClock(context, appWidgetManager, appWidgetId)
        }
    }

    companion object {
        fun updateClock(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val dateFormat = SimpleDateFormat("EEE, dd MMM", Locale.getDefault())

            val currentTime = timeFormat.format(Date())
            val currentDate = dateFormat.format(Date())

            val views = RemoteViews(
                context.packageName,
                R.layout.widget_glass_clock
            )

            views.setTextViewText(R.id.clock_text, currentTime)
            views.setTextViewText(R.id.date_text, currentDate)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
