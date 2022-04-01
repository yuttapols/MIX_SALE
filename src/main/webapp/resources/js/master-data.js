	$(document).ready(function() {
		
//		$('.groupType').select2();
		
		var masterList = $('#masterList').DataTable({
			"filter" : false,
			"info" : false,
			"paging": true,
			"columnDefs": [{
				"searchable": false,
				"orderable": false,
				"targets": 0
			}]
		});
		
	//	$.ajax({
	//	    type: 'GET',
	//	    url: "/masterData/selectAll"
	//	}).then(function (data) {
	//		for(var i=0; i<data.length; i++) {
	//			var element = data[i];
	//			$('#groupType').append('<option value="' + element.value+ '">' + element.name + '</option>');
	//		}
	//	});
		
	//	$('#masterList').DataTable( {
	//        "ajax": "/findAllMasterData",
	//        "columns": [
	//            { "data": "id" },
	//            { "data": "text" },
	//            { "data": "group" }
	//        ]
	//    } );
		
		$.ajax({
	        type: "GET",
	        url: ctx +"/findAllMasterData",
	//        data: JSON.stringify(dataSend),
	//        dataType: "json",
	        async: false,
	        contentType: "application/json; charset=utf-8",
	        success: function (res) {
	        	for (var i = 0; i < res.length; i++) {
	                    createRow(res[i], i);
	                }
	        }
		})
		
	});

	function searchClick() {
		alert("123");
	}
	
	function addClick() {
		alert("xxx");
	}

	function submitMaterdata() {
		
		var dataSend = {
				"value" : $("#valueKey").val(),
				"text" : $("#text").val(),
				"group" : $("#groupType").val()
			}
	
			$.ajax({
				type : "POST",
				url : ctx +"/insertMasterdata",
				data : JSON.stringify(dataSend),
				dataType : "json",
				async : false,
				contentType : "application/json; charset=utf-8",
				success : function(res) {
					window.location.href = "masterData";
				}
			})
		
		
		
	}

	function submitMaterdataGroup() {
		
		var dataSend = {
				"value" : $("#valueKey").val()
			}
	
			$.ajax({
				type : "POST",
				url : ctx +"/insertMasterdataGroup",
				data : JSON.stringify(dataSend),
				dataType : "json",
				async : false,
				contentType : "application/json; charset=utf-8",
				success : function(res) {
					window.location.href = "masterData";
				}
			})
		
	}

	function createRow(data, seq) {
	    colSeq = (seq + 1);
	    colCur2 = data.text;
	    colCur3 = data.value;
	
	    var t = $('#masterList').DataTable();
	    var rowNode = t.row.add([ colSeq, colCur2, colCur3 ]).draw(true).node();
	    $(rowNode).find('td').eq(0).addClass('center');
	    $(rowNode).find('td').eq(1).addClass('center');
	    $(rowNode).find('td').eq(2).addClass('center');
	}