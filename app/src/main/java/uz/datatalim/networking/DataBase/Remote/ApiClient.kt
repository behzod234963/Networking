package uz.datatalim.networking.DataBase.Remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val tester=true
    private const val SERVER_DEV="https://api.thecatapi.com/v1"
    private const val SERVER_PRODUCTION="https://api.thecatapi.com/v1"

    val client=getClient()

    private val retrofit=Retrofit.Builder().baseUrl(baseUrl()).addConverterFactory(GsonConverterFactory.create()).client(client).build()







    fun baseUrl():String{

        return if (tester){

            SERVER_DEV

        }else{

            SERVER_PRODUCTION

        }

    }

    private fun getClient():OkHttpClient {

        return OkHttpClient.Builder().addInterceptor(Interceptor {chain ->

            val builder=chain.request().newBuilder()
            builder.addHeader("x-api-key","live_WQ1vIGteNXpuZJbaxwQosWOvphfD96aZMkg2BCdB1JkPiVEQFMlnb39B1knUMtaB")
            chain.proceed(builder.build())

        }).build()

    }

}