package com.example.kelompoksatuadmin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.kelompoksatuadmin.paket.ui.PaketFragment
import com.example.kelompoksatuadmin.R
import com.example.kelompoksatuadmin.databinding.ActivityMainBinding
import com.example.kelompoksatuadmin.guide.ui.GuideFragment
import com.example.kelompoksatuadmin.pesanan.PesananFragment
import com.example.kelompoksatuadmin.user.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val paketFragment = PaketFragment()
        val pesananFragment = PesananFragment()
        val userFragment = UserFragment()
        val guideFragment = GuideFragment()

        makeCurrentFragment(paketFragment)
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.paket_menu -> makeCurrentFragment(paketFragment)
                R.id.pesanan_menu -> makeCurrentFragment(pesananFragment)
                R.id.user_menu -> makeCurrentFragment(userFragment)
                R.id.guide_menu -> makeCurrentFragment(guideFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_content, fragment)
            commit()
        }
    }
}