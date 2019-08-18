package com.derrick.populartv

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.derrick.database.Show
import com.derrick.database.ShowDatabaseDao
import com.derrick.util.SampleData
import kotlinx.coroutines.*

class PopularViewModel(val databaseDao: ShowDatabaseDao, application: Application) :
    AndroidViewModel(application) {
    /**
     * viewModelJob allows us to cancel all coroutines started by this ViewModel.
     */
    private var viewModelJob = Job()


    /**
     * A [CoroutineScope] keeps track of all coroutines started by this ViewModel.
     *
     * Because we pass it [viewModelJob], any coroutine started in this uiScope can be cancelled
     * by calling `viewModelJob.cancel()`
     *
     * By default, all coroutines started in uiScope will launch in [Dispatchers.Main] which is
     * the main thread on Android. This is a sensible default because most coroutines started by
     * a [ViewModel] update the UI after performing some processing.
     */
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    /**
     * Shows the total count of movies
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     */
    private var _count = MutableLiveData<String>()

    /**
     * This will show total of popular movies
     */
    val count: LiveData<String>
        get() = _count

    /**
     * Executes when the SAVE button is clicked.
     */
    fun oSaveTvShow() {
        uiScope.launch {
            val listOfSampleData = SampleData.getTvShows(getApplication())

            insertToDb(listOfSampleData)

            _count.value = getTotalCount()?.toString()
        }
    }


    private suspend fun insertToDb(listOfSampleData: List<Show>) {
        withContext(Dispatchers.IO) {
            databaseDao.builkInsert(listOfSampleData)
        }
    }

    private suspend fun getTotalCount(): Int? {
        return withContext(Dispatchers.IO) {
            databaseDao.getCount()
        }
    }

    /**
     * Called when the ViewModel is dismantled.
     * At this point, we want to cancel all coroutines;
     * otherwise we end up with processes that have nowhere to return to
     * using memory and resources.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}