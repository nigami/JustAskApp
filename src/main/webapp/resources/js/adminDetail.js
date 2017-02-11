//alert("iaaaaa");

$(document).ready(function(){
	
});

var i=1;
$("#ruchi").click(function(){
	i++;
	/*//alert("Hi Ruchi");*/
	if(i%2==0){
	$("#noUserDetail").css("display","none");
	$(".userDetail").css("display","block");
	}else{
		$("#noUserDetail").css("display","block");
		$(".userDetail").css("display","none");
	}
});


function hideshow(referenceId){
	//alert("ref"+referenceId);
}