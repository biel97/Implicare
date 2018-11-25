function bt1() { 
    document.getElementById("bt1").style.background = "#f0ad4e";
    document.getElementById("bt2").style.background = "#ffffff";
    document.getElementById("bt1").style.color = "#ffffff";
    document.getElementById("bt2").style.color = "#f0ad4e";
    $("#conteudo-cadastro").load("formCadastroEmpresa.jspf");
    $("#bt1").attr("value", "1");
    $("#bt2").attr("value", "0");
}

function bt2() {
    document.getElementById("bt2").style.background = "#f0ad4e";
    document.getElementById("bt1").style.background = "#ffffff";
    document.getElementById("bt2").style.color = "#ffffff";
    document.getElementById("bt1").style.color = "#f0ad4e";
    $("#conteudo-cadastro").load("formCadastroCandidato.jspf");
    $("#bt1").attr("value", "0");
    $("#bt2").attr("value", "1");
}

function bt1Fun(){
    var valor = $("#bt1").attr("value");
    return valor;
}

function bt2Fun(){
    var valor = $("#bt2").attr("value");
    return valor;
}

$(document).on('click', '.panel-heading span.clickable', function(e){
    var $this = $(this);
	if(!$this.hasClass('panel-collapsed')) {
		$this.parents('.panel').find('.panel-body').slideUp();
		$this.addClass('panel-collapsed');
		$this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
	} else {
		$this.parents('.panel').find('.panel-body').slideDown();
		$this.removeClass('panel-collapsed');
		$this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
	}
});


/*
Dependencies:
- jQuery
- Hammer
- jQuery.lazyload
*/

//Lazyload
$('.js-lazyload').lazyload({
  effect: 'fadeIn',
  threshold: 50,
});




//Globals
var $topCard,
  //deltaThreshold is the swipe distance from the initial place of the card
  deltaThreshold = 100,
	deltaX = 0;

function swipeEnded(event, direction, $card) {
	var  directionFactor,
		   transform;
  //If the event has a type, then it is triggered from a button and has a given direction
  if (event.type === 'click') {
    directionFactor = direction === 'right' ? -1 : 1;
  }
  //If the event has a deltaX, then it is triggered from a gesture and has a calculated direction
  else if (event.deltaX) {
    directionFactor = event.deltaX >= 0 ? -1 : 1;
  }
  
	//If the threshold is reached or a trigger clicked, the card is thrown on a side and then disappear
	if ( event.deltaX && deltaX > deltaThreshold || event.deltaX && deltaX < -1 * deltaThreshold || direction) {
		transform = 'translate(' + directionFactor * -100 + 'vw, 0) rotate(' + directionFactor * -5 + 'deg)';
		$card
       .delay(100)
       .queue(function () { 
         $(this).css('transform', transform).dequeue(); 
       })
       .delay(300)
       .queue(function () { 
         $(this).addClass('done').remove(); 
       });
			
     //Do something
		console.log('Swipe done. \nCard:', $card, '\nDirection:', directionFactor);

	}
	//If the threshold isn't reached, the card goes back to its initial place
	else {
		transform = 'translate(0, 0) rotate(0)';
		$card.css({
			'transform': transform,
		});
	}
}

function swipeLeft(event, $card) {
	var transform;
	deltaX = event.deltaX;
	transform = 'translate(' + deltaX * 0.8 + 'px, 0) rotate(5deg)';
  //translate the card on swipe
	$card.css({
		'transform': transform,
	});
}

function swipeRight(event, $card) {
	var transform;
	deltaX = event.deltaX;
	transform = 'translate(' + deltaX * 0.8 + 'px, 0) rotate(-5deg)';
  //translate the card on swipe
	$card.css({
		'transform': transform,
	});
}

//Events
$('.js-swiping-card').each(function(index, element) {
	var $card = $(element),
		//Add hammer events on element
		hammertime = new Hammer(element);
  
  //Mobile gesture
	hammertime.on('panleft swipeleft', function(event) {
		swipeLeft(event, $card);
	});
	hammertime.on('panright swiperight', function(event) {
		swipeRight(event, $card);
	});
	hammertime.on('panend', function(event) {
		swipeEnded(event, false, $card);
	});
});

//Btn controls
$('.js-left-trigger').on('click', function(event) {
  var $topCard= $('.js-swiping-card').last();
  swipeEnded(event, 'left', $topCard);
});
$('.js-right-trigger').on('click', function(event) {
  var $topCard = $('.js-swiping-card').last();
  swipeEnded(event, 'right', $topCard);
});

$(".swipe-area").prepend("<div id='relativefix' style='position:relative;margin-top:"+($(".card").offset().top+$(".card").outerHeight()+30)+"px'></div>");


$(window).resize(function(){
$("#relativefix").css("margin-top",($(".card").offset().top+$(".card").outerHeight()+30)+"px");
            });