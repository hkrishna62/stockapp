package com.mergsoft.stockapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mergsoft.stockapp.entity.User;
import com.mergsoft.stockapp.service.UserService;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/getlogin")
	public String getLoginPage(Model model) {

		User user = new User();

		model.addAttribute("user", user);

		return "login";
	}

	@PostMapping("/userlogin")
	public String userLogin(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttrs) {

		logger.info("-*-" + user.getUserId());

		Integer userid = user.getUserId();
		String pwd = user.getPassword();

		// if(userid != null && pwd !=null)

		if (userid != null) {

			Integer userId = user.getUserId();
			String password = user.getPassword();

			logger.info("--" + userId);

			List<User> userlogin = userService.loginCheck(userId, password);
			logger.info("login success :" + userlogin);
			if (userlogin.size() == 1) {

				logger.info("login successl :" + user);

				user = userService.getUserAccountType(userId);
				logger.info("--" + user.getUserId() + " " + user.getUserName() + " " + user.getAccUserType());

				String usertype = user.getAccUserType();

				logger.info("usertype :::::----::::  :" + usertype);

				if (usertype.equalsIgnoreCase("user")) {

					logger.info("login successl user :" + user.getAccUserType());
					
					// redirectAttrs.addFlashAttribute("userid", user.getUserId());
					model.addAttribute("userid", user.getUserId());
					return "user";
				}

				if (usertype.equalsIgnoreCase("admin")) {

					logger.info("login successl Admin :" + user.getAccUserType());
					
					model.addAttribute("adminid", user.getUserId());

					return "admin";
				}

			} else {
				logger.info("user null ***  :" + user.getUserId() + " " + user.getPassword());
				model.addAttribute("errmsg1", "user Details error");

				redirectAttrs.addFlashAttribute("errmsg1", "user Details error");

				return "redirect:" + "getlogin";

			}

		} else {

			logger.info("user null ***  :" + user.getUserId() + " " + user.getPassword());
			model.addAttribute("errmsg1", "user Details error");

			redirectAttrs.addFlashAttribute("errmsg1", "user Details error");

			return "redirect:" + "getlogin";
		}

		return null;

	}

}
