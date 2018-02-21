/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentprogrammingexercises;

/**
 *
 * @author Peter
 */
public final class ImmutableInteger {
    
    private static final int i = 42;
    
    private ImmutableInteger(){
        
    }
    
    public static int getI(){
        return i;
    }
}
