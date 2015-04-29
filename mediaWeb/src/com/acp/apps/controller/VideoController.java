package com.acp.apps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acp.apps.dao.VideosPlaylistDaoImpl;
import com.acp.apps.form.PlayListForm;

@Controller
public class VideoController {

@RequestMapping("video.action")
public ModelAndView viewVideo(HttpServletRequest request,HttpServletResponse res){
	List<PlayListForm> playList=VideosPlaylistDaoImpl.viewAllVideos();
	for(PlayListForm pForm:playList){
		request.getSession().setAttribute("songs", pForm.getPlayListStoreLocation());
	}
	res.setContentType("video/mp4");
	return new ModelAndView("videos");
	
}

@RequestMapping("videosList.action")
public ModelAndView viewVideos(HttpServletRequest request,HttpServletResponse res){
	List<PlayListForm> playList=VideosPlaylistDaoImpl.viewAllVideos();
	res.setContentType("video/mp4");
	request.getSession().setAttribute("listOfSongs", playList);
	return new ModelAndView("listOfSongs");
	
}

@RequestMapping("displayList.action")
public ModelAndView displayVideos(HttpServletRequest request,HttpServletResponse res){
	List<PlayListForm> playList=VideosPlaylistDaoImpl.viewAllVideos();
	res.setContentType("video/mp4");
	request.getSession().setAttribute("listOfDisplaySongs", playList);
	return new ModelAndView("selectSongs");
	
}

@RequestMapping("selectVideo.action")
public ModelAndView selectVideo(HttpServletRequest request,HttpServletResponse res){
	List<PlayListForm> playList=VideosPlaylistDaoImpl.selectVideo(Integer.parseInt(request.getParameter("songId")));
	for(PlayListForm pForm:playList){
		request.getSession().setAttribute("pSelectSongForm", pForm);
	}
	return new ModelAndView("displaySelectSong");
}
}
