package com.time1043.marsrover.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.time1043.marsrover.R

@Composable
fun Rover(
    name: String,
    img: Int,
    landingDate: String,
    distanceTraveled: String,
    modifier: Modifier = Modifier,
) {
    Card(modifier = Modifier.padding(16.dp)) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Image(painter = painterResource(id = img), contentDescription = null)
            Text(text = "Credit: NASA/JPL", fontSize = 8.sp)
            Text(text = "Landing date: $landingDate", fontSize = 12.sp)
            Text(text = "Distance traveled: $distanceTraveled", fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
fun RoverPreview() {
    Rover(
        name = "Perseverance",
        img = R.drawable.perseverance,
        landingDate = "18 February 2021",
        distanceTraveled = "12.56 km"
    )
}