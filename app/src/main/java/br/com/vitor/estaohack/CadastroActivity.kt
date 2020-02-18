package br.com.vitor.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        //R maisculo é a pasta Resources e as demais pastas
        //getter e setter é implicita
        //a lista pode ter varios tipos
        //só precisa tipar o array quando a lista está vazia
        val listaSexo = arrayListOf("Selecione o sexo", "Masculino", "Feminino","Outros")

        //CRIANDO O ADAPTER DO SPINNER

        //tudo que for mexer com apresentação de lista precisa de adapter

        val sexoAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
            )

        spnSexo.adapter = sexoAdapter


        btnCadastrar.setOnClickListener {

            val nome = edtNomeCadastro.text.toString().trim()
            val sobrenome = edtSobreNomeCadastro.text.toString().trim().toLowerCase()
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()
            val sexo = spnSexo.selectedItem.toString()

            if (nome.isEmpty() ||
                sobrenome.isEmpty() ||
                email.isEmpty() ||
                senha.isEmpty()
                || spnSexo.selectedItem == "Selecione o sexo") {
                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("Opss algo deu errado...")
                    .setMessage("Todos os campos são obrigatórios")
                    .setPositiveButton("Ok") { _, _ ->
                        //Aqui vai a ação que desejar
                    }
                    .setCancelable(false)
                    .create()
                    .show()

            } else {
                    val minhaPreferencia = getSharedPreferences("cadastro", Context.MODE_PRIVATE)
                    val meuEditor = minhaPreferencia.edit()

                    meuEditor.putString("nome", nome).apply()
                    meuEditor.putString("sobrenome", sobrenome).apply()
                    meuEditor.putString("email", email).apply()
                    meuEditor.putString("senha", senha).apply()
                    meuEditor.putString("sexo", sexo).apply()

                    startActivity(Intent(this@CadastroActivity, MainActivity::class.java))



            }
        }
    }
}
