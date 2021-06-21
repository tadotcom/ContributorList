package com.example.contributorlist

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


//class Asynchronous : AsyncTask<Int?, Int?, Int>() {
//
//    //非同期処理を実行
//    override fun doInBackground(vararg p0: Int?): Int {
//
//        return 0
//    }
//}

class Asynchronous : AsyncTask<String, Void, Bitmap>() {
    private var listener: Listener? = null

    // 非同期処理
    override fun doInBackground(vararg p0: String?): Bitmap? {

        return downloadImage("") ;
    }

    // 非同期処理が終了後、結果をメインスレッドに返す
    override fun onPostExecute(bmp: Bitmap?) {
        if (listener != null) {
            listener!!.onSuccess(bmp)
        }
    }

    private fun downloadImage(address: String): Bitmap? {
        var bmp: Bitmap? = null
        var urlConnection: HttpURLConnection? = null
        try {
            val url = URL(address)

            // HttpURLConnection インスタンス生成
            urlConnection = url.openConnection() as HttpURLConnection

            // タイムアウト設定
            urlConnection.setReadTimeout(10000)
            urlConnection.setConnectTimeout(20000)

            // リクエストメソッド
            urlConnection.setRequestMethod("GET")

            // リダイレクトを自動で許可しない設定
            urlConnection.setInstanceFollowRedirects(false)

            // ヘッダーの設定(複数設定可能)
            urlConnection.setRequestProperty("Accept-Language", "jp")

            // 接続
            urlConnection.connect()
            val resp: Int = urlConnection.getResponseCode()
            when (resp) {
                HttpURLConnection.HTTP_OK -> try {
                    urlConnection.getInputStream().use { `is` ->
                        bmp = BitmapFactory.decodeStream(`is`)
                        `is`.close()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                HttpURLConnection.HTTP_UNAUTHORIZED -> {
                }
                else -> {
                }
            }
        } catch (e: Exception) {
            Log.d("debug", "downloadImage error")
            e.printStackTrace()
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect()
            }
        }
        return bmp
    }

    fun setListener(listener: Listener?) {
        this.listener = listener
    }

    interface Listener {
        fun onSuccess(bmp: Bitmap?)
    }
}