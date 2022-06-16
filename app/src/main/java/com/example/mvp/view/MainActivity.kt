package com.example.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvp.contract.Contract
import com.example.mvp.model.Model
import com.example.mvp.presenter.Presenter
import com.example.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this, Model())

        binding.displayNextCourse.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
        binding.textView.visibility = View.VISIBLE
    }

    override fun setCourseContent(courseContent: String?) {
        binding.textView.text = courseContent
    }
}