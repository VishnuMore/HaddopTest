package com.info.mapreducetest;// Imported com.info.mapreduce package.

import java.io.IOException;//Imported java input output classes for the exception in input out operation on that classes.
import org.apache.hadoop.fs.Path;//Imported appache hadoop file system librarys package
import org.apache.hadoop.io.IntWritable;// imported  IO operation, in it the "IntWritable" class package 
import org.apache.hadoop.io.Text;// Imported 'Text" type package in IO main package of hadoop
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;//Imported package of mapreduce for input file format 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;// Imported package of mapreduce for output file format
import org.apache.hadoop.mapreduce.Job;// Imported package of mapreduce job process

public class Driver { //defined 1st class as public 
    
    public static void main(String... args) throws IOException, InterruptedException, ClassNotFoundException{  
        //Defined Main() method with do not return as "Void" and  defined 3 types of exception to ctah/ handale it.
        if(args.length<2){//Here checking length of arguments less than 2
            System.out.println("Usage is [generic option] <input path> <output path>");
            System.exit(1); 
        } 
        Job job=new Job();// Object created for job class
        
        job.setJarByClass(Driver.class);// using this  we are sending Driver.class jar to map & reducer to perform operation on it.
        job.setJobName("wordCount");//Here we are adding name to the job
        
        FileInputFormat.setInputPaths(job, new Path(args[0]));//The input file path seting which given at the time of  input 
        FileOutputFormat.setOutputPath(job, new Path(args[1]));//Setting output file path ,as where to get output file
        
        job.setMapperClass(MapperTest.class); //Setting which mapper get called for this job to get processed.
        job.setReducerClass(ReducerTest.class);// Setting which reducer get called and used for this job get processed.
        
        job.setOutputKeyClass(Text.class);//Setting data type of key and in this job the key is string so we are setting .text data type
        job.setOutputValueClass(IntWritable.class);// setting the data type of output get send  , here we are setting to IntWritable
        
        System.exit(job.waitForCompletion(true)?0:1);// defining here to when the system get exit with job get compleated or not, if job get compleated then true value get checking
        
    }
}
