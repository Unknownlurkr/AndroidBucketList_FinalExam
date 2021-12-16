package com.gc200404362.brittanysamuels200404362final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gc200404362.brittanysamuels200404362final.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel : ViewModelActivity by viewModels()

        viewModel.getEntries().observe(this, { entries ->
            var recyclerViewAdapter = RecyclerViewAdapter(this, entries)
            binding.verticalRecyclerView.adapter = recyclerViewAdapter
        })
        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}