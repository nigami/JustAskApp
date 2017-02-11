/**
 * 
 */

$(document).ready(function(){
	$("#personalUpdate").click(function(){
		$("#personalConfSection").css( "display", "block" );
		$("#personalUpdate").hide();
	});
	
	$(".yesPersonal").click(function(){
		//alert("inside ajax call");
		var firstname=$("#firstnameinput").val();
		var lastname=$("#lastnameinput").val();
		var email=$("#emailinput").val();
		//alert("email"+email);
		var queryString="firstname="+firstname+"&lastname="+lastname+"&email="+email;
		var url="updatePersonalProfile.htm";
		callAjaxForUpdateProfile(queryString,url);
		//alert("after ajax call");
		$("#personalUpdate").show().attr('value', 'Saved');
		$("#personalConfSection").hide();
	});
	
	
	$("#accountButton").click(function(){
		//alert("inside ajax call");
		var newusername=$("#usernameinput").val();
		
		var queryString="parameterName="+"newusername"+"&parameterValue="+newusername;
		var url="updateAccountProfile.htm";
		callAjaxForUpdateProfile(queryString,url);
		//alert("after ajax call");
	});
	
	
	$("#updatePwdButton").click(function(){
		//alert("inside ajax call");
		var passwordnew=$("#passwordnew").val();
		var passwordconf= document.getElementById("passwordConfirm").value;
		
		if(passwordconf==passwordnew){
			var queryString="parameterName="+"newpassword"+"&parameterValue="+passwordnew;
			var url="updateAccountProfile.htm";
			
			callAjaxForUpdateProfile(queryString,url);
		}else{
			 $("#passwordError").html("Passwords doesnt match!!").css({"color":"red"})/*.hide(2000)*/;
   		  
		}
		
		//alert("after ajax call");
	});
	
	$(".usernameEdit").click(function(){
		//alert("ila");
		$("#usernameinput").attr("disabled",false);
		$(".accountBtnDisplay").css({"display":"block"});
		
	});

	$(".passwordEdit").click(function(){
		$("#passwordinput").toggle();
		$("#passwordUpdateSec").toggle(800);
	});

	$(".addressEdit").click(function(){
		//alert("ila");
		$("#addrline1Label").attr("disabled",false);
		$("#addrLine2Label").attr("disabled",false);
		$("#citylabel").attr("disabled",false);
		$("#statelabel").attr("disabled",false);
		$("#cntrylabel").attr("disabled",false);
		$("#ziplabel").attr("disabled",false);
		$("#addressUpdateBtn").attr("disabled",false);
	});
	
	$("#addressUpdateBtn").click(function(){
		
		 //alert("i m clicked");
		 var addrLine1=$("#addrline1Label").val();
		 var addrLine2=$("#addrLine2Label").val();
		 var addrCity=$("#citylabel").val();
		 var addrState=$("#statelabel").val();
		 var addrCnty=$("#cntrylabel").val();
		 var zipcde=$("#ziplabel").val();
		     //document.getElementById("usernameError").innerHTML = x;
		     $.post( "updateAddressProfile.htm", { addr1: addrLine1,addr2: addrLine2,city:addrCity,state:addrState,country:addrCnty, zip:zipcde},function( data ) {
		    	//alert("i m back in ajax"+ data);
		    	 if(data == "success"){
			    	 $("#addrMessage").css({"color":"green"});
			    	 document.getElementById("addrMessage").innerHTML= "Address updated successfully!" ;
			    	 $("#addressUpdateBtn").attr("disabled",true);
			    	 $("#addrline1Label").attr("disabled",true);
			 		$("#addrLine2Label").attr("disabled",true);
			 		$("#citylabel").attr("disabled",true);
			 		$("#statelabel").attr("disabled",true);
			 		$("#cntrylabel").attr("disabled",true);
			 		$("#ziplabel").attr("disabled",true);
			 		
		    	 }else if(data == "fail"){
		    		 $("#addrMessage").css({"color":"red"});
			    	 document.getElementById("addrMessage").innerHTML= "Error: Address not updated!" ;
			     }
		    	});
	});
});

