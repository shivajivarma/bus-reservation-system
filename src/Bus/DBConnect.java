package Bus;

import Bus.Main;

import java.sql.*;

import javax.swing.JOptionPane;

import com.brs.utility.DBConnection;


/**
 * 
 * Mediates database and application.
 *
 */

public class DBConnect {
	
	Connection con;
	Statement st;
	ResultSet rst;
	
	/* Establish connection to database when ever DBConnect object is created 
	 * */
	public DBConnect(){
			con = DBConnection.getConnection();
	}
	
	
	
	
	/** 
	 * Provides the list of buses from selected origin to selected destination on given date 
	 * */
	public ResultSet selectBuses(String orgin,String dest,String dt){
		Main.mainFrame.date=dt;
		
		try{
			st=con.createStatement();
			rst=st.executeQuery("select b.bid,r.origin,r.DESTINATION,b.ac,b.DEPTTIME,b.ARRTIME,b.fare,(select 40-count(*) from reserve re where re.bid=b.bid and dt='"+dt+"')  as available from bus b,route r where b.rid=r.rid and r.origin='"+orgin+"' and r.destination='"+dest+"'");
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(Bus.Main.mainFrame,"Unable to connect to database. Contact your system admin","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return rst;
	}
	
	
	
	
	
	
	
	
	
	
	
	/* */
	public boolean reserveTicket(int pid,int bid,String dt,int seat){
		try {
			st=con.createStatement();
		//	st.executeUpdate("insert into reserve values(tid_auto.NEXTVAL,"+pid+","+bid+",'"+dt+"','"+Main.currentDate()+"',"+seat+")");
			
			rst=st.executeQuery("select tid_auto.CURRVAL from dual");
			rst.next();
			return true;
		
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(Bus.Main.mainFrame,"Unable to connect to database. Contact your system admin","Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	
	
	public ResultSet retrieveseat(int busid){
		
			try{
				st=con.createStatement();
				rst=st.executeQuery("select seat from reserve where bid="+busid+" and dt='"+Main.mainFrame.date+"'");
			}
			catch (SQLException e) {
				e.printStackTrace();
		}
			return rst;
		}
	
	/*public ResultSet customerHistory(int pid){
		
		try{
			st=con.createStatement();
			rst=st.executeQuery("select tid as Ticket_id,b.bid,dt as Journey_date,orgin,dest,depttime,arrtime,seat from reserve r,bus b,route ro where r.bid=b.bid and ro.rid=b.rid and pid="+pid+" order by tid desc");
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
		return rst;
	}*/
	
public ResultSet PrintTicket(int pid){
		
		try{
			st=con.createStatement();
		//	rst=st.executeQuery("select * from reserve where pid="+pid+" and tstamp='"+Main.currentDate()+"' order by tid desc");
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
		return rst;
	}
	
	
}