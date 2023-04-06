package com.example.newsapp.ui.theme.screen


import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.NewsData
import com.example.newsapp.R
import java.util.TimeZone

@Composable
fun DetailScreen(newsData: NewsData, scrollState: ScrollState){


    Scaffold(topBar = {
        DetailTopAppBar(onBackPRessed = {navController.popBackStack() })
    }) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Detail Screen", fontWeight = FontWeight.SemiBold)

            Image(painter = painterResource(id = newsData.image), contentDescription = "")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {

                infoWithIcon(Icons.Default.Edit, info = newsData.author)
                infoWithIcon(Icons.Default.DateRange, info = newsData.publishedAt)

            }

            Text(text = newsData.title, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(
                text = newsData.description,
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 22.sp
            )

        }

    }

        
    }




@Composable
fun DetailTopAppBar(onBackPRessed: ()-> Unit = {}){
    TopAppBar(title = { Text(text = "Detail Screen",
        fontWeight = FontWeight.SemiBold)},

        navigationIcon = {
            IconButton(onClick = { onBackPRessed()}) {

                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "" )

            }
        }

        )
        

}

@Composable
fun infoWithIcon(icon: ImageVector, info: String){

    Row {
        Icon(icon, contentDescription ="Author",
            modifier = Modifier.padding(end = 8.dp),
             colorResource(id = R.color.purple_500)
        )
        Text(text =info )
    }
}




@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){

 DetailScreen(
        NewsData(
            2,
            author = "Raja Razek",
            title = "Tiger King, Joe Exotic says he has been diagnosed with agressive Covid 19by doing maskless indoor press",
            description = "Joseph Maldonado, known as Joe Exotic on Kelvin has been conducting in-person interviews withiout mask",
            publishedAt = "2021-09-04T03:21:00z"
        ),

        rememberScrollState(),

 rememberNavController()
 )


}