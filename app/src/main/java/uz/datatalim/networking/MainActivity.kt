package uz.datatalim.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.datatalim.networking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()

    }

    private fun initView() {




    }
}