<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Goal,java.util.List" %>
<% // セッションから値を取得 
	User user=(User) session.getAttribute("user"); 
	List<Goal> mutterList=(List<Goal>)request.getAttribute("mutterList");
	String error = (String) request.getAttribute("error");
	String success= (String) request.getAttribute("success");
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>noGoalMain.jsp</title>
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
		<link rel="stylesheet" href="css/noGoalMain_popup.css">
		<!-- JavaScript -->
		<script type="text/javascript" src="js/script.js"></script>
	</head>


	<body>
	<div class="back_img_main">
		<!-- ヘッダーインクルード-->
			<jsp:include page="header.jsp"></jsp:include>
		<main class="main">	
			<h2 class="main_title">目標を宣言しよう！</h2>			
				<form class="form" action="SetGoalServlet" method="post">
					<div class="register_form">			
						<p>
							今日の目標<br><textarea class="textbox" type="text" name="goalName" placeholder="目標を30文字以内で入力"></textarea>
						</p>					
					</div>
					<!-- エラーメッセージを表示 -->
					<%if (error !=null) { %>
					<div class="error-message">
						<div class="error-icon"></div> <!-- アイコンの表示 -->
							<p class="error_msg" style="color: red;">
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
					
					
					
					<div class="footer_btn_nogoal">
						<button id="modal-open-nogoalmain" class="declaration_btn" type="button">
							<img src="PeerPass_img/btn_declare.png" alt="宣言">
						</button>
						
						<div id="modal-bg-nogoalmain"></div>
						
						<div id="modal-container-nogoalmain" >
							<h4>以下の内容で登録します。</h4>
							<p><span id="modal-goal-text"></span></p> <!-- テキストボックス入力内容 -->
						
						
							<div class="yes_no_nogoalmain">
									<button type="submit" >はい</button>
									<div id="modal-close-nogoalmain">いいえ</div>
							</div>
						</div>
					</div>
				</form>		
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
				<% } %>
			</main class="main">
		<footer>
			<p>©2024 PeerPass</p>
		</footer>
		<script src="js/noGoalMain_popup.js"></script>
		<!-- モーダルウィンドウ-->
<jsp:include page="header_modal.jsp"></jsp:include>
	</div>
	</body>

</html>