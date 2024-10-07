package com.example.juangonzalezherramientasdeprogramacionmovils8

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificacionUtils {
    // Método para enviar notificaciones
    fun sendNotification(context: Context, message: String) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "calculadora_channel"

        // Crear el canal de notificación para Android Oreo y superior
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Calculadora Notificaciones",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Construir la notificación
        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Resultado de la operación")
            .setContentText(message)  // Mensaje que se mostrará en la notificación
            .setSmallIcon(R.drawable.ic_notification)  // Icono de la notificación
            .build()

        // Mostrar la notificación
        notificationManager.notify(1, notification)  // ID de notificación
    }
}