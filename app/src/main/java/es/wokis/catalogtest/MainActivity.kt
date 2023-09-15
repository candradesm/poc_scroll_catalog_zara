package es.wokis.catalogtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.wokis.catalogtest.databinding.ActivityMainBinding
import es.wokis.catalogtest.databinding.PocRowBinding

class MainActivity : AppCompatActivity() {

    private val topAdapter = Adapter()
    private val bottomAdapter = Adapter()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpAdapters()
        submitLists()
    }

    private fun setUpAdapters() {
        binding.apply {
            recyclerTop.adapter = topAdapter
            recyclerBottom.adapter = bottomAdapter
        }
    }

    private fun submitLists() {
        val topList = generateList("topItem", 50)
        val bottomList = generateList("bottomList", 50)
        topAdapter.submitList(topList)
        bottomAdapter.submitList(bottomList)
    }

    private fun generateList(description: String, itemCount: Int): List<PocVO> {
        val list: MutableList<PocVO> = mutableListOf()
        for (x in 0..itemCount) {
            list.add(PocVO("$description$x", "$description, list pos: $x"))
        }
        return list.toList()
    }
}