//alert("userDashboard");

$(document).ready(function(){
	
		  
		  $("#newVenueMailBtn").click(function(){
			 $.post( "sendMail.htm", {home : "ila"},function( data ) {
			    	
			    	 if(data == "true"){
				    	 alert("you are successful");
			    	 }else if(data == "false"){
			    		 alert("Sorry! It was unsuccessful, Please try again!");
			    	 }
			    });
		  });
		  
		  $("#nextBtn").click(function(){
		        $("#addrDetails").toggle();
		        $("#nextBtn").hide();
		    });
		  
		  $("#restaurentSpecific").click(function(){
			  //$("#favSelect").html('<i class="fa fa-heart fa-2x text-danger"></i>');
			  var action="restaurantSearch";
	    	  var venueType="R";
			  callAjaxForRestaurant(action,venueType);
		  });
		  
		  $("#holidayImgId").click(function(){
			  //$("#favSelect").html('<i class="fa fa-heart fa-2x text-danger"></i>');
			  var action="restaurantSearch";
	    	  var venueType="H";
			  callAjaxForRestaurant(action,venueType);
		  });
		  
		  $("#restaurantImgId").click(function(){
			  //$("#favSelect").html('<i class="fa fa-heart fa-2x text-danger"></i>');
			  var action="restaurantSearch";
	    	  var venueType="R";
			  callAjaxForRestaurant(action,venueType);
		  });
		  
		  $("#partyImgId").click(function(){
			  //$("#favSelect").html('<i class="fa fa-heart fa-2x text-danger"></i>');
			  var action="restaurantSearch";
	    	  var venueType="P";
			  callAjaxForRestaurant(action,venueType);
		  });
		  
		 $(".logout").click(function(){
			  //alert("logout");
			  //$("#favSelect").html('<i class="fa fa-heart fa-2x text-danger"></i>');
			  $.ajax({
				  url: "logout.htm",
				  success: function(result){
				  /*<jsp:forward page = "/WEB-INF/jsp/test/test.jsp" /> 
				   *window.location="nextPage.jsp"
				  alert("success");*/
					  window.location="/spring/";
				  }
			  });
				
		  });
		 
		 
		  $("#updateProfile").click(function(){
			  //$("#favSelect").html('<i class="fa fa-heart fa-2x text-danger"></i>');
			  window.location="/spring/updateProfile.htm";
		  });
		  
		  
		
		  
		  $("#ilaInput").keyup(function(){
				
				var reviewSearch=$("#ilaInput").val();
			   
				if(reviewSearch.length >2){
					   $.get("sampleAjax.htm?reviewVenue="+reviewSearch, function(data, status){
					      var json = jQuery.parseJSON( data );;
						  var parentNode=$(".reviewSearchResult");
						  parentNode.empty();
							/*$("#displayDiv").empty();*/
							
							var count=json.venueJSONList.length;
							var parentNode=$(".reviewSearchResult");
							parentNode.empty();
							for(var i=0, l = json.venueJSONList.length; i < l; i++){
								//alert(response[i]);
								var venueId = json.venueJSONList[i].venueId;
								var venueName = json.venueJSONList[i].venueName;
								var venueDesc = json.venueJSONList[i].venueDesc;
								parentNode.append("<li id='"+venueId+"'><a href='#'><em>"+venueName+"</em>, <br /> "+venueDesc+"</a></li>");
								
							}
					        
					        
					    });
						
				}
			
			});
		  
		  function displayTheContent(response){
			  var json = JSON.parse(response);
	           //var reviewListObj= "reviewlist"+personid;
	           
	         /*  alert("reviewListObj"+ json.reviewlist.length);
	           */
	        var venueList= json.venueList;
	           
			  var parentNode=$(".reviewSearchResult");
				parentNode.empty();
				/*$("#displayDiv").empty();*/
				var count=json.venueList.length;
				var parentNode=$(".reviewSearchResult");
				parentNode.empty();
				for(var i=0, l = json.venueList.length; i < l; i++){
					//alert(response[i]);
					var venueId = json.venueList[i].venueId;
					var venueName = json.venueList[i].venueName;
					var venueDesc = json.venueList[i].venueDesc;
					parentNode.append("<li id='"+venueId+"'><a href='#'><em>"+venueName+"</em>,<br /> "+venueDesc+"</a></li>");
					
				}
			}
		  
		  
			 /* $("ul.reviewSearchResult > li > a").hover(function(){
				  alert("selected");
			  });*/
		  $(document).on("mouseenter", "ul.reviewSearchResult > li ", function() {
			    // hover starts code here
			  var element=$(this).text();
			  var id= $(this).attr("id");
			  var newElement="<p><strong>"+element+"<strong><p>";
			 
			 document.getElementById("reviewVenueName").innerHTML=element;
			 $("#hidden1").val(id);
			 
			 $(".costEffSect").show();
			 $(".reviewStarSection").show();
			 
			 // $("#reviewVenueName").
			});

			/*$(document).on("mouseleave", "ul.reviewSearchResult > li", function() {
			    // hover ends code here
				// alert("deselected");
			});
		*/
		  
		  
		  $("#reviewSubmit").click(function(){

				var rating= $("#rating").val();
				var comment= $("#comment").val();
				var costEff= $("#costEff").val();
				var venueId=$("#hidden1").val();
				if(rating.length>0 && comment.length>0  && venueId.length>0 && costEff.length>0 && parseInt(costEff)>0){
					$.post( "addReviewComments.htm", { reviewRating: rating,reviewComment: comment,reviewCostEff:costEff,reviewVenueId:venueId},function( data ) {
				    	alert("i m back in ajax"+ data);
				    	 if(data == "true"){
				    		$("#rating").val("");
							 $("#comment").val("");
							 $("#costEff").val("");
							 $("#reviewVenueName").html("");
							$("#hidden1").val("");
							
							$("#reviewSearchError").fadeIn();
							$("#reviewSearchError").html("<font color='green'>Review added successfully!</font>");
							$("#reviewSearchError").fadeOut(8000 );
							// $(".costEffSect").hide();
							// $(".reviewStarSection").hide();
							
				    	 }else if(data == "false"){
				    		 alert("Sorry! It was unsuccessful, Please try again!");
				    		 $("#reviewSearchError").fadeIn();
								$("#reviewSearchError").html("<font color='red'>Sorry! It was unsuccessful, Please try again!</font>");
								$("#reviewSearchError").fadeOut(10000);
				    	 }
				    });
				}else{
					$("#reviewSearchError").fadeIn();
					$("#reviewSearchError").html("<font color='red'>Please select venue and all the fields are manadatory!</font>");
					$("#reviewSearchError").fadeOut(10000);
					 alert("Sorry! It was unsuccessful, Please try again!");
				}
		  });
});

