package com.example.contributorlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (private val rowDataList: ArrayList<RowData>, private val listener: AddRowdataListener): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Viewの初期化
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val name: TextView
        val url: TextView

        init {
            image = view.findViewById(R.id.contributorsAvatar)
            name = view.findViewById(R.id.contributorslogin)
            url = view.findViewById(R.id.contributorsUrl)
        }
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_row, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val animal = rowDataList[position]

        viewHolder.image.setImageResource(animal.imageId)
        viewHolder.name.text = animal.name
        viewHolder.url.text = animal.age.toString()
    }

    // 表示数を返す
    override fun getItemCount() = rowDataList.size
}