<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	  <% // セッションから値を取得 
			String error=(String) request.getAttribute("error"); 
	  		System.out.println("レジスターjsp↓");
	  		String success= (String) request.getAttribute("success");
		%>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>ログイン画面</title>
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
			<div class="register_background">
				<header class="top_page_header">
						<h1>
							<a class="PeerPass_logo" href="WelcomeServlet"><img alt="PeerPassロゴ" src="PeerPass_img/peerpass_logo.png"></a>
						</h1>
				</header>
				<h2 class="main_title">ログイン</h2>
				
				<form action="LoginServlet" method="post">
					<div class="register_form">
						<p>
							メールアドレス<br><input type="email" name="mail" placeholder="peerpass@godthunder.com">
						</p>
						
						<p>
							パスワード<br><input type="password" name="pass" placeholder="パスワードを入力">
						</p>
					</div>
					<div class="footer_btn">
						<button type="submit">
							<img src="PeerPass_img/btn_login.png" alt="ログイン">
						</button>
						<a href="WelcomeServlet"><img alt="トップへ戻る" src="PeerPass_img/btn_top.png"></a>
					</div>
				</form>
				
				
				<!-- エラーメッセージを表示 -->
				<%if (error !=null) { %>
					<div class="error-message">
							<div class="error-icon"></div> <!-- アイコンの表示 -->
						<p style="color: red;">
							<%= error %>
						</p>
					</div>
				<% } %>
					
					
					
				<!-- 成功メッセージを表示 -->
						<% if (success != null) { %>
						    <div id="success-message" class="success-message">
						        <p><%= success %></p>
						    </div>
						<% } %>
				<footer>
					<p>©2024 PeerPass</p>
				</footer>
			</div>
		</body>

		</html>