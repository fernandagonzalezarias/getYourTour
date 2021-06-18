// EIF411 - Diseño y programación de plataformas móviles
// I Ciclo 2021
//
// Students:
//    - 117660980     María Fernanda González Arias
//    - 116980485     Scarleth Villarreal Jiménez

function loginAdmin() {
    location.href = "./pages/admin.html";
}

function loginClient() {
    location.href = "./pages/client.html";
}

function login() {
    let user = {
        email: $('#email1').val(),
        password: $('#pass1').val()
    };
    $.ajax({
        type: "POST",
        url: "/GetYourTour/users/",
        data: JSON.stringify(user),
        contentType: "application/json"
    }).then((e) => {
        if (e.role === "user") {
            console.log(e);
            userStorage(e);
            loginClient();
        } else {
            console.log(e);
            userStorage(e);
            loginAdmin();
        }
    }, (error) => {
    });
}

function userStorage(user) {
    sessionStorage.setItem('email', user.email);
    //location.href = "./pages/admin.html";
}



function logout() {

    $.ajax({
        type: "DELETE",
        url: "/GetYourTour/index.html",
        contentType: "application/json"
    }).then(() => {
        logoutRedirect();
    }, (error) => {
    });
}

//function logoutRedirect() {
//    location.href = "/WebSideGetYourTour/web/index.html"
//}