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
		String text = "����";
		//����������������͵�������utf-8����
		response.setCharacterEncoding("utf-8");//����Ҫ����ǰ�棬�����������������
		
		PrintWriter out = response.getWriter();
		
		//ͨ��������Ӧͷ�������������utf-8��������ʾ����
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//ʹ��HTML���������<meta>��ǩ�������������Ϊ��ģ��ͨ��������Ӧͷ�����������Ϊ
		out.print("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		
		out.write(text);
		
		//PrintWriter�����OutputStream ʡȥ�ַ�ת��Ϊ�ֽ�����Ĺ���
		
		//writer() �� print() ������ 
		//print�������Խ��������͵�����ת�����ַ�������ʽ�����
		//���ص�write����ֻ������ַ����ַ����顢�ַ��������ַ���ص����ݡ�
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
