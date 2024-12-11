<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Goal,java.util.List" %>
		<% // セッションから値を取得 
		User user=(User) session.getAttribute("user"); 
		Goal goal=(Goal) session.getAttribute("goal");
		List<Goal> mutterList=(List<Goal>) request.getAttribute("mutterList");
		%>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>notLoggedIn.jsp</title>
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<!-- リセットcss -->
				<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/destyle.css@1.0.15/destyle.css" />
				<!-- webフォント(メインビジュアル) -->
				<link rel="preconnect" href="https://fonts.googleapis.com">
				<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
				<link
					href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&family=Reggae+One&display=swap"
					rel="stylesheet">
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
				<link rel="stylesheet" href="css/main1.css">
				<link rel="stylesheet" href="css/withGoalMain.css">
				<link rel="stylesheet" href="css/notLoggedIn.css">
				<!-- JavaScript -->
				<script type="text/javascript" src="js/script.js"></script>
			</head>

			<body>
			<div class="back_img_main">
				<header class="top_page_header">
				<h1>
					<a class="PeerPass_logo" href="WelcomeServlet"><img alt="PeerPassロゴ" src="PeerPass_img/peerpass_logo.png"></a>
				</h1>
			</header>
				<main class="main">
			<!--みんなの投稿の表示-->
					<h2 class="posting_title">みんなの投稿</h2>
					<% for(Goal g : mutterList) { %>
						<div class="post">
							<div class="con">
								<div class="users">				
									<img alt="user_icon" src="PeerPass_img/user_icon.png">
											<p><%=g.getUserName() %></p>
								</div>
								<p class="goals_of_users">
									<%=g.getGoal() %>
								</p>
							</div>
							<% if(g.getGoalAttribute() == 2){ %>
							<div class="stamp_con"><img class="stamp" alt="達成スタンプ" src="PeerPass_img/stamp_achieved.png"></div>
							<% } %>
							<% if(g.getGoalAttribute() == 3){ %>
							<div class="stamp_con"><img class="stamp" alt="未達成スタンプ" src="PeerPass_img/stamp_notyet.png"></div>
							<% } %>
						</div>
				<%} %>
				<div class="top_page_btn">
					<a href="RegisterServlet"><img alt="新規登録" src="PeerPass_img/btn_register.png"></a>
					<a href="LoginServlet"><img alt="ログイン" src="PeerPass_img/btn_login.png"></a>
				</div>
				</main>
					<footer>
					<p>©2024 PeerPass</p>
				</footer>
			</div>
			</body>

			</html>