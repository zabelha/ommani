package br.com.opeimpacta.ommani

import android.app.Application
import java.lang.IllegalStateException

class OmmaniAplication: Application(){
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: OmmaniAplication? = null
        fun getInstance(): OmmaniAplication {
            if (appInstance == null){
                throw IllegalStateException(
                    "Configurar application no AndroidManifest"
                )
            }
            return appInstance!!
        }
    }


}