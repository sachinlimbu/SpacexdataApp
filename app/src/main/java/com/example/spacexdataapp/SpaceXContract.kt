package com.example.spacexdataapp

import Spacex_Base

interface SpaceXContract {
    interface View{
        fun showView(model:List<Spacex_Base>)
        fun showError(error:Throwable)
    }
    interface Presenter{
        fun getView()
        fun getExtView()
        fun onDestroyCalled()
    }
}