package com.example.kelompoksatuadmin.paket.ui

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.bumptech.glide.Glide
import com.example.kelompoksatuadmin.R
import com.example.kelompoksatuadmin.databinding.ActivityEditPaketBinding
import com.example.kelompoksatuadmin.paket.model.Paket
import com.google.firebase.database.*

class EditPaketActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityEditPaketBinding
    private lateinit var query: Query

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPaketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPaketData()
    }

    private fun getPaketData() {
        val extras = intent
        if (extras != null) {
            var id = extras.getStringExtra(EXTRA_ID)
            query = FirebaseDatabase.getInstance().getReference("paket")
                .orderByChild("id")
                .equalTo(id)
            query.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (paketSnapshot in snapshot.children) {
                        val paket = paketSnapshot.getValue(Paket::class.java)
                        binding.edtNamaPaket.setText(paket?.namaPaket)
                        binding.edtDomisiliPaket.setText(paket?.domisili)
                        binding.edtDurasiPaket.setText(paket?.durasi)
                        binding.edtHargaPaket.setText(paket?.harga)
                        binding.edtAlamatPaket.setText(paket?.alamatlengkap)
                        binding.edtDeskripsiPaket.setText(paket?.deskripsi)
                        binding.imgPoster.visibility = View.GONE
                        Glide.with(applicationContext)
                            .load(paket?.imagePoster)
                            .into(binding.btnImage)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}