package com.example.contributorlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class ContributorListFragment : Fragment() {
    var array = arrayOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // jsonファイルの読み込み
        val assetManager = resources.assets
        val inputStream = assetManager.open("contributors.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readText()
        val jObject = JSONObject(str)
        val jArray = jObject.getJSONArray("contributors")

        for (i in 1 until jArray.length()) {
            val obj = jArray.getJSONObject(i)
            val title = obj.getString("login")
            val url = obj.getString("url")

            array += title

            val listView = view.findViewById<ListView>(R.id.list)
            val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, array)
            listView.adapter = adapter
        }
   }
}