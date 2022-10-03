package com.example.assignmentneo.util

import com.example.assignmentneo.R
import com.example.assignmentneo.model.HorizontalAndVerticalListModel
import com.example.assignmentneo.model.VerticalListModel

fun prepareData(): ArrayList<HorizontalAndVerticalListModel> {
    return arrayListOf(
        HorizontalAndVerticalListModel(
            R.drawable.ic_fruit_header, arrayListOf(
                VerticalListModel("Apple type 1", R.drawable.ic_fruit_apple),
                VerticalListModel("Banana type 1", R.drawable.ic_fruit_banana),
                VerticalListModel("Grapes type 1", R.drawable.ic_fruit_grapes),
                VerticalListModel("Apple type 2", R.drawable.ic_fruit_apple),
                VerticalListModel("Banana type 2", R.drawable.ic_fruit_banana),
                VerticalListModel("Grapes type 2", R.drawable.ic_fruit_grapes),
                VerticalListModel("Apple type 3", R.drawable.ic_fruit_apple),
                VerticalListModel("Banana type 3", R.drawable.ic_fruit_banana),
                VerticalListModel("Grapes type 3", R.drawable.ic_fruit_grapes),
            )
        ),
        HorizontalAndVerticalListModel(
            R.drawable.ic_vegetable_header, arrayListOf(
                VerticalListModel("Carrot type 1", R.drawable.ic_vegetable_carrot),
                VerticalListModel("Broccoli type 1", R.drawable.ic_vegetable_broccoli),
                VerticalListModel("Brinjal type 1", R.drawable.ic_vegetable_brinjal),
                VerticalListModel("Carrot type 2", R.drawable.ic_vegetable_carrot),
                VerticalListModel("Broccoli type 2", R.drawable.ic_vegetable_broccoli),
                VerticalListModel("Brinjal type 2", R.drawable.ic_vegetable_brinjal),
                VerticalListModel("Carrot type 3", R.drawable.ic_vegetable_carrot),
                VerticalListModel("Broccoli type 3", R.drawable.ic_vegetable_broccoli),
                VerticalListModel("Brinjal type 3", R.drawable.ic_vegetable_brinjal),
            )
        ),
        HorizontalAndVerticalListModel(
            R.drawable.ic_fast_food_header, arrayListOf(
                VerticalListModel("Burger type 1", R.drawable.ic_fast_food_burger),
                VerticalListModel("Coke type 1", R.drawable.ic_fast_food_coke),
                VerticalListModel("Fries type 1", R.drawable.ic_fast_food_french_fries),
                VerticalListModel("Burger type 2", R.drawable.ic_fast_food_burger),
                VerticalListModel("Coke type 2", R.drawable.ic_fast_food_coke),
                VerticalListModel("Fries type 2", R.drawable.ic_fast_food_french_fries),
                VerticalListModel("Burger type 3", R.drawable.ic_fast_food_burger),
                VerticalListModel("Coke type 3", R.drawable.ic_fast_food_coke),
                VerticalListModel("Fries type 3", R.drawable.ic_fast_food_french_fries),
            )
        )
    )
}