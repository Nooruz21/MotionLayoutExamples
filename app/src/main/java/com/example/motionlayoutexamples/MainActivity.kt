package com.example.motionlayoutexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motionlayoutexamples.databinding.ActivityMainBinding
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: MainAdapter
    private lateinit var mLayoutManager: LinearLayoutManager

    private val mAdapterData: Array<Demo> = arrayOf(
        Demo("Basic Collapsing Toolbar", Types.DEFAULT, R.layout.collapsing_toolbar),
        Demo(
            "Collapsing Toolbar w/ Text Interpolation",
            Types.DEFAULT,
            R.layout.collapsing_toolbar_2
        ),
        Demo(
            "Collapsing Toolbar w/ Cover Example",
            Types.FULLSCREEN,
            R.layout.collapsing_toolbar_with_cover
        ),
        Demo(
            "Complex Animation Example",
            Types.WITHOUT_RECYCLER_VIEW,
            R.layout.complex_animation_example,
            ComplexAnimationActivity::class.java
        ),
        Demo(
            "Multiple Animation Example",
            Types.FULLSCREEN,
            R.layout.multiple_animation_example,
            ComplexAnimationActivity::class.java
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerViewProperties()
    }

    private fun initRecyclerViewProperties() = with(binding.recyclerView) {
        mAdapter = MainAdapter(mAdapterData)
        mLayoutManager = LinearLayoutManager(context)
        layoutManager = mLayoutManager
        adapter = mAdapter
        setHasFixedSize(true)
    }

    fun start(activity: Class<*>, layoutFileId: Int, types: Types?, position: Int) {
        if (position > 4) {
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, activity).apply {
                putExtra("layoutId", layoutFileId)
                putExtra("type", types?.ordinal ?: Types.DEFAULT.ordinal)
            }
            startActivity(intent)
        }
    }
}