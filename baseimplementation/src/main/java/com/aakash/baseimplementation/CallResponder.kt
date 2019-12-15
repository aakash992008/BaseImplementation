package com.aakash.baseimplementation

import retrofit2.Call

interface CallResponder<T> {

    fun responseSuccess(data: T)
    fun responseFailure(string: String,responseCode:Int)
    fun connectionError(call: Call<T>, t: Throwable)
}