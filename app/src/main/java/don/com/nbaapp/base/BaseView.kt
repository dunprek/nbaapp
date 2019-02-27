package com.ag.printerqoe.base

/**
 * Created by gideon on 09/04/18.
 */
interface BaseView {
    fun showLoading()
    fun errorLoading(errorMessage:String?)
    fun stopLoading()
}