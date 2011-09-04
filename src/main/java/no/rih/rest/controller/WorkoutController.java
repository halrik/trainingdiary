package no.rih.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.rih.dao.DynamicModelDao;
import no.rih.rest.bean.Workout;
import no.rih.rest.bean.WorkoutList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {
	
	private final static Logger log = Logger.getLogger(WorkoutController.class);
	
	@Autowired
	private DynamicModelDao dynamicModelDao;
		
	/*
	@RequestMapping(method=RequestMethod.GET, value="/workoutxml/{id}")
	public ModelAndView getWorkoutXML(@PathVariable String id) {
		log.debug("getWorkoutXML()");
		Workout w = new Workout();
		w.setName("My xml workout");
		return new ModelAndView("workouts", "object", w);
	}
	*/
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody WorkoutList getAllWorkouts() {
		log.debug("getWorkout()");
		Workout w = new Workout();
		w.setName("My json workout");
		
		List<Workout> workouts = new ArrayList<Workout>();
		workouts.add(w);
		workouts.add(w);
		
        log.debug("mongo result: " + dynamicModelDao.findAll());
		
		return new WorkoutList(workouts);
	}

	
	@RequestMapping(method=RequestMethod.GET, value="/{workoutId}")
	public @ResponseBody Workout getWorkout(@PathVariable String workoutId) {
		log.debug("getWorkout()");
		Workout w = new Workout();
		w.setName("My json workout");
		return w;
	}
	
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Workout updateWorkout(@RequestBody Workout workout) throws IOException {
        log.debug("updateWorkout(): " + workout.getName());
        
        log.debug(dynamicModelDao.findAll());
        
        return workout;
    }

}