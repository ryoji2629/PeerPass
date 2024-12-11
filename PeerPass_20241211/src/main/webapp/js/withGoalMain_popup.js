'use strict';

{
    // 達成モーダル関連の要素
    const completeButton = document.getElementById('complete');
    const modalBgWithGoal = document.getElementById('modal-bg-withgoal');
    const modalContainerWithGoal = document.getElementById('modal-container-withgoal');
    const closeModalWithGoal = document.getElementById('modal-close-withgoal');

    // 未達成モーダル関連の要素
    const incompleteButton = document.getElementById('complete2');
    const modalBgWithGoal2 = document.getElementById('modal-bg-withgoal-2');
    const modalContainerWithGoal2 = document.getElementById('modal-container-withgoal-2');
    const closeModalWithGoal2 = document.getElementById('modal-close-withgoal-2');

    // 達成ボタンのクリックイベント
    completeButton.addEventListener('click', () => {
        modalBgWithGoal.classList.add('active');
        modalContainerWithGoal.classList.add('active');
    });

    // 未達成ボタンのクリックイベント
    incompleteButton.addEventListener('click', () => {
        modalBgWithGoal2.classList.add('active');
        modalContainerWithGoal2.classList.add('active');
    });

    // 達成モーダルの閉じる処理
    closeModalWithGoal.addEventListener('click', () => {
        modalBgWithGoal.classList.remove('active');
        modalContainerWithGoal.classList.remove('active');
    });

    modalBgWithGoal.addEventListener('click', () => {
        modalBgWithGoal.classList.remove('active');
        modalContainerWithGoal.classList.remove('active');
    });

    // 未達成モーダルの閉じる処理
    closeModalWithGoal2.addEventListener('click', () => {
        modalBgWithGoal2.classList.remove('active');
        modalContainerWithGoal2.classList.remove('active');
    });

    modalBgWithGoal2.addEventListener('click', () => {
        modalBgWithGoal2.classList.remove('active');
        modalContainerWithGoal2.classList.remove('active');
    });
}
