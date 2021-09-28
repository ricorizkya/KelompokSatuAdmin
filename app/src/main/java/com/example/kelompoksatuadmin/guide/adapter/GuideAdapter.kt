package com.example.kelompoksatuadmin.guide.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kelompoksatuadmin.databinding.ListGuideBinding
import com.example.kelompoksatuadmin.guide.model.Guide

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