function myFav(venueId){
	var element=document.getElementById("favSelect"+venueId);
	var id= "favSelect"+venueId;
	
	   if($(element).find($(".fa")).hasClass('fa-heart-o'))
       {  
		  callAjaxForAddFav(element,venueId,"addVenueToFav");
         
       }
       else if($(element).find($(".fa")).hasClass('fa-heart'))
       {  
    	   callAjaxForDeleteFav(element,venueId,"deleteVenueToFav");
       }              
 }


function myVisited(venueId){
	var element=document.getElementById("visitSelect"+venueId);
	/*alert(element);
	var innerElement=  element.innerHtml;
	alert(innerElement);
	element.innerHtml='<i class="fa fa-heart fa-2x text-danger"></i>';*/
	var id= "visitSelect"+venueId;
	//$("#"+id).html('<i class="fa fa-heart fa-2x text-danger"></i>');
	
	// $(element).find('i').toggleClass('fa fa-heart fa-2x text-danger');
	   if($(element).find($(".fa")).hasClass('fa-thumbs-o-up'))
       {	
		  callAjaxForAddFav(element,venueId,"addVenueToVisited");
       }
       else if($(element).find($(".fa")).hasClass('fa-thumbs-up'))
       {                     
    	  callAjaxForDeleteFav(element,venueId,"deleteVenueToVisited");
       }              
 }
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

