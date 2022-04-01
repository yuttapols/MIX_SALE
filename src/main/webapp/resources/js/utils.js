$(document).ready(function() {
	$('.format4D').autoNumeric({vMin:'0.0000',vMax:'99999999999.9999'});
	$('.format2D').autoNumeric({vMin:'0.00',vMax:'9999999999999.99'});
	$('.numeric2point').autoNumeric({vMin:'0.00',vMax:'9999999999.99'});
	$('.format2DSib').autoNumeric({vMin:'0.00',vMax:'99.99'});
});

function formatDouble(num, scale) {
	if(scale === undefined) scale = 2;
	if(!$.isNumeric(num)) return num;
	return num.toFixed(scale).toString().replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
}

function changeMoney(changeRQ){
	//var balanceSummary = $("#moneyTran").val();
	
	 var change = $("#change").val();
	 if(change == ""){
		 change = parseFloat(0);
	 }
	 change = parseFloat(change) + parseFloat(changeRQ);
	 $("#change").val(change.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, '$1,'));
}

function formetMon(value) {
	var a = str.replace(/,/g , "");
	return parseFloat(a);
}

function  NumberFormatToMoneyShow(str){
	
}

function  FormatMoneyShowToNumber(str){
	var a = str.replace(/,/g , "");
	return parseFloat(a);
}

function checkTaxIdNumber(event) {
	var chk = String.fromCharCode(event.which);
	
	if(!(/[0-9]/.test(chk))) {
		event.preventDefault();
	}
}