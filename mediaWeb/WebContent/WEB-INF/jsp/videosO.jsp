<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>TS Stream</title>
<link href="http://vjs.zencdn.net/4.2/video-js.css" rel="stylesheet">
<script src="http://vjs.zencdn.net/4.2/video.js"></script>
<style type="text/css">
  .vjs-default-skin { color: #8a4242; }
  .vjs-default-skin .vjs-control-bar { font-size: 96% }
</style>
</head>
<body>
<p>
</p>
<%
	String songName = (String) session.getAttribute("songs");
%>
<video id="my_video_1" class="video-js vjs-default-skin" preload="auto" width="640" height="480" data-setup="{}">
 <source src="https://www.youtube.com/watch?v=iEFh3GQ-ue4" type='video/mp4'>
</video>
</body>
</html>