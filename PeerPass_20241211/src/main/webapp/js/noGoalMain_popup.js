'use strict';

{
	const open = document.getElementById('modal-open-nogoalmain');
	const container = document.getElementById('modal-container-nogoalmain');
	const modalBg = document.getElementById('modal-bg-nogoalmain');
	const close = document.getElementById('modal-close-nogoalmain');
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


{
	
	const open = document.getElementById('modal-open-nogoalmain');
	const container = document.getElementById('modal-container-nogoalmain');
	const modalBg = document.getElementById('modal-bg-nogoalmain');
	const close = document.getElementById('modal-close-nogoalmain');
	
  

//  const pastEmailInput = document.querySelector('input[name="goalName"]');
  const pastEmailInput = document.querySelector('textarea[name="goalName"]');

  open.addEventListener('click', () => {
    // モーダル内のpタグに直接値をセット
	document.getElementById('modal-goal-text').textContent = pastEmailInput.value;
    

    // モーダル表示
    container.classList.add('active');
    modalBg.classList.add('active');
  });

  close.addEventListener('click', () => {
    container.classList.remove('active');
    modalBg.classList.remove('active');
  });

  modalBg.addEventListener('click', () => {
    container.classList.remove('active');
    modalBg.classList.remove('active');
  });
}

