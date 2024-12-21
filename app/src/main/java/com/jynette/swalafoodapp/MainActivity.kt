package com.jynette.swalafoodapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //find the recycler id
        val recycler = findViewById<RecyclerView>(R.id.recyclerview) as RecyclerView
        // the layoutmanager sets views vertically
        val layoutmanager = LinearLayoutManager(this)
        // put the layoutmanager to the recycler view
        recycler.layoutManager = layoutmanager
        //get the recycler Adapter
        val adapter = RecyclerAdapter(applicationContext)
        // load the adapter with data to our UI (recyclerview)
        recycler.adapter = adapter

        // handle the modal bottom saheet
        //apply its height and collapse behaviour on the screen
        val bottomsheet : FrameLayout = findViewById(R.id.bottom_sheet_container)
        BottomSheetBehavior.from(bottomsheet).apply {
            // apply height
            peekHeight = 330
            //apply Behaviour
            this.state = BottomSheetBehavior.STATE_COLLAPSED
            //observe sheet effect when pulled down
        }
        //order Button
        val order = findViewById<Button>(R.id.order_btn) as Button
        order.setOnClickListener {
            val ordernow = Intent(applicationContext, OrderActivity::class.java)
            startActivity(ordernow)
        }
        val more = findViewById<Button>(R.id.more_btn) as Button
        more.setOnClickListener {
            val morebtn = Intent(applicationContext, SharedprefActivity::class.java)
            startActivity(morebtn)
        }

        //TODO :READ DATA SHAREPREFS
        val welcome = findViewById<TextView>(R.id.welcome) as TextView
        // create shared pref object
        val prefs = this.getSharedPreferences("storage", MODE_PRIVATE)
        val x = prefs.getString("username","") // WE HAVE OUR DATA

        welcome.append("\n"+ x)

        if(prefs.contains("password")){
            Toast.makeText(applicationContext,"You can order",Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(applicationContext,"Please Log In",Toast.LENGTH_LONG).show()
            order.visibility = View.GONE
        }
    }
}