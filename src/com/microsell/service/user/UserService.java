package com.microsell.service.user;

import javax.ws.rs.FormParam;

import com.microsell.bean.user.User;

public interface UserService {
	String createUser(@FormParam("userid") String userid, @FormParam("username") String userName,@FormParam("pword") String pword);
	String validateUser(@FormParam("userid") String userid,@FormParam("pword") String pword);

}
