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
