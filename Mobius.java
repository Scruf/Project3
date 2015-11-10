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

public class Mobius implements Puzzle {
	//@param goal is a goal to be achieved
	public static int goal = 0;
	//@param start is a starting point from where the countdown will go
	public static int start = 0;
	//@param range is a rane of numbers on which search will be perform
	public static int range = 0;
	/*
        @param goal is a goal to be returned
        @return will return the the goal

    */
@Override
	public int getGoal() {
		return goal;
	}
	/*
        @param config the incomingconfig
        @return the collection of neighbor configs

    */
@Override
	public java.util.ArrayList < java.lang.Integer > getNeighbors(int config) {
		if (config < 1) return null;
		if (config > range) return null;
		ArrayList < Integer > neighbor = new ArrayList < Integer > ();
		if (config == range) neighbor.add(1);
		if (config == 1) neighbor.add(range);
		else {
			int leftNeighbor = config - 1;
		
			int rightNeighbor = config + 1;
			neighbor.add(leftNeighbor);
			neighbor.add(rightNeighbor);
		}
		return neighbor;
	}
	/*
        @param start the starting config
        @return getting the starting config for this puzzle

    */
@Override
	public int getStart() {
		return start;
	}
	public static void main(String[] args) {
            try{
            if(args.length<3)
                {
                    System.out.println("Usage: java Mobius range start goal");
                    return;
                }
            }
            catch(ArrayIndexOutOfBoundsException ax){
                  System.out.println("Usage: java Mobius range start goal");
            }
		//@param mob creating a Mobius project
		Mobius mob = new Mobius();
		//@param range setting range to a first line argument
		range = Integer.parseInt(args[0]);
		//@param start setting start config to a second line argument
		start = Integer.parseInt(args[1]);
		//@param goal setting the goal config for this puzlle to a third line argument
		goal = Integer.parseInt(args[2]);
		//@param solve creating a solve object
		Solver solve = new Solver();
		//@param list copying the return value of solve method to list
		ArrayList < Integer > list = solve.solve(mob);
		//Iterating over the list and displaying the content of the list
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Step " + i + ":" + list.get(i));
		}


	}
}
