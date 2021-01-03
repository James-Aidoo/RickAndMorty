package com.questdev.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.questdev.rickandmorty.R
import com.questdev.rickandmorty.adapter.EpisodeAdapter
import com.questdev.rickandmorty.remote.EpisodeResponse
import com.questdev.rickandmorty.viewmodel.EpisodeViewModel
import com.questdev.rickandmorty.viewmodel.ResponseCallback

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EpisodeViewModel
    private lateinit var adapter: EpisodeAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)

        initView()

        getEpisodes()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.rv_episode_list_view)
    }

    private fun getEpisodes() {
        viewModel.getEpisodes(object : ResponseCallback {
            override fun execute(data: Any?) {
                data?.let {
                    when (it) {
                        is EpisodeResponse -> {
                            adapter = EpisodeAdapter(it.embedded.episodes)
                            recyclerView.adapter = adapter
                        }
                        is String -> {
                            Snackbar.make(recyclerView, it, Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        })
    }
}