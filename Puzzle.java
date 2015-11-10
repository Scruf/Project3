/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Egor Kozitski
 */
public interface Puzzle {
    public int getGoal();
    public java.util.ArrayList<java.lang.Integer> getNeighbors(int config);
    public int getStart();
}
