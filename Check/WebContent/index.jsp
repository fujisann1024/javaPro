<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
	<!-- ヘッダーを表す -->
</header>
<body>
	<!-- 見出しタグを表すh1～h6 -->
	<h1>クイズ集</h1>

	<!-- 一つのパラグラフを表す -->
	<p>こんにちは</p>
	<p>おはよう</p>
	<!-- 改行はhtmlは基本的に認識しない -->
	<p>みなさん
	元気ですか</p>
	<!-- 半角スペースや改行をそのまま表示 -->
	<pre>みなさん
	元気ですね
	</pre>
	<hr><!-- 一つの区切りを表す -->
	<!-- リスト表示
	     順序に意味があるバージョン -->
	 <ol>
	 	<li>国語</li>
	 	<li>数学</li>
	 	<li>英語</li>
	 </ol>
	 <!-- 順序に意味がないバージョン -->
	<ul>
	 	<li>国語</li>
	 	<li>数学</li>
	 	<li>英語</li>
	 </ul>
	<!-- 単語とその意味をリスト上に書く -->
	<dl>
		<dt>empty</dt>
		<dd>空</dd>
		<dt>inset</dt>
		<dd>はめ込む</dd>
	</dl>
	<!-- テキストにルビを振る -->
	<ruby>
		英語<rt>えいご</rt>
	</ruby>
	<a href = "#">リンク1</a>
	<a href="#">リンク2</a>
	<!-- 改行 -->
	<br><a href="#">リンク3</a><br>
	<!-- 内容が単体で完結するセクション -->
	<article>
	<h2>今回の授業の感想</h2>
	</article>

	<!-- 画像を貼り付ける PNG・GIF・JPEG -->
	<img src="img/ringo-070904ic1.png">

	<!-- 画像にキャプションをつける -->
	<figure>
		<img src = "img/OIP.jpg">
		<figcaption>タンス</figcaption>
	</figure>

	<!-- 動画を再生する -->
	<video>
		<source src = "#"></source>
	</video>

	<!-- 音声を再生する ogg -->
	<audio src="#"></audio>
	<table>
	<caption>テーブルタイトル</caption>
	</table>
</body>
</html>