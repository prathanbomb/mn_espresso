package com.yossisegev.movienight.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yossisegev.domain.common.Mapper
import com.yossisegev.domain.entities.MovieEntity
import com.yossisegev.domain.usecases.SearchMovie
import com.yossisegev.movienight.entities.Movie

/**
 * Created by Yossi Segev on 12/02/2018.
 */
class SearchVMFactory(val searchMovie: SearchMovie,
                      val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(searchMovie, mapper) as T
    }

}