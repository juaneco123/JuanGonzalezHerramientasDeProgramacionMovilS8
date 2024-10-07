package com.example.juangonzalezherramientasdeprogramacionmovils8

import android.app.Service
import android.content.Intent
import android.os.IBinder

class Servicios : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        // No se necesita enlazar
        return null
    }

    // Puedes implementar lógica aquí para tareas en segundo plano
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Ejemplo de código para iniciar una tarea en segundo plano
        return START_STICKY
    }
}
