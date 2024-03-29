package com.yossisegev.movienight

import android.util.Log
import androidx.lifecycle.Observer

/**
 * Created by Yossi Segev on 17/02/2018.
 */
class ChangeHistoryObserver<T> : Observer<T> {

    private val changeHistory = mutableListOf<T?>()

    override fun onChanged(t: T?) {
        changeHistory.add(t)
    }

    fun get(index: Int): T? {
        return changeHistory[index]
    }

    fun log() {
        changeHistory.map {
            Log.d(javaClass.simpleName, it.toString())
        }
    }

}