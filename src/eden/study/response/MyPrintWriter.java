package eden.study.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPrintWriter extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = "杭州";
		//服务器向浏览器发送的数据以utf-8编码
		response.setCharacterEncoding("utf-8");//必须要放在前面，否则浏览器还是乱码
		
		PrintWriter out = response.getWriter();
		
		//通过设置响应头来控制浏览器以utf-8编码来显示数据
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//使用HTML语言里面的<meta>标签来控制浏览器行为，模拟通过设置响应头控制浏览器行为
		out.print("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		
		out.write(text);
		
		//PrintWriter相比于OutputStream 省去字符转换为字节数组的过程
		
		//writer() 与 print() 的区别 
		//print方法可以将各种类型的数据转换成字符串的形式输出。
		//重载的write方法只能输出字符、字符数组、字符串等与字符相关的数据。
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
