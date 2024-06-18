// Login Create User Show/Hide Password & Confirm Password

    const loginPasswordInput = document.getElementById('loginPassword');
    const showLoginPasswordBtn = document.getElementById('showLoginPassword');

    showLoginPasswordBtn.addEventListener('click', () => {
        if (loginPasswordInput.type === 'password') {
            loginPasswordInput.type = 'text';
            showLoginPasswordBtn.textContent = 'Hide';
        } else {
            loginPasswordInput.type = 'password';
            showLoginPasswordBtn.textContent = 'Show';
        }
    });

/*
// Show/Hide Password Script

    const passwordInput = document.getElementById('password');
    const showPasswordBtn = document.getElementById('showPassword');

    showPasswordBtn.addEventListener('click', () => {
        if (passwordInput.type === 'password') {
            passwordInput.type = 'text';
            showPasswordBtn.textContent = 'Hide';
        } else {
            passwordInput.type = 'password';
            showPasswordBtn.textContent = 'Show';
        }
    });
*/
