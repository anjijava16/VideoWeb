package com.acp.apps.form;

import java.sql.Timestamp;
import java.util.Date;

public class PlayListForm implements java.io.Serializable {

	private Integer id;
	private String playListStoreLocation;
	private Integer sizeOfItem;
	private String playListItemName;
	private Date playListAddedDate;
	private Timestamp playListAddedTime;
	private String typeOfPlayList;
	private String userAgents;
	private String userHeaders;
	private String updateBy;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getPlayListStoreLocation() {
		return playListStoreLocation;
	}

	public void setPlayListStoreLocation(String playListStoreLocation) {
		this.playListStoreLocation = playListStoreLocation;
	}

	public Integer getSizeOfItem() {
		return sizeOfItem;
	}

	public void setSizeOfItem(Integer sizeOfItem) {
		this.sizeOfItem = sizeOfItem;
	}

	public String getPlayListItemName() {
		return playListItemName;
	}

	public void setPlayListItemName(String playListItemName) {
		this.playListItemName = playListItemName;
	}

	public Date getPlayListAddedDate() {
		return playListAddedDate;
	}

	public void setPlayListAddedDate(Date playListAddedDate) {
		this.playListAddedDate = playListAddedDate;
	}

	public Timestamp getPlayListAddedTime() {
		return playListAddedTime;
	}

	public void setPlayListAddedTime(Timestamp playListAddedTime) {
		this.playListAddedTime = playListAddedTime;
	}

	public String getTypeOfPlayList() {
		return typeOfPlayList;
	}

	public void setTypeOfPlayList(String typeOfPlayList) {
		this.typeOfPlayList = typeOfPlayList;
	}

	public String getUserAgents() {
		return userAgents;
	}

	public void setUserAgents(String userAgents) {
		this.userAgents = userAgents;
	}

	public String getUserHeaders() {
		return userHeaders;
	}

	public void setUserHeaders(String userHeaders) {
		this.userHeaders = userHeaders;
	}

	@Override
	public String toString() {
		return "PlayListForm [playListStoreLocation=" + playListStoreLocation
				+ ", sizeOfItem=" + sizeOfItem + ", playListItemName="
				+ playListItemName + ", playListAddedDate=" + playListAddedDate
				+ ", playListAddedTime=" + playListAddedTime
				+ ", typeOfPlayList=" + typeOfPlayList + ", userAgents="
				+ userAgents + ", userHeaders=" + userHeaders + "]";
	}

}
