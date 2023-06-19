package Heisei.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.protorider0.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val riders = listOf(
        Rider("Tycoon", "Sakurai Keiwa"),
        Rider("Ichigo", "Takeshi Hongo"),
        Rider("Decade", "Tsukasa Kadoya"),
        Rider("Diend", "Daiki Kaito"),
        Rider("Naago", "Kurama Neon")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
    }

    fun initRecycler(){
        binding.rvRider.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(riders)
        binding.rvRider.adapter = adapter
    }
}