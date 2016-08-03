package eden.study.response;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadWithPrintWriter extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取文件的真实路径
		String realPath = this.getServletContext().getRealPath("/images/壁纸.jpg");
		
		//2.获取文件名
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		
		 //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		//这种方式在FireFox没有用处 chrome可以  IE也可以
		
		//3.获取PrintWriter
		PrintWriter out = response.getWriter();
		
		//4.获取文件的FileReader
		FileReader  in = new FileReader (realPath);
		
		//5.读取数据到缓存区里
		char [] buffer = new char[1024];
		int len=0;
		while( (len=in.read(buffer))>0 ){
		//6.将数据以PrintWriter方式（字符流）输出到客户端
			out.write(buffer, 0, len);
		}
		//字符流文件发生损坏 无法打开。
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
