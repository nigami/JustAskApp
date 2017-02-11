/*$(window).scroll(function(){
	
                    if  (800 > ($(document).height()-$(window).scrollTop())){
                          // run our call for pagination
                    	var pageCount=$("#hiddenPageIndex").val();
                    	alert("page count"+pageCount);
                    	$.post( "venueSearchPagination.htm", {pageIndex:pageCount},function( data ) {
        			    	alert("i m back in ajax"+ data);
        			    	 var restaurantJson=JSON.parse(data);
        			    		// var rList=restaurantJson.restaurantVenueList;
        			    		
        			    		 var resListSize=restaurantJson.restaurantVenueList.length;
        			                for (var count = 0; count <resListSize; count++) {
        			               // $.each(restaurantJson.restaurantVenueList.venue, function(k, v) {
        			                	
        			                	 //alert("v...."+restaurantJson.restaurantVenueList[count]);
        			                	 var venueDetails =restaurantJson.restaurantVenueList[count];
        			                	// alert("v"+venueDetails[0]);
        			                	 var venueName= venueDetails[1];
        			                	// alert("venueName"+venueName);
        			                	 var venueId= venueDetails[0];
        			                    //  alert("venueId"+venueId);
        			                	 var venueType= venueDetails[2];
        			                	// alert("venueType"+venueType);
        			                	 var venueDesc= venueDetails[3];
        			                	// alert("venueDesc"+venueDesc);
        			                	 var venueRange= venueDetails[4];
        			                	// alert("venueRange"+venueRange);
        			                	 var venueImgLocation= venueDetails[5];
        			                	 
        			                	 var venueIntroReview=venueDetails[6];
        			                	// alert("venueImgLocation"+venueImgLocation);
        			                	
        			                	 $("#mainSection").append("<div class='panel panel-default col-lg-4 resizePanelVenue'>"
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
        				                		 	+" <p><em>Address:</em> "+venueAddress.addrLine1+",<br> "+venueAddress.city+"</p>"
        				                		 +"</div>"
        				                	+"</div>");
        			                		}
        			                var newCount=parseInt(pageCount)+5;
        			                $("#hiddenPageIndex").val(newCount);
        			               
        			    });
                    	
                    }
            }); */