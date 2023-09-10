package uz.datatalim.networking.DataBase.Remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import uz.datatalim.networking.Model.Breeds
import uz.datatalim.networking.Model.BreedsItem

interface ApiServis {

    @GET(value = "breeds")
    fun getAllBreeds():Call<ArrayList<BreedsItem>>

    @GET("images/search")
    fun getImageById(@Query("breed_ids")breeds_ids:String, @Query("limit")limit:Int=10):Call<ArrayList<BreedsItem>>

    @GET("images/search")
    fun getImageByPage(@Query("breed_ids")breeds_ids:String,@Query("page")page:Int=0, @Query("limit")limit:Int=10):Call<ArrayList<BreedsItem>>


}