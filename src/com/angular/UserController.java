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

import com.angular.entity.*;
import com.angular.service.*;



@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userManager")
	private IUserManager userManager;
	@Resource(name="followManager")
	private IFollowManager followManager;
	@Resource(name="favorManager")
	private IFavorManager favorManager;
	
	
//	Model可以用于向页面中传值，算是一个map，key是"username"，值是这里传入的username
//	要先拿到当前登录的用户名再更改profile，并将该用户名显示到下一个更改的界面
	@RequestMapping("/update/{username}")
	public String toUpdate(@PathVariable String username, Model model){
		model.addAttribute("username", username);
		return "/updateProfile";
	}
//	看看userDAO里面的方法改了没
	@RequestMapping("/updateProfile/{username}")
	public String updateProfile(User user,@PathVariable String username) {
		System.out.println(user.getPassword());
		user.setUserName(username);
		userManager.updateProfile(user);
		System.out.println("update success!");
		return "/accountInfo";
	}
	
	

	
//	通过toSaveUser转到/addUser这个jsp，再调用saveUser
	@RequestMapping("/toSaveUser")
	public String toSaveUser(){
		return "/addUser";
	}
	
//	这里是addUser的jsp里面调用了saveUser的方法再map到下面welcome.jsp（Angular.xml里面加的前缀后缀）
	@RequestMapping("/saveUser")
	public String saveUser(User user){
		if (userManager.checkUserExist(user)) {
			System.out.println("userAlreadyExist");
			return "/addUser";
//			return toSaveUser();
		}
		else {
			userManager.saveUser(user);
		}
		return "/welcome";
	}
	

	@RequestMapping(value="/follow/{follower}/{followed}")
	public String addFollow(@PathVariable String follower,@PathVariable String followed,
			HttpServletRequest request, Model model){
		if(follower.equals("null")){
			UserController uc= new UserController();
			return uc.login();
		}
		Follow follow=new Follow(follower,followed);
		
		if(!follower.equals(followed)){
			
			
			if(followManager.checkFollow(follow)){
				followManager.deleteFollow(follow);
				System.out.println("delete");
			}else{
				followManager.saveFollow(follow);
				System.out.println("save");
			}
		}
		
		return toProfile(followed,model);
	

		
		
	}


	
	@RequestMapping("/{username}")
	public String toAccountInfo(@PathVariable String username,Model model) {
//		如果拿到的username是null，跳到登录页面，注意这里可以调用controller里面的方法
		if(username.equals("null")){
			return login();
		}
//		这里把书名的list传到model中，可以在jsp中调用，在accountInfo页面列出
		List<String> books=favorManager.findFavoriteBookByUser(username);
		model.addAttribute("books", books);
		return "/accountInfo";
	}
	
	@RequestMapping("/profile/{username}")
	public String toProfile(@PathVariable String username,Model model){
		
		List<String> books=favorManager.findFavoriteBookByUser(username);
		model.addAttribute("books", books);
		model.addAttribute("otheruser", username);
		return "/profile";
	}
	
	@RequestMapping("/checkUser")
	public String check(User user, HttpServletRequest request){
		//System.out.println(user.getUserName());
		  
		if(userManager.checkUser(user)){
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", user.getUserName());
			
			return "/success";
		}else{
			return "/fail";
		}
		
	}

//	jsp页面中可以调这个，通过"/login" map过来之后再return一个String，map到
	@RequestMapping("/login")
	public String login(){
		
		return "/login";
	}
	


}