package com.example.juangonzalezherramientasdeprogramacionmovils8

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class AppWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray
    ) {

        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.app_widget_layout)


            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.btnWidgetDecimalToBinary, pendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}