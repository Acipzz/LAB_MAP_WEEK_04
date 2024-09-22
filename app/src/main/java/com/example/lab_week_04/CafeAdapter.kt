package com.example.lab_week_04

import android.content.Context
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(
    private val context: Context,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val cafeData = listOf(
        Pair(R.string.starbucks_title, R.string.starbucks_desc),
        Pair(R.string.janjijiwa_title, R.string.janjijiwa_desc),
        Pair(R.string.kopikenangan_title, R.string.kopikenangan_desc)
    )

    override fun getItemCount(): Int {
          return cafeData.size
    }
    override fun createFragment(position: Int): Fragment {
        val (titleResId, descriptionResId) = cafeData[position]
        val title = context.getString(titleResId)
        val description = context.getString(descriptionResId)
        return CafeDetailFragment.newInstance(title, description)
    }
}