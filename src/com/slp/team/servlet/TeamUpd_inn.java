package com.slp.team.servlet;

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

import com.slp.bean.Team;
import com.slp.service.TeamService;
import com.slp.service.impl.TeamServiceImpl;
import com.slp.util.Tool;

@WebServlet("/team/teamUpd_inn")
public class TeamUpd_inn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamService ts = new TeamServiceImpl();
		Team team = new Team();
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
System.out.println(name);
						team.setPhoto(name);
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
						if(name.equals("tName")) {
							String tName = item.getString("utf-8");
							team.setName(tName);
						}else if(name.equals("tjob")) {
							String tjob = item.getString("utf-8");
							team.setPosition(tjob);
						}else if(name.equals("bid")) {
							int id = Integer.parseInt(item.getString("utf-8"));
							team.setId(id);
						}
					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			flag = ts.teamUpd_inn(team);
		}
		if(flag) {
			request.getRequestDispatcher("/team/teamList?currentPage=1").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
