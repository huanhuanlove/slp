package com.slp.sizeInfo.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.slp.bean.SizeInfo;
import com.slp.service.SizeInfoService;
import com.slp.service.impl.SizeInfoServiceImpl;
import com.slp.util.Tool;

@WebServlet("/sizeInfo/sizeInfoUpd_inn")
public class SizeInfoUpd_inn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SizeInfoService ss = new SizeInfoServiceImpl();
		SizeInfo size = new SizeInfo();
		boolean flag = false;
		if(ServletFileUpload.isMultipartContent(request)) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					if(!item.isFormField()) {
						String name = Tool.getDate()+item.getName();
						size.setInfoImg(name);
						String path = getServletContext().getRealPath("/")+"newsImgs/";
						File f = new File(path);
						if(!f.exists()) {
							f.mkdirs();
						}
						File file = new File(path+name);
						try {
							item.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						String name = item.getFieldName();
						if(name.equals("infoName")) {
							String names = item.getString("utf-8");
							size.setName(names);
						}else if(name.equals("info")) {
							String content = item.getString("utf-8");
							size.setContent(content);
						}else if(name.equals("bid")) {
							String uid = item.getString("utf-8");
							int id = Integer.parseInt(uid);
							size.setId(id);
						}

					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			flag = ss.sizeInfoUpd_inn(size);
		}
		if(flag) {
			response.sendRedirect(request.getContextPath()+"/sizeInfo/sizeInfoList?currentPage=1");
		}


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
