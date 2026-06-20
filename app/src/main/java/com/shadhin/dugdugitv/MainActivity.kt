package com.shadhin.dugdugitv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Edit links/titles here as needed
    private val sections = listOf(
        Section("Dugdugi Live", "TV Server", "http://dugdugilive.com/"),
        Section("Roar Zone", "TV Server", "https://tv.roarzone.net/"),
        Section("FTP Server 1", "10.100.100.10", "http://10.100.100.10/"),
        Section("FTP Server 2", "172.16.50.4", "http://172.16.50.4/")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grid = findViewById<RecyclerView>(R.id.sectionsGrid)
        grid.layoutManager = GridLayoutManager(this, 3)
        grid.adapter = SectionAdapter(sections) { section ->
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("title", section.title)
            intent.putExtra("url", section.url)
            startActivity(intent)
        }
    }
}
