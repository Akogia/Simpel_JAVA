/**
 * Create connection to REST API
 */


const request = new XMLHttpRequest();
const url = 'http://localhost:3000/login';
request.open("GET", url);

// XMLHttpRequest is asynchronous so the methods does not block the application until a repsonse is received
//request.send();

//request.onload = (e) => {
//    alert(request.response);
//}

function submitReg_btn() {
    var x = document.getElementById("firstName");
    console.log(x);
}

function submitLog_btn() {
    var y = document.getElementById("email");
    console.log(y);
}