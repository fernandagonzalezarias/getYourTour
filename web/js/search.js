$(load)
function load() {
    console.log("la wea se cayó y Fer va a llorar")
}

async function search() {
    let tour = {
        city_code: {name: $("#city").val()}
    };
    let requestBody = {
        method: "POST",
        body: JSON.stringify(tour),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch('/RestApi/tours/searchTours', requestBody);
    let ListTour = await response.json();
    console.log(ListTour);
    ListTour.forEach(tour => {
        showCardsTour(tour);
    }
    );
}

function showCardsTour(elem) {
    let cardDiv = $("#cardsTours");
    let newCard = $("<div class=\"row\" onclick=\"showTour(" + elem.id + ")\" />");
    newCard.html(
            '<div class="col-12 mt-3">' +
            ' <div class="card">' +
            '<div class="card-horizontal">' +
            '<div class="img-square-wrapper">' +
            '<img class="image-container" src="./images/bogota-plaza.jpg" alt="Card image cap" id="imagen">'
            + '</div>'
            + '<div class="card-body">' +
            '<h4 class="card-title" id="titulo">' + elem.name + ' </h4>' +
            '<p class="card-text" id="description">' + elem.description + '</p>' +
            '</div>' +
            '</div>' +
            ' </div>' +
            '</div>'
            );
    cardDiv.append(newCard);

}

const imagesColombia = ["./images/bogota-fe.jpg", 
    "./images/bogotaSlide.jpg", 
    "./images/bogota-slide4.jpg", 
    "./images/bogota-slide3.jpg", 
    "./images/bogota.jpg", 
    "./images/bogota2.jpg"];


async function showTour(id) {
    let response = await fetch('/RestApi/obtenerTour?id=' + id);
    
    let tour = await response.json();
    $("#titleCard").html(tour.name);
    let descriptionCard = $("#descriptionCard");
    let carousel = $('<div id="carouselExampleControls" class="carousel slide" data-ride="carousel" />');
    carousel.html('<div class="carousel-inner">' +
            '<div class="carousel-item active">' +
            '<img class="d-block w-100" style="height: 500px; width: 400px;" src="./images/bogotaSlide.jpg" alt="First slide">' +
            '</div>' +
            '<div class="carousel-item">' +
            '<img class="d-block w-100" style="height: 500px; width: 400px;" src="./images/bogota-fe.jpg" alt="Second slide">' +
            '</div>' +
            '<div class="carousel-item">' +
            '<img class="d-block w-100" style="height: 500px; width: 400px;" src="./images/bogota-slide4.jpg" alt="Third slide">' +
            '</div>' +
            '</div>' +
            '<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">' +
            '<span class="carousel-control-prev-icon" aria-hidden="true"></span>' +
            '<span class="sr-only">Previous</span>' +
            '</a>' +
            '<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">' +
            '<span class="carousel-control-next-icon" aria-hidden="true"></span>' +
            '<span class="sr-only">Next</span>' +
            '</a>')
    let info = $("<div />");
    info.html('<h3>Description</h3>' 
            +'<p>' + tour.description + '</p>'+
            '<h4>Información </h4>'+ 
            '<p> Duración: ' + tour.duration + 'hora(s)</p>' +
            '<p> Precio: $' + tour.price + '</p>' +
            '<p> Actividades</p>' + 
            '<p> Desayuno</p>' +
            '<p> Almuerzo </p>');
    descriptionCard.append(carousel);
    descriptionCard.append(info);
    $("#cardTourSpecific").modal("show");
    console.log(tour);
}

