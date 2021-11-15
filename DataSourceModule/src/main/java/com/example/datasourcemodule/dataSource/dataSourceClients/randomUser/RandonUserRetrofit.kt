package com.example.datasourcemodule.dataSource


import com.example.datasourcemodule.dataSource.dataSourceClients.randomUser.randomUserEntities.RandomUserResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://randomuser.me/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RandomUserApiService {
    @GET("api")
    suspend fun getUsers(@Query("results") type: Int): RandomUserResult
}

object RandomUserApi {
    val retrofitService : RandomUserApiService by lazy { retrofit.create(RandomUserApiService::class.java) }
}

