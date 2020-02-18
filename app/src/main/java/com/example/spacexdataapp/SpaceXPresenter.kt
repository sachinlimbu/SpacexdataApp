package com.example.spacexdataapp

import Spacex_Base
import com.example.spacexdataapp.network.SpacexRetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SpaceXPresenter(
    private var view: SpaceXContract.View?):SpaceXContract.Presenter {

    private val compDisposable = CompositeDisposable()
    private val call = SpacexRetrofitInstance.getClient.getSpaceData()

    override fun getView() {
        if(call != null){
            compDisposable.add(
                call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::success,this::fail)

            )
        }

    }

    override fun getExtView(){
        if (call != null){
            compDisposable.add(
                call.subscribeOn(Schedulers.io())
                    .map { i -> i.filter { i -> i.active } }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::success,this::fail)
            )
        }
    }

    private fun success(model:List<Spacex_Base>){
        view?.showView(model = model)
    }

    private fun fail(t:Throwable){
        view?.showError(t)
    }

    override fun onDestroyCalled() {
        view = null
    }
}


