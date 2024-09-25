package br.unipar.atividade3pt2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edNumHomens: EditText
    private lateinit var edNumMulheres: EditText
    private lateinit var edNumCriancas: EditText
    private lateinit var txtCarne: TextView
    private lateinit var txtAperitivos: TextView
    private lateinit var txtTotalKgComida: TextView
    private lateinit var txtCerveja: TextView
    private lateinit var txtAgua: TextView
    private lateinit var txtRefrigerante: TextView
    private lateinit var txtTotalLitrosBebida: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnZerar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNumHomens = findViewById(R.id.edNumHomens)
        edNumMulheres = findViewById(R.id.edNumMulheres)
        edNumCriancas = findViewById(R.id.edNumCriancas)
        txtCarne = findViewById(R.id.txtCarne)
        txtAperitivos = findViewById(R.id.txtAperitivos)
        txtTotalKgComida = findViewById(R.id.txtTotalKgComida)
        txtCerveja = findViewById(R.id.txtCerveja)
        txtAgua = findViewById(R.id.txtAgua)
        txtRefrigerante = findViewById(R.id.txtRefrigerante)
        txtTotalLitrosBebida = findViewById(R.id.txtTotalLitrosBebida)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnZerar = findViewById(R.id.btnZerar)

        btnCalcular.setOnClickListener { calcular() }
        btnZerar.setOnClickListener { zerar() }
    }

    private fun calcular() {
        val numHomens = edNumHomens.text.toString().toIntOrNull() ?: 0
        val numMulheres = edNumMulheres.text.toString().toIntOrNull() ?: 0
        val numCriancas = edNumCriancas.text.toString().toIntOrNull() ?: 0

        val carnePorHomem = 400
        val carnePorMulher = 300
        val carnePorCrianca = 200
        val margemSeguranca = 0.10

        val totalCarne = (numHomens * carnePorHomem + numMulheres * carnePorMulher + numCriancas * carnePorCrianca) * (1 + margemSeguranca)

        val aperitivoPorHomem = 150
        val aperitivoPorMulher = 100
        val aperitivoPorCrianca = 50
        val totalAperitivos = (numHomens * aperitivoPorHomem + numMulheres * aperitivoPorMulher + numCriancas * aperitivoPorCrianca) * (1 + margemSeguranca)

        val cervejaPorHomem = 4
        val cervejaPorMulher = 2
        val totalCerveja = (numHomens * cervejaPorHomem + numMulheres * cervejaPorMulher) * (1 + margemSeguranca)

        val aguaPorPessoa = 2
        val refrigerantePorPessoa = 1.5
        val totalAgua = (numMulheres + numCriancas) * aguaPorPessoa * (1 + margemSeguranca)
        val totalRefrigerante = (numMulheres + numCriancas) * refrigerantePorPessoa * (1 + margemSeguranca)

        val totalComidaKg = (totalCarne + totalAperitivos) / 1000
        val totalBebidasLitros = totalCerveja + totalAgua + totalRefrigerante

        txtCarne.text = "Carne: ${totalCarne.toInt()} g"
        txtAperitivos.text = "Aperitivos: ${totalAperitivos.toInt()} g"
        txtTotalKgComida.text = "Total em Kilos: $totalComidaKg Kg"
        txtCerveja.text = "Cerveja: ${totalCerveja.toInt()} L"
        txtAgua.text = "Água: ${totalAgua.toInt()} L"
        txtRefrigerante.text = "Refrigerante: ${totalRefrigerante.toInt()} L"
        txtTotalLitrosBebida.text = "Total em Litros: $totalBebidasLitros L"
    }

    private fun zerar() {
        edNumHomens.text.clear()
        edNumMulheres.text.clear()
        edNumCriancas.text.clear()
        txtCarne.text = "Carne: 0 g"
        txtAperitivos.text = "Aperitivos: 0 g"
        txtTotalKgComida.text = "Total em Kilos: 0 Kg"
        txtCerveja.text = "Cerveja: 0 L"
        txtAgua.text = "Água: 0 L"
        txtRefrigerante.text = "Refrigerante: 0 L"
        txtTotalLitrosBebida.text = "Total em Litros: 0 L"
    }
}



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_margin="16dp"
        android:orientation="vertical"
        android:background="#FFFFFF"
        android:elevation="4dp"
        android:padding="16dp"
        android:layout_marginTop="8dp"
        tools:ignore="MissingConstraints">

        <TextView
            android:id="@+id/textViewNomeAluno"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:text="ChurrasPar"
            android:textColor="#4CAF50"
            android:textSize="24sp"
            android:textStyle="bold" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Número de Homens:"
            android:textSize="16sp"
            android:textColor="#333333" />

        <EditText
            android:id="@+id/edNumHomens"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:hint="Insira o número de homens" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Número de Mulheres:"
            android:textSize="16sp"
            android:layout_marginTop="16dp" />

        <EditText
            android:id="@+id/edNumMulheres"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:hint="Insira o número de mulheres" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Número de Crianças:"
            android:textSize="16sp"
            android:layout_marginTop="16dp" />

        <EditText
            android:id="@+id/edNumCriancas"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:hint="Insira o número de crianças" />

        <Button
            android:id="@+id/btnCalcular"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:backgroundTint="#4CAF50"
            android:text="Calcular"
            android:textColor="#FFFFFF" />

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@+id/textViewNomeAluno"
            android:layout_marginTop="16dp"
            android:gravity="center"
            android:text="COMIDA"
            android:textColor="#4CAF50"
            android:textSize="20sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/txtTotalKgComida"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtAperitivos"
            android:text="Total em Kilos: 0 Kg"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/txtAperitivos"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtCarne"
            android:text="Aperitivos: 0 g"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/txtCarne"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtResultado"
            android:text="Carne: 0 g"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/txtBebida"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtTotalKgComida"
            android:gravity="center"
            android:text="BEBIDA"
            android:textColor="#4CAF50"
            android:textSize="20sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/txtTotalLitrosBebida"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtRefrigerante"
            android:text="Total em Litros: 0 L"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/txtRefrigerante"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtAgua"
            android:text="Refrigerante: 0 L"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/txtAgua"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtCerveja"
            android:text="Água: 0 L"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/txtCerveja"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/txtBebida"
            android:text="Cerveja: 0 L"
            android:textSize="16sp" />

        <Button
            android:id="@+id/btnZerar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Limpar"
            android:backgroundTint="#E01414"
            android:textColor="#FFFFFF"
            android:layout_marginTop="8dp" />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
