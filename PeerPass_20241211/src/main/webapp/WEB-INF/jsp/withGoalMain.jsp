<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="model.User,model.Goal,java.util.List" %>
		<% // セッションから値を取得 
		User user=(User) session.getAttribute("user"); 
		Goal goal=(Goal) session.getAttribute("goal");
		List<Goal> mutterList=(List<Goal>) request.getAttribute("mutterList");
		String success= (String) request.getAttribute("success");
		%>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>withGoalMain.jsp</title>
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
				<link rel="stylesheet" href="css/pastGoal.css">
				<link rel="stylesheet" href="css/withGoalMain.css">
				<link rel="stylesheet" href="css/withGoalMain_popup.css">
				<!-- JavaScript -->
				<script type="text/javascript" src="js/script.js"></script>
			</head>

			<body>
			<div class="back_img_main">
				<!-- ヘッダーインクルード-->
			<jsp:include page="header.jsp"></jsp:include>
			
				<main class="main">
					<h2 class="main_title">あなたの今日の目標</h2>		
						<form action="GoalJudgeServlet" method="POST">
							<div class="form_bg">
								<div class="goal_name"><%=goal.getGoal() %></div>
							</div>
							
							
							<div class="btn_group">
								<input type="hidden" name="goalID" value="<%=goal.getGoalID() %>">
								<button type="button" id="complete" name="goalAttribute" value="2">
									<img  class="complete_btn" src="PeerPass_img/btn_achieved.png" alt="達成ボタン">
								</button>
								<button type="button" id="complete2" name="goalAttribute" value="3">
									<img class="incomplete_btn" src="PeerPass_img/btn_notyet.png" alt="未達成ボタン">
								</button>
							</div>
								<!--達成モーダルウィンドウ-->
								<div id="modal-bg-withgoal"></div>
								
								<div  id="modal-container-withgoal" >
									<h4>今日の目標は<span class="goal-achievement">達成</span>でよろしいですか？</h4>
									<div class="yes_no_withgoal">
											<button type="submit" name="goalAttribute" value="2">はい</button>
											<div  id="modal-close-withgoal">いいえ</div>
									</div>
								</div>
								
								<!--未達成モーダルウィンドウ-->
								<div id="modal-bg-withgoal-2"></div>
								
								<div id="modal-container-withgoal-2" >
									<h4>今日の目標は<span class="goal-not-achieved">未達成</span>でよろしいですか？</h4>
									<div class="yes_no_withgoal-2">
										<button type="submit" name="goalAttribute" value="3">はい</button>
										<div id="modal-close-withgoal-2">いいえ</div>
									</div>
								</div>
						</form>	
						
						<!-- 成功メッセージを表示 -->
						<% if (success != null) { %>
						    <div id="success-message" class="success-message">
						        <p><%= success %></p>
						    </div>
						<% } %>	
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
				</main>
					<footer>
					<p>©2024 PeerPass</p>
				</footer>
				<script src="js/withGoalMain_popup.js"></script>
				<!-- モーダルウィンドウ-->
<jsp:include page="header_modal.jsp"></jsp:include>
			</div>
			</body>

			</html>