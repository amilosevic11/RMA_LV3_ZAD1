package amilosevic.ferit.birdwatcher.data

import amilosevic.ferit.birdwatcher.BirdWatcher
import android.content.Context

class PreferenceManager
{
    companion object
    {
        const val PREFS_FILE = "myPreferences"
        const val KEY_BIRD_COLOR = "bird_color"
        const val KEY_BIRD_COUNTER = "bird_counter"
    }

    fun saveBirdColor(color : Int)
    {
        val sharedPreferences = BirdWatcher.context.getSharedPreferences(
                PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()

        editor.putInt(KEY_BIRD_COLOR, color)
        editor.apply()
    }

    fun retrieveBirdColor() : Int
    {
        val sharedPreferences = BirdWatcher.context.getSharedPreferences(
                PREFS_FILE, Context.MODE_PRIVATE
        )

        return sharedPreferences.getInt(KEY_BIRD_COLOR, 0) ?: 0
    }

    fun saveBirdCount(count : Int)
    {
        val sharedPreferences = BirdWatcher.context.getSharedPreferences(
                PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_BIRD_COUNTER, count)
        editor.apply()
    }

    fun retrieveBirdCount() : Int
    {
        val sharedPreferences = BirdWatcher.context.getSharedPreferences(
                PREFS_FILE, Context.MODE_PRIVATE
        )

        return sharedPreferences.getInt(KEY_BIRD_COUNTER, 0) ?: 0
    }
}