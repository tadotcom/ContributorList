package com.example.contributorlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class ContributorDetailFragment : Fragment() {
    var rowNumber: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val strtext = requireArguments().getString("ROWDATA")
        rowNumber = Integer.parseInt(strtext);
        return inflater.inflate(R.layout.contributor_detail_fragment, container,false)
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
            val name = obj.getString("login")
            val url = obj.getString("url")
        }

        var name = view.findViewById<TextView>(R.id.name)
        name.setText("テスト")
    }
}