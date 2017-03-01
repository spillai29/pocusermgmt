/**
 * 
 */
package com.microsell.service.user;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author suresh
 *
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.microsell.bean.user.User;

//@Consumes("application/json")
@Consumes("application/x-www-form-urlencoded")
@Produces("application/text")
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see com.microsell.service.user.UserService#createUser()
	 */
	@POST
	@Path("/createUser")
	public String createUser(@FormParam("userid") String userid, @FormParam("username") String username,@FormParam("pword") String pword) {
		// TODO Auto-generated method stub
		System.out.println("Systemprint)");
		System.out.println("got user "+userid);
		
		try{
	 Connection con= ShopingDBCon.dbCon();
	 
	 Statement stmt = con.createStatement();
	 System.out.println("Got statement)");
     String sql;
     sql = "Insert into usermgmtms.users (UserId,UserName,Password) values('"+userid+"','"+username+"','"+pword+"')";
     //sql="Insert into usermgmtms.users (UserId,UserName,Password) values('sgp','suresh','password')";
     stmt.executeUpdate(sql);
     System.out.println("Got insert)");
     con.close();
     return "success";	
		}
		catch(Exception ex)
		{
			
			System.out.println("Query error"+ex);
		}

						
			
		return "failed";	
		
		

	}

	/* (non-Javadoc)
	 * @see com.microsell.service.user.UserService#validateUser(java.lang.String, java.lang.String)
	 */
	@GET
	@Path("/validateUser")
	public String validateUser(@FormParam("userid") String userid,@FormParam("pword") String pword) {
		// TODO Auto-generated method stub
		System.out.println("in user validation)");
		System.out.println("got user "+userid);
		
		
		
		try{
	 Connection con= ShopingDBCon.dbCon();
	 
	 Statement stmt = con.createStatement();
	 System.out.println("Got statement)");
     String sql;
     sql = "select Password from usermgmtms.users where UserId =('"+userid+"')";
     //sql="Insert into usermgmtms.users (UserId,UserName,Password) values('sgp','suresh','password')";
     ResultSet rs=stmt.executeQuery(sql);
     while(rs.next())
     {
    	   
     
     if(pword.equals((String)rs.getString(1)))
     {
    	 System.out.println("Got user)");
    	 return "Valid";
     }
     
     }
     System.out.println("Got insert)");
     con.close();
		}
		catch(Exception ex)
		{
			
			System.out.println("Query error"+ex);
		}
		return "Invalid";
	}

}
