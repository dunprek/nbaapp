package com.ag.printerqoe.base

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.json.JSONObject
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException


/**
 * Created by gideon on 09/04/18.
 */
abstract class BaseObserver<T> : Observer<T> {

    override fun onComplete() {

    }

    override fun onNext(t: T) {
        //  onComplete()
        onResponseSuccess(t)
    }


    override fun onSubscribe(d: Disposable) {
        // onComplete()
        DisposableManager().add(d)
    }


    override fun onError(e: Throwable) {
        //  onComplete()
        if (e is HttpException) {
            val errorCode = e.code()
            val exeptions = e

            val errorBody = exeptions.response().errorBody()!!.string()
            val jObjError = JSONObject(errorBody)

            try {
                if (jObjError.has("message")) {
                    onResponseError(jObjError.getString("message"))
                }
                if (jObjError.has("errors")) {
                    onResponseError(jObjError.getString("errors"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }


        } else if (e is SocketTimeoutException) {
            onResponseError("Request time out")

        } else if (e is ConnectException) {
            if (e.message != null) {
                if (e.message.toString().contains("Failed to ") || e.message.toString().contains("Unable to resolve host")) {
                    onResponseError("Please Check Your Connection")
                } else if (e.message.toString().contains("HTTP")) {
                    val message = e.message.toString().substring(9)
                    onResponseError(message)
                }
            }
        }
    }

    abstract fun onResponseError(errorMessage: String)


    abstract fun onResponseSuccess(result: T)


}