package com.saxaindustries.weathercleanarch.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saxaindustries.weathercleanarch.R
import com.saxaindustries.weathercleanarch.domain.model.Weather
import com.saxaindustries.weathercleanarch.domain.model.displayTemperature
import com.saxaindustries.weathercleanarch.domain.model.uppercaseCity
import com.saxaindustries.weathercleanarch.presentation.components.BackgroundImage
import com.saxaindustries.weathercleanarch.presentation.weather.WeatherState

class WeatherStateProvider : PreviewParameterProvider<WeatherState> {
    override val count: Int get() = values.count()
    override val values: Sequence<WeatherState>
        get() = sequenceOf(
            WeatherState(
                data = Weather("Test City", temperature = 70)
            )
        )
}

@Composable
@Preview
fun WeatherTopRow(
    @PreviewParameter(WeatherStateProvider::class) state: WeatherState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = "")
            Text(
                text = state.data?.uppercaseCity ?: "...",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.align(Alignment.CenterVertically),
                color = Color.White,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sunday, Aug 28th",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun WeatherScreen(
    @PreviewParameter(WeatherStateProvider::class) state: WeatherState
) {
    BackgroundImage()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Row {
            WeatherTopRow(state = state)
        }

        Spacer(modifier = Modifier.weight(1F, true))

        Row {
            Text(
                text = state.data?.displayTemperature ?: "...",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h1,
                color = Color.White,
                fontSize = 180.sp,
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}