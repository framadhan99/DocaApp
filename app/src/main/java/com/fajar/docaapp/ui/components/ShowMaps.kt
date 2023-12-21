package com.fajar.docaapp.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fajar.docaapp.data.ResultsItem
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ShowMaps(
    listNearbyItem: List<ResultsItem>,
    latLng: LatLng
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 15f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        listNearbyItem.forEach {
            Marker(
                state = MarkerState(
                    position = LatLng(
                        it.geometry.location.lat,
                        it.geometry.location.lng
                    )
                ),
                title = it.name,
                snippet = "${it.rating} (${it.userRatingsTotal} User)"
            )
        }
    }
}