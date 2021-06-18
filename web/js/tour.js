/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function addTour(){
    /*
     *  private int id;
    private String name;
    private String description;
    private float duration;
    private Date initicialDate;
    private float price;
    private int id_category;
    private int maxCant;
    private String guidance;
    private City city_code;

     * 
     */
    let tour = {
        name:  $("#tourName").val(),
        description: $("#description").val(),
        duration: $("#duration").val(),
        initicialDate: $("#initialDate").val(),
        price: $("#price").val(),
        id_category: $("#cat").val(),
        maxCant: $("#cant").val(),
        guindance: $("#guidance").val(),
        city_code: {name: $("#cities").val()}
    };
    let requestBody = {
        method: "POST",
        body: JSON.stringify(tour),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch('/GetYourTour/addTour', requestBody);
    let ListTour = await response.json();
    console.log(ListTour);
    ListTour.forEach(tour => {
        showCardsTour(tour);
    }
    );
}