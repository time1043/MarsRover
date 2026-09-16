package com.time1043.marsrover.ui.manifestlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.time1043.marsrover.data.MarsRoverManifestRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverManifestViewModel @Inject constructor(
    private val marsRoverManifestRepo: MarsRoverManifestRepo
) : ViewModel() {

    fun getMarsRoverManifest(roverName: String) {
        viewModelScope.launch {
            marsRoverManifestRepo.getMarsRoverManifest(roverName).collect {

            }
        }
    }
}