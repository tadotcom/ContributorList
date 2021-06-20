package com.example.contributorlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContributorDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contributor_detail)

        //フラグメントの表示
        val contributorListFragment = ContributorListFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contributor_detail_fragment, contributorListFragment)
        fragmentTransaction.commit()
    }
}