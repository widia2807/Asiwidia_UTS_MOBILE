package com.example.uts_widia

import android.os.Bundle
import android.appcompat.app.AppCompatActivity
import android.widget.TextView

class DataAlumniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_alumni)

        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val namaTextView: TextView = findViewById(R.id.namaTextView)
        val nimTextView: TextView = findViewById(R.id.nimTextView)
        val kelasTextView: TextView = findViewById(R.id.kelasTextView)

        // Ambil data alumni dari database atau sumber data lainnya
        val dataAlumni = getDataAlumni(1)

        // Tampilkan data alumni ke view
        emailTextView.text = dataAlumni.email
        namaTextView.text = dataAlumni.nama
        nimTextView.text = dataAlumni.nim.toString()
        kelasTextView.text = dataAlumni.kelas
    }

    data class DataAlumni(
        val nim: Int,
        val nama: String,
        val email: String,
        val kelas: String
    )

    private fun getDataAlumni(nomor: Int): DataAlumni {
        // Ambil data alumni dari database atau sumber data lainnya
        val dataAlumni = arrayOf(
            DataAlumni(2007411020, "Widia Nurcahya", "widia@gmail.com", "Teknik Informatika-8A"),
            DataAlumni(2007411112, "Fulan bin Fulan", "fulan@gmail.com", "Teknik Listrik-8B"),
            DataAlumni(2007744112, "Diana Dwi Puspitasari", "diana@gmail.com", "Manajemen-8C")
        )

        return dataAlumni.first { it.nim == nomor }
    }
    // Fungsi dan variabel lainnya
}