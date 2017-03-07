 $(document).ready(function() {

	$("#post_btom").click(function(){
		var item = {
			"property":($("input[name='property']:checked")).val(),
			"title":($("input[name='title']")).val(),
			"date":($("input[name='date']")).val(),
			"description":$("textarea[name='description']").val()
		};
		console.log(item);
		var itemStr = JSON.stringify(item);
		$.ajax({
		type:'POST',
		url:'excutePostJsonAction',
		data: itemStr,
		dataType:"json",
		success: function(data){console.log(data)},
		error: function(jqXHR){console.log(jqXHR)},
		});
	});

 });