'use strict';

{
	const open = document.getElementById('modal-open-useredit');
	const container = document.getElementById('modal-container-useredit');
	const modalBg = document.getElementById('modal-bg-useredit');
	const close = document.getElementById('modal-close-useredit');
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
  const open = document.getElementById('modal-open-useredit');
  const container = document.getElementById('modal-container-useredit');
  const modalBg = document.getElementById('modal-bg-useredit');
  const close = document.getElementById('modal-close-useredit');

  const pastEmailInput = document.querySelector('input[name="pastEmail"]');
  const pastPassInput = document.querySelector('input[name="pastPass"]');
  const newEmailInput = document.querySelector('input[name="newEmail"]');
  const newPassInput = document.querySelector('input[name="newPass"]');

  open.addEventListener('click', () => {
    // モーダル内のpタグに直接値をセット
    document.getElementById('modal-email1').textContent = pastEmailInput.value;
    document.getElementById('modal-pass1').textContent = pastPassInput.value;
    document.getElementById('modal-email2').textContent = newEmailInput.value;
    document.getElementById('modal-pass2').textContent = newPassInput.value;

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

