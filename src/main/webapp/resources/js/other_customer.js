$(document).ready(function () {
	otherCustomerTB = $('#otherCustomerTB').DataTable({
		"filter" : false,
		"info" : false,
//		"order": [[ 2, 'asc' ]],
		"columnDefs": [ {
			"searchable": false
//			"orderable": false
//			"targets": [0,2]
		} ]
	});
	
	search();
	
	$('#clearCriteria').click(function(){
		$('#nameCust').val('');
		$('#taxId').val('');
		search();
	});
});

function search() {
	otherCustomerTB.clear().draw();
	var data = '';
	var dataSend = {"name": $('#nameCust').val(), "taxId": $('#taxId').val()};
	$.ajax({
        type: "POST",
        url: ctx +"/other/find",
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
}

function createRow(data, seq) {

	no = seq + 1
	name = data.name;
	taxId = data.taxId;
	address = data.address;
	action = '';
	
    var t = $('#otherCustomerTB').DataTable();
    var rowNode = t.row.add([no , name , taxId , address, action]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center');
    $(rowNode).find('td').eq(1).addClass('center');
    $(rowNode).find('td').eq(2).addClass('center');
    $(rowNode).find('td').eq(3).addClass('center');
    $(rowNode).find('td').eq(4).addClass('center');
};