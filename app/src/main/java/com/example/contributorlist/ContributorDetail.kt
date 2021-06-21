package com.example.contributorlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContributorDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contributor_detail)

        //jsonデータの行数を取得
        val detailRowData = intent.getStringExtra("ROWDATA")

        //フラグメントの表示
        val contributorDetailFragment = ContributorDetailFragment()

        val bundle = Bundle()
        bundle.putString("ROWDATA", intent.getStringExtra("ROWDATA"))
        contributorDetailFragment.setArguments(bundle)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contributor_detail_fragment, contributorDetailFragment)
        fragmentTransaction.commit()
    }
}