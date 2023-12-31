package com.example.newsflashv2.ui.screen.bookmarks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsflashv2.R
import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.ui.navigation.ARTICLES_DETAIL_ROUTE
import com.example.newsflashv2.ui.theme.Typography
import com.example.newsflashv2.ui.widget.BookmarkView
import com.example.newsflashv2.ui.widget.BottomNavigationView
import com.example.newsflashv2.ui.widget.TopBarView
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun BookmarkScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: BookmarkViewModel = hiltViewModel()
) {
    val bookmarkFlow = viewModel.state.value.bookmarkList
    val bookmarkList by bookmarkFlow.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Bookmarks",
                    style = Typography.h5,
                    textAlign = TextAlign.Center
                )
            }
        },
        bottomBar = {
            BottomNavigationView(navController = navController)
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = it.calculateBottomPadding())
                .verticalScroll(rememberScrollState()),
        ) {
            if (bookmarkList.isNotEmpty()) {
                BookmarkList(
                    news = bookmarkList,
                    navController = navController,
                    removeFromBookmark = {news ->
                        viewModel.deleteFromBookmark(news)
                    }
                )
            }
        }
    }
}

@Composable
private fun BookmarkList(
    news: List<NewsEntity>,
    navController: NavController,
    removeFromBookmark: (NewsEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        news.forEach {
            BookmarkView(
                article = it,
                onClickOpenNews = {
                    val encodedUrl = URLEncoder.encode(it.url, StandardCharsets.UTF_8.toString())
                    navController.navigate(
                        "$ARTICLES_DETAIL_ROUTE/{url}".replace(
                            oldValue = "{url}",
                            newValue = encodedUrl
                        )
                    )
                },
                removeFromBookmark = { news ->
                    removeFromBookmark(news)
                }
            )
        }
    }
}