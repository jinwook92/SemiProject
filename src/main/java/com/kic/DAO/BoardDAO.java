package com.kic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kic.VO.MultiBoardVO;

public class BoardDAO {
     public    List<MultiBoardVO> getList(Connection conn) 
     {
    	 PreparedStatement pstmt=null;
    	 ResultSet rs=null;
    	 StringBuilder sb=new StringBuilder();
    	 ArrayList<MultiBoardVO> arr=new ArrayList<>();
    	 sb.append(" select                  ");
    	 sb.append("         board_num       ");
    	 sb.append("         ,title          ");
    	 sb.append(" from                    ");
    	 sb.append("      multiboard         ");
    	 try{
    	 	  pstmt=conn.prepareStatement(sb.toString());
    		 rs=pstmt.executeQuery();
    		 while(rs.next())
    		 {
    			 MultiBoardVO data=new MultiBoardVO();
    			 data.setBoardnum(rs.getInt("board_num"));
    			 data.setTitle(rs.getString("title"));
                 arr.add(data); 			 
    		 }
    	 } catch(SQLException e)
    	 {
    		 throw new RuntimeException();
    	 }finally{
    		 rsClose(rs);
    		 pstmtClose(pstmt);
    		 
    	 }
    	 	 
    	 return arr;
    	 
     }
	
	 private void  pstmtClose(PreparedStatement pstmt)
	 {
		 if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
	 }
     private void rsClose(ResultSet rs)
     {
    	 if(rs!=null) try{ rs.close();} catch(SQLException e){}
     }
     
     public int AddData(Connection conn, String title, String content, String fname)
     {
    	   PreparedStatement pstmt=null;
    	   StringBuilder sb=new StringBuilder();
    	   sb.append("  insert   into   multiboard 							      ");
    	   sb.append("                          (board_num,title, content,fname)  ");
    	   sb.append(" values (multiboard_seq.nextval, ? ,?,? )                   ");
    	   int r=0;
    	   try{
    		   pstmt=conn.prepareStatement(sb.toString());
    		   pstmt.setString(1, title);
    		   pstmt.setString(2, content);
    		   pstmt.setString(3, fname);
    		   r=pstmt.executeUpdate();
    		   
    	   }catch(SQLException e)
    	   {
    		   throw new RuntimeException();
    	   }finally{
    		   pstmtClose(pstmt);
    	   }
    	   return r;
     }
 
     public MultiBoardVO  ReadData(Connection conn, int num)
     {
    	 PreparedStatement pstmt=null;
    	 StringBuilder sql=new StringBuilder();
    	 ResultSet rs=null;
    	 sql.append(" select    board_num                  ");
    	 sql.append("          ,title                      ");
    	 sql.append("          ,content                    ");
    	 sql.append("          ,nvl(fname,' ') as fname    ");
    	 sql.append(" from  multiboard                     ");
    	 sql.append(" where  board_num=?                   ");
    	 MultiBoardVO data=new MultiBoardVO();
    	 try{
    		 pstmt=conn.prepareStatement(sql.toString());
    		 pstmt.setInt(1, num);
    		 rs=pstmt.executeQuery();
    		 if(rs.next())
    		 {
    		   data.setBoardnum(rs.getInt("board_num"));
    		   data.setTitle(rs.getString("title"));
    		   data.setContent(rs.getString("content"));
    		   data.setFname(rs.getString("fname"));
    		 }
    	 }catch(SQLException e)
    	 {
    		throw  new RuntimeException();
    	 }finally{
    		 rsClose(rs);
            pstmtClose(pstmt);
    		 
    	 }
    	 return data;
     }

     public void DelData(Connection conn, int num)
     {
    	 PreparedStatement pstmt=null;
    	 try{
    		 StringBuilder sb=new StringBuilder();
    		 sb.append("  delete    from  multiboard ");
    		 sb.append("  where  board_num=?         ");
    		 pstmt=conn.prepareStatement(sb.toString());
             pstmt.setInt(1, num);
             pstmt.executeUpdate();
    	 }
    	 catch(SQLException e)
    	 {
    	     System.out.println(e);
    		 throw new RuntimeException();
    	 }finally{
    		 if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
    	 }
     }

}











