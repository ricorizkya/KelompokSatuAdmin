package com.example.kelompoksatuadmin.paket

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kelompoksatuadmin.R
import com.example.kelompoksatuadmin.activity.MainActivity
import com.example.kelompoksatuadmin.databinding.ActivityTambahPaketBinding
import com.example.kelompoksatuadmin.paket.model.Paket
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class TambahPaketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahPaketBinding
    var selectedImageuri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahPaketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding.btnImage.setOnClickListener {
            Log.d("Upload Gambar", "Pilih Gambar")
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityImage.launch(intent)
        }

        binding.btnAdd.setOnClickListener { simpanPaket() }
    }

    var activityImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            selectedImageuri = data?.data
            val image = MediaStore.Images.Media.getBitmap(contentResolver, selectedImageuri)
            val bitmap = BitmapDrawable(image)
            binding.imgPoster.visibility = View.GONE
            binding.btnImage.setBackgroundDrawable(bitmap)
        }
    }

    private fun tambahPaket(image: String) {

        if (binding.edtNamaPaket.text.toString().isEmpty() && binding.edtDomisiliPaket.text.toString().isEmpty() && binding.edtDurasiPaket.text.toString().isEmpty() && binding.edtHargaPaket.text.toString().isEmpty() && binding.edtAlamatPaket.text.toString().isEmpty() && image.isEmpty()) {
            binding.edtNamaPaket.error = "Form tidak boleh kosong"
            binding.edtDomisiliPaket.error = "Form tidak boleh kosong"
            binding.edtDurasiPaket.error = "Form tidak boleh kosong"
            binding.edtHargaPaket.error = "Form tidak boleh kosong"
            binding.edtAlamatPaket.error = "Form tidak boleh kosong"
            return Toast.makeText(applicationContext, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }

        val ref = FirebaseDatabase.getInstance().getReference("paket")
        val paketId = ref.push().key
        val paket = Paket(
            paketId,
            binding.edtNamaPaket.text.toString(),
            binding.edtDomisiliPaket.text.toString(),
            binding.edtDurasiPaket.text.toString(),
            binding.edtHargaPaket.text.toString(),
            binding.edtAlamatPaket.text.toString(),
            image
        )

        if (paketId != null) {
            ref.child(paketId).setValue(paket)
                .addOnSuccessListener {
                    Log.d("InputPaket", "Berhasil Input Data Paket")
                    Toast.makeText(applicationContext, "Paket Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
        }
    }

    private fun simpanPaket() {
        if (selectedImageuri == null) return
        val fileName = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/images/paket/$fileName")
        ref.putFile(selectedImageuri!!)
            .addOnSuccessListener {
                Log.d("UploadGambar", "Berhasil Upload Gambar: ${it.metadata?.path}")
                ref.downloadUrl.addOnSuccessListener {
                    Log.d("UploadGambar", "File Location: $it")
                    tambahPaket(it.toString())
                }
            }
            .addOnFailureListener {
                Log.d("Upload Gambar", "Gagal Upload Gambar")
            }
    }
}