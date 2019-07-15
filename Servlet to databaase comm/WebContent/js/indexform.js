/*
* Projrct details
*/

function validate(frm) {
	frm.vflag.value="yes";
	
	
function projectNameValidation(projnameInput){

	var pname=document.getElementById("projname")
	pname.setCustomValidty("");
	pname.style.borderColor=defaultInput;
}

function projectIdValidation(projectIdInput){

	var pid=document.getElementById("projtid")
	pid.setCustomValidty("");
	pid.style.borderColor=defaultInput;
}
function projectVerticalValidation(projectVerticalInput){

	var pvertical=document.getElementById("vertical")
	pvertical.setCustomValidty("");
	pvertical.style.borderColor=defaultInput;
}
function projectTicketValidation(projectTicketInput){

	var pticket=document.getElementById("pticket")
	pticket.setCustomValidty("");
	pticket.style.borderColor=defaultInput;
}
/*
* Floor details
*/
function projectTicketValidation(projectBuildingInput){

	var pbuilding=document.getElementById("building")
	pbuilding.setCustomValidty("");
	pbuilding.style.borderColor=defaultInput;
}
function projectTicketValidation(projectFloorInput){

	var pfloor=document.getElementById("floor")
	pbuilding.setCustomValidty("");
	pbuilding.style.borderColor=defaultInput;
}
function projectTicketValidation(projectWingInput){

	var pwing=document.getElementById("wing")
	pbuilding.setCustomValidty("");
	pbuilding.style.borderColor=defaultInput;
}
function projectTicketValidation(projectDeskInput){

	var pdesk=document.getElementById("desk")
	pbuilding.setCustomValidty("");
	pbuilding.style.borderColor=defaultInput;
}

/*
* Employee details
*/
function projectEmployeeValidation(projectEmployeeInput){

	var pename=document.getElementById("empname")
	pename.setCustomValidty("");
	pename.style.borderColor=defaultInput;
}

function projectIdValidation(projectEmployeeIdInput){

	var peid=document.getElementById("empid")
	peid.setCustomValidty("");
	peid.style.borderColor=defaultInput;
}

/*
* Asset details 
*/
function projectAssetValidation(projectAssetInput){

	var passet=document.getElementById("assetid")
	passet.setCustomValidty("");
	passet.style.borderColor=defaultInput;
}
function projectSerialValidation(projectSerialInput){

	var pserial=document.getElementById("serialno")
	pserial.setCustomValidty("");
	pserial.style.borderColor=defaultInput;
}
function projectAllocationValidation(projectAllocationInput){

	var pallocation=document.getElementById("allocdate")
	pallocation.setCustomValidty("");
	pallocation.style.borderColor=defaultInput;
}
function projectHostnameValidation(projectHostnameInput){

	var phostname=document.getElementById("hostname")
	phostname.setCustomValidty("");
	phostname.style.borderColor=defaultInput;
}

return true;
}