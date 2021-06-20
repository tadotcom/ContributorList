package com.example.contributorlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ContributorListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 配列の生成
        val array = arrayOf("リスト１", "リスト２", "リスト３", "リスト４", "リスト５")

        // xmlにて実装したListViewの取得
        val listView = view.findViewById<ListView>(R.id.list)

        // ArrayAdapterの生成
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, array)

        // ListViewに、生成したAdapterを設定
        listView.adapter = adapter
   }
}