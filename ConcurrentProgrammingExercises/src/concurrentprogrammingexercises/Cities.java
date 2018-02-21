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
public class Cities {

    private static class CityList {
        
        private static ThreadLocal<ArrayList<String>> list = new ThreadLocal<ArrayList<String>>(){
            protected ArrayList<String> initialValue(){
                return new ArrayList<String>();
            }
        };
        
    }

    public static void main() {
        
        CityList cl = new CityList();
        
        cl.list.get().add("Copenhagen");
        cl.list.get().add("Odense");
        cl.list.get().add("Aarhus");
        cl.list.get().add("Aalborg");
        
        Thread t1 = new Thread( () -> {
            cl.list.get().add("Silkeborg");
            cl.list.get().add("Kolding");
            cl.list.get().add("Holbæk");
            cl.list.get().add("Slagelse");
        });
        
        Thread t2 = new Thread( () -> {
            cl.list.get().add("Næstved");
            cl.list.get().add("Ishøj");
            cl.list.get().add("Kalundborg");
            cl.list.get().add("Svendborg");
        });
        
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){
            
        }
        
        cl.list.get().forEach((s) -> {
            System.out.println(s);
        });
        
    }

}
