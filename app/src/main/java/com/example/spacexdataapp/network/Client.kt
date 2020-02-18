package com.example.spacexdataapp.network

import Spacex_Base
import com.example.spacexdataapp.network.Constant.END_POINT
import io.reactivex.Observable
import retrofit2.http.GET

interface Client {
    @GET(END_POINT)
    fun getSpaceData(): Observable<List<Spacex_Base>>
}