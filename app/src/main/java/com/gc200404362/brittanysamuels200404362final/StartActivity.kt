package com.gc200404362.brittanysamuels200404362final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gc200404362.brittanysamuels200404362final.databinding.ActivityStartBinding
import com.google.firebase.firestore.FirebaseFirestore

//made by accident supposed to be AddDestinationActivity
class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //look for cahnges when user submits bucket list
        binding.submitNewBucketListItem.setOnClickListener{
            /**d)	If all the fields have a value, save the information to the firestore database and show a toast stating that the save was successful(2 marks) **/
            if(binding.enterDestination.text.toString().isNotEmpty() && binding.enterDescription.text.toString().isNotEmpty() && binding.spinner.selectedItemPosition > 0){

                //create instance of model class and assign to view bindings
                var entry = Entry()
                entry.destination = binding.enterDestination.text.toString()
                entry.description = binding.enterDescription.text.toString()
                entry.rank = binding.spinner.selectedItem.toString().toInt()

                //connect to db
                val db = FirebaseFirestore.getInstance().collection("entries")
                entry.id = db.document().id

                /** e)	If the information was successfully stored, navigate the user back to the main activity.(1 mark)**/
                db.document(entry.id!!).set(entry).addOnSuccessListener {
                    //if data successfully gets passed to db create a toast
                    Toast.makeText(this, "You bucket list item as been successfully saved!", Toast.LENGTH_LONG).show()
                    //when sucessful and info passed to db then resets views
                    binding.enterDestination.setText("")
                    binding.enterDescription.setText("")
                    binding.spinner.setSelection(0)

                    //send user back to the main activity
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }else{
                /** c)	If any of the fields do not have a value and the “add destination” button is pressed,
                 * show a toast stating all fields need to be populated (1 mark)**/
                Toast.makeText(this, "Destination name, description and ranking required! Please enter the information into the fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}