<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
  <% // セッションから値を取得 
		String error=(String) request.getAttribute("error"); 
  		User user=(User) session.getAttribute("user"); 
	%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<title>header.jsp</title>
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
		<link rel="stylesheet" href="css/profileEdit.css">
		<!-- JavaScript -->
		<script type="text/javascript" src="js/script.js"></script>
	</head>
	
    <body>
    	<div class="register_background">
		   <!-- ヘッダーインクルード-->
			<jsp:include page="header.jsp"></jsp:include>	
<!-- ここから井川さんのフォーマット-->
			<h2 class="main_title">プロフィール編集</h2>			
			<form class="form" action="ProfileEditServlet" method="post">
	
				<div class="register_form">			
					<p>
						新しいニックネーム<br><input type="text" class="input_text" name="name" placeholder="現在のニックネームは「<%=user.getName() %>」です。">
					</p>					
				</div>
				<div class="footer_btn">
					<button type="submit">
						<img src="PeerPass_img/btn_change.png" alt="変更">
					</button>
					<a href="ChoiceServlet"><img alt="トップへ戻る" src="PeerPass_img/btn_main.png"></a>
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
<!-- 井川さんのコード終了 -->
			
			<footer>
				<p>©2024 PeerPass</p>
			</footer>
			<!-- モーダルウィンドウ-->
<jsp:include page="header_modal.jsp"></jsp:include>
		</div>
    </body>
</html>