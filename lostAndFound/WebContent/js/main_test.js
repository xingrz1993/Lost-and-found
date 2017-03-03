$(function(){
	var $cards = $('#cards');
	$.ajax({
		type:'GET',
		url:"excuteAjaxJsonAction",
		contentType: 'application/json',
		success:function(cardsStr){
			var cardsObj = eval('(' + cardsStr + ')');
			//console.log('success',cardsObj);
				$.each(cardsObj,function(i, item){
					$cards.append('<div class="card">	<div class="cardposter"> <img class="cardposter" src="'+item.userAvatar+'" alt="Avatar"> <p>'+item.userName+'<p> <i class="material-icons">message</i> </div>	<div class="container">	<h3><b>'+item.title+'</b></h3> <button class="item_'+item.property+'_btom">'+item.property+'</button><p>posted on '+item.postDate+'</p><br><p>'+item.description+'</p></div></div>')
				})
			}
		
	})
})
