/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Egor Kozitski
 */
public class Solver {
	public ArrayList < Integer > solve(Puzzle puzzle) {
		//create an empty queue as an ArrayList<ArrayList<Integer>>
		ArrayList < ArrayList < Integer >> queue = new ArrayList < ArrayList < Integer >> ();
		//create an ArrayList<Integer> of one element from the starting config and enqueue it
		ArrayList < Integer > element = new ArrayList < Integer > (1);
		element.add(puzzle.getStart());
		queue.add(element);
		//set found to whether the starting config is the goal config, or not
		boolean found = false;
		if (puzzle.getStart() == puzzle.getGoal()) found = true;
		//while the queue is not empty and not found: 
		while (!queue.isEmpty() && !found) {
			// dequeue the front element from the queue and set it to current
			element = queue.get(0);
			queue.remove(0);
			// for each neighbor of the last element in current:
			for (Integer i: puzzle.getNeighbors(element.get(element.size() - 1))) {
				//create an ArrayList<Integer> for the next config and make it a copy of current
				ArrayList < Integer > nextConfig = new ArrayList(element);
				//append the neighbor to the next config
				nextConfig.add(i);
				//if the next config is the goal:
				if (i == puzzle.getGoal()) {
					element = nextConfig;
					found = true;
					break;
				}
				// enqueue the next config
				else {
					queue.add(nextConfig);
				}
			}

		}
		//if found:
		if (found)
		//current is the solution
		return element;
		else
		//there is no solution
		return null;
	}
}