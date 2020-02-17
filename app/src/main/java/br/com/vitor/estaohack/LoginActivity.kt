package br.com.vitor.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar.setOnClickListener {

            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if(usuario.isEmpty()){
                Toast.makeText(
                    this@LoginActivity,
                    "Preencha o Usuário",
                    Toast.LENGTH_LONG).show()

            }else if(senha.isEmpty()){
                Toast.makeText(
                    this@LoginActivity,
                    "Preencha a Senha",
                    Toast.LENGTH_LONG).show()

            }else if (usuario == "ADM"){
                if (senha == "123"){
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuário Logado",
                        Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(this@LoginActivity,
                        "Senha Incorreta",
                        Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(
                    this@LoginActivity,
                    "Usuário Incorreto",
                    Toast.LENGTH_LONG).show()


            }


        }

        btnCadastrar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }


    }
}
