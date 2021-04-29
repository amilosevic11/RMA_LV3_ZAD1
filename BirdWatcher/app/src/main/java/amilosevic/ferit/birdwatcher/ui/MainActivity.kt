package amilosevic.ferit.birdwatcher.ui

import amilosevic.ferit.birdwatcher.BirdWatcher
import amilosevic.ferit.birdwatcher.R
import amilosevic.ferit.birdwatcher.data.PreferenceManager
import amilosevic.ferit.birdwatcher.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity()
{
    private lateinit var activityMainBinding : ActivityMainBinding
    private val preferenceManager = PreferenceManager()
    private var birdCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        birdCounter = preferenceManager.retrieveBirdCount()
        activityMainBinding.tvBirdCount.setBackgroundColor(preferenceManager.retrieveBirdColor())
        activityMainBinding.tvBirdCount.text = birdCounter.toString()

        activityMainBinding.buttonReset.setOnClickListener {
            reset()
        }

        activityMainBinding.buttonRedBird.setOnClickListener {
            seeBird()

            activityMainBinding.tvBirdCount.text = birdCounter.toString()
            preferenceManager.saveBirdCount(birdCounter)

            preferenceManager.saveBirdColor(ContextCompat.getColor(BirdWatcher.context, R.color.red))
            activityMainBinding.tvBirdCount.setBackgroundColor(preferenceManager.retrieveBirdColor())
        }

        activityMainBinding.buttonGreenBird.setOnClickListener {
            seeBird()

            activityMainBinding.tvBirdCount.text = birdCounter.toString()
            preferenceManager.saveBirdCount(birdCounter)

            preferenceManager.saveBirdColor(ContextCompat.getColor(BirdWatcher.context, R.color.green))
            activityMainBinding.tvBirdCount.setBackgroundColor(preferenceManager.retrieveBirdColor())
        }

        activityMainBinding.buttonBlueBird.setOnClickListener {
            seeBird()

            activityMainBinding.tvBirdCount.text = birdCounter.toString()
            preferenceManager.saveBirdCount(birdCounter)

            preferenceManager.saveBirdColor(ContextCompat.getColor(BirdWatcher.context, R.color.blue))
            activityMainBinding.tvBirdCount.setBackgroundColor(preferenceManager.retrieveBirdColor())
        }

        activityMainBinding.buttonYellowBird.setOnClickListener {
            seeBird()

            activityMainBinding.tvBirdCount.text = birdCounter.toString()
            preferenceManager.saveBirdCount(birdCounter)

            preferenceManager.saveBirdColor(ContextCompat.getColor(BirdWatcher.context, R.color.yellow))
            activityMainBinding.tvBirdCount.setBackgroundColor(preferenceManager.retrieveBirdColor())
        }
    }

    private fun seeBird() : Unit
    {
        birdCounter++
    }
    private fun setBackgroundColor(color : Int)
    {
        activityMainBinding.tvBirdCount.setBackgroundColor(color)
        preferenceManager.saveBirdColor(color)
    }

    private fun reset() : Unit
    {
        birdCounter = 0
        preferenceManager.saveBirdCount(birdCounter)
        preferenceManager.saveBirdColor(0)
        activityMainBinding.tvBirdCount.text = birdCounter.toString()
        activityMainBinding.tvBirdCount.setBackgroundColor(0)
    }
}