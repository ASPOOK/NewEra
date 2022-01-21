package com.aspook.newera

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.lifecycle.ProcessLifecycleOwner
import com.aspook.compose.ComposeActivity
import com.aspook.newera.databinding.ActivityScrollingBinding
import com.aspook.jsengine.QuickJSActivity
import com.aspook.jsengine.V8TestActivity

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
//        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // 设置点击监听器
        setClickListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setClickListeners() {
        val btnCompose: Button = binding.root.findViewById(R.id.btn_compose)
        btnCompose.setOnClickListener {
            val intent = Intent(this, ComposeActivity::class.java)
            startActivity(intent)
        }

        val btnQuickJS: Button = binding.root.findViewById(R.id.btn_quick_js)
        btnQuickJS.setOnClickListener {
            val intent = Intent(this, QuickJSActivity::class.java)
            startActivity(intent)
        }

        val btnV8: Button = binding.root.findViewById(R.id.btn_v8)
        btnV8.setOnClickListener {
            val intent = Intent(this, V8TestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("anxiaofei", "onStart");
    }

    override fun onStop() {
        super.onStop()
        Log.d("anxiaofei", "onStop");
    }


}