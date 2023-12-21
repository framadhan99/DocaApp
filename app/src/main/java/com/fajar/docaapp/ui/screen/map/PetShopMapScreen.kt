package com.fajar.docaapp.ui.screen.map

import android.annotation.SuppressLint
import android.location.Location
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fajar.docaapp.data.Result
import com.fajar.docaapp.data.ResultsItem
import com.fajar.docaapp.ui.ViewModelFactory
import com.fajar.docaapp.ui.components.ShowMaps
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("MissingPermission")
@Composable
fun PetShopMapScreen(
    mapViewModel: MapViewModel = viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)
    )
) {
    var latLng by mapViewModel.latLng
    mapViewModel.uiState.observeAsState(initial = Result.Loading).value.let {
        when (it) {
            is Result.Loading -> {
                mapViewModel.getNearbyPetShop()
            }

            is Result.Success -> {
                latLng?.let { it1 ->
                    ShowMaps(
                        listNearbyItem = it.data,
                        latLng = it1
                    )
                }
            }

            is Result.Error -> {
            }
        }
    }
    val context = LocalContext.current
    val fusedLocationProviderClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)
    fusedLocationProviderClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            location?.let {
                latLng = LatLng(it.latitude, it.longitude)
            }
        }
}