const loginFromDb = "login";
const passwordFromDb = "password";

function loginValidate() {
    let form = document.getElementById("login-form");
    let login = form.elements.namedItem("login");
    let password = form.elements.namedItem("password");
    let message = document.getElementById("message");

    if (isNull(login.value)) {
        message.innerHTML = "Логин не может быть пустым";
        login.style.border = "1px solid red";
    } else {

        if (isNull(password.value)) {
            message.innerHTML = "Пароль не может быть пустым";
            password.style.border = "1px solid red";
        } else {

            if (password.value.length < 6 || password.value.length > 15) {
                message.innerHTML = "Невозможный пароль";
                password.style.border = "1px solid red";
            } else {

                if (!auth(login.value, password.value)) {
                    message.innerHTML = "Неверный логин или пароль";
                    password.style.border = "1px solid red";
                } else {
                    window.location.replace("/home.html");
                }
            }
        }
    }
}

function registrationValidate() {
    let form = document.getElementById("registration");
    let login = form.elements.namedItem("login");
    let name = form.elements.namedItem("name");
    let email = form.elements.namedItem("email");
    let phone = form.elements.namedItem("phone");
    let password = form.elements.namedItem("password");
    let message = document.getElementById("message");

    let isFormNull = true;
    let isFormValid = false;

    login.style.border = "1px solid #f2f2f2";
    name.style.border = "1px solid #f2f2f2";
    email.style.border = "1px solid #f2f2f2";
    phone.style.border = "1px solid #f2f2f2";

    if (isNull(login.value)) {
        message.innerHTML = "Логин не может быть пустым";
        login.style.border = "1px solid red";
    } else {
        if (isNull(name.value)) {
            message.innerHTML = "Имя не может быть пустым";
            name.style.border = "1px solid red";

        } else {
            if (isNull(email.value)) {
                message.innerHTML = "Почта не может быть пустой";
                email.style.border = "1px solid red";

            } else {
                if (isNull(phone.value)) {
                    message.innerHTML = "Телефон не может быть пустым";
                    phone.style.border = "1px solid red";

                } else {
                    if (isNull(password.value)) {
                        message.innerHTML = "Пароль не может быть пустым";
                        password.style.border = "1px solid red";

                    } else {
                        isFormNull = false;
                    }
                }
            }
        }
    }

    if (!isFormNull) {

        if (!validateEmail(email.value)) {
            message.innerHTML = "Проверьте почту";
            email.style.border = "1px solid red";

        } else {
            if (!validatePhone(phone.value)) {
                message.innerHTML = "Проверьте телефон";
                phone.style.border = "1px solid red";

            } else {

                if (!validatePassword(password.value)) {
                    message.innerHTML = "Проверьте пароль";
                    password.style.border = "1px solid red";

                } else {
                    isFormValid = true;
                }
            }
        }
    }

    if (!isFormNull && isFormValid) {
        window.location.replace("/login.html");
    }
}

function isNull(value) {
    return !(value !== "" && value != null);
}

function auth(login, password) {
    return login === loginFromDb && password === passwordFromDb;
}

function validateEmail(email) {
    const template = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return template.test(String(email).toLowerCase());
}

function validatePhone(phone) {
    const template = /\+\d{12}/;
    return template.test(String(phone).toLowerCase());
}

function validatePassword(password) {
    return true;
}