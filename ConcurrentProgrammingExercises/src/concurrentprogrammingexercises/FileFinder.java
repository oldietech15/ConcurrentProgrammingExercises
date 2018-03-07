/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentprogrammingexercises;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Peter
 */
public class FileFinder {
    
    private static LinkedList<File> list = new LinkedList<>();
    private static int cores = Runtime.getRuntime().availableProcessors() + 1;
    private static ExecutorService fileExecutor = Executors.newFixedThreadPool(cores);
    
    
    public static void main(String[] args){
        File startFile = new File("C:\\Users\\Peter\\Desktop\\Start");
        
        
        CountDownLatch myLatch = new CountDownLatch(startFile.listFiles().length);
        fileExecutor.submit( () -> fileFinder(startFile));
        //fileFinder(startFile);
        while(myLatch.getCount() > 0){
            if(!fileExecutor.isShutdown()){
                fileExecutor.shutdown();
            }
        try{
            fileExecutor.awaitTermination(10, TimeUnit.SECONDS);
        } catch(InterruptedException e){}
        }
        for(File fileName : list){
            System.out.println(fileName.toString());
        }
        
    }
    
    private static void fileFinder(File folder){
        for(File file : folder.listFiles()){
            if(file.isDirectory()){
                
                fileExecutor.submit( () -> fileFinder(file));
                /*Thread thread = new Thread( () -> {
                    fileFinder(file);
                });
                thread.start();
                try{
                    thread.join();
                } catch (InterruptedException e){
                    
                }*/
                
                
            } 
            else {
                list.add(file);
            }
        }
    }
    
}
