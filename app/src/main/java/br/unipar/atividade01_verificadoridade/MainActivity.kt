package br.unipar.atividade01_verificadoridade

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextIdade: EditText
    private lateinit var buttonVerificar: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextIdade = findViewById(R.id.editTextIdade)
        buttonVerificar = findViewById(R.id.buttonVerificar)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonVerificar.setOnClickListener {
            verificarIdade()
        }
    }

    private fun verificarIdade() {
        val idadeStr = editTextIdade.text.toString()

        if (idadeStr.isEmpty()) {
            Toast.makeText(this, "Por favor, insira sua idade!", Toast.LENGTH_SHORT).show()
            return
        }

        val idade = idadeStr.toIntOrNull()

        if (idade == null || idade < 0) {
            Toast.makeText(this, "Por favor, insira uma idade válida!", Toast.LENGTH_SHORT).show()
            return
        }

        val resultado = when {
            idade < 18 -> "Você é menor de idade."
            idade in 18..60 -> "Você está na meia idade."
            else -> "Você é idoso."
        }
        
        textViewResultado.text = resultado
    }
}
