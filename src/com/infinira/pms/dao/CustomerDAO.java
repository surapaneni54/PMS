package com.infinira.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.infinira.pms.models.Customer;
import com.infinira.pms.service.DBService;
import com.infinira.pms.service.ServiceUtil;


public  class CustomerDAO {
    public  static  long  create(Customer customer)  {
        long customerId = -1;  
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
        
		Connection con = DBService.getInstance().getConnection();
		try {
            pstmt = con.prepareStatement(INSERT_QUERY, new String[] { "CUSTOMER_ID" });
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getProjectExecutive() );
			pstmt.setString(3, customer.getProjectManager());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
            if (null !=rs && rs.next()) {
                customerId = rs.getLong(1);
            }else{
                ServiceUtil.throwException("PMS-0001", null, customer.getCustomerName());
            }    
		}
        catch (Throwable th) {
           ServiceUtil.throwException("PMS-0001", th, customer.getCustomerName());
		}finally{
			DBService.getInstance().closeResources(rs, pstmt, con);
		}
        return customerId;
	}
	
	public static int remove(long customerId) {
		PreparedStatement pstmt = null;
        int deletedRows = -1;
        
        Connection con = DBService.getInstance().getConnection();
		try {
			pstmt =  con.prepareStatement(DELETE_QUERY);
			pstmt.setLong(1, customerId);
            deletedRows = pstmt.executeUpdate();
            if(deletedRows == -1) {
                ServiceUtil.throwException("PMS-0002", null, customerId);
            }
		} catch(Throwable th){
            ServiceUtil.throwException("PMS-0002", th,customerId);
		} finally{
			DBService.getInstance().closeResources(null, pstmt, con);
		}    
        return deletedRows;
	} 
	public static int  update(Customer customer) {
		PreparedStatement pstmt = null;
        int updatedRows = -1;
        
		Connection con =DBService.getInstance().getConnection();
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);  
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getProjectExecutive());
			pstmt.setString(3, customer.getProjectManager());
			pstmt.setLong(4, customer.getCustomerId());
			updatedRows = pstmt.executeUpdate();
            if(updatedRows == -1) {
                ServiceUtil.throwException("PMS-0003", null, customer.getCustomerId(),customer.getCustomerName());
            }
		}catch (Throwable th) {  
            ServiceUtil.throwException("PMS-0003", th, customer.getCustomerId(),customer.getCustomerName());
		}finally{
			DBService.getInstance().closeResources(null, pstmt, con);
		}
        return updatedRows;
	} 
	private  static final String DELETE_QUERY = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID =?";
	private  static final String INSERT_QUERY = "INSERT INTO CUSTOMER VALUES(CUSTOMER_Sequence.nextval,?,?,?)";
	private  static final String UPDATE_QUERY = "UPDATE  CUSTOMER SET CUSTOMER_NAME=?,PROJECT_EXECUTIVE = ?,PROJECT_MANAGER = ? WHERE  CUSTOMER_ID=?";
}