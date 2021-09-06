//footer ano funcionando!

 document.getElementById("ano").innerHTML = new Date().getFullYear();


//Mostrar senha eye
 function mostrarOcultarSenha(){
 var senha = document.getElementById("password");
  if(senha.type=="password"){
    senha.type =="text";
  }else{senha.type="pasword";
}
}

//Validar senha

function validacaoSenha(){}


 function recuperarSenha(){
  var senha= formuser.senha.value;
  var senha_repet= formuser.rep_senha.value;

  if(senha ==""|| length!=8){
    alert("Preencha o campo senha com no mínimo 8 caracteres");
    formuser.senha.focus();
    return false;
  }
  if(senha_repet ==""|| length!=8){
    alert("Preencha o campo senha com no mínimo 8 caracteres");
    formuser.rep_senha.focus();
    return false;
  }
  if(senha!=senha_repet){
    alert("As senhas são diferentes")
    form1.senha.focus();
    return false;
  }
}

 
//e-mail



/*function validacaoEmail(field) {
usuario = field.value.substring(0, field.value.indexOf("@"));
dominio = field.value.substring(field.value.indexOf("@")+ 1, field.value.length);
if ((usuario.length >=1) &&
    (dominio.length >=3) &&
    (usuario.search("@")==-1) &&
    (dominio.search("@")==-1) &&
    (usuario.search(" ")==-1) &&
    (dominio.search(" ")==-1) &&
    (dominio.search(".")!=-1) &&
    (dominio.indexOf(".") >=1)&&
    (dominio.lastIndexOf(".") < dominio.length - 1)) {
document.getElementById("msgemail").innerHTML="E-mail válido";
alert("email valido");
}
else{
document.getElementById("msgemail").innerHTML="<font color='red'>Email inválido </font>";
alert("E-mail invalido");
}
}*/

