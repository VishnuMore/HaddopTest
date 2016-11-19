package com.info.mapreducetest;// Imported com.info.mapreduce package.

import java.io.IOException;//Imported java input output classes for the exception in input out operation on that classes.
import org.apache.hadoop.io.IntWritable;// imported  IO operation, in it the "IntWritable" class package
import org.apache.hadoop.io.Text;// Imported 'Text" type package in IO main package of hadoop
import org.apache.hadoop.mapreduce.Reducer;// Imported hadoop reducer library

public class ReducerTest extends Reducer<Text,IntWritable,Text,IntWritable>{//Defned ReducerTest class which is extended from Reducer class with parameters, which is imported hadoop java library class
    
    @Override
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{// Here we are overriding reduce method of reducer class
        int count=0; //Intilitising count variable with 0 value
        for(IntWritable one:values){//Defining for condition to check the values 
            count=one.get()+count; // Here we are incrimenting count of words as we found multiple times
        }
        context.write(key, new IntWritable(count));//Now lastly of reducer w are creating pair of key and value to pass it to result.
    }
    
}
