var nameerror=document.getElementById("name-error").value
var passworderror=document.getElementById("password-error").value
var addresserror=document.getElementById("address-error").value
var eduerror=document.getElementById("edu-error").value

function validation(){
 var name=document.reg.name1.value
 var password=document.reg.pw.value
 var address=document.reg.address1.value
 var education=document.reg.ed1.value
 if(name==" "|| name.length<=6){
     nameerror.innerHTML='Name is required more then 6 charecter'
 }
 else if(!password.match(/?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/)){
     passworderror.innerHTML="Enter the valid password";
     return false;
 }
 else if(address==" "){
    addresserror.innerHTML="enter the address";
    return false;
 }
 else if(education=" "){
    education.innerHTML="enter the education";
    return false;
 }
else{
    return check()
}

}
