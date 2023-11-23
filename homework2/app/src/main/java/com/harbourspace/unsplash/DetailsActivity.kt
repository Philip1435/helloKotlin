package com.harbourspace.unsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harbourspace.unsplash.ui.theme.UnsplashTheme


class DetailsActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      UnsplashTheme {
          SettingsContent()
      }
    }
  }
}

@Composable
@Preview
fun SettingsContent() {

  LazyColumn (
  ) {
    item {
      Box {
        Image(
          modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
          painter = painterResource(id = R.drawable.img1),
          contentScale = ContentScale.Crop,
          contentDescription = stringResource(id = R.string.description_image_preview)
        )
        Row (
          modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(16.dp),
          verticalAlignment = Alignment.CenterVertically,

        ){
          Icon(
            painter = painterResource(id = R.drawable.icon_loc),
            contentDescription = null,
            tint = Color.White
          )
          Text(
            text = "Bangkok",
            color = Color.White
          )
        }
      }
    }

    item {
      Row (
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth()
      ){
        Row (
          verticalAlignment = Alignment.CenterVertically,
        ){
          Image(
            modifier = Modifier
              .size(48.dp)
              .clip(CircleShape),
            painter = painterResource(id = R.drawable.alex_profile),
            contentDescription = null
          )
          Spacer(modifier = Modifier.width(10.dp))
          Text(
            text = "Bob Marley",
            fontSize = 17.sp,
            color = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        Row (
          verticalAlignment = Alignment.CenterVertically
        ){
          IconButton(onClick = { /*TODO*/ }) {
            Icon(
              painter = painterResource(id = R.drawable.icon_download),
              contentDescription = null,
              tint = Color.White
            )
          }
          IconButton(onClick = { /*TODO*/ }) {
            Icon(
              painter = painterResource(id = R.drawable.icon_favourite),
              contentDescription = null,
              tint = Color.White
            )
          }
          IconButton(onClick = { /*TODO*/ }) {
            Icon(
              painter = painterResource(id = R.drawable.icon_bookmark),
              contentDescription = null,
              tint = Color.White
            )
          }
        }
      }
    }

    item {
      Divider(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        thickness = 1.dp,
        color = Color.LightGray
      )
    }

    item {
      Row(
        modifier = Modifier.padding(16.dp)
      ) {
        Column(
          modifier = Modifier.weight(1.0f)
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_camera_title),
            subtitle = stringResource(id = R.string.details_camera_default)
          )
        }

        Column(
          modifier = Modifier.weight(1.0f)
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_aperture_title),
            subtitle = stringResource(id = R.string.details_aperture_default)
          )
        }
      }
    }

    item {
      Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
      ) {
        Column(
          modifier = Modifier.weight(1.0f)
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_focal_title),
            subtitle = stringResource(id = R.string.details_focal_default)
          )
        }

        Column(
          modifier = Modifier.weight(1.0f)
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_shutter_title),
            subtitle = stringResource(id = R.string.details_shutter_default)
          )
        }
      }
    }

    item {
      Row(
        modifier = Modifier.padding(16.dp)
      ) {
        Column(
          modifier = Modifier.weight(1.0f)
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_iso_title),
            subtitle = stringResource(id = R.string.details_iso_default)
          )
        }

        Column(
          modifier = Modifier.weight(1.0f)
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_dimensions_title),
            subtitle = stringResource(id = R.string.details_dimensions_default)
          )
        }
      }
    }

    item {
      Divider(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        thickness = 1.dp,
        color = Color.LightGray
      )
    }

    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
      ) {

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_views_title),
            subtitle = stringResource(id = R.string.details_views_default)
          )
        }

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_downloads_title),
            subtitle = stringResource(id = R.string.details_downloads_default)
          )
        }

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          AddImageInformation(
            title = stringResource(id = R.string.details_likes_title),
            subtitle = stringResource(id = R.string.details_likes_default)
          )
        }
      }
    }
    item {
      Divider(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        thickness = 1.dp,
        color = Color.LightGray
      )
    }

    item {
      Row (
        modifier = Modifier
          .padding(16.dp)
      ){
        Button(
          onClick = { /*TODO*/ },
          colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
            )
        ){
          Text(text = "barcelona")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
          onClick = { /*TODO*/ },
          colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray)
        ){
          Text(text = "spain")
        }
      }
    }
  }
}

@Composable
fun AddImageInformation(
  title: String,
  subtitle: String
) {

  Text(
    text = title,
    fontSize = 17.sp,
    fontWeight = FontWeight.Bold,
    color = Color.White
  )

  Text(
    text = subtitle,
    fontSize = 15.sp,
    color = Color.White
  )
}