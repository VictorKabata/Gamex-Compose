package com.vickikbt.gamex.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vickikbt.gamex.R
import com.vickikbt.gamex.ui.theme.TextSecondary

@Composable
fun HomeToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colors.surface),
            //.alpha(0.4F),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column(
            modifier = Modifier
                .padding(12.dp)
                .weight(6F),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.new_and_trending),
                color = TextSecondary,
                style = MaterialTheme.typography.h3,
                fontSize = 28.sp
            )
            Text(
                text = stringResource(id = R.string.new_and_trending_description),
                color = TextSecondary,
                style = MaterialTheme.typography.h5,
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
        }

        Image(
            modifier = Modifier
                .weight(1F)
                .padding(14.dp),
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "Filter menu icon"
        )

    }
}

@Preview
@Composable
fun Previews() {
    HomeToolbar()
}