package example.net.yiup.models.common.bigdata.hadoop.hadoop2.mapreduce.wordcount;

import java.io.IOException;
import java.net.URISyntaxException;

import net.yiup.models.common.bigdata.hadoop.hdfs.file.HadoopFile;

/**
 * WordCount 程序，生成测试数据
 * @author hadoop
 *
 */
public class WordCountDataExample {

	public static void main(String[] args) throws IOException, URISyntaxException {
		testWriteFileToHDFS();
	}
	
	/**
	 * 往文件写数据测试,新建文件
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void testWriteFileToHDFS() throws IOException, URISyntaxException {
		String uri = "hdfs://S0:9000/bigdata/examples/hadoop/hadoop2/wordcount/input/file01";
		String content = "Hello World Bye World Hello Bye";
		HadoopFile.writeFileToHDFS(uri, content);
		
		uri = "hdfs://S0:9000/bigdata/examples/hadoop/hadoop2/wordcount/input/file02";
	    content = "Hello Hadoop Goodbye Hadoop";
		HadoopFile.writeFileToHDFS(uri, content);
	}
}
