package com.cognixia.jump.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.CheckedBook;


public class CheckedBookDao {

	public static final Connection conn = ConnectionManager.getConnection();
	private static String SELECT_ALL_CHECKEDBOOK = "select * from book_checkout";
	private static String SELECT_CHECKEDBOOK_BY_ID = "select * from book_checkout where checkout_id = ?";
	private static String INSERT_CHECKEDBOOK = "insert into book_checkout(patron_id, isbn, checkedout, due_date, returned) values(?, ?, ?, ?, ?)";
	private static String DELETE_CHECKEDBOOK = "delete from product where checkout_id = ?";
	private static String UPDATE_CHECKEDBOOK = "update book_checkout set patron_id = ?, isbn = ?, checkedout = ?, due_date = ?, returned = ? where checkout_id = ?";
	
	public List<CheckedBook> getAllCheckedBooks() {
		
			List<CheckedBook> allCheckedBooks  = new ArrayList<CheckedBook>();
			
			
			try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_CHECKEDBOOK);
					ResultSet rs = pstmt.executeQuery() ) {
				
				while(rs.next()) {
					
					int id = rs.getInt("checked_id");
					int patron_id = rs.getInt("patron_id");
					String isbn = rs.getString("isbn");
					String checkedout = rs.getString("checkedout");
					String due_date = rs.getString("due_date");
					String returned = rs.getString("returned");
					
					allCheckedBooks.add(new CheckedBook(id,patron_id,isbn,checkedout,due_date,returned));
					
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return allCheckedBooks;
			
			
		}
	
	public CheckedBook getBookByID(int id) {
			
			CheckedBook checkedBook = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement(SELECT_CHECKEDBOOK_BY_ID)) {
				
				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				// if product found, if statement run, if not null returned as product
				if(rs.next()) {
					int patron_id = rs.getInt("patron_id");
					String isbn = rs.getString("isbn");
					String checkedout = rs.getString("checkedout");
					String due_date = rs.getString("due_date");
					String returned = rs.getString("returned");
					
					checkedBook = new CheckedBook(id,patron_id,isbn,checkedout,due_date,returned);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return checkedBook;
		}
		
	
	
	public boolean addCheckedBook(CheckedBook checkedBook) {
			
			try(PreparedStatement pstmt = conn.prepareStatement(INSERT_CHECKEDBOOK)) {
				
				
				
				pstmt.setInt(1, checkedBook.getPatron_id());
				pstmt.setString(2, checkedBook.getIsbn());
				pstmt.setString(3, checkedBook.getCheckedout());
				pstmt.setString(4, checkedBook.getDue_date());
				pstmt.setString(5, checkedBook.getReturned());
				
				// at least one row added
				if(pstmt.executeUpdate() > 0) {
					return true;
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
	
	
	public boolean deleteCheckedBook(int id) {

		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_CHECKEDBOOK)) {

			pstmt.setInt(1, id);

			// at least one row deleted
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
	

	public boolean updateCheckedBook(CheckedBook checkedBook) {
		
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_CHECKEDBOOK)) {

			
			
			pstmt.setInt(1, checkedBook.getPatron_id());
			pstmt.setString(2, checkedBook.getIsbn());
			pstmt.setString(3, checkedBook.getCheckedout());
			pstmt.setString(4, checkedBook.getDue_date());
			pstmt.setString(5, checkedBook.getReturned());
			pstmt.setInt(6, checkedBook.getCheckout_id());

			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
			
		
		
	
	
}

