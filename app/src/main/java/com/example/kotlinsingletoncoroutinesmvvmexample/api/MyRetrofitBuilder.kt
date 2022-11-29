package com.example.kotlinsingletoncoroutinesmvvmexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Lior Hazael
 */
object MyRetrofitBuilder {

	private const val BASE_URL = "https://open-api.xyz"

	private val retrofitBuilder: Retrofit.Builder by lazy {
		Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
	}


	val apiService: ApiService by lazy {
		retrofitBuilder
			.build()
			.create(ApiService::class.java)
	}
}