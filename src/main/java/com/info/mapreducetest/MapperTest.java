package com.info.mapreducetest;// Imported com.info.mapreduce package.

import java.io.IOException;//Imported java input output classes for the exception in input out operation on that classes 
import org.apache.hadoop.io.IntWritable;// imported  IO operation, in it the "IntWritable" class package as java libraryes
import org.apache.hadoop.io.LongWritable;// imported  IO operation, in it the "LongWritable" class package as java libraryes
import org.apache.hadoop.io.Text;// Imported 'Text" type package in IO main package of hadoop as java libraryes
import org.apache.hadoop.mapreduce.Mapper;// Imported hadoop mappper library 

public class MapperTest extends Mapper<LongWritable,Text,Text,IntWritable>{ //Extended MpaperTest class from imorted Mapper package class
    IntWritable one=new IntWritable(1);//Object created for IntWritable 
    
    @Override
    public void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException{ //Map class with arguments and exception handling.
        
        String[] line=value.toString().split(" ");//Here spliting/ divide the all words as passing (" ")
        for(String word:line){       //Here getting the all words line by line found after split it with space 
            context.write(new Text(word.toLowerCase()), one); //Creating pair or key which will get pass to reducer
        }
        
    }
}
