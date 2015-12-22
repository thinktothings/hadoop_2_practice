package example.net.yiup.models.common.bigdata.hadoop.hadoop2.mapreduce.maxtemperature;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MaxTemperatureWithCombiner {

	public static void main(String[] args)  throws Exception {
		
		if(args == null || args.length ==0){
			args = new String[2];
			args[0] = "hdfs://S0:9000/bigdata/examples/hadoop/hadoop2/input/ncdc/all";
			args[1] = "hdfs://S0:9000/bigdata/examples/hadoop/hadoop2/maxtemperature/output";
		}
		
		
		// TODO Auto-generated method stub
	    if (args.length != 2) {
	        System.err.println("Usage: MaxTemperatureWithCombiner <input path> " +
	            "<output path>");
	        System.exit(-1);
	      }
	      //作业
	      Job job = new Job();
	      job.setJarByClass(MaxTemperatureWithCombiner.class);
	      job.setJobName("Max temperature");

	      //可能添加多个输入路径(不仅可以是文件，而可以是文件夹,不会递归)
	      FileInputFormat.addInputPath(job, new Path(args[0]));
	      //只能输出一个输出路径,而且是不能存在
	      FileOutputFormat.setOutputPath(job, new Path(args[1]));
	      
	      job.setMapperClass(MaxTemperatureMapper.class);
	      /*[*/job.setCombinerClass(MaxTemperatureReducer.class)/*]*/;
	      job.setReducerClass(MaxTemperatureReducer.class);

	      //设置输出key类型
	      job.setOutputKeyClass(Text.class);
	      //设置输出value类型
	      job.setOutputValueClass(IntWritable.class);
	      //等待作业完成
	      System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}
