package test.net.yiup.models.common.bigdata.hadoop.hadoop2.hdfs.file;

import java.io.IOException;
import java.net.URISyntaxException;

import net.yiup.models.common.bigdata.hadoop.hdfs.file.HadoopFile;

public class HadoopFileTest {

	/**
	 *  入口
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		testPrintSubDirsToHDFS();// 打印输出，当前目录的所有子目录
		
		
//		writeDirToHDFS();//只创建目录，暂未实现
//		testWriteFileToHDFS();//往文件写数据测试,新建文件
//		testPrintSubDirsToHDFS();// 打印输出，当前目录的所有子目录
//		printFileContent();//打印输出，文件的内容
//		testDownloadFileFromHDFS();//从hdfs下载文件，保存到本地
//		//testDownloadDirFromHDFS();//从hdfs下载目录，保存到本地（暂未实现）
//		testDelFileToHDFS();//删除文件,或目录
	}
	
	/**
	 * 往文件写数据测试,新建文件
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void testWriteFileToHDFS() throws IOException, URISyntaxException {
		String uri = "hdfs://S1:9000/test2/FileWrite";
		String content = "第一行数据\n第二行数据2\n第三行数据3\n";
		HadoopFile.writeFileToHDFS(uri, content);
	}
	
	/**
	 * 往文件写数据测试,新建文件
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void writeDirToHDFS() throws IOException, URISyntaxException {
		String uri = "hdfs://S0:9000/test2/aa/b/c";
		HadoopFile.writeDirsToHDFS(uri);
	}
	
	/**
	 * 打印输出，文件的内容
	 * @throws IOException
	 */
	public static void printFileContent() throws IOException {
		String uri="hdfs://S0:9000/test2/FileWrite";
		HadoopFile.printFileContentToHDFS(uri);
	}
	
	/**
	 * 打印输出，当前目录的所有子目录
	 * @throws IOException
	 */
	public static void testPrintSubDirsToHDFS() throws IOException {
		String uri="hdfs://S0:9000/";
		HadoopFile.printSubDirsToHDFS(uri);
	}
	
	/**
	 * 从hdfs下载文件，保存到本地
	 * @throws IOException
	 */
	public static void testDownloadFileFromHDFS() throws IOException {
		String uri="hdfs://S0:9000/test2/FileWrite";
		String localUri = "FileWrite" ;
		HadoopFile.downloadFileFromHDFS(uri,localUri);
	}
	/**
	 * 从hdfs下载目录，保存到本地（暂未实现）
	 * @throws IOException
	 */
	public static void testDownloadDirFromHDFS() throws IOException {
		String uri="hdfs://S0:9000/test2";
		String localUri = "test2" ;
		HadoopFile.downloadFileFromHDFS(uri,localUri);
	}

	


	/**
	 * 删除文件,或目录
	 * @throws IOException
	 */
	public static void testDelFileToHDFS() throws IOException {
		String uri="hdfs://S0:9000/test2/FileWrite";
		HadoopFile.delFileToHDFS(uri);
	}

}
