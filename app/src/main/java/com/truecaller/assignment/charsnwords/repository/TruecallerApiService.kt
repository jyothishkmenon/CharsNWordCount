package com.truecaller.assignment.charsnwords.repository

import retrofit2.http.GET

interface TruecallerApiService {
    @GET("blog/life-at-truecaller/life-as-an-android-engineer")
    suspend fun getWebsiteContent(): String
}
