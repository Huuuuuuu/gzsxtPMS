package com.gzsxt.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/fulservlet")
public class FileUpLoadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempDirectory = "f:/temp/";    //要在最后加上斜杠:temp/
		String fileDirectory="f:/afile/";
		try {
			int sizeThreshold = 1024 * 64;  //写满该大小的缓存后，存入硬盘中。
			File repositoryFile = new File(tempDirectory);
	
			FileItemFactory factory = new DiskFileItemFactory(sizeThreshold, repositoryFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(500 * 1024 * 1024); // set every upload file'size less than 500M
			List items = upload.parseRequest(req);   //这里开始执行上传

			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();   //FileItem就是表示一个表单域。
				
				if(item.isFormField()){ //isFormField方法用于判断FileItem是否代表一个普通表单域(即非file表单域)
					System.out.println("***"+item.getFieldName());	  //返回表单域的名字
					System.out.println("***"+item.getString("utf-8"));	 //返回表单域的值
				}else {
					String fieldName = item.getFieldName();  //获取表单域name属性的值
					String fileName = item.getName();     //返回该文件在客户机上的文件名。e.g: e:\dianying\\video\1.wmv
					System.out.println("*****"+fieldName);
					System.out.println("*****"+fileName);
					String fileType = fileName.substring(fileName.lastIndexOf("."));
					File uploadedFile = new File(fileDirectory+new Date().getTime()+fileType);
					item.write(uploadedFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
