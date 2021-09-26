package com.example.kelompoksatuadmin.paket

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kelompoksatuadmin.R
import com.example.kelompoksatuadmin.databinding.FragmentPaketBinding

class PaketFragment : Fragment() {

    private lateinit var binding: FragmentPaketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            binding.btnAddPackage.setOnClickListener {
                activity?.startActivity(Intent(activity, TambahPaketActivity::class.java))
            }
        }
    }
}