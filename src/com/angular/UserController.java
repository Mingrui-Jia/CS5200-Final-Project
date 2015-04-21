package com.angular;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.angular.entity.User;
import com.angular.service.IFavorManager;
import com.angular.service.IUserManager;
import com.angular.service.UserManager;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userManager")
	private IUserManager userManager;
	@Resource(name="favorManager")
	private IFavorManager favorManager;
	
	@RequestMapping("/checkUserExist")
	public String checkUserExist(User user) {
		//System.out.println(userManager.checkUserExist(user));
		if(userManager.checkUserExist(user)){
			//System.out.println(userManager.checkUserExist(user));
			return "/userAlreadyExist";
		}
		else return saveUser(user);
	}
	
	@RequestMapping("/toSaveUser")
	public String toSaveUser(){
		return "/addUser";
	}
	
	@RequestMapping("/{username}")
	public String toUserProfile(@PathVariable String username,Model model){
		if(username.equals("null")){
			return login();
		}
		List<String> books=favorManager.findFavoriteBookByUser(username);
		model.addAttribute("books", books);
		return "/profile";
	}
	
	@RequestMapping("/checkUser")
	public String check(User user,HttpServletRequest request){
		//System.out.println(user.getUserName());
		  
		if(userManager.checkUser(user)){
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", user.getUserName());
			
			return "/success";
		}else{
			return "/fail";
		}
		
	}

	@RequestMapping("/login")
	public String login(){
		
		return "/login";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(User user){
		userManager.saveUser(user);
		return "/welcome";
	}

}
