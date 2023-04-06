package com.example.newsapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.Mockdata
import com.example.newsapp.NewsData


@Composable
fun TopNews(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Top News", fontWeight = FontWeight.SemiBold)

        LazyColumn{
            items(Mockdata.TopNewsList){
               newsData ->
                TopNewsItem(newsData = newsData, onNewsClick = {
                    navController.navigate("Detail/${newsData.id}")
                })
            }
        }
    }
}


@Composable
fun TopNewsItem(newsData: NewsData, onNewsClick: () -> Unit = {}){
    Box(modifier = Modifier
        .height(200.dp)
        .padding(8.dp).clickable {
            onNewsClick()
        }) {
        Image(painter = painterResource(id = newsData.image), contentDescription = "",
        contentScale = ContentScale.FillBounds)
        
        Column(modifier = Modifier
            .wrapContentHeight()
            .padding(top = 16.dp, start = 16.dp),
            
            verticalArrangement = Arrangement.SpaceBetween
            
            ) {
            
            Text(text = newsData.publishedAt, color = Color.White, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(18.dp))
            
            Text(text = newsData.title, color = Color.White)
            
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopNewsPreview(){
    TopNewsItem(newsData =  NewsData(
        2,
        author = "Raja Razek",
        title = "Tiger King, Joe Exotic says he has been diagnosed with agressive Covid 19by doing maskless indoor press",
        description = "Joseph Maldonado, known as Joe Exotic on Kelvin has been conducting in-person interviews withiout mask",
        publishedAt = "2021-09-04T03:21:00z"
    )
    )
}