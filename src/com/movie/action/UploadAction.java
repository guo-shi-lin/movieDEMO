package com.movie.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadAction {
	@RequestMapping("/doUpload")
	// 绑定参数
	public void doUpload(@RequestParam MultipartFile myfile, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		if (myfile.isEmpty()) {
			System.out.println("文件不存在");
		} else {
			String oldName = myfile.getOriginalFilename();// 获得原文件名
															// abc.cde.xzy.jsp
			Date date = new Date();
			String newName = date.getTime() + oldName.substring(oldName.lastIndexOf("."));
			// 获得upload文件夹的物理路径。
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			System.out.println("realPath:"+realPath);
			// 将上传的文件流保存为文件
			FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, newName));

			StringBuffer jsonString = new StringBuffer();
			jsonString.append("{\"error\":0,\"url\":\"");
			jsonString.append(request.getContextPath() + "/upload/" + newName);
			jsonString.append("\"}");
			out.println(jsonString);
			out.flush();// 清除
			out.close();

		}
	}
}
