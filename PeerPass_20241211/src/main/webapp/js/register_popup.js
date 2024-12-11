'use strict';

{
	const open = document.getElementById('modal-open');
	const container = document.getElementById('modal-container');
	const modalBg = document.getElementById('modal-bg');
	const close = document.getElementById('modal-close');
	console.log(container)
	console.log(modalBg)
	console.log(close)
	
	
	
	
	
	open.addEventListener('click', () =>{
		console.log("click")
			container.classList.add('active');
			modalBg.classList.add('active');
	});
	
	close.addEventListener('click', () =>{
				container.classList.remove('active');
				modalBg.classList.remove('active');
		});
	modalBg.addEventListener('click', () =>{
				container.classList.remove('active');
				modalBg.classList.remove('active');
		});
}



'use strict';

{
    // 要素の取得
    const open = document.getElementById('modal-open');
    const container = document.getElementById('modal-container');
    const modalBg = document.getElementById('modal-bg');
    const close = document.getElementById('modal-close');

    // フォームの入力フィールドを取得
    const emailInput = document.querySelector('input[name="mail"]');
    const nameInput = document.querySelector('input[name="name"]');
    const passInput = document.querySelector('input[name="pass"]');

    // モーダル内の<p>タグを取得
    const emailDisplay = container.querySelector('p:nth-of-type(1)');
    const nameDisplay = container.querySelector('p:nth-of-type(2)');
    const passDisplay = container.querySelector('p:nth-of-type(3)');

    // モーダルを開くボタンのイベントリスナー
    open.addEventListener('click', () => {
        // 入力内容を取得してモーダルに表示
        emailDisplay.textContent = `メールアドレス：${emailInput.value}`;
        nameDisplay.textContent = `ニックネーム：${nameInput.value}`;
        passDisplay.textContent = `パスワード：${'*'.repeat(passInput.value.length)}`; // パスワードを伏せ字で表示

        // モーダルを表示
        container.classList.add('active');
        modalBg.classList.add('active');
    });

    // モーダルを閉じる処理
    close.addEventListener('click', () => {
        container.classList.remove('active');
        modalBg.classList.remove('active');
    });

    // モーダル背景をクリックして閉じる処理
    modalBg.addEventListener('click', () => {
        container.classList.remove('active');
        modalBg.classList.remove('active');
    });
}


