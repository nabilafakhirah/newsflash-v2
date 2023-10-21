package com.example.newsflashv2.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsflashv2.ui.theme.Typography

@Composable
fun TopBarView(
    onClickBack: () -> Unit,
    pageTitle: String = "",
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onClickBack()
                }
        )
        if (pageTitle.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = pageTitle,
                style = Typography.h5,
                textAlign = TextAlign.Center
            )
        }
    }
}