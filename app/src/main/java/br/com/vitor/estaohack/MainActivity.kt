package br.com.vitor.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minhaPreferencia = getSharedPreferences("cadastro",Context.MODE_PRIVATE)

        txvEmail.text = minhaPreferencia.getString("email","erro no email")
        txvNome.text = minhaPreferencia.getString("nome","erro no nome")
        txvSexo.text = minhaPreferencia.getString("sexo", "erro no sexo")

        btnSair.setOnClickListener {
            onBackPressed()


        }

        btnSiteCellup.setOnClickListener {
            startActivity(Intent(this@MainActivity::class.java))

        }
        /*
            * sobre escreve o metodo voltar
            *
            * override fun onBackPressed(){
            *   super.onBackPressed()
            * }
            *
            * */

    }
}
