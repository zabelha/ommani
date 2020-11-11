package br.com.opeimpacta.ommani

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFiribaseMessagingService: FirebaseMessagingService() {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Prefs.setString("FB_TOKEN", token!!)
        Log.d("firebase", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {

        if(mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d("firebase", titulo!!)
            Log.d("firebase", corpo!!)
            showNotification(mensagemRemota)
        }
        if(mensagemRemota?.data!!.isNullOrEmpty()){
            val dado = mensagemRemota?.data!!.get("produtoId")
            Log.d("firebase", "Dado $dado")
        }
    }
    private fun showNotification(mensagemRemota: RemoteMessage?){
        val intent = Intent(this, TelaInicialActivity::class.java)
        val titulo = mensagemRemota?.notification?.title
        val corpo = mensagemRemota?.notification?.body

        NotificationUtil.create(1, intent, titulo!!, corpo!!)
    }

}