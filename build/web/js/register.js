


function register() {
    let user = {
        id: $('#identification').val(),
        email: $('#email').val(),
        password: $('#pass').val(),
        lastName: $('#lastName').val(),
        name: $('#name').val(),
        birthDate:  $('#birthdate').val()
    };
    $.ajax({
        type: "POST",
        url: "/GetYourTour/register",
        data: JSON.stringify(user),
        contentType: "application/json"
    }).then(() => {
        // logoutRedirect();
    }, (error) => {
    });
}
