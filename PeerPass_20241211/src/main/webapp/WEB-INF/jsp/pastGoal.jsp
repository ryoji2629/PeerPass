<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Goal,java.util.List"%>
<!--  セッションから値を取得 -->
<% String error=(String) request.getAttribute("error");
	User user=(User)session.getAttribute("user"); 
	List<Goal>goalList = (List<Goal>) session.getAttribute("goalList");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>pastGoal.jsp</title>
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
		<link rel="stylesheet" href="css/pastGoal.css">
		<link rel="stylesheet" href="css/pastGoal_popup.css">
		<!-- JavaScript -->
		<script type="text/javascript" src="js/script.js"></script>
	</head>	
	<body>	
		<div class="bgimg">
			<!-- ヘッダーインクルード-->
			<jsp:include page="header.jsp"></jsp:include>
			
			<main class="main">
				<div class="wrapper">
					<h2 class="title">過去目標一覧</h2>
						<div class="form_container">
							<% for(Goal goal : goalList) { %>
							<% if(goal.getGoalAttribute()==1){ %>
							<!--目標状態が1、つまり目標可否確認が必要なら-->
							<form class="form_bg" action="PastServlet" method="POST">
								<div class="icon_name_container">
									<div class="img_icon"><img class="icon_sub" alt="勇者アイコン" src="PeerPass_img/temp_hero_icon.png"></div>
									<p class="nickname"><%=user.getName() %></p>
								</div><!--icon_name_containerの閉じタグ-->
								<div class="goal_name"><%=goal.getGoal() %></div>
								<div class="btn_group">
									<input type="hidden" name="goalID" value="<%=goal.getGoalID() %>">
									
										<button type="button" class="complete" data-goal="<%=goal.getGoal()%>" data-register-date="<%=goal.getRegisterDate()%>">
										    <img class="complete_btn" src="PeerPass_img/btn_achieved.png" alt="達成ボタン">
										</button>
										<button type="button" class="complete2" data-goal="<%=goal.getGoal()%>" data-register-date="<%=goal.getRegisterDate()%>">
										    <img class="incomplete_btn" src="PeerPass_img/btn_notyet.png" alt="未達成ボタン">
										</button>

									
									<!--達成モーダルウィンドウ-->
									<div class="modal-bg-pastgoal" id="modal-bg-pastgoal"></div>
									<div class="modal-container-pastgoal" id="modal-container-pastgoal" >
										<h4><%=goal.getRegisterDate() %>の目標は<span class="goal-achievement">達成</span>でよろしいですか？</h4>
										<p class="modal-pastgoal-text">目標内容：<%=goal.getGoal() %></p> 
									
										<div class="yes_no_pastgoal">
												<button type="submit" name="goalAttribute" value="2">はい</button>
												<div class="modal-close-pastgoal" id="modal-close-pastgoal">いいえ</div>
										</div>
									</div>
									
									<!--未達成モーダルウィンドウ-->
									<div id="modal-bg-pastgoal-2"></div>
									<div id="modal-container-pastgoal-2" >
										<h4><%=goal.getRegisterDate() %>の目標は<span class="goal-not-achieved">未達成</span>でよろしいですか？</h4>
										<p class="modal-pastgoal-text">目標内容：<%=goal.getGoal() %></p> 
									
										<div class="yes_no_pastgoal-2">
												<button type="submit" name="goalAttribute" value="3">はい</button>
												<div id="modal-close-pastgoal-2">いいえ</div>
										</div>
									</div>
									
									
									
									
								</div>
								<p class="register_date_1"><%=goal.getRegisterDate() %></p>
							</form>
							<%}%>
							<% if(goal.getGoalAttribute()==2){ %>
							<form class="form_bg" action="PastServlet" method="POST">
								<div class="achieved_stamp"><img alt="達成スタンプ" src="PeerPass_img/stamp_achieved.png"></div>
								<div class="icon_name_container">
									<div class="img_icon"><img class="icon" alt="勇者アイコン" src="PeerPass_img/temp_hero_icon.png"></div>
									<p class="nickname"><%=user.getName() %></p>
								</div><!--icon_name_containerの閉じタグ-->
								<div class="goal_name"><%=goal.getGoal() %></div>
								<p class="register_date"><%=goal.getRegisterDate() %></p>
							</form>
							<%}%>
							<% if(goal.getGoalAttribute()==3){ %>
							<form class="form_bg" action="PastServlet" method="POST">
								<div class="achieved_stamp"><img alt="達成スタンプ" src="PeerPass_img/stamp_notyet.png"></div>
								<div class="icon_name_container">
									<div class="img_icon"><img class="icon" alt="勇者アイコン" src="PeerPass_img/temp_hero_icon.png"></div>
									<p class="nickname"><%=user.getName() %></p>
								</div><!--icon_name_containerの閉じタグ-->
								<div class="goal_name"><%=goal.getGoal() %></div>
								<p class="register_date"><%=goal.getRegisterDate() %></p>
							</form>
							<%}%>
							<% } %>
						</div>
					
					<div class="top_btn">
						<a href="ChoiceServlet"><img class="backtotop_btn" alt="トップに戻る" src="PeerPass_img/btn_main.png"></a>
					</div>
				
					<!-- エラーメッセージを表示 -->
					
					<%if (error !=null) { %>
						<div class="error-message">
								<div class="error-icon"></div> <!-- アイコンの表示 -->
							<p style="color: red;">
								<%= error %>
							</p>
						</div>
					<% } %>
					
					
				</div>
				
				
			</main>
			<footer>
				<p>©2024 PeerPass</p>
			</footer>
			<script src="js/pastGoal_popup.js"></script>
			<!-- モーダルウィンドウ-->
<jsp:include page="header_modal.jsp"></jsp:include>
		</div>
	</body>
</html>