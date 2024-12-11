<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% // セッションから値を取得 
			String error=(String) request.getAttribute("error"); 
		%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アカウント作成</title>
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
		<link rel="stylesheet" href="css/register.css">
		<link rel="stylesheet" href="css/register_popup.css">
		
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
			<h2 class="main_title">無料でアカウントを作成</h2>
			
			<form action="RegisterServlet" id="form" method="post">
				<div class="register_form">
					<p>
						メールアドレス<br><input type="text" name="mail"  placeholder="peerpass@godthunder.com" >
					</p>
					<p>
						ニックネーム<br><input type="text" name="name" placeholder="15文字以内で入力" >
					</p>
					<p>
						パスワード<br><input type="password" name="pass"  placeholder="半角英数字8文字以上で入力（大文字、数字含む）">
					</p>
				</div>
				<div class="footer_btn">
					<button id="modal-open" type="button">
						<img src="PeerPass_img/btn_create_new.png" alt="登録">
					</button>
					
					<div id="modal-bg"></div>
					
					<div id="modal-container" >
						<h4>以下のアカウントを作成しますがよろしいですか？</h4>
						<p>メールアドレス：</p>
						<p >ニックネーム：</p>
						<p>パスワード：</p>
						<div class="yes_no">
							<button type="submit" >はい</button>
							<div id="modal-close">いいえ</div>
						</div>
					</div>
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
			
				
			<footer>
				<p>©2024 PeerPass</p>
			</footer>
		</div>
		
			
		<script src="js/register_popup.js"></script>
	</body>
</html>