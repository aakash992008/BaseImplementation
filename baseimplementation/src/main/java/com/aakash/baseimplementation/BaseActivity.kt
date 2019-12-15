package com.aakash.baseimplementation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open abstract class BaseActivity<DB: ViewDataBinding>:AppCompatActivity(){

    lateinit var mBinding: DB
    private var mProgressBarDialog:Dialog?=null
    private var progressDialogView:View?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this,getLayout())
    }


    abstract fun getLayout():Int

    override fun onResume() {
        super.onResume()
        onBaseResume()
    }


    override fun onPause() {
        super.onPause()
        onBasePause()
    }


    abstract fun onBaseResume()

    abstract fun onBasePause()



    fun setProgressBarView(view: View){

    }


    fun showProgressBar() {
        if (mProgressBarDialog == null) {
            mProgressBarDialog = Dialog(this)
            if(progressDialogView==null){
                val view = LayoutInflater.from(this).inflate(R.layout.progress, null)
                mProgressBarDialog!!.setContentView(view)
            }else{
                mProgressBarDialog!!.setContentView(progressDialogView!!)
            }
            mProgressBarDialog!!.setCancelable(false)
            mProgressBarDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        mProgressBarDialog?.show()
    }


    fun hideProgressBar(){
        mProgressBarDialog?.dismiss()
    }


}