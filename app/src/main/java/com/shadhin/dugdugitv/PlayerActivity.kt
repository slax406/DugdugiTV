package com.shadhin.dugdugitv

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class PlayerActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        playerView = findViewById(R.id.playerView)
        progressBar = findViewById(R.id.progressBar)
        errorText = findViewById(R.id.errorText)
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    private fun initializePlayer() {
        val url = intent.getStringExtra("url") ?: return

        val exoPlayer = ExoPlayer.Builder(this).build()
        player = exoPlayer
        playerView.player = exoPlayer

        exoPlayer.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_BUFFERING -> {
                        progressBar.visibility = View.VISIBLE
                        errorText.visibility = View.GONE
                    }
                    Player.STATE_READY -> {
                        progressBar.visibility = View.GONE
                        errorText.visibility = View.GONE
                    }
                    Player.STATE_ENDED, Player.STATE_IDLE -> {
                        progressBar.visibility = View.GONE
                    }
                }
            }

            override fun onPlayerError(error: PlaybackException) {
                progressBar.visibility = View.GONE
                errorText.visibility = View.VISIBLE
                errorText.text = "Stream load korte parlo na.\nLink ba network check koro.\n\n${error.errorCodeName}"
            }
        })

        val mediaItem = MediaItem.fromUri(url)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    private fun releasePlayer() {
        player?.release()
        player = null
    }
}