function callAjaxForAddFav(element, venueId, action){
	   var xmlHttp;
       xmlHttp = GetXmlHttpObject();
      
    	   if (xmlHttp == null)
           {
               alert("Your browser does not support AJAX!");
               return;
           }
    	   


    	   var query = "action="+action+"&venueId="+venueId/*+"username"+username*/;
		   xmlHttp.open("POST", "addVenueToUserDb.htm", true);
		   xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		   xmlHttp.send(query);
		  
			
		   var status;
		   xmlHttp.onreadystatechange = function stateChanged()
           {
               if (xmlHttp.readyState == 4)
               {
                  /* document.getElementById("row" + idr).style.backgroundColor = "#00FF00";
                   btn.style.display="none";*/
                   var json = JSON.parse(xmlHttp.responseText);
                   //alert("inReadyState"+json);
                   //alert("response from json "+json.addStatus);
                   status= json.addStatus;
                  // alert("status"+status);
                   if(status == true){
                	   if(action== "addVenueToVisited"){
                		   $(element).find($(".fa")).removeClass('fa-thumbs-o-up').addClass('fa-thumbs-up text-success');
                	   }else if(action== "addVenueToFav"){
                		   $(element).find($(".fa")).removeClass('fa-heart-o').addClass('fa-heart text-danger');
                	   }
                   }
               }
           };
		   
		   return false;
      
}

function callAjaxForDeleteFav(element, venueId, action){
	//alert("calledAjax"); 
	   var xmlHttp;
       xmlHttp = GetXmlHttpObject();
       //alert("GetXmlHttpObject"); 
      
    	   if (xmlHttp == null)
           {
               alert("Your browser does not support AJAX!");
               return;
           }
    	   
    	 //  alert("action"+action);


    	   var query = "action="+action+"&venueId="+venueId/*+"username"+username*/;
    	  // alert("query"+query);
		   xmlHttp.open("POST", "deleteVenueToUserDb.htm", true);
		   xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		   xmlHttp.send(query);
		  // 	alert("query send");
		  
			
		   var status;
		   xmlHttp.onreadystatechange = function stateChanged()
           {
               if (xmlHttp.readyState == 4)
               {
                  /* document.getElementById("row" + idr).style.backgroundColor = "#00FF00";
                   btn.style.display="none";*/
                   //alert("inReadyState"+xmlHttp.responseText);
                   var json = JSON.parse(xmlHttp.responseText);
                  // alert("inReadyState"+json);
                  // alert("response from json "+json.addStatus);
                   status= json.addStatus;
                  // alert("status"+status);
                   if(status == true){
                	   if(action== "deleteVenueToVisited"){
                		   $(element).find($(".fa")).removeClass('fa-thumbs-up text-success').addClass('fa-thumbs-o-up');    
                	   }else if(action== "deleteVenueToFav"){
                		   $(element).find($(".fa")).removeClass('fa-heart text-danger').addClass('fa-heart-o');    
                	   }
                   }
               }
           };
		   
		   return false;
		  
}



