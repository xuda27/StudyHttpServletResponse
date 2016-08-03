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
		//1.��ȡ�ļ�����ʵ·��
		String realPath = this.getServletContext().getRealPath("/images/��ֽ.jpg");
		
		//2.��ȡ�ļ���
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		
		 //����content-disposition��Ӧͷ��������������ص���ʽ���ļ��������ļ���Ҫʹ��URLEncoder.encode�������б���
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		//���ַ�ʽ��FireFoxû���ô� chrome����  IEҲ����
		
		//3.��ȡPrintWriter
		PrintWriter out = response.getWriter();
		
		//4.��ȡ�ļ���FileReader
		FileReader  in = new FileReader (realPath);
		
		//5.��ȡ���ݵ���������
		char [] buffer = new char[1024];
		int len=0;
		while( (len=in.read(buffer))>0 ){
		//6.��������PrintWriter��ʽ���ַ�����������ͻ���
			out.write(buffer, 0, len);
		}
		//�ַ����ļ������� �޷��򿪡�
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
