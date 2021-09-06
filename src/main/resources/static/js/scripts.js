function mostrarOcultarSenha(){
	
 var senha = document.getElementById("password");

  if(senha.type == "password"){
	
     senha.type = "text";

}
	else{
		
		if(senha.type == "text"){
			
  			  senha.type = "password";
	
	}
}

}