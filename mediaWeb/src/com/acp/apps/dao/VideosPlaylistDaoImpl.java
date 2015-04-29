package com.acp.apps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.acp.apps.form.PlayListForm;

public class VideosPlaylistDaoImpl {
	private static DataSource l_ds = null;
	private Logger logger = Logger.getLogger(VideosPlaylistDaoImpl.class);

	public void setDataSource(DataSource ds) {
		this.l_ds = ds;
	}
	public static void insertPlayList(PlayListForm pListForm){
      boolean insertValue=savePlayList(pListForm);
	}		
		public static boolean savePlayList(final PlayListForm pForm){
			JdbcTemplate jdbcTemplate = new JdbcTemplate(l_ds);
		     String query="INSERT INTO playlist(LOCATION_STORE_PLACE,SIZE_OF_ITEM,ITEM_NAME,addedDate,addedTime,updatedBy,type_Of,user_agents,user_header)VALUES(?,?,?,?,?,?,?,?,?)";
		     System.out.println("PForm "+pForm);
		    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
		    @Override  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		    	ps.setString(1, pForm.getPlayListStoreLocation());
		    	ps.setInt(2, pForm.getSizeOfItem());
		    	ps.setString(3,pForm.getPlayListItemName());
		    	ps.setDate(4,new java.sql.Date(new Date().getTime()));
		    	ps.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
		    	ps.setString(6, pForm.getUpdateBy());
		    	ps.setString(7,pForm.getTypeOfPlayList());
		    	ps.setString(8, pForm.getUserAgents());
		    	ps.setString(9, pForm.getUserHeaders());
		        return ps.execute();  
		    }  
		    });  
	}
		public static List<PlayListForm> viewAllVideos(){
			JdbcTemplate jdbcTemplate = new JdbcTemplate(l_ds);
			 return jdbcTemplate.query("select * from playlist order by ID desc",new RowMapper<PlayListForm>(){  
				    public PlayListForm mapRow(ResultSet rs, int rownumber) throws SQLException {  
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
				    });  
		}
		public static List<PlayListForm> selectVideo(Integer id){
			JdbcTemplate jdbcTemplate = new JdbcTemplate(l_ds);
			String query="select * from playlist where ID=?";
			List<PlayListForm> pForm=jdbcTemplate.query(query, new Object[]{id}, new PlayListMapper());
			return pForm;
			
		}
		
		
}
