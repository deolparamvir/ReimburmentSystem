package dev.deol.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.deol.entities.Reimbursment;
import dev.deol.utils.ConnectionUtil;


public class ReimbursmentDAOmariadb implements ReimbursmentDAO{

	@Override
	public Reimbursment createReimbursment(Reimbursment reimbursment) {
		try(Connection conn= ConnectionUtil.createConnection()){
			String sql= "INSERT INTO REIMBURSMENT VALUES (?,?,?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setInt(2, reimbursment.getAmount());
			ps.setString(3, reimbursment.getDescription());
			ps.setInt(4, reimbursment.geteId());
			ps.setInt(5, reimbursment.getmId());
			ps.setBoolean(6, reimbursment.getStatus());
			ps.execute();
			
			ResultSet rs= ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("R_ID");
			
			reimbursment.setrId(key);
			return reimbursment;
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Reimbursment getReimbursmentById(int id) {
		String sql = "SELECT * FROM REIMBURSMENT WHERE R_ID = ?";
        try(Connection conn = ConnectionUtil.createConnection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Reimbursment reimbursment = new Reimbursment();
            reimbursment.setrId(rs.getInt("R_ID"));   
            reimbursment.setAmount(rs.getInt("AMOUNT"));  
            reimbursment.setDescription(rs.getString("DESCRIPTION"));		
            reimbursment.seteId(rs.getInt("E_ID"));		
            reimbursment.setmId(rs.getInt("M_ID"));
            reimbursment.setStatus(rs.getBoolean("STATUS"));
            return reimbursment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;

	}

	@Override
	public List<Reimbursment> getAllReimbursments() {
		try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "SELECT * FROM REIMBURSMENT";
            List<Reimbursment> reimbursments = new ArrayList<Reimbursment>();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()) {
            	Reimbursment reimbursment = new Reimbursment();
                reimbursment.setrId(rs.getInt("R_ID"));   
                reimbursment.setAmount(rs.getInt("AMOUNT"));  
                reimbursment.setDescription(rs.getString("DESCRIPTION"));		
                reimbursment.seteId(rs.getInt("E_ID"));		
                reimbursment.setmId(rs.getInt("M_ID"));
                reimbursment.setStatus(rs.getBoolean("STATUS"));
                reimbursments.add(reimbursment);
             
            }
            return reimbursments;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public Reimbursment updateReimbursment(Reimbursment reimbursment) {
		try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "UPDATE REIMBURSMENT SET AMOUNT = ?, DESCRIPTION = ?, STATUS = ?, M_ID = ?, E_ID = ? WHERE R_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setInt(1, reimbursment.getAmount());
            ps.setString(2, reimbursment.getDescription());
            ps.setBoolean(3, reimbursment.getStatus());
            ps.setInt(4, reimbursment.getmId());
            ps.setInt(5, reimbursment.geteId());
            ps.setInt(6, reimbursment.getrId());
            ps.execute();
            
            return reimbursment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursment> getCompletedReimbursments() {
		try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "SELECT * FROM REIMBURSMENT WHERE STATUS = 1";
            List<Reimbursment> reimbursments = new ArrayList<Reimbursment>();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()) {
            	Reimbursment reimbursment = new Reimbursment();
                reimbursment.setrId(rs.getInt("R_ID"));   
                reimbursment.setAmount(rs.getInt("AMOUNT"));  
                reimbursment.setDescription(rs.getString("DESCRIPTION"));		
                reimbursment.seteId(rs.getInt("E_ID"));		
                reimbursment.setmId(rs.getInt("M_ID"));
                reimbursment.setStatus(rs.getBoolean("STATUS"));
                reimbursments.add(reimbursment);
            }
            return reimbursments;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursment> getPendingReimbursments() {
		try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "SELECT * FROM REIMBURSMENT WHERE STATUS = 0";
            List<Reimbursment> reimbursments = new ArrayList<Reimbursment>();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()) {
            	Reimbursment reimbursment = new Reimbursment();
                reimbursment.setrId(rs.getInt("R_ID"));   
                reimbursment.setAmount(rs.getInt("AMOUNT"));  
                reimbursment.setDescription(rs.getString("DESCRIPTION"));		
                reimbursment.seteId(rs.getInt("E_ID"));		
                reimbursment.setmId(rs.getInt("M_ID"));
                reimbursment.setStatus(rs.getBoolean("STATUS"));
                reimbursments.add(reimbursment);
            }
            return reimbursments;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursment> getReimbursmentsByEmployeeId(int id) {
		String sql = "SELECT * FROM REIMBURSMENT WHERE E_ID = ?";
        try(Connection conn = ConnectionUtil.createConnection()){
            
        	List<Reimbursment> reimbursments = new ArrayList<Reimbursment>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
	            Reimbursment reimbursment = new Reimbursment();
	            reimbursment.setrId(rs.getInt("R_ID"));   
	            reimbursment.setAmount(rs.getInt("AMOUNT"));  
	            reimbursment.setDescription(rs.getString("DESCRIPTION"));		
	            reimbursment.seteId(rs.getInt("E_ID"));		
	            reimbursment.setmId(rs.getInt("M_ID"));
	            reimbursment.setStatus(rs.getBoolean("STATUS"));
	            reimbursments.add(reimbursment);
            }
            return reimbursments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}

	@Override
	public List<Reimbursment> getReimbursmentsByManagerId(int id) {
		String sql = "SELECT * FROM REIMBURSMENT WHERE M_ID = ?";
        try(Connection conn = ConnectionUtil.createConnection()){
            
        	List<Reimbursment> reimbursments = new ArrayList<Reimbursment>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
	            Reimbursment reimbursment = new Reimbursment();
	            reimbursment.setrId(rs.getInt("R_ID"));   
	            reimbursment.setAmount(rs.getInt("AMOUNT"));  
	            reimbursment.setDescription(rs.getString("DESCRIPTION"));		
	            reimbursment.seteId(rs.getInt("E_ID"));		
	            reimbursment.setmId(rs.getInt("M_ID"));
	            reimbursment.setStatus(rs.getBoolean("STATUS"));
	            reimbursments.add(reimbursment);
            }
            return reimbursments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
}
