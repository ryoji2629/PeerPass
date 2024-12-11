//成功メッセージ

// 成功メッセージを自動的に非表示にする
document.addEventListener('DOMContentLoaded', function () {
    const successMessage = document.getElementById('success-message');
    if (successMessage) {
        // 5秒後に非表示にする
        setTimeout(() => {
            successMessage.style.display = 'none';
        }, 5000);
    }
});



window.onload = function () {
    // 読み込みが完了したら実行したい処理を記述
    var nav = document.querySelector('.sp-nav'); // メニューのナビゲーション
    var hamburger = document.getElementById('js-hamburger'); // ハンバーガーアイコン
    var blackBg = document.getElementById('js-black-bg'); // 黒い背景
	var closeBtn = document.getElementById('js-close-btn'); // ×ボタン
	
	
	// モーダルウィンドウ関連
	   var modal = document.getElementById('logout-modal'); // モーダル
	   var confirmLogoutBtn = document.getElementById('confirm-logout'); // はいボタン
	   var cancelLogoutBtn = document.getElementById('cancel-logout'); // いいえボタン
	   var logoutLink = document.querySelector('.sp-nav a[href="LogoutServlet"]'); // ログアウトリンク

	
	
	
    // ハンバーガーアイコンをクリックしたら
    hamburger.addEventListener('click', function () {
        // メニューに 'open' クラスをトグル
        nav.classList.toggle('open');
        // 黒背景も表示/非表示を切り替える
        blackBg.classList.toggle('show');
    });

    // 黒背景をクリックしたら
    blackBg.addEventListener('click', function () {
        // メニューの 'open' クラスを削除
        nav.classList.remove('open');
        // 黒背景も非表示にする
        blackBg.classList.remove('show');
    });
	
	// ×ボタンをクリックしたらメニューを閉じる
	    closeBtn.addEventListener('click', function () {
	        nav.classList.remove('open');
	        blackBg.classList.remove('show');
	    });
		
		
		// ログアウトリンクをクリックしたとき
		   logoutLink.addEventListener('click', function (event) {
		       event.preventDefault(); // デフォルトのリンク動作をキャンセル
		       modal.style.display = 'flex'; // モーダルを表示
		   });

		   // 「はい」ボタンをクリックしたとき
		   confirmLogoutBtn.addEventListener('click', function () {
		       // ログアウト処理を実行（WelcomeServletに遷移）
		       window.location.href = 'LogoutServlet'; // LogoutServletにリダイレクト
		   });

		   // 「いいえ」ボタンをクリックしたとき
		   cancelLogoutBtn.addEventListener('click', function () {
		       modal.style.display = 'none'; // モーダルを非表示
		   });
		
};










