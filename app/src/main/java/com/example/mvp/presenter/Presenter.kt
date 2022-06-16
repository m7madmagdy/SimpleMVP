package com.example.mvp.presenter

import com.example.mvp.contract.Contract

class Presenter(
    private var mainView: Contract.View?,
    private val model: Contract.Model
) : Contract.Presenter, Contract.Model.OnFinishedListener {

    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgressBar()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView!!.setCourseContent(string)
            mainView!!.hideProgressBar()
        }
    }

}