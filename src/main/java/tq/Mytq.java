package tq;




import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class Mytq {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration(true);
        Job job = Job.getInstance(conf);
}
}
