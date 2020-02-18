package com.example.spacexdataapp

import Spacex_Base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexdataapp.adapter.RocketAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SpaceXContract.View {

    private lateinit var spaceXPresenter: SpaceXPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spaceXPresenter = SpaceXPresenter(this)
        spaceXPresenter.getView()

        radioButton_custom.setOnCheckedChangeListener(object:RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rb_one -> spaceXPresenter.getView()
                    R.id.rb_two -> spaceXPresenter.getExtView()
                }
            }

        })


    }

    override fun showView(model: List<Spacex_Base>) {

        rocker_recyclerView_id.adapter = RocketAdapter(model)
        rocker_recyclerView_id.layoutManager = LinearLayoutManager(this)
    }

    override fun showError(error: Throwable) {
        var t = Toast.makeText(this@MainActivity,"Error:" + error.localizedMessage, Toast.LENGTH_LONG)
        t. show()
    }
}
