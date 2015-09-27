/**
 * Author: SHIVAJI VARMA <contact@shivajivarma.com>
 */
package com.shivajivarma.brs.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.Passenger;
 
public class PassengerDAOImpl extends BaseDAO implements PassengerDAO {
	
	private static final String table = Passenger.indentity;
	
	public void save(Passenger passenger){
		
		String sql = "INSERT INTO "+table+" VALUES(pid_auto.NEXTVAL,?,?,?,?,?)";
			 
		getJdbcTemplate().update(sql, 
				new Object[] { 
					passenger.getUsername(),
					passenger.getPassword(),
					passenger.getName(),
					passenger.getEmail(),
					passenger.getMobile()});
			
	}

	/**
	 * Following function retrieves Passenger data for given id.
	 * @param id Passenger Id
	 * @return Passenger object.
	 */
    @Override
    public Passenger findById(int id) throws EmptyResultDataAccessException{
        String query = "select * from "+table+" where id = ?";
        
        //query single row with BeanPropertyRowMapper (Passenger.class)
        Passenger passenger = (Passenger)getJdbcTemplate().queryForObject(query, 
        		new Object[] { id }, 
				new BeanPropertyRowMapper<Passenger>(Passenger.class));
       
        return passenger;
    }
    
    /**
	 * Following function retrieves Passenger data for given username.
	 * @param id Passenger Id
	 * @return Passenger object.
	 */
    @Override
    public Passenger findByUsername(String username) throws EmptyResultDataAccessException{
        String query = "select * from "+table+" where username = ?";
     
        //query single row with BeanPropertyRowMapper (Passenger.class)
        Passenger passenger = (Passenger)getJdbcTemplate().queryForObject(query, 
    		   			new Object[] { username }, 
    		   			new BeanPropertyRowMapper<Passenger>(Passenger.class));
        return passenger;
    }
 
  /*@Override
    public void update(Employee employee) {
        String query = "update Employee set name=?, role=? where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setInt(3, employee.getId());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Employee updated with id="+employee.getId());
            }else System.out.println("No Employee found with id="+employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    @Override
    public void deleteById(int id) {
        String query = "delete from Employee where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Employee deleted with id="+id);
            }else System.out.println("No Employee found with id="+id);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    @Override
    public List<Employee> getAll() {
        String query = "select id, name, role from Employee";
        List<Employee> empList = new ArrayList<Employee>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                empList.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empList;
    }*/
 
}