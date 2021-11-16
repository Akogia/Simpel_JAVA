var loginData = document.getElementById('login');
var regData = document.getElementById('register');
var btnValue = document.getElementById('btn');

function register(){
    loginData.style.left = '-400px';
    regData.style.left = '50px';
    btnValue.style.left = '110px';
}
function login(){
    loginData.style.left = '50px';
    regData.style.left = '450px';
    btnValue.style.left = '0px';
}
var modal = document.getElementById('login-form');
window.onclick = function(event){
    if(event.target == modal){
        modal.style.display = "none";
    }
}