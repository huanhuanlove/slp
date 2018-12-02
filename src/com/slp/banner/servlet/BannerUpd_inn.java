package com.slp.banner.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.slp.bean.Banner;
import com.slp.service.BannerService;
import com.slp.service.impl.BannerServiceImpl;
import com.slp.util.Tool;

import javafx.scene.control.Alert;


@WebServlet("/banner/bannerUpd_inn")
public class BannerUpd_inn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BannerService bs = new BannerServiceImpl();
		Banner banner = new Banner();
		boolean flag = false;

		//判断是否是表单文件
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					if(!item.isFormField()) {
						String name = Tool.getDate()+item.getName();
						banner.setBannerImg(name);
						String path = getServletContext().getRealPath("/")+"bannerImg/";
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
						if(name.equals("bannerName")) {
							String namebanner = item.getString("utf-8");
							banner.setName(namebanner);
						}else if(name.equals("urlImage")) {
							String url = item.getString("utf-8");
							banner.setUrl(url);
						}else if(name.equals("bid")) {
							String bid = item.getString("utf-8");
							int id = Integer.parseInt(bid);
							banner.setId(id);
						}

					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			flag = bs.updBanner_inn(banner);
		}
		if(flag) {
			request.getRequestDispatcher("/banner/bannerList?currentPage=1").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
