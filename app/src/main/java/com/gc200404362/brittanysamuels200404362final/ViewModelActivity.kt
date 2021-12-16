package com.gc200404362.brittanysamuels200404362final

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class ViewModelActivity : ViewModel(){

    private val entries = MutableLiveData<List<Entry>>()

    init{
        loadEntires()
    }

    private fun loadEntires(){
        //order by rank
        val db = FirebaseFirestore.getInstance().collection("entries").orderBy("rank")
        db.addSnapshotListener{ documents, exception ->
            val entryList = ArrayList<Entry>()

            documents?.let{
                for(document in documents){
                    val entry = document.toObject(Entry::class.java)
                    entryList.add(entry)
                }
            }
            entries.value = entryList
        }

    }
    fun getEntries() : LiveData<List<Entry>> {
        return entries
    }
}