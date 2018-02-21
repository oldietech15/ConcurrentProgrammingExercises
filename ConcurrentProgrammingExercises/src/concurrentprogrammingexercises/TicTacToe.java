/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentprogrammingexercises;

import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class TicTacToe {
    
    private static ThreadLocal<ArrayList<ArrayList<Integer>>> board = 
            new ThreadLocal<ArrayList<ArrayList<Integer>>>(){
        
                protected ArrayList<ArrayList<Integer>> initialValue(){
                    
                    ArrayList<Integer> j = new ArrayList<>();
                    j.add(0);
                    j.add(0);
                    j.add(0);
                    
                    ArrayList<ArrayList<Integer>> i = 
                            new ArrayList<>();
                    i.add(j);
                    i.add(j);
                    i.add(j);
                    
                    return i;
                            }
    };
    
    
    public static void main(){
        
        Object obj = new Object();
        
        Thread t1 = new Thread( () -> {
            synchronized (obj){
                placeCross();
            }
        });
        
        Thread t2 = new Thread( () -> {
            synchronized (obj){
                placeCircle();
            }
        });
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){ }
        
        
    }
    
    private static void placeCross(){
        int i = (int) (Math.random() * ((9 - 1) + 1));
        System.out.println(i);
        int row = i/3;
        int column = i%3;
        System.out.println(row);
        
        if(board.get().get(row).get(column) == 0){
            board.get().get(row).set(column, 1);
        } else {
            placeCross();
        }
        
    }
    
    private static void placeCircle(){
        int i = (int) (Math.random() * ((9 - 1) + 1));
        System.out.println(i);
        int row = i/3;
        System.out.println(row);
    }
    
}
