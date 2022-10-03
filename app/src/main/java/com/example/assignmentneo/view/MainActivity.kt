package com.example.assignmentneo.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.assignmentneo.R
import com.example.assignmentneo.adapter.HorizontalListAdapter
import com.example.assignmentneo.adapter.VerticalListAdapter
import com.example.assignmentneo.databinding.ActivityMainBinding
import com.example.assignmentneo.model.HorizontalAndVerticalListModel
import com.example.assignmentneo.model.VerticalListModel
import com.example.assignmentneo.viewmodel.CustomViewModel
import com.example.assignmentneo.viewmodel.CustomViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CustomViewModel
    private lateinit var horizontalListAdapter: HorizontalListAdapter
    private lateinit var verticalListAdapter: VerticalListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            CustomViewModelFactory()
        )[CustomViewModel::class.java]

        fetchData()
        setObserver()
    }

    private fun fetchData() {
        viewModel.fetchDataToLoad()
    }

    private fun setObserver() {
        viewModel.listLiveData.observe(this, Observer {
            it?.let { horizontalAndVerticalListModelResponse ->
                if (horizontalAndVerticalListModelResponse.isNotEmpty()) {
                    setUpHorizontalViewPagerBannerData(
                        horizontalAndVerticalListModelResponse
                    )
                    setUpVerticalListData(horizontalAndVerticalListModelResponse[0].listItems)
                } else {
                    showNoDataFound(getString(R.string.no_data_found))
                }
            } ?: run {
                showNoDataFound(getString(R.string.no_data_found))
            }
        })
    }

    private fun setUpHorizontalViewPagerBannerData(horizontalAndVerticalListModel: List<HorizontalAndVerticalListModel>) {
        horizontalListAdapter =
            HorizontalListAdapter(horizontalAndVerticalListModel, ::onHorizontalListItemClick)
        binding.vpHorizontalBanner.adapter = horizontalListAdapter

        binding.vpHorizontalBanner.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setUpVerticalListData(horizontalAndVerticalListModel[position].listItems)
                searchFilterData(horizontalAndVerticalListModel[position].listItems)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
        TabLayoutMediator(
            binding.vpTabsIndicator,
            binding.vpHorizontalBanner
        ) { tab, position -> }.attach()
    }

    fun setUpVerticalListData(verticalListModel: List<VerticalListModel>) {
        verticalListAdapter = VerticalListAdapter(verticalListModel, ::onVerticalListItemClick)
        binding.rvVerticalList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = verticalListAdapter
        }
    }

    //on vertical Item click listener
    private fun onVerticalListItemClick(verticalListModel: VerticalListModel) {
        Toast.makeText(this, "Click event action to be added", Toast.LENGTH_SHORT).show()
    }

    //on horizontal Item click listener
    private fun onHorizontalListItemClick(horizontalListModel: HorizontalAndVerticalListModel) {
        Toast.makeText(this, "Click event action to be added", Toast.LENGTH_SHORT).show()
    }

    fun searchFilterData(verticalListModel: List<VerticalListModel>) {
        val filterListData = ArrayList<VerticalListModel>()
        clearSearch(verticalListModel)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(inputText: String?): Boolean {
                filterListData.clear()
                if (verticalListModel.isNotEmpty()) {
                    val data = verticalListModel.filter { item: VerticalListModel ->
                        item.title.lowercase().contains(inputText?.lowercase().toString())
                    }
                    if (data.isEmpty()) {
                        showNoDataFound(getString(R.string.no_search_data_found))
                    } else {
                        hideNoDataFound()
                        filterListData.addAll(data)
                    }
                }
                setUpVerticalListData(filterListData)
                return false
            }
        })

        val searchCloseButtonId: Int =
            resources.getIdentifier("android:id/search_close_btn", null, null)
        val closeSearchImage =
            binding.searchView.findViewById(searchCloseButtonId) as ImageView

        closeSearchImage.setOnClickListener {
            clearSearch(verticalListModel)
            closeSearchImage.visibility = View.GONE
        }
    }

    private fun clearSearch(verticalListModel: List<VerticalListModel>) {
        binding.searchView.setQuery("", true)
        binding.searchView.clearFocus()
        setUpVerticalListData(verticalListModel)
    }

    private fun showNoDataFound(errorText: String) {
        binding.tvNoData.visibility = View.VISIBLE
        binding.tvNoData.text = errorText
    }

    private fun hideNoDataFound() {
        binding.tvNoData.visibility = View.GONE
    }
}