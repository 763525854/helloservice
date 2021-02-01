package helloservice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class FileController {
	@RequestMapping(value = "/download")
	@ResponseBody
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = request.getParameter("fileName");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String path = "";
		if (System.getProperty("file.separator").equals("/")) {
			path = "/opt/yxt/projects/fs_api/WEB-INF/classes/file/wav/";
		} else {
			path = "D:/SvnProject/java/fs_api_branch/src/main/resources/file/wav/";
			path = "F:/迅雷下载/";
		}
		String downLoadPath = path + fileName;
		System.out.println(downLoadPath);
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setContentType("application/force-download");//下载不打开
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}
}
