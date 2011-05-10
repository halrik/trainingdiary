package no.rih.rest.bean;

import java.util.List;

public class WorkoutList {

	private int count;
	private List<Workout> workouts;

	public WorkoutList() {}
	
	public WorkoutList(List<Workout> workouts) {
		this.workouts = workouts;
		this.count = workouts.size();
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public List<Workout> getworkouts() {
		return workouts;
	}
	
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}
}