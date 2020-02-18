package br.com.vitor.estaohack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minhaPreferencia = getSharedPreferences("cadastro",Context.MODE_PRIVATE)

        txvEmail.text = minhaPreferencia.getString("email","erro no email")
        txvNome.text = minhaPreferencia.getString("email","erro no nome")
        txvSexo.text = minhaPreferencia.getString("email", "erro no sexo")


    }
}
