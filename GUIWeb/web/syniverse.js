/* 
 * This file needs to get query results (in JSON format) from
 * Java Class and then push them to the HTML page.
 */


function init() {
       
       var mapDiv = document.getElementById("map_container");
       // below we must specify our map options
       
       var mapOptions = {
           center: new google.maps.LatLng (27.9710,-82.4650),
           zoom: 8,
           mapTypeId: google.maps.MapTypeId.ROADMAP
       };
      
       //below we create a map object using options defined above-->
       var map = new google.maps.Map(mapDiv,mapOptions);
       
       
       
       
       //below we drop a PIN to the map-->
       var marker = new google.maps.Marker({
           position:new google.maps.LatLng(28.0587,-82.4139),
           map:map,
           title:'PIN created at USF'
          });
          
        //below we create an information window to show above PIN details-->  
        var infoWindow = new google.maps.InfoWindow({
            content: "This is USF"    
        });       

        //Creating a mouse event to show our infowindow--> 
        //pass our pin name, mouse event, and call our funtion--> 
        google.maps.event.addListener(marker,'click', function(){
            infoWindow.open(map, marker); 
        }); 
        
        //Creating multiple PINs saved on an array--> 
        var PINlocation = [];
        PINlocation.push({name:"PIN 1", latlng: new google.maps.LatLng(30.1587,-82.4139) });
        PINlocation.push({name:"PIN 2", latlng: new google.maps.LatLng(26.3987,-80.3959) });
        PINlocation.push({name:"PIN 3", latlng: new google.maps.LatLng(32.0587,-82.9939) });


        //assigning markers to each PIN saved on an array--> 
        for (var i=0; i < PINlocation.length;i++){
            var newmarker = new google.maps.Marker({
                position: PINlocation[i].latlng,
                map:map,
                title:PINlocation[i].name
            })
        }
        
        
        
        //we can only see 1 pin using our initial zoom of 8--> 
        //we must bound our map to show more locations--> 
        //increasing bound shows all PINs without touching zoom--> 
        var bounds = new google.maps.LatLngBounds();
        for (var i=0; i < PINlocation.length;i++){
           bounds.extend( PINlocation[i].latlng );
        }
        map.fitBounds(bounds);
        
        
        
        
        //Drawing Shapes: Circle, rectangle,  polygon--> 

        //Drawing a Circle given center, radius 50Km> 
        var circle = new google.maps.Circle({
            map:map,
            center: new google.maps.LatLng(29.646836, -82.345546),
            radius: 50000,
            fillColor:"#00FF00",
            strokeColor:"yellow"
        })
                
        //Drawing a rectangle given top left, lower right coord> 
        var rectangle = new google.maps.Rectangle({
            map:map,
            bounds: new google.maps.LatLngBounds(
                    new google.maps.LatLng(28.534660, -81.517022),
                    new google.maps.LatLng(28.215870, -81.224261)
                    ),
            fillColor:"#00FF00",
            strokeColor:"blue"
        })
        
        //Drawing a Polygon given some coord > 
        var polylines = new google.maps.MVCArray();
        polylines.push( new google.maps.LatLng(27.686041, -81.967039) );
        polylines.push( new google.maps.LatLng(27.513224, -82.054929) );
        polylines.push( new google.maps.LatLng(27.530275, -81.568784) );
        polylines.push( new google.maps.LatLng(27.829442, -81.159544) );
        polylines.push( new google.maps.LatLng(28.057519, -81.675901) );
        
        var polygonOptions = {path: polylines, strokeColor:"red", fillColor:"00FF00"};
        var polygon = new google.maps.Polygon(polygonOptions);
        
        polygon.setMap(map);
        
        
        
        //TESTING
        var TestDiv = document.getElementById("test");
        TestDiv.innerHTML = "JSON PRACTICE";
        var myJSONObject = {"bindings": [
        {"ircEvent": "PRIVMSG", "method": "newURI", "regex": "^http://.*"},
        {"ircEvent": "PRIVMSG", "method": "deleteURI", "regex": "^delete.*"},
        {"ircEvent": "PRIVMSG", "method": "randomURI", "regex": "^random.*"}
        ]};
             
        
        

        
     }
     
    function Get_Data() 
    {
        $.get('syniverseQuery.java', '', Process_Response);
    }
    function Process_Response(result, status)
    {
        if (status == 'success')
        {
            $('Message').text(result);          
            
        }
        else
        {
            $('Message').text('Error retrieving data from server');
        }
        
    }
   
    



