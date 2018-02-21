/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentprogrammingexercises;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Peter
 */
public class ConcurrentProgrammingExercises2Counter {
    
    private static class Counter{
        //It depends alot on whether i is private or public,
        //If private, only the Counter class and other classes which has Counter Nested has access to i.
        //If public everybody has access to i.
        private int i = 0;
        private final AtomicInteger i2 = new AtomicInteger();
        
        private void increment(){
            i++;
        }
        
        private void decrement(){
            i--;
        }
    }
    
    
    public static void main(){
        
        Counter counter = new Counter();
        boolean bool = true;
        
        Thread thread1 = new Thread( () -> {
            for(int j = 0; j < 10000; j++){
                counter.increment();
                counter.i2.incrementAndGet();
            }
        });
        
        Thread thread2 = new Thread( () -> {
            for(int j = 0; j < 10000; j++){
                counter.increment();
                counter.i2.incrementAndGet();
            }
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch(InterruptedException e){
            
        }
        
        System.out.println(counter.i);
        System.out.println(counter.i2.get());
    }
}
