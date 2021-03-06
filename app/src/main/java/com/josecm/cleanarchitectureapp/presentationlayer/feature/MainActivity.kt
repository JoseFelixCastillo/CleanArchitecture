package com.josecm.cleanarchitectureapp.presentationlayer.feature

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.josecm.cleanarchitectureapp.R
import com.josecm.cleanarchitectureapp.datalayer.base.Failure
import com.josecm.cleanarchitectureapp.presentationlayer.base.ScreenState
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter.HomeActionView
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter.HomeAdapter
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter.HomeItem
import com.josecm.cleanarchitectureapp.presentationlayer.domain.CommentVO
import com.josecm.cleanarchitectureapp.presentationlayer.domain.PostVO
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private val rv: RecyclerView? by lazy { main_activity__rv }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initModel()
        initView()
    }

    private fun initModel() {
        mainActivityViewModel = ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)

        mainActivityViewModel.mainState.observe(this, Observer { screenState ->
            when (screenState) {
                ScreenState.Loading -> {
                    //Progress bar
                    Log.d("MainActivity", "LOADING")
                }
                is ScreenState.Render -> processRender(screenState.renderState)
                else -> showUnknowError()
            }
        })
    }

    private fun initView() {
        rv?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = createAdapter()
            addItemDecoration(createItemDecoration())
        }
    }

    private fun createAdapter(): HomeAdapter {
        val list = emptyList<HomeItem>().toMutableList()
        return HomeAdapter(itemList = list, callback = { action ->
            when (action) {
                is HomeActionView.Post -> toast("pulse in: ${action.post.title}")
                is HomeActionView.Comment -> toast("pulse in: ${action.comment.body}")
                HomeActionView.None -> toast("pulse in item")
                else -> toast("pulse in item unknow")
            }
        })
    }


    private fun createItemDecoration(): RecyclerView.ItemDecoration {
        return object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom = 30
            }
        }
    }

    private fun processRender(renderState: MainState?) {
        //Hide progress bar
        when (renderState) {
            is MainState.ShowComment -> renderComment(renderState.comments)
            is MainState.ShowPost -> renderPost(renderState.posts)
            is MainState.ShowError -> renderError(renderState.failure)
            else -> showUnknowError()
        }
    }

    private fun renderError(failure: Failure) {
        Log.d("MainActivity", "Error" + failure)
    }

    private fun renderPost(posts: List<PostVO>?) {
        posts?.let {
            (rv?.adapter as? HomeAdapter)?.refreshData(posts)
        }

    }

    private fun renderComment(comments: List<CommentVO>?) {
        comments?.let {
            (rv?.adapter as? HomeAdapter)?.refreshData(comments)
        }
    }

    private fun showUnknowError() {
        Log.d("MainActivity", "Unknow State")
    }
}
