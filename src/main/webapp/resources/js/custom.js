

function xxx(){
	console.log("Goooo...");
}

function selectAll(){
	console.log("xxxx")
	$.ajax({
        type: "GET",
        url: "http://localhost:9090/all",
//        data: JSON.stringify(bean),
//        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	console.log(res)
        	for(var i=0; i<res.length; i++) {
//        		$('#table_user').DataTable( {
//        	        "pagingType": "full_numbers"
//        	    } );
        		$('#name').val(res[i].name);
        	}
        	}
        })
}