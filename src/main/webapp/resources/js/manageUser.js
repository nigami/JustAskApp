/**
 * 
 */

//alert("manageUserJS");
$(document).ready(function(){
	
	
});
//end of document read function
/*function viewReview(personId){
	$("userReview"+personId).toggle();
}*/

function viewReview(personid){
	//review${user.personId}
	//alert("view...."+"review"+personid);
	$(".review"+personid).toggleClass("hide");
	 $.post( "getReviewsForUser.htm", { personId: personid },function( data ) {
	/*	 //alert(data);*/
		   var json = JSON.parse(data);
		  /* //alert(data);*/
           var reviewListObj= "reviewlist"+personid;
           
         /*  alert("reviewListObj"+ json.reviewlist.length);
           */
        
           for (var count = 0; count <json.reviewlist.length; count++) {
          
        	   //alert("inside loop");
           	 var reviewId= json.reviewlist[count].reviewId;
           	//alert("id of body "+"reviewTableBody"+personid)
           	
           	
           			var reviewId= json.reviewlist[count].reviewId;
           			var dateOfReview= json.reviewlist[count].dateOfReview;
           			var venueId=json.reviewlist[count].venueId;
           			var costEff=json.reviewlist[count].costEff;
           			var rating=json.reviewlist[count].rating;
           			var desc=json.reviewlist[count].desc;
           		
           			
           	 $("#reviewTableBody"+personid).append(/*"<tr id='review"+reviewId+"' ><td colspan='6'>Ila Nigam</td></tr>"*/
           			 "<tr id='review"+reviewId+"' >"
           				+"<td>"+count+1+"</td>"
           				+"<td>"+dateOfReview+"</td>"
           				+"<td>"+venueId+"</td>"
           				+"<td><textarea cols='35'  readonly='readonly' >"+desc+"</textarea></td>"
           				+"<td>"+costEff+"</td>"
           				+"<td>"+rating+"</td>"
           				+"<td><input type='button' class='btn btn-danger' value='Delete' onclick='deleteReview("+reviewId+")'/></td>"
           			+"</tr>"
           	 );
            }
		
	});
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


function deleteUser(personid){
	//alert( personid);
	var rowId="user"+personid;
		 $.post( "deleteUser.htm", { personId: personid },function( data ) {
	//	alert("data"+data);
	       if(data.trim() == "true"){
	    		alert("inside true");
	    		/*$("tr").remove("#"+rowId);*/
	    		/*$("#"+rowId).attr("disabled", true);*/
	    		
	    		//alert("1 "+$("#unblock"+personid).length);
		    	if($("#unblock"+personid).length==0){
	    			//alert("inside unblock");
	    		$("#deleteBtnSection"+personid).append("<input type='button' class='btn btn-success' value='Unblock' onclick='unblockUser("+personid+")' id='unblock"+personid+"'/>");
	    		}else{
	    			$("#unblock"+personid).css("display","block");	
	    		}//$("#delete"+personid).css("display","block");
	    		$("#delete"+personid).css("display","none");
	    		sendmail(personid);
		    }else{
		    	 alert("Error");
		     }
	    
		 });

}


function unblockUser(personid){
	//alert( personid);
	var rowId="user"+personid;
		 $.post( "unblockUser.htm", { personId: personid },function( data ) {
		//alert("data"+data);
	       if(data.trim() == "true"){
	    		//alert("inside true");
	    		/*$("tr").remove("#"+rowId);*/
	    		/*$("#"+rowId).attr("disabled", true);*/
	    		
	    		//alert("1 "+$("#delete"+personid).length);
	    		if($("#delete"+personid).length==0){
		    		//alert("inside delete");
		    		$("#unblockBtnSection"+personid).append("<input type='button' class='btn btn-danger' value='Delete' onclick='deleteUser("+personid+")' id='delete"+personid+"'/>");
	    		}else{
	    			$("#delete"+personid).css("display","block");	
	    		}
	    		//$("#delete"+personid).css("display","block");
	    		$("#unblock"+personid).css("display","none");
		    }else{
		    	 alert("Error");
		     }
	    
		 });
} 
		 
function sendmail(personid){
	
	 var email=document.getElementById(("email"+personid)).innerText ;
	 
	 //alert(email);
	 $.post( "sendMail.htm", {emailId : email},function( data ) {
	    	//alert("i m back in ajax"+ data);
	    	 if(data == "true"){
		    	// alert("Mail send!");
	    	 }else if(data == "false"){
	    		// alert("Mail not send!");
	    	 }
	    });
}

