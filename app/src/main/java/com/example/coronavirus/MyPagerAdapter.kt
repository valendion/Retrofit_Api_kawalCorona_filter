package com.example.coronavirus

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter (fm:FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return  when(position){
            0 -> {
                FragmentSatu()
            }
            1 ->{
                FragmentDua()
            }
            else -> {
                return  FragmentKetiga()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Dunia"
            1 -> "Daftar Negara"
            else -> return "Provinsi"
        }
    }
}