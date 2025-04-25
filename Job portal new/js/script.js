document.getElementById('loginForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('https://your-login-api.com/api/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const data = await response.json();
            alert('Login Successful!');
            console.log(data);
        } else {
            alert('Login Failed! Please check credentials.');
        }
    } catch (error) {
        console.error('Error:', error);
    }
});
// sing-up page js

document.getElementById('signInForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (email === '' || password === '') {
        alert('Please fill in all fields');
    } else {
        alert('Sign In Successful!');
        // Implement your login logic here (e.g., API call)
    }
});
