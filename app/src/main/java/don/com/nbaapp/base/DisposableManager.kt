package com.ag.printerqoe.base

import io.reactivex.disposables.Disposable

/**
 * Created by gideon on 09/04/18.
 */
class DisposableManager {

    //    private var compositeDisposable: CompositeDisposable? = null
    private var compositeDisposable: MutableList<Disposable> = mutableListOf()
    fun add(disposable: Disposable) {

        compositeDisposable.add(disposable)


    }

    fun dispose() {
        for (d in compositeDisposable){
            d.dispose()
        }

    }
}