package edu.fullerton.fz.cs411.activity01

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

const val LOG_TAG = "lifecycle"

private const val COUNTER_KEY = "myCounter"

class MainActivity : AppCompatActivity() {

    private lateinit var incr_button: Button
    private lateinit var counter_label: TextView
    private lateinit var image: ImageView
    private val counterViewModel: MyCounterViewModel by lazy {
        ViewModelProvider(this).get(MyCounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // generated by Android Studio
        Log.i(LOG_TAG, "activity created")

        setContentView(R.layout.activity_main)
        incr_button = findViewById(R.id.increase)
        counter_label = findViewById(R.id.counter)
        incr_button.setOnClickListener {
            counterViewModel.increaseCounter()
            updateCounterText()
        }

        val previousCounter = savedInstanceState?.getInt(COUNTER_KEY, 0) ?: 0
        counterViewModel.setCounter(previousCounter)

        updateCounterText()
    }

    fun updateCounterText() {
        counter_label.text = counterViewModel.getCounter().toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(LOG_TAG,"Saving instance data")
        outState.putInt(COUNTER_KEY, counterViewModel.getCounter())
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_TAG, "activity started")
    }
    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "activity resumed")
    }
    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG, "activity paused")
    }
    override fun onStop() {
        super.onStop()
        Log.i(LOG_TAG, "activity stopped")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "activity destroyed")
    }
}