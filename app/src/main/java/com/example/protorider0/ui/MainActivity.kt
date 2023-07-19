package com.example.protorider0.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.protorider0.R
import com.example.protorider0.model.Rider
import com.example.protorider0.ui.extras.OnItemClickListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var viewModel: MainViewModel
    private lateinit var rvRiders: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var firebaseAuth: FirebaseAuth
    private val progressDialog by lazy { CustomProgressDialog(this) }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAuth = FirebaseAuth.getInstance()
        // checkUser()
        bindView()
        bindViewModel()

    }
    override fun onStart() {
        super.onStart()
        progressDialog.start("Henshin...")
        // viewModel.onStart(rider, this)
    }


    override fun onItemClick(rider: Rider) {
        val intent = Intent(this, CartaRider::class.java )
        intent.putExtra("id",rider.id)
        startActivity(intent)
        Log.d("DEMO", "listener on")
    }

    private fun bindView() {
        rvRiders = findViewById(R.id.rvRider)
        rvRiders.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvRiders.adapter = adapter
    }

    private fun bindViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.riders.observe(this) {
            adapter.Update(it)
            progressDialog.stop()
        }
    }


    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}