function callAjaxForRestaurant(action,venueType){
	//alert("calledAjax"); 
	   var xmlRestaurantHttp;
	   xmlRestaurantHttp = GetXmlHttpObject();
      // alert("GetXmlHttpObject"); 
      
    	   if (xmlRestaurantHttp == null)
           {
               alert("Your browser does not support AJAX!");
               return;
           }
    	   
    	   var query = "action="+action+"&venueType="+venueType/*+"username"+username*/;
    	  // alert("query"+query);
    	   xmlRestaurantHttp.open("POST", "VenueSearch.htm", true);
    	   xmlRestaurantHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    	   xmlRestaurantHttp.send(query);
		  // 	alert("query send");
		  
			
		  
		   	xmlRestaurantHttp.onreadystatechange = function stateChanged()
           {
               if (xmlRestaurantHttp.readyState == 4)
               {
                // alert("responseText"+ xmlRestaurantHttp.responseText);
                 var restaurantJson = JSON.parse(xmlRestaurantHttp.responseText);
                 $("#mainSection").html("");
                 $("#mainSection2").empty();
                 
                var resListSize= restaurantJson.restaurantVenueList.length;
               // alert("length"+resListSize);
                /* if (resListSize > 0) {
                	for (var i = 0; i <resListSize; i++) {
                		                		  
                		  var panel = document.createElement("div");
                          panel.setAttribute("class", "panel panel-default col-lg-4 resizePanelVenue");
                         
                          $("#mainSection").appendChild(panel);
                	}
                 }*/
                var rList=restaurantJson.restaurantVenueList;
                for (var count = 0; count <resListSize; count++) {
               // $.each(restaurantJson.restaurantVenueList.venue, function(k, v) {
                	// alert("inside loop");
                	 
                	//alert("v...."+rList[count]);
                	 var venueDetails =rList[count];
                	////alert("v"+venueDetails[0]);
                	 var venueName= venueDetails[1];
                	////alert("venueName"+venueName);
                	 var venueId= venueDetails[0];
                	////alert("venueId"+venueId);
                	 var venueType= venueDetails[2];
                	////alert("venueType"+venueType);
                	 var venueDesc= venueDetails[3];
                	////alert("venueDesc"+venueDesc);
                	 var venueRange= venueDetails[4];
                	////alert("venueRange"+venueRange);
                	 var venueImgLocation= venueDetails[5];
                	 
                	 var venueIntroReview=venueDetails[6];
                	// alert("venueImgLocation"+venueImgLocation);
                	
                	/* $("#mainSection2").append("<div class='panel panel-default col-lg-4 resizePanelVenue'>"
                			 +"<div class='panel-heading'>"
                				+"<h3 class='venueSectionHeading'>"+venueName+"</h3>"
                			 	+"<span id='favSelect"+venueId+"' onclick='myFav("+venueId+")'><i class='fa fa-heart-o fa-2x' ></i></span>"
                			 	+"<span id='visitSelect"+venueId+"'  onclick='myVisited("+venueId+")'><i class='fa fa-thumbs-o-up fa-2x'></i> </span> <span class='glyphicon glyphicon-star text-warning'></span>"
                			 +"</div>"
                				+"<div class='panel-body'>"
	                			 +"<div class='col-lg-6'>"
	                			 	+"<img class='ImgVenueSize' src='resources/images/venueImgs/"+venueImgLocation+"' alt='venue Image'/>"
	                			 +"</div>"
	                			 +"<div class='col-lg-6'>"
	                		 		+"<i class='fa fa-quote-left fa-3x fa-pull-left'></i>"
	                		 	 +"</div>"
	                		 +"</div>"
	                		 +"<div class='panel-footer'>"
	                		 	+"<p>"+venueDesc+"</p>"
	                		 	+"<p>"+ venueType+"</p>"
	                		 	+"<p> "+ venueRange+"</p>"
	                		 	+" <p>"+venueAddress.addrLine1+",<br> "+venueAddress.city+"</p>"
	                		 +"</div>"
	                	+"</div>");*/
                	 
                	 $("#mainSection2").append("<div class='panel panel-default col-lg-4 resizePanelVenue'>"
                			 +"<div class='panel-heading'>"
                				+"<div class='col-lg-offset-9'>"
									+"<span id='favSelect"+venueId+"' onclick='myFav("+venueId+")'><i class='fa fa-heart-o fa-lg' ></i></span>"
									+" <span id='visitSelect"+venueId+"'  onclick='myVisited("+venueId+")'><i class='fa fa-thumbs-o-up fa-lg'></i> </span> <span class='glyphicon glyphicon-star text-warning'></span>"
								+"</div>"
								+"<h3 class='venueSectionHeading'><a onclick='getVenueDetail("+venueId+")'>"+venueName+"</a></h3>"
							 +"</div>"
                				+"<div class='panel-body'>"
	                			 +"<div class='col-lg-6'>"
	                			 	+"<img class='ImgVenueSize' src='resources/images/venueImgs/"+venueImgLocation+"' alt='venue Image'/>"
	                			 +"</div>"
	                			 +"<div class='col-lg-6'>"
	                		 		+"<i class='fa fa-quote-left fa-3x fa-pull-left'></i>"+venueIntroReview
	                		 	 +"</div>"
	                		 +"</div>"
	                		 +"<div class='panel-footer'>"
	                		 	+"<p>"+venueDesc+"</p>"
	                		 	+"<p><em>Restaurant Type:</em> "+ venueType+"</p>"
	                		 	+"<p><em>Range:</em> "+ venueRange+"<i class='fa fa-usd' aria-hidden='true'></i></p>"
	                		 	/*+" <p><em>Address:</em> "+venueAddress.addrLine1+",<br> "+venueAddress.city+"</p>"*/
	                		 +"</div>"
	                	+"</div>");
                 }
                 
               }
           };
		   
		   return false;		  
}



function getVenueDetail(venueId){
	window.location = "./venueDetails.htm?index="+venueId;
	
}


