package com.example.kelompoksatuadmin.guide.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompoksatuadmin.databinding.FragmentGuideBinding
import com.example.kelompoksatuadmin.guide.adapter.GuideAdapter
import com.example.kelompoksatuadmin.guide.model.Guide
import com.google.firebase.database.*


class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private lateinit var guideRecyclerView: RecyclerView
    private lateinit var guideArrayList: ArrayList<Guide>
    private lateinit var query: Query

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

            guideRecyclerView = binding.rvGuide
            guideRecyclerView.layoutManager = LinearLayoutManager(context)
            guideRecyclerView.setHasFixedSize(true)

            guideArrayList = arrayListOf()
            getGuideData()
        }
    }

    fun getGuideData() {
        query = FirebaseDatabase.getInstance().getReference("guide")
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (guideSnapshot in snapshot.children) {
                        val guide = guideSnapshot.getValue(Guide::class.java)
                        guideArrayList.add(guide!!)
                    }
                    guideRecyclerView.adapter = GuideAdapter(guideArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}