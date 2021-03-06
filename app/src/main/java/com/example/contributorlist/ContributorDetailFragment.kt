package com.example.contributorlist

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


class ContributorDetailFragment : Fragment() {
    var rowNumber: Int = 0
    val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //ContributorDetailからリストの選択行番号を取得
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

        for (i in 0 until jArray.length()) {

            // contributorsの詳細情報を取得
            if (i == rowNumber) {
                val obj = jArray.getJSONObject(i)

                //jsonファイルから詳細画面に必要な項目を取得
                val login = obj.getString("login")
                val id = obj.getString("id")
                val node_id = obj.getString("node_id")
                val url = obj.getString("url")
                val avatar_url = obj.getString("avatar_url")

                //アバター画像の取得(非同期)　画像が取得できない場合は緑色の画像を表示
                var avatarImageView = view.findViewById<ImageView>(R.id.avatar)
                avatarImageView.setImageResource(R.drawable.ic_launcher_background);

                //非同期でアバター画像を取得してImageViewにセットする
                val task = Asynchronous(avatarImageView)
                task.execute(avatar_url)

                //詳細画面のTextViewを取得
                var loginTextView = view.findViewById<TextView>(R.id.login)
                var idTextView = view.findViewById<TextView>(R.id.id)
                var nodeIdTextView = view.findViewById<TextView>(R.id.nodeId)
                var urlTextView = view.findViewById<TextView>(R.id.url)

                //詳細画面のTextViewに値をセット
                loginTextView.setText(login)
                idTextView.setText(id)
                nodeIdTextView.setText(node_id)
                urlTextView.setText(url)
            }
        }
    }
}