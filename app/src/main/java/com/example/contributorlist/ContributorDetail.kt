package com.example.contributorlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContributorDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contributor_detail)

        val contributorDetailFragment = ContributorDetailFragment()

        //ContributorDetailFragmentにリスト何番目の行が押されたか値渡しを行う
        val bundle = Bundle()
        bundle.putString("ROWDATA", intent.getStringExtra("ROWDATA"))

        //フラグメントの表示
        contributorDetailFragment.setArguments(bundle)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contributor_detail_fragment, contributorDetailFragment)
        fragmentTransaction.commit()
    }
}