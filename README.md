# ContributorList

「Android Architecture Components samples」リポジトリの「contributors」のjsonファイルを表示するAndroidアプリ

使用言語はkotlin
リストの表示にはListView、アバター画像を表示させる非同期処理にはAsyncTaskを使用

### アプリの使用方法や機能
(1)「Android Architecture Components samples」リポジトリの「contributors」が一覧で表示される</br>
(2)一覧の任意の行をタップすると、contributorsの詳細ページに遷移する。URLの欄のURLをタップすると、ブラウザが起動してGitHubのユーザーページを確認できる</br>

### 今後の対応
・ユニットテスト、UIテスト(Espresso)の導入を行う
・ListViewやAsyncTaskはAndroidのAPI30から非推奨になるため、ListViewはRecycleViewにAsyncTaskはコルーチンに移行する
・GitHubの使用経験が浅いため、効果的なプルリクエストの使用方法がわからなかった
