package com.rafaelbandeeira.chucknorrisjokes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var textView: TextView
    private lateinit var button: Button

    private val TAG: String = "Lifecycle - Fragment"

    private fun getJokes() {
        val jokesInterface = JokesInterface.create().getRandomJoke()

        jokesInterface.enqueue( object : Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>?, response: Response<Jokes>?) {
                if (response?.code() == 200) {
                    val responseBody = response.body()
                    textView.text = responseBody?.value
                }
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textview)
        button = view.findViewById(R.id.mainButton)

        button.setOnClickListener {
            getJokes()
        }
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
