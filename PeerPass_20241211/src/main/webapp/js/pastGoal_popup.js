document.addEventListener("DOMContentLoaded", function () {
    // 達成ボタン・未達成ボタン取得
    const openButtons = document.querySelectorAll('.complete'); // 達成ボタン
    const openButtons2 = document.querySelectorAll('.complete2'); // 未達成ボタン
    const modalBg = document.getElementById('modal-bg-pastgoal'); // 達成モーダル背景
    const modalContainer = document.getElementById('modal-container-pastgoal'); // 達成モーダルコンテナ
    const closeModal = document.getElementById('modal-close-pastgoal'); // 達成モーダル閉じる
    const modalBg2 = document.getElementById('modal-bg-pastgoal-2'); // 未達成モーダル背景
    const modalContainer2 = document.getElementById('modal-container-pastgoal-2'); // 未達成モーダルコンテナ
    const closeModal2 = document.getElementById('modal-close-pastgoal-2'); // 未達成モーダル閉じる

    // 達成ボタンのクリックイベント
    openButtons.forEach(button => {
        button.addEventListener('click', function () {
            const goal = button.getAttribute('data-goal'); // ボタンのdata-goal属性から目標内容を取得
            const registerDate = button.getAttribute('data-register-date'); // data-register-date属性から登録日を取得
            const modalHeader = document.querySelector('.modal-container-pastgoal h4');
            
            // モーダルのヘッダーを更新（達成部分を青色にする）
            modalHeader.innerHTML = `${registerDate}の目標は<span class="goal-achievement">達成</span>でよろしいですか？`;
            document.querySelector('.modal-pastgoal-text').textContent = `目標内容：${goal}`;
            modalContainer.classList.add('active');
            modalBg.classList.add('active');
        });
    });

    // 未達成ボタンのクリックイベント
    openButtons2.forEach(button => {
        button.addEventListener('click', function () {
            const goal = button.getAttribute('data-goal'); // ボタンのdata-goal属性から目標内容を取得
            const registerDate = button.getAttribute('data-register-date'); // data-register-date属性から登録日を取得
            const modalHeader2 = document.querySelector('#modal-container-pastgoal-2 h4');
            
            // モーダルのヘッダーを更新（未達成部分を赤色にする）
            modalHeader2.innerHTML = `${registerDate}の目標は<span class="goal-not-achieved">未達成</span>でよろしいですか？`;
            document.querySelector('#modal-container-pastgoal-2 .modal-pastgoal-text').textContent = `目標内容：${goal}`;
            modalContainer2.classList.add('active');
            modalBg2.classList.add('active');
        });
    });

    // 達成モーダルの「いいえ」ボタンまたは背景クリックで閉じる
    closeModal.addEventListener('click', function () {
        modalContainer.classList.remove('active');
        modalBg.classList.remove('active');
    });
    modalBg.addEventListener('click', function () {
        modalContainer.classList.remove('active');
        modalBg.classList.remove('active');
    });

    // 未達成モーダルの「いいえ」ボタンまたは背景クリックで閉じる
    closeModal2.addEventListener('click', function () {
        modalContainer2.classList.remove('active');
        modalBg2.classList.remove('active');
    });
    modalBg2.addEventListener('click', function () {
        modalContainer2.classList.remove('active');
        modalBg2.classList.remove('active');
    });
});





//document.addEventListener("DOMContentLoaded", function () {
//    // 達成ボタンと未達成ボタンを取得
//    const openButtons = document.querySelectorAll('.complete');  // 達成ボタン
//    const openButtons2 = document.querySelectorAll('.complete2');  // 未達成ボタン
//
//    const modalBg = document.getElementById('modal-bg-pastgoal');
//    const modalContainer = document.getElementById('modal-container-pastgoal');
//    const closeModal = document.getElementById('modal-close-pastgoal');
//    const modalBg2 = document.getElementById('modal-bg-pastgoal-2');
//    const modalContainer2 = document.getElementById('modal-container-pastgoal-2');
//    const closeModal2 = document.getElementById('modal-close-pastgoal-2');
//
//    // 要素が存在するか確認
//    if (!modalContainer || !modalBg || !closeModal || !modalContainer2 || !modalBg2 || !closeModal2) {
//        console.error("モーダルウィンドウの要素が見つかりません");
//        return;
//    }
//
//    // 達成ボタンがクリックされた時
//    openButtons.forEach(button => {
//        button.addEventListener('click', function () {
//            const goal = button.getAttribute('data-goal');
//            const registerDate = button.getAttribute('data-register-date');
//            document.querySelector('.modal-container-pastgoal h4').textContent =
//                `${registerDate}の目標は達成でよろしいですか？`;
//            document.querySelector('.modal-pastgoal-text').textContent = `目標内容：${goal}`;
//            modalContainer.classList.add('active');
//            modalBg.classList.add('active');
//        });
//    });
//
//    // 未達成ボタンがクリックされた時
//    openButtons2.forEach(button => {
//        button.addEventListener('click', function () {
//            const goal = button.getAttribute('data-goal');
//            const registerDate = button.getAttribute('data-register-date');
//            document.querySelector('#modal-container-pastgoal-2 h4').textContent =
//                `${registerDate}の目標は未達成でよろしいですか？`;
//            document.querySelector('#modal-container-pastgoal-2 .modal-pastgoal-text').textContent = `目標内容：${goal}`;
//            modalContainer2.classList.add('active');
//            modalBg2.classList.add('active');
//        });
//    });
//
//    // モーダルの「いいえ」ボタンがクリックされた時
//    closeModal.addEventListener('click', function () {
//        modalContainer.classList.remove('active');
//        modalBg.classList.remove('active');
//    });
//
//    closeModal2.addEventListener('click', function () {
//        modalContainer2.classList.remove('active');
//        modalBg2.classList.remove('active');
//    });
//
//    // モーダル背景をクリックして閉じる
//    modalBg.addEventListener('click', function () {
//        modalContainer.classList.remove('active');
//        modalBg.classList.remove('active');
//    });
//
//    modalBg2.addEventListener('click', function () {
//        modalContainer2.classList.remove('active');
//        modalBg2.classList.remove('active');
//    });
//});
//
//
//
//
//
