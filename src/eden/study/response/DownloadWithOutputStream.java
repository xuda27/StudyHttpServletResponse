package eden.study.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadWithOutputStream extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		//获取要下载的绝对路径
		String realPath = this.getServletContext().getRealPath("/images/壁纸.jpg");
		
		//定义要下载的文件的文件名
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		
		// 根据request的locale 得出可能的编码，中文操作系统通常是gb2312 
		fileName = new String(fileName.getBytes("GB2312"),"ISO_8859_1");
		
		//设置以content-disposition下载形式的响应头 ,中文文件名要使用URLEncoder.encode(文件名,编码集)来进行编码 否则文件名会乱码或者无法显示。 
//		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));//然而这样还是乱码
		
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		
		//获取要下载文件的文件输入流
		InputStream in = new FileInputStream(realPath);
		
		//获取输出流
		ServletOutputStream out = response.getOutputStream();
		
		//创建缓存区
		byte[] buffer = new byte[1024];
		
		int len = 0;
		
		//将in读入到缓冲区
		while(( len = in.read(buffer) ) > 0){
		
		//使用out将缓冲区的数据输出到客户端	
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
