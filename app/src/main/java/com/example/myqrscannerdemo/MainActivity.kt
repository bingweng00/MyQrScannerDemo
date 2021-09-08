package com.example.myqrscannerdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnScan : Button = findViewById(R.id.btnScan)

        btnScan.setOnClickListener(){
            val qrScanner = IntentIntegrator(this)

            qrScanner.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result != null){
            val strCode = result.contents

//            Real mobile only
//            val obj = JSONObject(result.contents)
//            findViewById<TextView>(R.id.Result).text = obj.getString("tel")

            findViewById<TextView>(R.id.Result).text = strCode
        }
    }
}