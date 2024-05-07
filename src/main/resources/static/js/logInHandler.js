/*This part of the script creates variables for the different elements in the HTML file

 */

let registerButton = document.getElementById("registerButton");
let loginButton = document.getElementById("loginButton");
let fname = document.getElementById("nameField1")
let lname = document.getElementById("nameField2")
let imagebox = document.getElementById("file")
let title = document.getElementById("title");
let q1 = document.getElementById("question1");
let q2 = document.getElementById("question2");
let q3 = document.getElementById("question3");
let q4 = document.getElementById("question4");
let q5 = document.getElementById("question5");
let continueButton = document.getElementById("continueButton");
let submitButton = document.getElementById("submit");
let returnButton = document.getElementById("returnButton");
let passwordInstructions = document.getElementById("passwordInstructions");


let nameField1 = document.querySelector("#nameField1 input");
let nameField2 = document.querySelector("#nameField2 input");
let email = document.querySelector(".input-group input[type='text'][placeholder='Email']");
let password = document.querySelector(".input-group input[type='password']");
let contentContainer = document.querySelector('.content-container-register');
let buttonfield = document.querySelector('.button-field');
let radioButtons = document.querySelectorAll("input[type='radio']");
let file = document.querySelector("#file");

let totalScore = 0;
fname.style.maxHeight = "0";
lname.style.maxHeight = "0";
imagebox.style.maxHeight = "0";
passwordInstructions.style.display = "none";
title.innerHTML = "Logga in";
registerButton.classList.add("disable");
loginButton.classList.remove("disable");
isLogInButtonPressed = true;


/*
This part adds event listeners to the radio buttons in the evaluation form. When a radio button is checked
the event listeners fire and the next question is displayed. When the last question is answered
the submit button is displayed.
 */

document.querySelectorAll("#question1 input[type='radio']").forEach(function (radio) {
    radio.addEventListener('change', function () {
        q2.style.padding = '12px';
        q2.style.maxHeight = '120px';

    });
});

document.querySelectorAll("#question2 input[type='radio']").forEach(function (radio) {
    radio.addEventListener('change', function () {
        q3.style.padding = '12px';
        q3.style.maxHeight = '120px';

    });
});

document.querySelectorAll("#question3 input[type='radio']").forEach(function (radio) {
    radio.addEventListener('change', function () {
        q4.style.padding = '12px';
        q4.style.maxHeight = '120px';
    });
});

document.querySelectorAll("#question4 input[type='radio']").forEach(function (radio) {
    radio.addEventListener('change', function () {
        q5.style.padding = '12px';
        q5.style.maxHeight = '120px';
    });
});

document.querySelectorAll("#question5 input[type='radio']").forEach(function (radio) {
    radio.addEventListener('change', function () {
        submitButton.style.display = 'block';
        submitButton.style.maxHeight = '40px';
    });
});

//This part of the script sets the state of the evaluation form to be hidden initially.

submitButton.style.display = 'none';
returnButton.style.display = 'none';
imagebox.style.display = 'none';
q1.style.maxHeight = '0';
q2.style.maxHeight = '0';
q3.style.maxHeight = '0';
q4.style.maxHeight = '0';
q5.style.maxHeight = '0';

/*
These two functions control the visability of the login and register buttons. When the login button is pressed
the register form is hidden and the login form is displayed. When the register button is pressed the login form
is hidden and the register form is displayed.
It also changes the state of the isLogInButtonPressed variable to true or false depending on which button is pressed.
for later use in the continueButton.onclick function.
 */

loginButton.onclick = function () {
    email.style.borderColor = "#ccc"
    fname.style.maxHeight = "0";
    lname.style.maxHeight = "0";
    imagebox.style.display = "none";
    title.innerHTML = "Logga in";
    registerButton.classList.add("disable");
    loginButton.classList.remove("disable");
    isLogInButtonPressed = true;
}

registerButton.onclick = function () {
    fname.style.maxHeight = "60px";
    lname.style.maxHeight = "60px";
    imagebox.style.display = "block";
    imagebox.style.maxHeight = "60px";
    title.innerHTML = "Registrera dig";
    registerButton.classList.remove("disable");
    loginButton.classList.add("disable");
    isLogInButtonPressed = false;
}

/*
This function creates a snackbar that displays a message for 3 seconds. The color and border of the snackbar
is set depending on the color and border parameters that are passed to the function.
This method shows the notification message with the response from the backend as a notification box.

The message is set to the
response from the backend so if it's a success message or an error message it will be displayed in the snackbar.
 */

function showSnackbar(message, color, border) {
    let snackbar = document.getElementById("snackbar");
    snackbar.innerHTML = message;
    snackbar.className = "show";
    snackbar.style.backgroundColor = color;
    snackbar.style.border = border;
    setTimeout(function () {
        snackbar.className = snackbar.className.replace("show", "");
    }, 3000);
}

/*
The returnButton onclick function handles the logic for what happens when the return button is pressed.
it hides all the questions and sets the buttonfield with the login and register buttons to be displayed.
it also resets the width of the content container and brings back the continue button :)
 */

