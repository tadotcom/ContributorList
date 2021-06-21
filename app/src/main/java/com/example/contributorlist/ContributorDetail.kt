package com.example.contributorlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ContributorDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contributor_detail)

        //jsonデータの行数を取得
        val detailRowData = intent.getStringExtra("VALUE")
        val bundle = Bundle()
        //フラグメントに値渡しを行う
        bundle.putInt("INT_KEY", Integer.parseInt(detailRowData))

        //フラグメントの表示
        val contributorDetailFragment = ContributorDetailFragment()
        contributorDetailFragment.arguments = bundle
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contributor_detail_fragment, contributorDetailFragment)
        fragmentTransaction.commit()
    }
}