/**
 * 
 */

// alert("nigam");
$(document).ready(function(){
    $("#nextBtn").click(function(){
        $("#addrDetails").toggle();
        $("#nextBtn").hide();
    });
  
    $("#userSignUpBtn").click(function(){
    	 $("#userTypelabel").val('User');
    });
    
    $("#ownerSignUpBtn").click(function(){
   	 $("#userTypelabel").val('Owner');
    });
    
    /*$("body").on('keyup', "#usernameinput", function(){
    	alert("ula");
    });
    
    $("#usernameinputFrom").on('keyup',function(event){
    	alert("thia");
    })*/
});