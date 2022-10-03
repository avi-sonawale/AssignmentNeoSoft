package com.example.assignmentneo.model

import androidx.annotation.DrawableRes

data class HorizontalAndVerticalListModel(
    @DrawableRes val bannerUrl: Int,
    val listItems: List<VerticalListModel>
)