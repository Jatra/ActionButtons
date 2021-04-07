package uk.co.jatra.actionbuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var count = 0
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enable = findViewById<CheckBox>(R.id.enable)
        val activate = findViewById<CheckBox>(R.id.activate)
        val image = findViewById<ImageView>(R.id.image)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)

        handler = Handler(Looper.getMainLooper())

        enable.setOnCheckedChangeListener { _, isChecked ->
            image.isEnabled = isChecked
            imageButton.isEnabled = isChecked
        }

        activate.setOnCheckedChangeListener { _, isChecked ->
            image.isActivated = isChecked
            imageButton.isActivated = isChecked
        }

        image.setOnClickListener {
            activateForABit(it)
        }
        imageButton.setOnClickListener {
            activateForABit(it)
        }
    }

    private fun activateForABit(it: View) {
        handler.post { it.isActivated = true }
        //Starts an operation
        //Then after a while, the result will come back...
        //This is simulating a response coming back from the api
        handler.postDelayed({ it.isActivated = false }, 2500)
    }


}