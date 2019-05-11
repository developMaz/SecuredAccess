package dev.obsydian.securedaccess.controller;

import dev.obsydian.securedaccess.domain.User;
import dev.obsydian.securedaccess.mapper.UserMapper;
import dev.obsydian.securedaccess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
		return "site/index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("newUser", new User());
		return "form/logout";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("form/signUp");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
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


}

