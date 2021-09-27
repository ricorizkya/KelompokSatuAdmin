package com.example.kelompoksatuadmin.guide

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kelompoksatuadmin.R
import com.example.kelompoksatuadmin.databinding.FragmentGuideBinding


class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuideBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            binding.btnAddGuide.setOnClickListener {
                activity?.startActivity(Intent(activity, TambahGuideActivity::class.java))
            }
        }
    }
}