package uz.datatalim.networking.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.datatalim.networking.R
import uz.datatalim.networking.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {



    }
}