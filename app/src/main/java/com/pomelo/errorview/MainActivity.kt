package com.pomelo.errorview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btEmpty: Button? = null
    private var btError: Button? = null
    private var btSucceed: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btEmpty = findViewById(R.id.bt_empty) as Button
        btError = findViewById(R.id.bt_error) as Button
        btSucceed = findViewById(R.id.bt_succeed) as Button
        btEmpty!!.setOnClickListener(this)
        btError!!.setOnClickListener(this)
        btSucceed!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_empty //空的界面
            -> {
                Toast.makeText(this, "我是空的界面", Toast.LENGTH_SHORT).show()
            }
            R.id.bt_error //成功的界面
            -> {
                Toast.makeText(this, "我是成功的界面", Toast.LENGTH_SHORT).show()
            }
            R.id.bt_succeed //错误的界面
            -> {
                Toast.makeText(this, "我是错误的界面", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun getName(num: Int):String {
        return ""
    }

}
