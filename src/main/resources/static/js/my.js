function register(){
	alert("register sucessful")
}

function login(){
	var pass=document.getElementById("password").value
	console.log(pass)
	var pas="${use.password}"
	if(pass==pas)
	{
		alert("Login Successful")
	}
	else{
		alert("you are entering wrong email or password")
	}
}

