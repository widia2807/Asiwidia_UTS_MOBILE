import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_widia.database.AlumniDatabase
import com.example.uts_widia.model.DataAlumni

class TambahDataActivity : AppCompatActivity() {

    private lateinit var nimEditText: EditText
    private lateinit var namaEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var kelasEditText: EditText

    private lateinit var alumniDatabase: AlumniDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)

        val emailTextView: TextView = findViewById(R.id.email_text_view)
        val namaTextView = findViewById<TextView>(R.id.nama_text_view)
        val nimTextView = findViewById<TextView>(R.id.nim_text_view)
        val kelasTextView = findViewById<TextView>(R.id.kelas_text_view)

        alumniDatabase = AlumniDatabase.getInstance(this)

        val simpanButton: Button = findViewById(R.id.simpan_button)
        simpanButton.setOnClickListener {
            val nim = nimEditText.text.toString().trim()
            val nama = namaEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val kelas = kelasEditText.text.toString().trim()

            if (nim.isEmpty() || nama.isEmpty() || email.isEmpty() || kelas.isEmpty()) {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val dataAlumni = DataAlumni(nim.toInt(), nama, email, kelas)
            alumniDatabase.dataAlumniDao().insert(dataAlumni)

            Toast.makeText(this, "Data alumni berhasil disimpan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}