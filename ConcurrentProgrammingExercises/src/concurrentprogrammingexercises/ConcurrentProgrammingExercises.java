/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentprogrammingexercises;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class ConcurrentProgrammingExercises {

    private class Pair<K,T>{
        private K obj1;
        private T obj2;
        
        private void setK ( K obj1 ){
            this.obj1 = obj1;
        }
        
        private K getK (){
            return this.obj1;
        }
        
        private void setT ( T obj2 ){
            this.obj2 = obj2;
        }
        
        private T getT (){
            return this.obj2;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Pair<String,Integer>> l;
        l = new LinkedList<>();
        
    }
    
}
