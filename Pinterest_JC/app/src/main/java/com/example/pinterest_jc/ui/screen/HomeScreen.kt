package com.example.pinterest_jc.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pinterest_jc.R
import com.example.pinterest_jc.model.Tag

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val tags = listOf(
        Tag("For You", true),
        Tag("Popular"),
        Tag("Design"),
        Tag("Interstellar"),
        Tag("NASA"),
        Tag("Earth")
    )

    val images = listOf(
        R.drawable.img_4,
        R.drawable.img,
        R.drawable.img_2,
        R.drawable.img_22,
        R.drawable.img_26,
        R.drawable.img_1,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_11,
        R.drawable.img_8,
        R.drawable.img_10,
        R.drawable.img_12,
        R.drawable.img_19,
        R.drawable.img_14,
        R.drawable.img_3,
        R.drawable.img_16,
        R.drawable.img_17,
        R.drawable.img_9,
        R.drawable.img_18,
        R.drawable.img_23,
        R.drawable.img_20,
        R.drawable.img_13,
        R.drawable.img_21,
        R.drawable.img_24,
        R.drawable.img_7,
        R.drawable.img_25,
        R.drawable.img_15
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBar()

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalItemSpacing = 20.dp
        ) {
            item(
                span = StaggeredGridItemSpan.FullLine
            ) {
                TagList(tags = tags)
            }

            items(images) { image ->
                ImageCard(image)
            }
        }

        BottomBar()
    }
}

@Composable
fun TagList(tags: List<Tag>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(tags) { tag ->
            TagItem(tag)
        }
    }
}

@Composable
fun TagItem(tag: Tag) {
    FilledTonalButton(onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (tag.isSelected) colorResource(R.color.red_pinterest) else Color.Transparent,
            contentColor = if (tag.isSelected) Color.White else Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.LightGray
        ),
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 16.dp
        ),
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Text(
            text = tag.text,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ImageCard(item: Int) {
    Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Image(
            painter = painterResource(item),
            contentDescription = null
        )
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier
            .fillMaxWidth()
            .background(Color(0xB3FFFFFF))
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.red_pinterest),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.home_btn),
                contentDescription = "Home",
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.icon_tint),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.chat_btn),
                contentDescription = "Chat",
                modifier = Modifier.size(27.dp)
            )
        }

        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.icon_tint),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.notifications_btn),
                contentDescription = "Notifications",
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.icon_tint),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.person_btn),
                contentDescription = "Profile",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.pinterest_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(
                width = 180.dp,
                height = 30.dp
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.icon_tint),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.add_btn),
                contentDescription = "Add",
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(
            modifier = Modifier.size(4.dp)
        )

        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.icon_tint),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.search_btn),
                contentDescription = "Search",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
