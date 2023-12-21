package com.fajar.docaapp.ui.screen.map

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajar.docaapp.data.Repository
import com.fajar.docaapp.data.ResultsItem
import com.fajar.docaapp.data.Result
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

class MapViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableLiveData<Result<List<ResultsItem>>> = MutableLiveData(Result.Loading)
    val uiState: LiveData<Result<List<ResultsItem>>>
        get() = _uiState


    private val _latLng = mutableStateOf<LatLng?>(null)
    val latLng = _latLng

    fun getNearbyPetShop() {
        viewModelScope.launch {
            _latLng.value?.let {
                repository.getNearbyPetShop(it).observeForever {
                    _uiState.value = it as Result<List<ResultsItem>>?
                }
            }
        }
    }

    fun getNearbyPetVet() {
        viewModelScope.launch {
            _latLng.value?.let {
                repository.getNearbyPetVet(it).observeForever {
                    _uiState.value = it as Result<List<ResultsItem>>?
                }
            }
        }
    }
}