
function loaded(){
    getLoggedUser();
    $("#closeSession").on("click", getOut);
}
function getLoggedUser(){
    var data = sessionStorage.getItem('email');
    $("#userEmail").html(data);
    //document.getElementsByTagName("BODY")[0].style.display = "block";
}
function getOut(){
    sessionStorage.clear();
    location.href="../index.html";
}
$(loaded);