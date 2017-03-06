$(function(){
	$('#sign_up').submit(function(event){
		var user = {
			"email":($("input[name='Email']")).val(),
			"password":($("input[name='Password']")).val(),
			"username":($("input[name='Name']")).val(),
			"mobile":($("input[name='Mobile']")).val()
		};
		console.log(user);		
		var userStr = JSON.stringify(user);
		$.ajax({
		type:'POST',
		url:'excuteSignUpJsonAction',
		data: userStr,
		dataType:"json",
		success: function(data){console.log(data)},
		error: function(jqXHR){console.log(jqXHR)},
	});
	});
});