package net.yiup.models.common.bigdata.hadoop.hdfs.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HadoopFile {
	
	/**
	 * 打印输出，文件的内容
	 * @param uri
	 * @throws IOException
	 */
	public static void printFileContentToHDFS(String uri) throws IOException{
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		InputStream in = null;
		in = fs.open(new Path(uri));
		IOUtils.copyBytes(in, System.out, 4096, false);
		
	}
	
	/**
	 * 从hdfs下载文件，保存到本地
	 * @param uri 
	 * @param localUil
	 * @throws IOException
	 */
	public static void downloadFileFromHDFS(String uri,String localUil) throws IOException{
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
	    // 读出流
		FSDataInputStream  fSDataInputStream  = fs.open(new Path(uri));
		// 写入流
        OutputStream outputStream = new FileOutputStream(localUil);
		IOUtils.copyBytes(fSDataInputStream, outputStream, 4096, false);
		
	}

	/**
	 * 查看目录,打印目录信息
	 * 
	 * @param uri
	 * @throws IOException
	 * demo:
         String uri = "hdfs://node1:9000/opt";
		 HadoopFile.subDirsToHDFS(uri);	 
	 */
	public static void printSubDirsToHDFS(String uri) throws IOException

	{

		System.out.println("目录下的子文件或文件夹");
		Configuration conf = new Configuration();

		FileSystem fs = FileSystem.get(URI.create(uri), conf);

		Path path = new Path(uri);

		FileStatus[] status = fs.listStatus(path);

		// 方法1

		// for(FileStatus f: status)
		//
		// {
		//
		// System.out.println(f.getPath().toString());
		//
		// }

		// 方法2

		Path[] listedPaths = FileUtil.stat2Paths(status);

		for (Path p : listedPaths) {

			System.out.println(p.toString());

		}

	}

	/**
	 *  新建目录
	 * @param uri
	 * @throws IOException
	 */
	public static void writeDirsToHDFS(String uri) throws IOException{
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);

		Path path = new Path(uri);

		
		fs.mkdirs(path); // 创建目录
		
	}
	/**
	 * 在指定位置新建一个文件，并写入数据
	 * 
	 * @param uri
	 * @param content
	 * @throws IOException
	 * @throws URISyntaxException
	 *             demo: String fileWrite = "hdfs://node1:9000/test/FileWrite";
	 *             String words = "中国人民s is to write into file!\n";
	 *             HadoopFile.writeFileToHDFS(fileWrite, words);
	 */
	public static void writeFileToHDFS(String uri, String content) throws IOException, URISyntaxException

	{

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);

		Path path = new Path(uri);

		FSDataOutputStream out = fs.create(path); // 创建文件

		// 两个方法都用于文件写入，好像一般多使用后者

		// out.writeBytes(words);

		out.write(content.getBytes("UTF-8"));

		out.close();

		// 如果是要从输入流中写入，或是从一个文件写到另一个文件（此时用输入流打开已有内容的文件）

		// 可以使用如下IOUtils.copyBytes方法。

		// FSDataInputStream in = fs.open(new Path(args[0]));

		// IOUtils.copyBytes(in, out, 4096, true) //4096为一次复制块大小，true表示复制完成后关闭流

	}

	/**
	 * 文件删除
	 * @param uri
	 * @return
	 * @throws IOException
	 * demo:
		fileWrite = "hdfs://node1:9000/test2";
		delFile(fileWrite);	 
	 */
	public static boolean delFileToHDFS(String uri) throws IOException {
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(URI.create(uri), conf);
		hdfs.delete(new Path(uri), true);
		return true;
	}

}
