$(document).ready(function () {
	histroryTB = $('#histroryPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
//		"order": [[ 2, 'asc' ]],
		"scrollX": true,
		"columnDefs": [ {
			"searchable": false
//			"orderable": false
//			"targets": [0,2]
		} ]
		});
	
	search();
	
	$('#clearCriteria').click(function(){
		$('#billAccount').val('');
		search();
	});
});

function search(){
	histroryTB.clear().draw();
	var data = '';
	var dataSend = {"accountNo": $('#billAccount').val()};
	$.ajax({
        type: "POST",
        url: ctx +"/histroryPayment/find",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	for (var i = 0; i < res.length; i++) {
                    createRow(res[i], i);
                }
        }
	})
};

function createRow(data, seq) {

	no = seq + 1
	paidDate = data.createDateStr;
	createDate = data.createDateStr;
	receiptNoManual = data.receiptNoManual;
	branchCode = data.brancharea;
	createBy = data.createBy;
	invoiceNo = data.invoiceNo;
	period = data.period;
	amount = formatDouble(data.amount,2);
	source = data.paymentMethod;
	paidAmount = formatDouble(data.paidAmount, 2);
	vatAmount = formatDouble(data.vatAmount,2);
	if(data.recordStatus == 'A'){
		recordStatus = 'ปกติ';
		if(data.remark != ""){
			remark ='<a name="remark" id="remark" onclick="dialogRemake('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
		}else {
			remark = '-';
		}
	}else{
		recordStatus = 'ยกเลิก';
		if(data.remark != ""){
			remark ='<a name="remark" id="remark" onclick="dialogRemake('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
		}else {
			remark = '-';
		}
	}
	
	accountNo = data.accountNo;
	custName = data.customerName;
	
    var t = $('#histroryPaymentTB').DataTable();
    var rowNode = t.row.add([no ,paidDate ,createDate ,receiptNoManual, accountNo, custName, branchCode, createBy ,invoiceNo ,period , paidAmount, source, amount, vatAmount, recordStatus, remark, accountNo
    ]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('left');
    $(rowNode).find('td').eq(1).addClass('left');
    $(rowNode).find('td').eq(2).addClass('left');
    $(rowNode).find('td').eq(3).addClass('left');
    $(rowNode).find('td').eq(4).addClass('center');
    $(rowNode).find('td').eq(5).addClass('center');
    $(rowNode).find('td').eq(6).addClass('center');
    $(rowNode).find('td').eq(7).addClass('left');
    $(rowNode).find('td').eq(8).addClass('center');
    $(rowNode).find('td').eq(9).addClass('center');
    $(rowNode).find('td').eq(10).addClass('right');
    $(rowNode).find('td').eq(11).addClass('center');
    $(rowNode).find('td').eq(12).addClass('right');
    $(rowNode).find('td').eq(13).addClass('right');
    $(rowNode).find('td').eq(14).addClass('left');
    $(rowNode).find('td').eq(15).addClass('center');
};
function dialogRemake(value){
	$("#remake_dialog").modal('show');
	var dataSend = {"manualId": value};
	$.ajax({
        type: "POST",
        url: ctx +"/histroryPayment/findInvoiceByManualId",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	$("#remake").text(res.remark);
        }
	})
};
function closeDialog(){
	$("#remake_dialog").modal('hide');
}

