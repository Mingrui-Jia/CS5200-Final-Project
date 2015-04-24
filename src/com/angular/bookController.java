package com.angular;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import com.angular.entity.Book;
import com.angular.entity.Favor;
import com.angular.entity.User;
import com.angular.service.IBookManager;
import com.angular.service.ICommentsManager;
import com.angular.service.IFavorManager;
import com.angular.service.IUserManager;


@Controller
@RequestMapping(value="/book")
public class bookController {
	@Resource(name="bookManager")
	private IBookManager bookManager;
	@Resource(name="favorManager")
	private IFavorManager favorManager;
	@Resource(name="commentsManager")
	private ICommentsManager commentsManager;
	
	
	
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView toIndex(){
		String result ="this is delUser------";
		return new ModelAndView("/static/000","result",result);
	}
	@RequestMapping(value="/{bookID}")
	public String toDetails(@PathVariable String bookID, Model model){

		//System.out.println("this is details");
		List<String> users=(List<String>) favorManager.findUserByFavoriteBook(bookID);
//		List<String> commentList=(List<String>) commentsManager.findCommentByBook(bookID);
//		model.addAttribute("comments", commentList);
		model.addAttribute("users", users);
		model.addAttribute("id", bookID);
		return  "book/details";
	}
	@RequestMapping(value="toComment/{username}/{bookID}")
	public String toCreateComment(@PathVariable String username, @PathVariable String bookID,Model model){
		System.out.println(username);
		System.out.println(bookID);
		model.addAttribute("username",username);
		model.addAttribute("bookID", bookID);
		return "book/comment";
	}
	
	@RequestMapping(value="/addFavor/{bookID}/{username}")
	public String addFavor(@PathVariable String bookID,@PathVariable String username,HttpServletRequest request){
		if(username.equals("null")){
			UserController uc= new UserController();
			return uc.login();
		}
		Book book= new Book();
		book.setId(bookID);
		Favor favor=new Favor();
		favor.setBookID(bookID);
		favor.setUserID(username);
		
		if(!bookManager.checkBook(book)){
			
			bookManager.saveBook(book);
		}else{
			System.out.println("book already exists");
		}
	
		if(favorManager.checkFavor(favor)){
			favorManager.deleteFavor(favor);
			return "book/unfavor";
		}else{
			System.out.println(favor.getBookID());
			System.out.println(favor.getUserID());
			favorManager.saveFavor(favor);
			HttpSession session=request.getSession();
			session.setAttribute("bookID", bookID);
			return "book/favor";
		}
		
		//return new ModelAndView("/book/"+bookID,"id",bookID);
	}
	

}