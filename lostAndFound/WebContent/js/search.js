 $("#search").submit(function(event)){
 	var searchtype = ($("input[name='search_type']")).val();
 	console.log(searchtype);
 	var item = {
		if($("#found_check").is(':checked')) {"found" : "checked";},
		if($("#lost_check").is(':checked')) {"lost" : "checked";},
 		"search_input" : ($("input[name='search_input']")).val(),
 		"dateStart" : ($("input[name='since_date']")).val(),
 		"dateEnd" : ($("input[name='until_date']")).val(),
 		"solved" : ($("input[name='solved']")).val()
 	}
	var itemStr = JSON.stringify(item);
	$.ajax({
	type:'POST',
	url:'excuteSearchJsonAction',
	data: itemStr,
	dataType:"json",
	success: function(result){
		window.location.href="search_result.html";
	}
	error: function(result){
		console.log(result);
	}
 });