function GetXmlHttpObject()
{
    var xmlHttp = null;
    try
    {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e)
    {
        // Internet Explorer
        try
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}

function callAjaxForUpdateProfile(queryString,url){
	//alert("calledAjax"); 
	   var xmlHttp;
       xmlHttp = GetXmlHttpObject();
       //alert("GetXmlHttpObject"); 
      
    	   if (xmlHttp == null)
           {
               alert("Your browser does not support AJAX!");
               return;
           }
    	   
    	   xmlHttp.open("POST", url, true);
		   xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			//alert("query send"+queryString);
		   xmlHttp.send(queryString);
		   //alert("query sent");
		   var status;
		   xmlHttp.onreadystatechange = function stateChanged()
           {
               if (xmlHttp.readyState == 4)
               {
                  /* document.getElementById("row" + idr).style.backgroundColor = "#00FF00";
                   btn.style.display="none";*/
                   //alert("inReadyState"+xmlHttp.responseText);
                   var json = JSON.parse(xmlHttp.responseText);
                  
                   status= json.status;
                   //alert("status"+status);
                   if(status == true){
                	   //alert("success"+url+"...."+"updateAccountProfile.htm"+(url=="updateAccountProfile.htm"));
                	   if(url=="updateAccountProfile.htm"){
                		   var param=json.param;
                		   //alert("json.param"+param);
                		   if(("newusername")==param){
                			   //alert("username updated");
                			   var msg="Username Updated!!";
						       document.getElementById("usernameError").innerHTML = msg;
						      
                			   $("#accountButton").attr("disabled",true);
                			   $(".accountBtnDisplay").css({"display":"none"});
                			   $("#usernameError").css({"color":"green"}).hide(10000);
                    		   $("#savedUser").show().hide(10000); 
                    		   $("#usernameinput").attr("disabled",true);
                		   }else if(("newpassword")==param){
                			   //alert("newpassword updated");
                			   document.getElementById("passwordValidation").innerHTML = "Password Updated!!";
                			   $("#passwordValidation").css({"color":"green"}).hide(10000);
                    		   $("#savedPassword").show().hide(10000);   
                    		   $("#passwordUpdateSec").hide();
                    		   $("#passwordinput").show();
                    		   
                		   }
                		}else if(url==("updatePersonalProfile.htm")){
                		   alert("updated personal");    
                	   }else {
                		   alert("not in correct else update"); 
                	   }
                   }else{
                	   if(url== "updateAccountProfile.htm"){
                		   if(json.param=="newusername"){
                			   $("#usernameError").html("Username not Updated!!").css({"color":"red"})/*.hide(2000)*/;
                    		   
                		   }else if(json.param=="newpassword"){
                			   $("#passwordError").html("Password not Updated!!").css({"color":"red"})/*.hide(2000)*/;
                    		   
                		   }
                		}else {
                 		  // alert("failed"); 
                 	   }
                   }
               }
           };
		   
		   return false;
		  
}


function myUsernameChk(element){
	 var x = element.value;
	 //alert(x);
	 
	     //document.getElementById("usernameError").innerHTML = x;
	     $.post( "availableUsername.htm", { findUsername: x },function( data ) {
	    	//alert("i m back in ajax"+ data);
	    	 if(data == "true"){
		    	 $("#usernameError").css({"color":"green"});
		    	 document.getElementById("usernameError").innerHTML= "Username available!" ;
		    	 $("#accountButton").attr("disabled",false);
		     
	    	 }else if(data == "false"){
	    		 $("#usernameError").css({"color":"red"});
		    	 document.getElementById("usernameError").innerHTML= "Username already exist!" ;
		     }
	    	});
}

function myPasswordChk(element){
	 var x = element.value;
	// //alert(x);
	    // document.getElementById("passwordError").innerHTML = x;
	     $.post( "checkPasswordOld.htm", { currentpwd: x },function( data ) {
	    	
	    	 if(data== "true"){
		    	 $("#passwordError").css({"color":"green"});
		    	 document.getElementById("passwordError").innerHTML= "Password match!" ;
		    	 $("#passwordError").fadeIn().fadeOut(8000);
		    	 $("#passwordnew").attr("disabled",false);
		    	 $("#passwordConfirm").attr("disabled",false);
		     }else{
		    	 $("#passwordError").css({"color":"red"});
		    	 document.getElementById("passwordError").innerHTML= "Wrong Password!" ;
		     }
	    	});
}


function confirmPwd(confirm){
	var newPwd=$("#passwordnew").val();
	var confirmPwd = document.getElementById("passwordConfirm").value;
	
	//alert("if condition");
	if(newPwd==confirmPwd){
		 $("#updatePwdButton").attr("disabled",false);
	}else{
		 $("#updatePwdButton").attr("disabled",true);
	}
}


function deleteReview(reviewId){
	//alert(reviewId);
	 var rowId="review"+reviewId;
	 $.post( "deleteReview.htm", { reviewIndex: reviewId },function( data ) {
		//alert("data"+data);
    	 if(data== "true"){
    		 //alert("inside true");
    		$("tr").remove("#"+rowId);
	    }else{
	    	 alert("Error");
	     }
    	});
}

function editReview(reviewId){
	//alert("edit"+reviewId);
	var rowId= "review"+reviewId;
	var className= ".editManage"+reviewId;
	var editBtnId="#editBtn"+reviewId;
	var saveBtn="saveBtn"+reviewId;
	
	$(className).attr("readonly",false);
	$(editBtnId).attr("disabled",true);
	$("#"+saveBtn).attr("disabled",false);
	$("#"+saveBtn).attr("value","Save it");
	$("#"+saveBtn).removeClass("btn-success");
	$("#"+saveBtn).addClass("btn-primary");
}

function saveReview(reviewId){
	//alert("save"+reviewId);
	var rowId= "review"+reviewId;
	var className= "editManage"+reviewId;
	var editBtnId="editBtn"+reviewId;
	var saveBtn="saveBtn"+reviewId;
	
	var reviewDesc= $("#reviewDesc"+reviewId).val();
	//alert("reviewDesc"+reviewDesc);
	var reviewRating= $("#reviewRating"+reviewId).val();
	//alert("reviewRating"+reviewRating);
	var reviewCost=$("#reviewCostEff"+reviewId).val();
	//alert("reviewCost"+reviewCost);
	
	$("#"+editBtnId).attr("disabled",false);
	
	 $.post( "updateReview.htm", { id:reviewId ,desc: reviewDesc,rating:reviewRating, costEff: reviewCost},function( data ) {
			//alert("data"+data);
	    	 if(data== "true"){
	    		 //alert("inside");
	    		$("."+className).attr("readonly",true);
	    		$("#"+saveBtn).attr("value","Saved");
	    		$("#"+saveBtn).attr("disabled",true);
	    		$("#"+saveBtn).removeClass("btn-primary");
	    		$("#"+saveBtn).addClass("btn-success");
		    }else{
		    	 alert("Error: Not Successful!");
		     }
	    	});
	
}


function getVenueDetail(venueId){
	window.location = "./venueDetails.htm?index="+venueId;
	/*$.post( "venueDetails.htm", {venueIndex : venueId},function( data ) {
		 window.location="/spring/venueDetails.htm";
    });*/
}


