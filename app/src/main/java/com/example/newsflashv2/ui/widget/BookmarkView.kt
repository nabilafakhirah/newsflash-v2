package com.example.newsflashv2.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsflashv2.R
import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.data.model.NewsResponse
import com.example.newsflashv2.ui.theme.PurpleGrey80
import com.example.newsflashv2.ui.theme.Typography

@Composable
fun BookmarkView(
    article: NewsEntity,
    onClickOpenNews: () -> Unit,
    removeFromBookmark: (NewsEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PurpleGrey80)
            .padding(16.dp)
            .clickable { onClickOpenNews() },
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        AsyncImage(
            modifier = Modifier.height(150.dp),
            model = article.urlToImage,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.img_placeholder),
            error = painterResource(id = R.drawable.img_placeholder),
            contentDescription = "",
        )
        Text(
            text = article.title,
            style = Typography.h5,
        )
        Text(
            text = article.description,
            style = Typography.body1,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.clickable {
                    removeFromBookmark(article)
                },
                text = stringResource(id = R.string.remove_from_bookmark),
                style = Typography.body1.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = article.publishedAt,
                style = Typography.body1,
            )
        }
    }
}
