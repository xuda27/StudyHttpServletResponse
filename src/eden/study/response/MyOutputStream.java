package eden.study.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyOutputStream extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String text = "º¼ÖÝ";
		
		ServletOutputStream outputStream = resp.getOutputStream();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		byte[] texts = text.getBytes("utf-8");
		
		outputStream.write(texts);
	}
	
}
