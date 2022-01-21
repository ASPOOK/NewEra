package com.aspook.jsengine

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aspook.newera.R
import com.quickjs.QuickJS

class QuickJSActivity : AppCompatActivity() {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_jsactivity)

        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)

        setListeners()
    }

    private fun setListeners() {
        btn1.setOnClickListener {
            QuickJsTool.quickJsTest()
        }

        btn2.setOnClickListener {
//            for (i in 1..10) {
////                Thread.sleep(500)
////                QuickJsTool.quickJsTestClose()
//                test()
//            }
        }

        btn3.setOnClickListener {
            test()
        }

        btn4.setOnClickListener {

        }
    }

    private fun test() {
        val quickJS = QuickJS.createRuntime()
        for (i in 1..10) {
            val jsContext = quickJS.createContext()
        }

    }
}
