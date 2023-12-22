package com.jam.timeline.controller.user;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.jam.timeline.biz.event.EventVO;
import com.jam.timeline.biz.event.ScheduleVO;
import com.jam.timeline.biz.user.UserService;
import com.jam.timeline.biz.user.UserVO;
import com.jam.timeline.biz.user.impl.UserDAO;
@SessionAttributes("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = "/createAccount.do")
	public String createAccount(UserVO userVO, UserDAO userDAO) {
		System.out.println("createAccount()");
		System.out.println(userVO.toString());
		userDAO.createAccount(userVO);
		return "redirect:login.jsp";
	}

	@RequestMapping(value = "/login.do")
	public String login(UserVO userVO, UserDAO userDAO, Model model, HttpSession session) {
		System.out.println("login(): " + userVO.toString());
		if (userVO.getUsername() == null || userVO.getPassword() == null) {
			System.out.println("null error");
		}
		UserVO user = userDAO.login(userVO);
		if (user != null) {
			session.setAttribute("profpic_path", user.getProfpic_path());
			model.addAttribute("user", user);
			System.out.println("after login(): " + user.toString());
			return "timeline";
		} else
			return "redirect:login.jsp";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		System.out.println("logout()");
		session.invalidate();
		return "redirect:home.jsp";
	}
	
	@RequestMapping(value = "/myAccount.do")
	public String myAccount(UserVO userVO, EventVO eventVO, ScheduleVO scheduleVO) {
		return "myAccount";
	}
	
	@RequestMapping(value = "/submitProfpic.do")
	public String submitProfpic(UserVO userVO, UserDAO userDAO, HttpSession session) throws IllegalStateException, IOException {
		System.out.println("submitProfPic()");
		userVO.setUsername((String)session.getAttribute("username"));
		System.out.println(userVO.toString());
		MultipartFile profpicFile = userVO.getProfpicFile();
		// if a file exists
		if(!profpicFile.isEmpty()) {
			// check file type
			String fileType = profpicFile.getContentType();
			System.out.println(fileType);
			// if it is an image
			if(fileType.startsWith("image/")) {
				// get image folder location
				// get file name of MultipartFile
				String fileName = profpicFile.getOriginalFilename();
				// set filename as userVO variable
				userVO.setProfpic_path(fileName);
				// test
				System.out.println(userVO.toString());
				// save filename into DB
				userDAO.setProfpicPath(userVO);
				// create file with path to image folder and name of the image to save
//				File saveFile = new File("images/" + fileName);
				File saveFile = new File("C:/DEV/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Timeline/images/" + fileName);
				// create directory if it doesn't exist
				if (!saveFile.exists()) {
					saveFile.mkdirs();  
				}
				System.out.println(saveFile.toString());
				
				// transfer MultipartFile
				profpicFile.transferTo(saveFile);
				// test
				System.out.println(profpicFile.toString());
				// set attribute
				session.setAttribute("profpic_path", fileName);
			} else {
				System.out.println("not an image type");
				session.setAttribute("profpic_path", "default_image.png");				
			}
		}
		return "myAccount";
	}
	
	@RequestMapping(value = "/goToTimeline.do")
	public String goToTimeline(UserVO userVO) {
		return "timeline";
	}
	
	@RequestMapping(value = "/deleteAccount.do")
	public String deleteAccount(UserVO userVO, UserDAO userDAO) {
		System.out.println("deleteAccount()");
		System.out.println("mapping: " + userVO.getUsername() + ", " + userVO.getPassword());
		userDAO.deleteAccount(userVO);
		return "redirect:home.jsp";
	}
	
	@RequestMapping(value = "/updateAccount.do")
	public String updateAccount(UserVO userVO, UserDAO userDAO) {
		
		
		return "timeline";
	}
}
