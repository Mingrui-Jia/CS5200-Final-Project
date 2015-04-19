package com.angular;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.angular.entity.Book;
import com.angular.entity.User;
import com.angular.service.IBookManager;
import com.angular.service.IUserManager;


@Controller
@RequestMapping(value="/book")
public class bookController {
	@Resource(name="bookManager")
	private IBookManager bookManager;
	
	
	
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView toIndex(){
		String result ="this is delUser------";
		return new ModelAndView("/static/000","result",result);
	}
	@RequestMapping(value="/{bookID}")
	public ModelAndView toDetails(@PathVariable String bookID){

		String result ="this is details";
		return new ModelAndView("book/details","id",bookID);
	}
	@RequestMapping(value="/add/{bookID}")
	public ModelAndView addBook(@PathVariable String bookID,HttpServletRequest request){
		System.out.println(bookID);
		
		Book book= new Book();
		book.setId(bookID);
		bookManager.saveBook(book);
		String result ="this is details";
		return toDetails(bookID);
		//return new ModelAndView("/book/"+bookID,"id",bookID);
	}
	
	@RequestMapping(value="/addFavor/{bookID}/{username}")
	public String addFavor(@PathVariable String bookID,@PathVariable String username,HttpServletRequest request){
		if(username.equals("null")){
			UserController uc= new UserController();
			return uc.login();
		}
		Book book= new Book();
		book.setId(bookID);
		bookManager.saveBook(book);
		
		return "book/confirm";
		//return new ModelAndView("/book/"+bookID,"id",bookID);
	}
	

}