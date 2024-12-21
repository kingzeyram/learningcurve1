package com.jynette.swalafoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SharedprefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sharedpref)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // we need to find the edit texts
        val UsernameInput = findViewById<EditText>(R.id.username) as EditText
        val PasswordInput : EditText = findViewById(R.id.password)


        // Get the button to save out profile
        val updatebtn = findViewById<Button>(R.id.updatebtn) as Button

        // TODO: CREATE SHARED PREFERENCES OBJECT
        val pref = this.getSharedPreferences("storage", MODE_PRIVATE)
        // MODE_PRIVATE - Available only in the application

        // TODO: SAVE TO SHARED PREFS
        updatebtn.setOnClickListener{
            // getting user input
            val username = UsernameInput.text.toString()
            val password = PasswordInput.text.toString()
            // create Editor
            val editor = pref.edit()
            // we save our sharedprefs as key, value #kijson like
            editor.putString("username", username)
            editor.putString("password", password)
            // Then we apply/commit the changes
            editor.apply()
            // SOMETHING EXTRA - Intent to the mainActivity and close the app
            val go = Intent(applicationContext,MainActivity::class.java)
            startActivity(go)
            finish()
        }

        //TODO: READ FROM SHARED PREFS - MAIN ACTIVITY
        // create shared pref objects
       val user = pref.getString("username","")
        UsernameInput.setText(user)

        //TODO: CLEAR ALL FROM SHARED PREFS
        val reset = findViewById<TextView>(R.id.reset) as TextView
        reset.setOnClickListener{
            val editor = pref.edit()
            editor.clear()
            editor.apply()
            val go = Intent(applicationContext,MainActivity::class.java)
            startActivity(go)
            finish()
        }
    }
}