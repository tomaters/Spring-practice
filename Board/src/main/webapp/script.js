function checkLoginValues(id){
	if(id == "") {
		alert("Enter username");
		document.regForm.id.focus();
	}
	if(password == "") {
		alert("Enter password");
		document.regForm.id.focus();
	}
}
