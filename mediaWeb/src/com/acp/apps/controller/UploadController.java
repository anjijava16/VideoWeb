package com.acp.apps.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acp.apps.dao.VideosPlaylistDaoImpl;
import com.acp.apps.form.PlayListForm;
import com.acp.apps.utils.RandomStringGenerator;

@Controller
public class UploadController {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY_DB = "http://localhost:3030/security/";
	private final String UPLOAD_DIRECTORY = "D:\\Tomcat 6.0\\webapps\\ROOT\\security\\";
	@RequestMapping("upload.action")
	public String doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PlayListForm pForm = new PlayListForm();
		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				File file;
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						file = new File((UPLOAD_DIRECTORY + File.separator + name));
						int startIndex=name.indexOf(".");
						String type=name.substring(startIndex+1, name.length());
                        String generateKey=RandomStringGenerator.getGenerateKey(8);
						item.write(new File(UPLOAD_DIRECTORY + File.separator + generateKey+"."+type));
						pForm.setPlayListItemName(name);
						pForm.setPlayListStoreLocation(UPLOAD_DIRECTORY_DB + generateKey+"."+type);
						int size = (int) file.length();
						pForm.setSizeOfItem(size);
						pForm.setTypeOfPlayList(type);
					}
					
					VideosPlaylistDaoImpl.insertPlayList(pForm);
				}

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				ex.printStackTrace();
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}

		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
		// request.getRequestDispatcher("/result.jsp").forward(request,
		// response);
		return "homePage";
	}

}
