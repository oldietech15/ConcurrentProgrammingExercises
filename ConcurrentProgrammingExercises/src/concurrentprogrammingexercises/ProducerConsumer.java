/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentprogrammingexercises;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.Random;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class ProducerConsumer
{
	private static class Product {
		private final String name;
		private final String attributes;
		
		public Product( String name, String attributes )
		{
			this.name = name;
			this.attributes = attributes;
		}
		
		public String toString()
		{
			return name + " : " + attributes;
		}
	}
	
        private static boolean consumeAhead = false;
        
	private static final Deque<Product> THE_LIST = new LinkedList<>();
	
	private static void produce( Deque< Product > list )
	{
		// int stream range to add water bottles and flower bouquets
            //for loop instead of int stream.
            synchronized(list){
                Random rand = new Random();
                int randInt = rand.nextInt(10000);
                for(int i = 1; i <= randInt; i++){
                    list.add( new Product( "Water bottle " + i, "Fresh" ) );
		    list.add( new Product( "Flower bouquet " + i, "Roses" ) );
                }
                consumeAhead = true;
            }
            
		
	}
	
	private static void consume( Deque< Product > list )
	{
            while(consumeAhead){
            
                synchronized(list){
                    for (Product p : list) {
                        System.out.println(p.toString());
                    }
                }
            } 
            if(!consumeAhead){ consume( list ); }
	}
	
	public static void main()
	{
            //produce( THE_LIST );
            //consume( THE_LIST );
            
            Thread p1 = new Thread ( () -> {
                
                produce( THE_LIST );
		
            });
		
            Thread c1 = new Thread ( () -> {
                
                consume( THE_LIST );
                
            });
            
            p1.start();
            c1.start();
            try{
                
                p1.join();
                c1.join();
                
            } catch (InterruptedException e){
                
            }
            
            System.out.println(THE_LIST.size()/2);
	}
}