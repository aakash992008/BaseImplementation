package com.aakash.baseimplementation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment <DB:ViewDataBinding> : Fragment() {

    lateinit var mBinding: DB
    private var mProgressBarDialog: Dialog? = null
    private var progressDialogView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding=DataBindingUtil.inflate(inflater,getLayout(),container,false)
        return mBinding.root
    }



    abstract fun getLayout(): Int

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


    fun setProgressBarView(view: View) {

    }


    fun showProgressBar() {
        if (mProgressBarDialog == null) {
            mProgressBarDialog = Dialog(activity!!)
            if (progressDialogView == null) {
                val view = LayoutInflater.from(activity!!).inflate(R.layout.progress, null)
                mProgressBarDialog!!.setContentView(view)
            } else {
                mProgressBarDialog!!.setContentView(progressDialogView!!)
            }
            mProgressBarDialog!!.setCancelable(false)
            mProgressBarDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        mProgressBarDialog?.show()
    }


    fun hideProgressBar() {
        mProgressBarDialog?.dismiss()
    }

}