returnButton.onclick = function () {
    q1.style.maxHeight = '0';
    q1.style.padding = '0';
    q2.style.maxHeight = '0';
    q2.style.padding = '0';
    q3.style.maxHeight = '0';
    q3.style.padding = '0';
    q4.style.maxHeight = '0';
    q4.style.padding = '0';
    q5.style.maxHeight = '0';
    q5.style.padding = '0';

    buttonfield.style.display = 'flex';
    contentContainer.style.width = '30%';
    continueButton.style.display = 'block';
    returnButton.style.display = 'none';
    submitButton.style.display = 'none';

    radioButtons.forEach(function (radio) {
        radio.checked = false;
    });

}

/*
The continue onClick function handles the logic for what happens when the continue button is pressed.
If the isLogInButtonPressed variable is true it sends a post request to the backend with the email and password
that the user has entered. If the response is not ok it will display a snackbar with the error message from the backend.
If the isLogInButtonPressed is false it hides the buttonfield with Login and register button and expands the content container
so the questions fit.
 */

continueButton.onclick = function () {
    if (isLogInButtonPressed) {
        console.log("logga in skickas från front-end till back-end")
        email.style.borderColor = "#ccc"
        password.style.borderColor = "#ccc"
        /*
        Fetch sends the request to the spring backend to the post mapping /login. it sends the data as
        JSON strings to the backend. If the response is not ok it will display a snackbar with the error message
        from the backend. If the response is ok it will display a snackbar with the message "Inloggning lyckades"
         */
        fetch('/verifyUser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email.value,
                password: password.value
            })
        })
            .then(response => {
                if (response.status === 404) {
                    email.style.borderColor = "#ff4444"
                    response.json().then(data => {
                        showSnackbar(data.message, "#ff4444", "#b20000")
                    })
                    throw new Error("Fel användarnamn eller lösenord")
                } else if (response.status === 401) {
                    password.style.borderColor = "#ff4444"
                    response.json().then(data => {
                        showSnackbar(data.message, "#ff4444", "#b20000")
                    })
                    throw new Error(response.message)
                }
                showSnackbar("Inloggning lyckades", "#44ff44", '#00b300')
                setTimeout(function () {
                    window.location.href = "/home";
                }, 2000);
                return response.json()
            })

    } else {

        /*
        If the user did not press the login button the register form is displayed and the buttonfield is hidden.
        it sets the styling for the questions and widens the content container and shows the first question.
         */

        buttonfield.style.display = 'none';
        contentContainer.style.width = '65%';
        continueButton.style.display = 'none';
        returnButton.style.display = 'block';

        q1.style.padding = '12px';
        q1.style.maxHeight = '120px';

    }
}

/*
The submit button onclick fires when the submit button is clicked. This button only appears when the evaluation form
is fully filled in. It starts off by calculation the total score of the evaluation form.
It then sends the data to the backend as JSON strings and if the response is not ok it will display a snackbar with the error message
from the backend. If the response is ok it will display a snackbar with the message "Registreringen lyckades"
 */

submitButton.onclick = function () {
    email.style.borderColor = "#ccc"
    password.style.borderColor = "#ccc"
    imagebox.style.borderColor = "#ccc"
    nameField1.style.borderColor = "#ccc"
    nameField2.style.borderColor = "#ccc"
    passwordInstructions.style.display = 'none';

    this.setAttribute('disabled', 'disabled');
    this.innerHTML = '<i class="fa fa-spinner fa-spin"></i> Laddar...';

    totalScore = 0;

    radioButtons.forEach(function (radio) {
        if (radio.checked) {
            totalScore += parseInt(radio.value);
        }
    });

    if (file.files.length === 0) {
        file.style.borderColor = "#ff4444"
        showSnackbar("Du måste ladda upp en profilbild", "#ff4444", "#b20000")
    } else {
        var formData = new FormData();
        formData.append("fname", nameField1.value);
        formData.append("lname", nameField2.value);
        formData.append("email", email.value);
        formData.append("password", password.value);
        formData.append("evaluationScore", totalScore);

        formData.append("image", file.files[0]);
    }

    fetch('/addUser', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            this.removeAttribute('disabled');
            this.innerHTML = 'Submit';
            if (!response.ok) {
                switch (response.status) {
                    case 416:
                        file.style.borderColor = "#ff4444"
                        response.json().then(data => {
                            showSnackbar(data.message, "#ff4444", "#b20000")
                        })
                        break;

                    case 406:
                        password.style.borderColor = "#ff4444"
                        passwordInstructions.style.display = 'block';
                        response.json().then(data => {
                            showSnackbar(data.message, "#ff4444", "#b20000")
                        })
                        break;

                    case 409:
                        email.style.borderColor = "#ff4444"
                        response.json().then(data => {
                            showSnackbar(data.message, "#ff4444", "#b20000")
                        })
                        break;

                    case 410:
                        nameField1.style.borderColor = "#ff4444"
                        response.json().then(data => {
                            showSnackbar(data.message, "#ff4444", "#b20000")
                        })
                        break;

                    case 411:
                        nameField2.style.borderColor = "#ff4444"
                        response.json().then(data => {
                            showSnackbar(data.message, "#ff4444", "#b20000")
                        })

                        break;
                }
            } else {
                showSnackbar("Registreringen lyckades", "#44ff44", '#00b300')

                fetch('/verifyUser', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        email: email.value,
                        password: password.value
                    })
                }).then(response => {
                    if (response.ok) {
                        setTimeout(function () {
                            window.location.href = "/home";
                        }, 2000);
                    }
                    return response.json()
                })
            }
        })
}