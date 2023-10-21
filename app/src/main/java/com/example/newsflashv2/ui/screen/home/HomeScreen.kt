package com.example.newsflashv2.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsflashv2.R
import com.example.newsflashv2.ui.navigation.BOOKMARKS_ROUTE
import com.example.newsflashv2.ui.navigation.SOURCES_SCREEN_ROUTE
import com.example.newsflashv2.ui.theme.Typography
import com.example.newsflashv2.ui.widget.CategoryItemView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = Typography.h5,
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it),
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
            ) {
                items(state.value.categoryList.size) { index ->
                    val categoryName = state.value.categoryList[index]
                    CategoryItemView(
                        key = categoryName,
                        onClickCategory = {
                            navController.navigate(
                                "${SOURCES_SCREEN_ROUTE}/{category}".replace(
                                    oldValue = "{category}",
                                    newValue = categoryName
                                )
                            )
                        },
                        onClickBookmark = {
                            navController.navigate(BOOKMARKS_ROUTE)
                        }
                    )
                }
            }
        }
    }
}