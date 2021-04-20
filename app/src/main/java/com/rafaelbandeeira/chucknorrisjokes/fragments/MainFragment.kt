package com.rafaelbandeeira.chucknorrisjokes.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.rafaelbandeeira.chucknorrisjokes.viewModels.MainViewModel
import com.rafaelbandeeira.chucknorrisjokes.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var textView: TextView
    private lateinit var button: Button

//    private val viewModel: MainViewModel by viewModels()
    private val mainViewModel by viewModel<MainViewModel>()
    private val TAG: String = "Lifecycle - Fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textview)
        button = view.findViewById(R.id.mainButton)

        button.setOnClickListener{
            mainViewModel.getJokes()
        }

        mainViewModel.joke.observe(viewLifecycleOwner, { joke ->
            textView.text = joke
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onPause() {
        super.onPause()

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i(TAG, "onViewStateRestored")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "onViewStateRestored")
    }
}
