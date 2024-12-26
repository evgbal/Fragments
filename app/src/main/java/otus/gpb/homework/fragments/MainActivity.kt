package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_to_activity_a).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        findViewById<Button>(R.id.button_to_activity_b).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}