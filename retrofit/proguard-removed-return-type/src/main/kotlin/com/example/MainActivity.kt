package com.example

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import retrofit2.http.POST

class MainActivity : Activity() {

	@SuppressLint("CheckResult")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		Retrofit.Builder()
			.client(
				OkHttpClient.Builder()
					.addInterceptor(HttpLoggingInterceptor().apply { level = Level.BODY })
					.build()
			)
			.baseUrl("https://httpstat.us/")
			.addConverterFactory(GsonConverterFactory.create(Gson()))
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.build()
			.create(RetrofitService::class.java)
			.makeRequest()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{ response ->
					// Simulate using the header only, ignoring body.
					println(response.headers()["Content-Length"])
					//println(response.body()!!.description)
				},
				{ ex ->
					ex.printStackTrace()
				},
			)
	}
}

interface RetrofitService {

	@POST("200")
	@Headers("Accept: application/json")
	fun makeRequest(): Single<Response<ResponseDTO>>
}

class ResponseDTO(
	@SerializedName("code")
	val code: String,
	@SerializedName("description")
	val description: String,
)
