(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();

var currentPage=$('#currentPage1').val();
var totalPage=$('#totalPage1').val();

if (totalPage<=5) {
	for (var i=1; i <= totalPage; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="yonghufangyuan.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage<3) {
	for (var i=1; i <= 5; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="yonghufangyuan.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage-1>1&&currentPage+1<totalPage) {
	for (var i=currentPage-2; i <= currentPage+2; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="yonghufangyuan.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage+1==totalPage) {
	for (var i=currentPage-3; i <= currentPage+1; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="yonghufangyuan.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage==totalPage) {
	for (var i=currentPage-4; i <= currentPage; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="yonghufangyuan.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}