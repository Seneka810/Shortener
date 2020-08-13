package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.entity.Customer;
import com.company.entity.Link;
import com.company.role.CustomerRole;
import com.company.service.CustomerService;
import com.company.service.LinkService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	LinkService linkService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Link linkObj;
	
    @RequestMapping("/")
    public String mainPage(Model model){
        User user = getCurrentUser();

        String login = user.getUsername();
        Customer customer = customerService.findByLogin(login);
        List<Link> links= linkService.getAllLinks();

        model.addAttribute("login", login);
        model.addAttribute("shortLink", customer.getLink());
        model.addAttribute("links", links);
        model.addAttribute("counts", linkObj.getCount());
        
        return "index";
    }
    
    @RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         Model model) {
        String passHash = passwordEncoder.encode(password);
        String link = login + ".com";

        if ( ! customerService.addUser(login, passHash, link, CustomerRole.USER)) {
            model.addAttribute("exists", true);
            model.addAttribute("login", login);
            return "register";
        }

        return "redirect:/";
    }
    
    @RequestMapping(value = "/addlink", method = RequestMethod.POST)
    public String addLinks(@RequestParam String link) {

    	linkObj.setLink(link);
    	
    	linkService.addLink(linkObj);

        return "redirect:/";
    }
    
    @RequestMapping(value = "/countlink", method = RequestMethod.GET)
    public String countLinks(@RequestParam long id, 
    						 @RequestParam String link, 
    						 @RequestParam int count) {

    	Link longLink = linkService.getLinkById(id);
    	longLink.setCount(++count);
    	
    	linkService.addLink(longLink);
    	
        return "redirect:" + link;
    }

	@RequestMapping("/login")
	public String loginPage() {
		linkService.addLinks();
		return "login";
	}
	
	@RequestMapping("/register")
    public String register() {
        return "register";
    }
	
	@RequestMapping("/unauthorized")
    public String unauthorized(Model model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }
	
	private User getCurrentUser() {
        return (User)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

}
