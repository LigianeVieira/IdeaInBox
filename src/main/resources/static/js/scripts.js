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

 //Validações formulario

//cpf erro



function validacaoCpf() {
var cpf = document.getElementById("cpf").value;
 cpf = cpf.replace(/[\s.-]*/igm, '')
   
    if (!cpf || cpf.length != 11 ||cpf == "00000000000" ||cpf == "11111111111" ||
        cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" ||
        cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" ||
        cpf == "88888888888" || cpf == "99999999999" 
    ) 
        return false
    var soma = 0
    var resto
    for (var i = 1; i <= 9; i++) 
        soma = soma + parseInt(cpf.substring(i-1, i)) * (11 - i)
      resto = (soma * 10) % 11
    if ((resto == 10) || (resto == 11))  resto = 0
    if (resto != parseInt(cpf.substring(9, 10)) ) return false
    soma = 0
    for (var i = 1; i <= 10; i++) 
        soma = soma + parseInt(cpf.substring(i-1, i)) * (12 - i)
    resto = (soma * 10) % 11
    if ((resto == 10) || (resto == 11))  resto = 0
    if (resto != parseInt(cpf.substring(10, 11) ) ) return false
    return true



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
}
