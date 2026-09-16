package com.time1043.marsrover.domain.model

import com.time1043.marsrover.service.model.RoverManifestRemoteModel

fun toUiModel(roverManifestRemoteModel: RoverManifestRemoteModel): RoverManifestUiState =
    RoverManifestUiState.Success(roverManifestRemoteModel.photoManifest.photos.map { photo ->
        RoverManifestUiModel(
            sol = photo.sol.toString(),
            earthDate = photo.earthDate,
            photoNumber = photo.totalPhotos.toString()
        )
    }.sorted())