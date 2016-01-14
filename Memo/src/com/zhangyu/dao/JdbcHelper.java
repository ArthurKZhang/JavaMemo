package com.zhangyu.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhangyu.bean.MemoBean;

public class JdbcHelper implements JdbcConfig {
	
	/**
	 * get the object of Connection to database.
	 * @return object of Connection or null.
	 */
	private static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * save the memo use process batch
	 * @param MemoBean memo
	 * @return -1 if error happended
	 */
	public static int save(MemoBean memo){
		String sql = "insert into tb_memo (username,title," +
				"content,memotype,memotime) values (?,?,?,?,?);";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memo.getUserName());
			ps.setString(2, memo.getTitle());
			ps.setString(3, memo.getContent());
			ps.setString(4, memo.getMemoType());
			ps.setString(5, memo.getMemoTime());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	/**
	 * update memo
	 * @param MemoBean memo.
	 * @return -1 if some error happened.
	 */
	public static int update(MemoBean memo){
		String sql = "update tb_memo set username = ?, title = ?, " +
				"content = ?, memoType = ?, memoTime = ? where id = ?;";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memo.getUserName());
			ps.setString(2, memo.getTitle());
			ps.setString(3, memo.getContent());
			ps.setString(4, memo.getMemoType());
			ps.setString(5, memo.getMemoTime());
			ps.setInt(6, memo.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	/**
	 * save all the information  to list
	 * @return List<MemoBean>
	 */
	public static List<MemoBean> queryAll(){
		String sql = "select * from tb_memo;";
		List<MemoBean> results = new ArrayList<MemoBean>();
		Connection conn = getConnection();
		Statement sm = null;
		ResultSet rs = null;
		try {
			sm = conn.createStatement();
			rs = sm.executeQuery(sql);
			while(rs.next()){
				MemoBean memo = new MemoBean();
				memo.setId(rs.getInt("id"));
				memo.setUserName(rs.getString("username"));
				memo.setContent(rs.getString("content"));
				memo.setMemoTime(rs.getString("memotime"));
				memo.setMemoType(rs.getString("memotype"));
				memo.setTitle(rs.getString("title"));
				results.add(memo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sm != null){
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return results;
	}

	/**
	 * query
	 * @param MemoBean memo
	 * @return List<MemoBean>
	 */
	public static List<MemoBean> query(MemoBean memo){
		String userName = memo.getUserName();
		String title = memo.getTitle();
		String content = memo.getContent();
		String memoType = memo.getMemoType();
		String memoTime = memo.getMemoTime();
		
		StringBuilder sql = new StringBuilder("select * from tb_memo where 1=1 ");
		if(!userName.isEmpty()){
			sql.append(" and username like '%" + userName + "%' ");
		}
		if(!title.isEmpty()){
			sql.append(" and title like '%" + title + "%' ");
		}
		if(!content.isEmpty()){
			sql.append(" and content like '%" + content + "%' ");
		}
		if(!memoType.isEmpty()){
			sql.append(" and memotype like '%" + memoType + "%' ");
		}
		if(!memoTime.isEmpty()){
			sql.append(" and memotime like '%" + memoTime + "%' ");
		}
		sql.append(";");
		
		List<MemoBean> results = new ArrayList<MemoBean>();
		Connection conn = getConnection();
		Statement sm = null;
		ResultSet rs = null;
		try {
			sm = conn.createStatement();
			rs = sm.executeQuery(sql.toString());
			while(rs.next()){
				MemoBean tempMemo = new MemoBean();
				tempMemo.setContent(rs.getString("content"));
				tempMemo.setId(rs.getInt("id"));
				tempMemo.setMemoTime(rs.getString("memotime"));
				tempMemo.setMemoType(rs.getString("memotype"));
				tempMemo.setTitle(rs.getString("title"));
				tempMemo.setUserName(rs.getString("username"));
				results.add(tempMemo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs !=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sm != null){
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return results;
	}

	/**
	 * delete a memo
	 * @param memo
	 * @return
	 */
	public static int delete(MemoBean memo){
		String sql = "delete from tb_memo where id = " + memo.getId();
		Connection conn = getConnection();
		Statement sm = null;
		try {
			sm = conn.createStatement();
			return sm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sm != null) {
                try {
                    sm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		return -1;
	}
	

}
