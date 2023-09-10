package uz.datatalim.networking.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.datatalim.networking.Adapter.BreedAdapter
import uz.datatalim.networking.DataBase.Remote.ApiClient
import uz.datatalim.networking.Model.BreedsItem
import uz.datatalim.networking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var breeds:ArrayList<BreedsItem>
    lateinit var breedsAdapter: BreedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()

    }

    private fun initView() {

        breedsAdapter= BreedAdapter()
        breeds= ArrayList()
        loadBreeds()
        binding.rvCats.adapter=breedsAdapter
        binding.rvCats.layoutManager=LinearLayoutManager(this)
        breedsAdapter.submitList(breeds)
        breedsAdapter.itemClick={position->

            val intent= Intent(this,InfoActivity::class.java)
            startActivity(intent)

        }

    }

    private fun loadBreeds() {

        ApiClient.apiServis.getAllBreeds().enqueue(object :Callback<ArrayList<BreedsItem>>{
            override fun onResponse(
                call: Call<ArrayList<BreedsItem>>,
                response: Response<ArrayList<BreedsItem>>
            ) {

                if (response.isSuccessful){

                    breeds.clear()
                    breeds.addAll(breeds)


                }

            }

            override fun onFailure(call: Call<ArrayList<BreedsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "errroer", Toast.LENGTH_SHORT).show()
            }


        })

    }
}