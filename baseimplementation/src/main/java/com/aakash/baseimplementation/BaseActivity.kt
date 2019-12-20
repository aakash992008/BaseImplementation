package com.aakash.baseimplementation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseActivity<DB: ViewDataBinding>:AppCompatActivity(){

    lateinit var mBinding: DB
    private var mProgressBarDialog:Dialog?=null
    private var progressDialogView:View?=null
    var navController:NavController?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this,getLayout())
        try {
            navController=Navigation.findNavController(this,getLayout())
        }catch (e:Exception){
            e.printStackTrace()
        }
        initialisationBlock(savedInstanceState)
    }




    override fun onResume() {
        super.onResume()
        onBaseResume()
    }


    override fun onPause() {
        super.onPause()
        onBasePause()
    }


    fun generateToast(message:Int,length:Int=Toast.LENGTH_SHORT){
        try {
            Toast.makeText(this,getString(message),length).show()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    fun generateToast(message:String,length:Int=Toast.LENGTH_SHORT){
        try {
            Toast.makeText(this,message,length).show()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    abstract fun getLayout():Int
    abstract fun onBaseResume()
    abstract fun onBasePause()
    abstract fun initialisationBlock(savedInstanceState: Bundle?)



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