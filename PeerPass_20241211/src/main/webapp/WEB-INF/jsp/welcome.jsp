<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
    
    <% // セッションから値を取得 
	  		String success= (String) request.getAttribute("success");
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>welcome.jsp</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- リセットcss -->
		 <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/destyle.css@1.0.15/destyle.css"/>
		  <!-- webフォント(メインビジュアル) -->
		 <link rel="preconnect" href="https://fonts.googleapis.com">
		 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&family=Reggae+One&display=swap" rel="stylesheet">
		 <!-- webフォント(dot) -->
		 <link rel="preconnect" href="https://fonts.googleapis.com">
		 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		 <link href="https://fonts.googleapis.com/css2?family=DotGothic16&display=swap" rel="stylesheet">
		  <!-- webフォント(h3) -->
		 <link rel="preconnect" href="https://fonts.googleapis.com">
		 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		 <link href="https://fonts.googleapis.com/css2?family=Reggae+One&display=swap" rel="stylesheet">
		 
		 
		 
		 <!-- style.css -->
		<link rel="stylesheet" href="css/style.css">
		<!-- JavaScript -->
		<script type="text/javascript" src="js/script.js"></script>
	</head>
	
	<body>
		<div class="main_visual">
			<header class="top_page_header">
				<h1>
					<a class="PeerPass_logo" href="WelcomeServlet"><img alt="PeerPassロゴ" src="PeerPass_img/peerpass_logo.png"></a>
				</h1>
			</header>
				<section>
					<h2 class="main_visual_title">毎日ひとつ、<br>目標をクリア。</h2>
					<p class="top_page_subtitle">～宣言・達成・共有・成長～</p>
					<div class="top_page_btn">
						<a href="RegisterServlet"><img alt="新規登録" src="PeerPass_img/btn_register.png"></a>
						<a href="LoginServlet"><img alt="ログイン" src="PeerPass_img/btn_login.png"></a>
						<a href="NotLoggedInServlet"><img alt="みんなの投稿" src="PeerPass_img/btn_post.png"></a>
					</div>
					
					<div class="scroll_down" id="Scroll">
					  <a href="#">Scroll</a>
					</div>
					
				</section>
		</div>
		
		<!-- 成功メッセージを表示 -->
			<% if (success != null) { %>
			    <div id="success-message" class="success-message">
			        <p><%= success %></p>
			    </div>
			<% } %>
		
		<section class="main_1">
			<h3>毎日一つの目標を宣言して達成しよう！</h3>
			<div class="textbox_1">
				<img class="textbox1" alt="テキストボックス" src="PeerPass_img/textbox1.png">
				<img class="started_hero" alt="目標開始勇者" src="PeerPass_img/started_hero.png">
			</div>
			
			<h3 class="buddies_title">共に頑張れる仲間とつながろう。</h3>
			<div class="textbox_2">
				<img class="buddies" alt="仲間" src="PeerPass_img/buddies.png">
				<img class="textbox2" alt="テキストボックス" src="PeerPass_img/textbox2.png">
			</div>
			
			<h3>モチベーションを上げる。</h3>
			<div class="textbox_2">
				<img class="textbox3" alt="テキストボックス" src="PeerPass_img/textbox3.png">
				<img alt="勇者モチベ" src="PeerPass_img/motivated_hero.png">
			</div>
		</section>
		
		<section class="main_2">
			<h2>さあ、PeerPassをはじめよう！</h2>
			<div>
				<h3 class="top_page_h3">①<span>今日一日の目標を宣言する</span></h3>
				<div class="main2_first">
					<p>毎日「ひとつの目標を宣言」して達成しましょう。小さな成功の積み重ねが、大きな成長へと繋がります。あなたの目標を仲間と共有して進捗を感じる事も出来ます。</p>
					<img alt="宣言するボタンにマウスホバーしている画像" src="PeerPass_img/toppage_btn_declare.png">
				</div>
			</div>
			<div>
				<h3 class="top_page_h3">②<span>達成したかどうか確認する</span></h3>
				<div class="main2_second">
					<p>立てた目標に実際に取り組み「達成状況を確認」します。それによって自分の努力がどれだけ実を結んだかを実感し、目標継続へのモチベーションが高まります。</p>
					<img alt="達成した勇者" src="PeerPass_img/achieved_hero_icon.png">
				</div>
			</div>
			<div class="achieved_check">
				<h3 class="top_page_h3">③<span>過去の達成実績を確認する</span></h3>
				<div class="main2_third">
					<p>「過去の達成実績を確認」する事によって、自分の日々の努力の積み重ねを視覚的に確認する事が出来ます。これはモチベーションの維持を助け、自信が深まるというポジティブなサイクルを生み出します。</p>
					<img alt="達成ロゴ" src="PeerPass_img/achieved_logo.png">
				</div>
			</div>
		</section>
		<section class="main_3">
			<h2>PeerPassをもっと使いこなそう！</h2>
			<div>
				<h3 class="top_page_h3">④<span>目標を仲間と共有しよう</span></h3>
				<div class="main3_first">
					<p>「目標を仲間と共有」する事で、共に成長するための大きな力が生まれます。仲間からのフィードバックやサポートは目標達成へのモチベーションを高めます。</p>
					<img alt="共有ロゴ" src="PeerPass_img/share_logo.png">
				</div>
			</div>
			<div>
				<h3 class="top_page_h3">⑤<span>いいねやコメントをして仲間と鼓舞し合おう</span></h3>
				<div class="main3_second">
					<p>仲間とのいいねやコメントは、お互いにポジティブなエネルギーを送り合う大切な方法です。小さな言葉やアクションが、次のステップへの励みとなり共に成長し続ける力になります。</p>
					<img alt="いいねロゴ" src="PeerPass_img/nice.png">
				</div>
			</div>
			<div class="top_page_footer_btn">
				<a href="RegisterServlet"><img alt="新規登録" src="PeerPass_img/btn_create_new.png"></a>
				<a href="LoginServlet"><img alt="ログイン" src="PeerPass_img/btn_login.png"></a>
				<a href="NotLoggedInServlet"><img alt="みんなの投稿" src="PeerPass_img/btn_post.png"></a>
			</div>
			<footer>
				<p>©2024 PeerPass</p>
			</footer>
		</section>
	</div>
	
		<!-- ベータ版ボタン-->
		<!--<button onclick="window.location.href='RegisterServlet'">新規登録</button><br>
		<button onclick="window.location.href='LoginServlet'">ログイン</button><br>
		<button onclick="window.location.href='NotLoggedInServlet'">みんなの目標をみる</button><br> -->
	</body>
</html>
 