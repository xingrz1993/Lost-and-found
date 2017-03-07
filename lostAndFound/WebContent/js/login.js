 $(function(){
	 $("#login").submit(function(event){
		var user = {
			"email":($("input[name='Email']")).val(),
			"password":($("input[name='Password']")).val()
		};
		
		var userStr = JSON.stringify(user);
		console.log(userStr);
		$.ajax({
		type:'POST',
		url:'excuteLogInJsonAction',
		data: userStr,
		dataType:"json",
		success: function(result){
			window.location.href="main_login.html";
		}
		error: function(result){
			window.location.href="login_error.html";
		}
		});
	 });
 });