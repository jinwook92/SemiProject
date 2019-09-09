package com.kic.Service;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kic.DAO.BoardDAO;
import com.kic.DAO.SubBoardDAO;
import com.kic.VO.MultiBoardVO;
import com.kic.VO.MultiSubVO;
import com.kic.comm.DBConn;

import sun.security.pkcs11.Secmod.DbMode;

public class BoardService {
    private static BoardService instance = new BoardService();

    public static BoardService getInstance() {
        return instance;
    }

    private BoardService() {
    }

    public List<MultiBoardVO> ListService() {

        Connection conn = null;
        List<MultiBoardVO> list = null;
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = new BoardDAO();
            list = dao.getList(conn);

            conn.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (NamingException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (RuntimeException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public void AddService(String title, String content, String fname) {
        Connection conn = null;
        try {

            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = new BoardDAO();
            int r = dao.AddData(conn, title, content, fname);


            conn.commit();
        } catch (SQLException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (NamingException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }

        }
    }

    public void delService(int num) {
        Connection conn = null;
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = new BoardDAO();
            dao.DelData(conn, num);

            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (RuntimeException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

    public MultiBoardVO detailService(int num) {
        Connection conn = null;
        MultiBoardVO data = new MultiBoardVO();
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = new BoardDAO();
            data = dao.ReadData(conn, num);
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (NamingException e) {
            System.out.println(e);
            //try{ conn.rollback();} catch(SQLException e1){}
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return data;
    }

    public List<MultiSubVO> subDetailService(int num) {
        Connection conn = null;
        List<MultiSubVO> list = null;
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            SubBoardDAO dao = new SubBoardDAO();
            list = dao.subList(conn, num);
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (NamingException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }

        }
        return list;

    }

    public void subAdd(int num, String title) {
        Connection conn = null;
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            SubBoardDAO dao = new SubBoardDAO();
            dao.addData(conn, num, title);
            conn.commit();
        } catch (SQLException | NamingException e)  //jdk7
        {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }

        }
    }

    public void subDel(int num) {
        Connection conn = null;
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);
            SubBoardDAO dao = new SubBoardDAO();
            dao.delDate(conn, num);


            conn.commit();
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }

        } catch (RuntimeException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

}








