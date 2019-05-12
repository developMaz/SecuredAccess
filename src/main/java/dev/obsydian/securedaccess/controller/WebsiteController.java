package dev.obsydian.securedaccess.controller;

import dev.obsydian.securedaccess.domain.User;
import dev.obsydian.securedaccess.mapper.UserMapper;
import dev.obsydian.securedaccess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class WebsiteController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String login() {
		return "form/signIn";
	}


	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("form/signUp");
		return modelAndView;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		User checkUser = userService.findUser(user.getEmail());

		if(checkUser != null) {
			bindingResult.rejectValue("email", "error.user", "User alredy exits, try to log in");
		} if (bindingResult.hasErrors()) {
			modelAndView.setViewName("form/signUp");

		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been register");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("form/signUp");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUser(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getSecondName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value = "/site", method = RequestMethod.GET)
	public String site() {
		return "site/index";
	}
}

