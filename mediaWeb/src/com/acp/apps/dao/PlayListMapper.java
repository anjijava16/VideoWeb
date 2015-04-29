package com.acp.apps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.acp.apps.form.PlayListForm;

public class PlayListMapper implements RowMapper<PlayListForm> {

	public PlayListForm mapRow(ResultSet rs, int arg1) throws SQLException {
		PlayListForm pForm=new PlayListForm();
		 pForm.setId(rs.getInt("ID"));
         pForm.setPlayListStoreLocation(rs.getString("LOCATION_STORE_PLACE"));
         pForm.setPlayListItemName(rs.getString("ITEM_NAME"));
         pForm.setPlayListAddedDate(rs.getDate("addedDate"));
         pForm.setPlayListAddedTime(rs.getTimestamp("addedTime"));
         pForm.setUpdateBy(rs.getString("updatedBy"));
         pForm.setTypeOfPlayList(rs.getString("type_Of"));
		return pForm;
	}

}
