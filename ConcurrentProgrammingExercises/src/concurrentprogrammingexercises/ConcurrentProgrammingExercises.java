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

    private static class Pair<K,T>{
        private K obj1;
        private T obj2;
        
        public Pair(K obj1, T obj2){
            setK(obj1);
            setT(obj2);
        }
        
        private void setK ( K obj1 ){
            this.obj1 = obj1;
        }
        
        public K getK (){
            return this.obj1;
        }
        
        private void setT ( T obj2 ){
            this.obj2 = obj2;
        }
        
        public T getT (){
            return this.obj2;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pair<String,Integer> p1 = new Pair<> ("Hello",1);
        Pair<String,Integer> p2 = new Pair<> (" world",2);
        Pair<String,Integer> p3 = new Pair<> ("!",3);
        Pair<String,Integer> p4 = new Pair<> ("!",6);
        
        List<Pair<String,Integer>> l = new LinkedList<>();
        
        l.add( p1 );
        l.add( p2 );
        l.add( p3 );
        l.add( p4 );
        
        readList( l );
        printSumOfList( l );
        printSumOfUniqueString(l, 2);
    }
    
    private static void readList(List<Pair<String,Integer>> l){
        String s = "";
        for(int i = 0; i < l.size(); i++){
            s = s + l.get(i).getK();
        }
        System.out.println(s);
    }
    
    private static void printSumOfList(List<Pair<String,Integer>> l){
        int sum = 0;
        for(int i = 0; i < l.size(); i++){
            sum = sum + l.get(i).getT();
        }
        System.out.println(sum);
    }
    
    private static void printSumOfUniqueString(List<Pair<String,Integer>> l, int li){
        int sum = 0;
        String s = l.get(li).getK();
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).getK().equals(s)){
                sum = sum + l.get(i).getT();
            }
        }
        System.out.println(sum);
    }
    
}
