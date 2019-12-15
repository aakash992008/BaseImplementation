package com.aakash.baseimplementation

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseWrapper<T>(private val mCallResponder: CallResponder<T>?) : Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        mCallResponder?.connectionError(call,t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        mCallResponder?.let {
            if (response.isSuccessful) {
                mCallResponder.responseSuccess(response.body()!!)
            } else {
                mCallResponder.responseFailure(response.errorBody()!!.string(),response.code())
            }
        }
    }
}