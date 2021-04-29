package amilosevic.ferit.birdwatcher

import android.app.Application
import android.content.Context

class BirdWatcher : Application()
{
    companion object
    {
        lateinit var context: Context
    }

    override fun onCreate()
    {
        super.onCreate()

        context = this
    }
}