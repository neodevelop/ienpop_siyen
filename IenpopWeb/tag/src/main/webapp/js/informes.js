function showInformePeriodico(tipo){
	var desde = document.informeMensual.fechaInicio.value;
	var hasta = document.informeMensual.fechaFin.value;
	//alert(desde+" - "+hasta);
	//alert(formato);
	if(desde==""){
		alert("Falta indicar la fecha inicial...");
	}else if(hasta==""){
		alert("Falta indicar la fecha final...");
	}else{
		window.open("informePeriodico.ienpop?desde="+desde+"&hasta="+hasta+"&tipo="+tipo, "_blank", "width=800,height=600,scrollbars=yes");
	} 
}

function showInformeTipoLibreta(tipo){
	var desde = document.informeTipoLibreta.fechaInicio2.value;
	var hasta = document.informeTipoLibreta.fechaFin2.value;
	var idPuerto = document.informeTipoLibreta.idPuerto.value;
	var libreta = "";
	for(var i=0; i<document.informeTipoLibreta.libreta.length;i++){
		if(document.informeTipoLibreta.libreta[i].checked)
			libreta += document.informeTipoLibreta.libreta[i].value + ",";
	}
	//alert(desde+" - "+hasta);
	//alert(formato);
	if(desde==""){
		alert("Falta indicar la fecha inicial...");
	}else if(hasta==""){
		alert("Falta indicar la fecha final...");
	}else if(libreta.length==0){
		alert("Selecciona una libreta por lo menos...");
	}else{
		libreta = libreta.substr(0,libreta.length-1);
		//alert(libreta);
		window.open("informePeriodico.ienpop?desde="+desde+"&hasta="+hasta+"&tipo="+tipo+"&idPuerto="+idPuerto+"libreta="+libreta, "_blank", "width=800,height=600,scrollbars=yes");
	} 
}

function printPage() { 
  if (confirm("¿Imprimir página?")) {
    window.print();
  }
} 