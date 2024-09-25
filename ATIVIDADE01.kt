package br.unipar.atividade3pt1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunoAdapter(private val alunosList: List<Aluno>) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_aluno, parent, false)
        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunosList[position]
        holder.tvNomeAluno.text = aluno.nome
        holder.tvAreaEscolha.text = aluno.areaEscolha
        holder.tvData.text = aluno.data
    }

    override fun getItemCount(): Int {
        return alunosList.size
    }

    class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomeAluno: TextView = itemView.findViewById(R.id.tvNomeAluno)
        val tvAreaEscolha: TextView = itemView.findViewById(R.id.tvAreaEscolha)
        val tvData: TextView = itemView.findViewById(R.id.tvData)
    }
}



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val alunosList = mutableListOf<Aluno>()
    private lateinit var adapter: AlunoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      
        adapter = AlunoAdapter(alunosList)
        rvAlunos.layoutManager = LinearLayoutManager(this)
        rvAlunos.adapter = adapter

        
        btnInserir.setOnClickListener {
            val nome = etNomeAluno.text.toString()
            val areaEscolha = etAreaEscolha.text.toString()

            if (nome.isNotEmpty() && areaEscolha.isNotEmpty()) {
                val dataAtual = SimpleDateFormat("dd/MM", Locale.getDefault()).format(Date())
                val aluno = Aluno(nome, areaEscolha, dataAtual)
                alunosList.add(aluno)
                adapter.notifyDataSetChanged()

                
                tvCountAlunos.text = "${alunosList.size} Alunos"

                
                etNomeAluno.text.clear()
                etAreaEscolha.text.clear()
            }
        }

        
        btnZerar.setOnClickListener {
            alunosList.clear()
            adapter.notifyDataSetChanged()
            tvCountAlunos.text = "0 Alunos"
        }
    }
}

data class Aluno(val nome: String, val areaEscolha: String, val data: String)




<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/etNomeAluno"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Nome Aluno"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0"
        android:layout_marginTop="16dp"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"/>

    <EditText
        android:id="@+id/etAreaEscolha"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Área de Escolha"
        app:layout_constraintTop_toBottomOf="@+id/etNomeAluno"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/btnInserir"
        android:layout_marginTop="16dp"
        android:layout_marginStart="16dp"/>

    <Button
        android:id="@+id/btnInserir"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Inserir"
        app:layout_constraintTop_toBottomOf="@+id/etNomeAluno"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"/>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rvAlunos"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@+id/etAreaEscolha"
        app:layout_constraintBottom_toTopOf="@+id/tvCountAlunos"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"/>

    <TextView
        android:id="@+id/tvCountAlunos"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="0 Alunos"
        android:gravity="center"
        android:textColor="@android:color/white"
        android:padding="10dp"
        app:layout_constraintTop_toBottomOf="@+id/rvAlunos"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"/>

    <Button
        android:id="@+id/btnZerar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="ZERAR"
        android:backgroundTint="@android:color/holo_red_dark"
        app:layout_constraintTop_toBottomOf="@+id/tvCountAlunos"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="16dp"/>

</androidx.constraintlayout.widget.ConstraintLayout>
