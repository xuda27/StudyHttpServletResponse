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
		//��ȡҪ���صľ���·��
		String realPath = this.getServletContext().getRealPath("/images/��ֽ.jpg");
		
		//����Ҫ���ص��ļ����ļ���
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		
		// ����request��locale �ó����ܵı��룬���Ĳ���ϵͳͨ����gb2312 
		fileName = new String(fileName.getBytes("GB2312"),"ISO_8859_1");
		
		//������content-disposition������ʽ����Ӧͷ ,�����ļ���Ҫʹ��URLEncoder.encode(�ļ���,���뼯)�����б��� �����ļ�������������޷���ʾ�� 
//		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));//Ȼ��������������
		
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		
		//��ȡҪ�����ļ����ļ�������
		InputStream in = new FileInputStream(realPath);
		
		//��ȡ�����
		ServletOutputStream out = response.getOutputStream();
		
		//����������
		byte[] buffer = new byte[1024];
		
		int len = 0;
		
		//��in���뵽������
		while(( len = in.read(buffer) ) > 0){
		
		//ʹ��out��������������������ͻ���	
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
