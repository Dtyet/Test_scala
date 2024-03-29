package wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import java.io.IOException;
public class Mywc {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration(true);
        Job job = Job.getInstance(conf);
        job.setJarByClass(Mywc.class);

      // Specify various job-specific parameters
        job.setJobName("myjob");
//        job.setInputPath(new Path("in"));
//        job.setOutputPath(new Path("out"));

        Path input = new Path("");
        FileInputFormat.addInputPath(job,input);

        Path ouput = new Path("");
        FileOutputFormat.setOutputPath(job,ouput);


        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setReducerClass(MyReducer.class);

     // Submit the job, then poll for progress until the job is complete
        job.waitForCompletion(true);
    }
}
