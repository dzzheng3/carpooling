 
	
      function initMap() {
    	  var geocoder = new google.maps.Geocoder();
    	  var address = $("#cityDestination").text();
    	  var citySource1 = $("#citySource").text();
    	  var myLatLng = {lat: -25.363, lng: 131.044};
    	  var latitude;
    	  var longitude;
    	  if (citySource1 !== null || citySource1 !== undefined || citySource1 !== '') { 
          	{ 
          	    if (navigator.geolocation) //html5
          	    { 
          	        navigator.geolocation.getCurrentPosition(showPosition); 
          	    } 
          	    else 
          	    { 
          	    	console.log("your brower does not support navigator!");
          	    } 
          	}	
          } 
          function showPosition(position) 
          { 
        	  latitude = position.coords.latitude ; 
        	  longitude= position.coords.longitude;     
          }
    	 
    	  var directionsService = new google.maps.DirectionsService;
	      var directionsDisplay = new google.maps.DirectionsRenderer;
	     
	      
	     
    	  var geocoder = new google.maps.Geocoder();

    	  geocoder.geocode( { 'address': address}, function(results, status) {
    	    var location = results[0].geometry.location;
    	    myLatLng = {lat: location.lat(), lng: location.lng()};  
    	    
    	    var map = new google.maps.Map(document.getElementById('map'), {
        	    zoom: 4,
        	    center: myLatLng
        	  });
    	    
    	    directionsDisplay.setMap(map); 
    	    function getDirections(){
  	    	  directionsService.route({
  					origin: $("#citySource").text(),
  					destination: $("#cityDestination").text(), 
  					optimizeWaypoints: true,
  					travelMode:'DRIVING'
  			}, function(response, status) {
  										if (status === 'OK') {
  												directionsDisplay.setDirections(response);
  												var route = response.routes[0];
  												var summaryPanel = document.getElementById('summaryPanel');
  												summaryPanel.innerHTML = '';
  			// For each route, display summary information.
  												for (var i = 0; i < route.legs.length; i++) {
  													var routeSegment = i + 1;
  													summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
  													'</b><br>';
  													summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
  													summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
  													summaryPanel.innerHTML += route.legs[i].distance.text +  '<br><br>';
  												}
  										} 
  										else {
  												window.alert('Directions request failed due to ' + status);
  											}
  			})
  	      }
      	  
    	    getDirections();

//	    	  var marker = new google.maps.Marker({
//	    	    position: myLatLng,
//	    	    map: map,
//	    	    title: 'Hello World!'
//	    	  });
    	  
    	  });    
    	  
    	  

      }
      
	$(function(){ 	
	
		var content="";
		
	//			$("#submit").click(function(){
	//			$("#weather").empty(); 
		var city="";
		city=$("#cityDestination").text();
		var api="http://api.openweathermap.org/data/2.5/forecast?q=";
		var countryCode=",us";
	    var apiKey="&appid=95974909e1adcbde64767dc2d805b01a"; 
	    var units="&units=metric&mode=json";
	    var url= api + city + countryCode + units + apiKey;
	      
	    if(city!=""){
	    	
	    	//Displaying day
			var weekdays = new Array(7);
			weekdays[0] = "Sunday";
			weekdays[1] = "Monday";
			weekdays[2] = "Tuesday";
			weekdays[3] = "Wednesday";
			weekdays[4] = "Thursday";
			weekdays[5] = "Friday";
			weekdays[6] = "Saturday";			
	    	$.get(url).done(function(data){
	    	
	    		
	    		//content+=	"<h5>Country :"+data.city.name+", "+data.city.country+"</h5>";
	    		content+=	"<h5>Today"+"<img   src='http://openweathermap.org/img/w/"+data.list[0].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[0].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[0].weather[0].description+"</span>"+
	    	 				"<h5>"+weekdays[new Date(data.list[3].dt_txt).getDay()] +
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[3].weather[0].icon+".png'/>"+
	    	 				"<span> "+data.list[3].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[3].weather[0].description+"</span>"+"</h5>"+
	    	 				"<h5>"+weekdays[new Date(data.list[11].dt_txt).getDay()] + 
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[11].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[11].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[11].weather[0].description+"</span>"+"</h5>"+
	    	 				"<h5>"+weekdays[new Date(data.list[19].dt_txt).getDay()] + 
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[19].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[19].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[19].weather[0].description+"</span>"+"</h5>"+
	    	 				"<h5>"+weekdays[new Date(data.list[27].dt_txt).getDay()] + 
	    	 				"<img  src='http://openweathermap.org/img/w/"+data.list[27].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[27].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[27].weather[0	].description+"</span>"+"</h5>"+
	    	 				"<h5>"+weekdays[new Date(data.list[35].dt_txt).getDay()] + 
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[35].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[35].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[35].weather[0	].description+"</span></h5>";
	    		$(".weather-content").append(content);
	    		
	    	})
	    	.fail(function(xhr,status,exception){
	    											console.log(exception);
	    		});		
		}
	    
	    
	   
	});

	

	 
 