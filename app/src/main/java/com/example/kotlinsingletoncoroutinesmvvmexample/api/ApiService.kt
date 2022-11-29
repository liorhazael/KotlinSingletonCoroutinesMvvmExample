package com.example.kotlinsingletoncoroutinesmvvmexample.api

import com.example.kotlinsingletoncoroutinesmvvmexample.model.User
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Lior Hazael
 */
interface ApiService {

	@GET("placeholder/user/{userId}")
	suspend fun getUser(
		@Path("userId") userId: String
	): User
}