/**
 * 
 */
package net.jin.controller;

import java.text.*;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author njh
 *
 */
@Controller
public class HomeController {
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
        Date date = new Date();
		DateFormat dateFormat1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.FULL);
		
		String formatedDate1 = dateFormat1.format(date);
		System.out.println("formatedDate1 :"+formatedDate1);
		model.addAttribute("serverTime1", formatedDate1);
		
		String formatedDate2 = dateFormat2.format(date);
		System.out.println("formatedDate2 :"+formatedDate2);
		model.addAttribute("serverTime2", formatedDate2);
		
		
		
		return "home";
	}
}
