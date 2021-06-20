package com.example.contributorlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContributorDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contributor_detail)

        //フラグメントの表示
        val contributorDetailFragment = ContributorDetailFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contributor_detail_fragment, contributorDetailFragment)
        fragmentTransaction.commit()
    }
}