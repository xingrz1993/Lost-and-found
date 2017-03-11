$(function(){
	var $cards = $('#result_cards');
	$.ajax({
		type:'GET',
		url:'./api/result_cards',
		contentType: 'application/json',
		success:function(cardsStr){
			var cardsObj = eval('(' + cardsStr + ')');
			console.log('success',cardsObj);
				$.each(cardsObj,function(i, item){
					$cards.append('<div class="card">	<div class="cardposter"> <img class="cardposter" src="'+item.userAvatar+'" alt="Avatar"> <p>'+item.userName+'<p> <i class="material-icons">message</i> </div>	<div class="card_container">	<h3 class="card_container_title"><b>'+item.title+'</b></h3> <button class="item_'+item.stat+'_bton">'+item.stat+'</button><button class="item_'+item.property+'_bton">'+item.property+'</button><p>posted on '+item.date+'</p><br><p class="card_container_des">'+item.description+'</p></div></div>')
				})
			}
		
	})
})
