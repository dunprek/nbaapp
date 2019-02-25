package don.com.nbaapp.services

import don.com.nbaapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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

    fun getApiServices(): ApiServices {
        return mApiServices
    }


    private fun initRetrofit(baseURL: String): Retrofit {


        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            connectTimeout(10000, TimeUnit.SECONDS)
                    .writeTimeout(10000, TimeUnit.SECONDS)
                    .readTimeout(10000, TimeUnit.SECONDS)

            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .header("Api-Key", BuildConfig.API_KEY)
                        .header("X-Platform", BuildConfig.X_PLATFORM)
                        .header("Platform-Id", BuildConfig.PLATFORM_ID)
                        .header("Base-Uri", BuildConfig.BASE_URI)
                        .header("App-Name", BuildConfig.APPNAME)
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }
        return Retrofit.Builder().baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
    }
}
