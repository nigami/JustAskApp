//alert("inside cool");

window.onload = function () {

	//var x=test();
	var userTrafficData= ajaxForUserTraffic();
	/*alert("main"+userTrafficData);*/
	var userData=ajaxForUserAnalysis('analyzeUserData.htm');
	
	var venueData=ajaxForUserAnalysis('analyzeVenueData.htm');
	
	var reviewData=ajaxForUserAnalysis('analyzeReviewData.htm');;
	
	
    var chart = new CanvasJS.Chart("chartContainer",
    {
      theme: "theme2",
      title:{
        text: "User Traffic - per month"
      },
      animationEnabled: true,
      axisX: {
        valueFormatString: "MMM",
        interval:1,
        intervalType: "month"
        
      },
      axisY:{
        includeZero: false
        
      },
      data: [
      {        
        type: "line",
        //lineThickness: 3,        
        dataPoints:userTrafficData
      }
      
      
      ]
    });

chart.render();

var chart2 = new CanvasJS.Chart("chartContainer2",
		{
			zoomEnabled: false,
                      animationEnabled: true,
			title:{
				text: "User, Venue and Review Analysis"
			},
			axisY2:{
				valueFormatString:"0 k",
				
				maximum: 10,
				interval: 1,
				interlacedColor: "#F5F5F5",
				gridColor: "#D7D7D7",      
	 			tickColor: "#D7D7D7"								
			},
                      theme: "theme2",
                      toolTip:{
                              shared: true
                      },
			legend:{
				verticalAlign: "bottom",
				horizontalAlign: "center",
				fontSize: 15,
				fontFamily: "Lucida Sans Unicode"

			},
			data: [
			{        
				type: "line",
				lineThickness:3,
				axisYType:"secondary",
				showInLegend: true,           
				name: "User", 
				dataPoints: userData
			},
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "Venue",
				axisYType:"secondary",
				dataPoints: venueData
			},
			{        
				type: "line",
				lineThickness:3,
				showInLegend: true,           
				name: "Review",        
				axisYType:"secondary",
				dataPoints: reviewData
			}

			],
        legend: {
          cursor:"pointer",
          itemclick : function(e) {
            if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
            e.dataSeries.visible = false;
            }
            else {
              e.dataSeries.visible = true;
            }
            chart.render();
          }
        }
      });

chart2.render();

//populateUserAnalytics();
}


function test() {
    myFunction();
    //alert("myfunctino4");
}

function myFunction() {
	//alert("myfunctino1");
    var data;
    $.ajax({
    	  type: 'POST',
        url: 'analyzeUserTraffic.htm',
        data: {home : "ila"},
       
        success: function (resp) {
            //alert("myfunctino2");
            var json = JSON.parse(resp);
		    //alert("reviewListObj"+ json.userTrafficList.length);
           
	    	//alert("i m back in ajax"+ json.userTrafficList);
	    	data=json.userTrafficList;
           // callback(data);
        },
        
        async:false
    }); // ajax asynchronus request 
    //alert("myfunctino3.."+data);
    //the following line wouldn't work, since the function returns immediately
    //return data; // return data from the ajax request
}


function ajaxForUserTraffic(){
	/*alert("myfunctino1");*/
    var data;
    var min;
    var max;
    $.ajax({
    	  type: 'POST',
        url: 'analyzeUserTraffic.htm',
        data: {home : "ila"},
       
        success: function (resp) {
           /* alert("myfunctino2");*/
            var json = JSON.parse(resp);
		    /*alert("reviewListObj"+ json.userTrafficList.length);
           
	    	alert("i m back in ajax"+ json.userTrafficList);*/
	    	data=json.userTrafficList;
           // callback(data);
	    	min=json.min;
	    	max=json.max;
        },
        
        async:false
    });


 y= [
	          { x: new Date(2012, 00, 1), y: data[0], indexLabel: "",markerColor: "", markerType: ""},
	          { x: new Date(2012, 01, 1), y: data[1]},
	          { x: new Date(2012, 02, 1), y: data[2]},
	          { x: new Date(2012, 03, 1), y: data[3], indexLabel: "highest",markerColor: "red", markerType: "triangle" },
	          { x: new Date(2012, 04, 1), y: data[4] },
	          { x: new Date(2012, 05, 1), y: data[5] },
	          { x: new Date(2012, 06, 1), y: data[6] },
	          { x: new Date(2012, 07, 1), y: data[7] },
	          { x: new Date(2012, 08, 1), y: data[8] /* , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross"*/},
	          { x: new Date(2012, 09, 1), y: data[9] },
	          { x: new Date(2012, 10, 1), y: data[10] },
	          { x: new Date(2012, 11, 1), y: data[11] }
	          
	          ];



	 /*
		alert("y....."+y);*/
		 
		return  y;
}



function ajaxForUserAnalysis(url){
	/*alert("myfunctino1");*/
    var data;
    var min;
    var max;
    $.ajax({
    	  type: 'POST',
        url: url,
        data: {home : "ila"},
       
        success: function (resp) {
           /* alert("myfunctino2");*/
            var json = JSON.parse(resp);
		    /*alert("reviewListObj"+ json.userTrafficList.length);
           
	    	alert("i m back in ajax"+ json.userTrafficList);*/
	    	data=json.userDataList;
           // callback(data);
	    	min=json.min;
	    	max=json.max;
        },
        
        async:false
    });


 y= [
		{ x: new Date(2005, 0), y: data[0] },
		{ x: new Date(2006, 0), y:data[1] },
		{ x: new Date(2007, 0), y: data[2]},
		{ x: new Date(2008, 0), y: data[3] },
		{ x: new Date(2009, 0), y: data[4] },
		{ x: new Date(2010, 0), y: data[5] },
		{ x: new Date(2011, 0), y: data[6] },
		{ x: new Date(2012, 0), y: data[7]  },
		{ x: new Date(2013, 0), y: data[8] },
		{ x: new Date(2014, 0), y:data[9] },
		{ x: new Date(2015, 0), y: data[10] },
		{ x: new Date(2016, 0), y: data[11] }


		];
		return  y;
}

function populateUserAnalytics(){
	alert("populateUserAnalytics");
}


