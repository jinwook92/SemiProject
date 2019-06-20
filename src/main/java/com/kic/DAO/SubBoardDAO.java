package com.kic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.kic.VO.MultiSubVO;

public class SubBoardDAO {
     public  List<MultiSubVO> subList(Connection conn, int num)
     {
    	 PreparedStatement pstmt=null;
    	 ResultSet rs=null;
    	 StringBuilder sb=new StringBuilder();
    	 sb.append(" select SUB_BOARD_NUM,   title, refno ");
    	 sb.append(" from submultiboard                   ");
    	 sb.append(" where REFNO=?                        ");
    	 sb.append(" order by sub_board_num  desc         ");
    	 List<MultiSubVO> arr=new ArrayList<>();
     	 try{
    		 pstmt=conn.prepareStatement(sb.toString());
    		 pstmt.setInt(1, num);
    		rs=pstmt.executeQuery(); 
    		while(rs.next())
    		{
    			System.out.println("ttt");
    			MultiSubVO data=new MultiSubVO();
    			data.setSubno(rs.getInt("SUB_BOARD_NUM"));
    			data.setTitle(rs.getString("title"));
    			data.setRefno(rs.getInt("refno"));
    		   arr.add(data);	
    		}
    		 
    	 }catch(SQLException e)
    	 {
    		 throw new RuntimeException();
    	 }finally{
    		    if(rs!=null) try{ rs.close();} catch(SQLException e){}
    		   if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
    		 
    	 }
    	 
    	 return arr;
    	 
     }
	 public  void addData(Connection conn, int num, String title)
	 {
		 PreparedStatement pstmt=null;
		 StringBuilder sql=new StringBuilder();
		 sql.append("  insert into  submultiboard(               ");
		 sql.append("                             sub_board_num  ");
		 sql.append("                             ,title         ");
		 sql.append("                             ,refno         ");
		 sql.append("                             )              ");
		 sql.append("  values  (SUB_MULTIBOARD_SEQ.nextval,?,?)  ");
		 try{
			 pstmt=conn.prepareStatement(sql.toString());
			 pstmt.setString(1, title);
			 pstmt.setInt(2, num);
             pstmt.executeUpdate();
		 }catch(SQLException e)
		 {
		     throw new RuntimeException();	 
		 }finally{
			 if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		 }
	 }
	 public  void delDate(Connection conn, int num)
	 {
		 PreparedStatement pstmt=null;
		 try{
			 StringBuilder sb=new StringBuilder();
			 sb.append( " delete  from  submultiboard    ");
			 sb.append("  where  sub_board_num=?         ");
			 
			 pstmt=conn.prepareStatement(sb.toString());
			 pstmt.setInt(1, num);
			 pstmt.executeUpdate();
			 
		 }catch(SQLException e)
		 {
             throw new RuntimeException();
		 
		 }finally{
			 if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		 }
		 
	 }
	
}
