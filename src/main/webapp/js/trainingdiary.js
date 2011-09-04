var trainingDiary;

jQuery(document).ready( function() {
	trainingDiary = new TrainingDiary();

	jQuery.ajaxSetup({
		contentType: "application/json"
	});
});

function TrainingDiary() {

	this.listWorkouts = function() {
		jQuery.ajax({ 
			type: "GET", 
			url: "service/workouts", 
			contentType: "application/json", 
			dataType: "text", 
			success: function(text) { 
				alert(text);
			}, 
			error: function(xhr) { 
				alert(xhr.responseText); 
			}
		});		
	};
	
	
	this.updateWorkout = function() {
		jQuery.ajax({ 
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
	};	
};