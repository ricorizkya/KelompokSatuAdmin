package com.example.kelompoksatuadmin.guide.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kelompoksatuadmin.databinding.ListGuideBinding
import com.example.kelompoksatuadmin.guide.model.Guide
import com.example.kelompoksatuadmin.guide.ui.DetailGuideActivity
import com.example.kelompoksatuadmin.paket.ui.DetailPaketActivity

class GuideAdapter(private val guideList: ArrayList<Guide>): RecyclerView.Adapter<GuideAdapter.GuideViewHolder>() {

    inner class GuideViewHolder(private val binding: ListGuideBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(guide: Guide) {
            with(binding) {
                tvNama.text = guide.namaGuide
                tvHp.text = guide.nomorGuide
                tvEmail.text = guide.emailGuide
                Glide.with(itemView.context)
                        .load(guide.fotoGuide)
                        .into(imgProfile)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailGuideActivity::class.java)
                    intent.putExtra(DetailGuideActivity.EXTRA_ID, guide.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val listGuideBinding = ListGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideViewHolder(listGuideBinding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        val guide = guideList[position]
        holder.bind(guide)
    }

    override fun getItemCount(): Int = guideList.size
}