package com.example.kotlinsingletoncoroutinesmvvmexample.repository

import androidx.lifecycle.LiveData
import com.example.kotlinsingletoncoroutinesmvvmexample.api.MyRetrofitBuilder
import com.example.kotlinsingletoncoroutinesmvvmexample.model.User
import kotlinx.coroutines.*

/**
 * @author Lior Hazael
 */
object Repository {

	var job: CompletableJob? = null

	fun getUser(userId: String): LiveData<User> {
		job = Job()

		return object : LiveData<User>() {
			override fun onActive() {
				super.onActive()

				job?.let { currJob ->
					CoroutineScope(Dispatchers.IO + currJob).launch {
						val user: User = MyRetrofitBuilder.apiService.getUser(userId)

						withContext(Dispatchers.Main) {
							value = user
							currJob.complete()
						}
					}
				}
			}
		}
	}

	fun cancelJob() {
		job?.cancel()
	}
}