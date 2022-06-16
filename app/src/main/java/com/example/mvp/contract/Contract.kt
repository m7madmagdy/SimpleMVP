package com.example.mvp.contract

interface Contract {
    interface View {
        fun showProgressBar()

        fun hideProgressBar()

        fun setCourseContent(courseContent: String?)
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(courseContent: String?)
        }

        fun getNextCourse(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun onButtonClick()

        fun onDestroy()
    }
}
