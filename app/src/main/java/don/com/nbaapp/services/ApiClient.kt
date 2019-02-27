package don.com.nbaapp.services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class ApiClient(val baseURL: String) {

    lateinit var mApiServices: ApiServices



    init {
        val retrofit = initRetrofit(baseURL)
        initServices(retrofit)

    }

    private fun initServices(retrofit: Retrofit) {
        mApiServices = retrofit.create(ApiServices::class.java)
    }


    private fun initRetrofit(baseURL: String): Retrofit {


        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val gson = GsonBuilder()
                .serializeNulls()
                .create()


        val client = OkHttpClient.Builder().apply {
            connectTimeout(10000, TimeUnit.SECONDS)
                    .writeTimeout(10000, TimeUnit.SECONDS)
                    .readTimeout(10000, TimeUnit.SECONDS)


            addInterceptor(interceptor)
        }
        return Retrofit.Builder().baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .build()
    }
}