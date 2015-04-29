package com.acp.apps.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class IwinnerStartupServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = config.getServletContext();
		InputStream iStream = context.getResourceAsStream(context
				.getInitParameter("log4j.properties"));

		Properties properties = new Properties();
		try {
			properties.load(iStream);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		PropertyConfigurator.configure(properties);
		Logger logger = Logger.getLogger(IwinnerStartupServlet.class);
		logger.info("Logger main class");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		execute(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		execute(req, resp);

	}

	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
}
