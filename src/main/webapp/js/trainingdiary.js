/*
jQuery(document).ready(function() {
  jQuery.ajaxSetup({
    contentType: "application/json"
  });
  alert("sending put request");
  
  $.ajax({ 
    type: "PUT", 
    url: "service/workouts", 
    data: "{\"name\":\"My json workout\"}}", 
    contentType: "application/json", 
    dataType: "text", 
    success: function(text) { 
      alert(text);
    }, 
    error: function(xhr) { 
      alert(xhr.responseText); 
    }
  });

  
//  jQuery.ajax({
//    type: "PUT",
//    url: "/service/workouts",
//    contentType: "application/json",
//    data: "{ \"foo\": \"bar\", \"fruit\": \"apple\" }"
//  });
  
  //jQuery.post("/service/workouts", {"workout":{"name":"My json workout"}}, "application/json" );
});
*/
