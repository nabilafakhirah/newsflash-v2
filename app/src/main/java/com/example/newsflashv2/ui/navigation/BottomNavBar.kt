package com.example.newsflashv2.ui.navigation

import com.example.newsflashv2.R

sealed class BottomNavItem(var title:String, var icon:Int, var screenRoute:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home, HOME_SCREEN_ROUTE)
    object Bookmarks: BottomNavItem("Bookmarks", R.drawable.ic_bookmarks, BOOKMARKS_ROUTE)
}