<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
  <% // セッションから値を取得 
  		User user=(User) session.getAttribute("user"); 
	%>
		
	<header class="top_page_header">
				<div class="header_nav">
					<h1>
						<a class="PeerPass_logo" href="ChoiceServlet"><img alt="PeerPassロゴ"src="PeerPass_img/peerpass_logo.png"></a>
					</h1>
					<div class="top_page_header_nav">
						<a class="past_goals" href="PastServlet">過去の目標</a>
						
						<div class="hamburger" id="js-hamburger">
							
							<a class="temp_hero_icon" href="#"><img alt="勇者アイコン"
									src="PeerPass_img/temp_hero_icon.png"></a>
						</div>
						<nav class="sp-nav">
							<button class="close-btn"
								id="js-close-btn">×</button><!-- ×ボタンを追加 -->
							<p class="username_modal">ユーザー名</p>
							<p class="header_username"><%=user.getName() %>さん</p>
							<ul>
								<li>
									<a href="UserEditServlet">ユーザー編集</a>
								</li>
								<li>
									<a href="ProfileEditServlet">プロフィール編集</a>
								</li>
								<li>
									<a href="LogoutServlet">ログアウト</a>
								</li>
							</ul>
						</nav>
						<div class="black-bg" id="js-black-bg"></div>
					</div>
				</div>
			</header>	
	
