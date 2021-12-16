package com.gc200404362.brittanysamuels200404362final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gc200404362.brittanysamuels200404362final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**a)	When the user clicks on the “add new bucket list item” from the main activity,
         * they should be taken to a view that allows them to enter information about new destinations.
         *  The view should use the same background as the main activity. (2 marks) **/
        binding.addNewBucketListButton.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        binding.viewBucketListButton.setOnClickListener(){
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

    }
}