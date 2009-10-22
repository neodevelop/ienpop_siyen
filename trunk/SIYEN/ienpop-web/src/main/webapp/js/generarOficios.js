function mostrarOficio(){
	var dirigido = document.generarOficio.dirigido.value;
	var desde = document.generarOficio.desde.value;
	var hasta = document.generarOficio.hasta.value;
	var idPuerto = document.generarOficio.idPuerto.value;
	var no = document.generarOficio.no.value;
	var formato = document.generarOficio.formato.value;
	var idUsuario = document.generarOficio.idUsuario.value;
	//alert(formato);
	if(desde==""){
		alert("Falta indicar la fecha inicial...");
	}else if(hasta==""){
		alert("Falta indicar la fecha final...");
	}else{
		window.open("oficio.ienpop?dirigido="+dirigido+"&desde="+desde+"&hasta="+hasta+"&idPuerto="+idPuerto+"&no="+no+"&format="+formato+"&idUsuario="+idUsuario, "_blank", "width=800,height=600,scrollbars=yes");
	} 
	//alert("Dirigido a: "+dirigido);
}