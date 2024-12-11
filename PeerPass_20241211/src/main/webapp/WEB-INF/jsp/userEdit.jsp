<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <% // セッションから値を取得 
			String error=(String) request.getAttribute("error"); 
			
		%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>ユーザー編集画面</title>
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
		<link rel="stylesheet" href="css/useredit.css">
		<link rel="stylesheet" href="css/useredit_popup.css">
		<!-- JavaScript -->
		<script type="text/javascript" src="js/script.js"></script>
    </head>

    <body>
        <div class="register_background">
			<!-- ヘッダーインクルード-->
			<jsp:include page="header.jsp"></jsp:include>
			
			 <h2 class="main_title">ユーザー編集</h2>
			<form action="UserEditServlet" method="post">
				<div class="register_form">
					<p>
						現在のメールアドレス<br><input type="email" name="pastEmail" placeholder="peerpass@godthunder.com" >
					</p>
					<p>
						現在のパスワード<br><input type="password" name="pastPass" placeholder="現在のパスワードを入力" >
					</p>
					<p class="new_edit_text">
						新しいメールアドレス<br><input type="email" class="newtext" name="newEmail" placeholder="peerpass@godthunder.com" >
					</p>
					<p class="new_edit_text">
						新しいパスワード<br><input type="password"  class="newtext" name="newPass" placeholder="半角英数字8文字以上で入力（大文字、数字含む）" >
					</p>
				</div>
				<div class="footer_btn">
					<button  id="modal-open-useredit" type="button">
						<img src="PeerPass_img/btn_change.png" alt="変更">
					</button>
					
					<div id="modal-bg-useredit"></div>
					
					<div id="modal-container-useredit" >
						<h4>変更内容は下記でよろしいですか？</h4>
						<p>メールアドレス：<span id="modal-email1"></span></p> <!-- 現在のメールアドレス -->
						<p>パスワード：<span id="modal-pass1"></span></p> <!-- 現在のパスワード -->
						
						<p class="after-change">▼</p>
						
						<p>メールアドレス：<span id="modal-email2"></span></p><!-- 新しいメールアドレス -->
						<p>パスワード：<span id="modal-pass2"></span></p><!-- 新しいパスワード -->
						 
						<div class="yes_no_useredit">
							<button type="submit" >はい</button>
							<div id="modal-close-useredit">いいえ</div>
						</div>
					</div>
					
					<a href="ChoiceServlet"><img alt="メインへ戻る" src="PeerPass_img/btn_main.png"></a>
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
			
			<script src="js/useredit_popup.js"></script>
			<!-- モーダルウィンドウ-->
<jsp:include page="header_modal.jsp"></jsp:include>
    </body>

    </html>