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







import com.angular.entity.Book;
import com.angular.entity.Favor;
import com.angular.entity.Follow;
import com.angular.entity.User;
import com.angular.service.FollowManager;
import com.angular.service.IFavorManager;
import com.angular.service.IFollowManager;
import com.angular.service.IUserManager;
import com.angular.service.UserManager;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userManager")
	private IUserManager userManager;
	@Resource(name="favorManager")
	private IFavorManager favorManager;
	@Resource(name="followManager")
	private IFollowManager followManager;
	@RequestMapping("/checkUserExist")
	public String checkUserExist(User user) {
		//System.out.println(userManager.checkUserExist(user));
		if(userManager.checkUserExist(user)){
			//System.out.println(userManager.checkUserExist(user));
			return "/userAlreadyExist";
		}
		else return saveUser(user);
	}
	@RequestMapping("/update/{username}")
	public String toUpdate(@PathVariable String username, Model model){
		model.addAttribute("username", username);
		return "/updateProfile";
	}
	
	@RequestMapping("/updateProfile/{username}")
	public String updateProfile(User user,@PathVariable String username) {
		System.out.println(user.getPassword());
		user.setUserName(username);
		userManager.updateProfile(user);
		System.out.println("update success!");
		return "/accountInfo";
	}
	@RequestMapping("/toSaveUser")
	public String toSaveUser(){
		return "/addUser";
	}
	
	@RequestMapping("/{username}")
	public String toAccountInfo(@PathVariable String username,Model model){
		if(username.equals("null")){
			return login();
		}
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
	@RequestMapping(value="/follow/{follower}/{followed}")
	public String addFollow(@PathVariable String follower,@PathVariable String followed,HttpServletRequest request
			,Model model){
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
	
//		if(favorManager.checkFavor(favor)){
//			favorManager.deleteFavor(favor);
//			return "book/unfavor";
//		}else{
//			System.out.println(favor.getBookID());
//			System.out.println(favor.getUserID());
//			favorManager.saveFavor(favor);
//			HttpSession session=request.getSession();
//			session.setAttribute("bookID", bookID);
//			return "book/favor";
//		}
		
		
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
