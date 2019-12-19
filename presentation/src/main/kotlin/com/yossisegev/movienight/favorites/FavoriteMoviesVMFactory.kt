package com.yossisegev.movienight.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yossisegev.domain.common.Mapper
import com.yossisegev.domain.entities.MovieEntity
import com.yossisegev.domain.usecases.GetFavoriteMovies
import com.yossisegev.movienight.entities.Movie

/**
 * Created by Yossi Segev on 01/01/2018.
 */
class FavoriteMoviesVMFactory(private val useCase: GetFavoriteMovies,
                              private val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoriteMoviesViewModel(useCase, mapper) as T
    }

}