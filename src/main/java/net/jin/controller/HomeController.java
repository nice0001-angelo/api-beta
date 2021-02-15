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
		DateFormat dateFormat3 = DateFormat.getDateInstance(DateFormat.LONG);
		
		String formatedDate1 = dateFormat1.format(date);
		System.out.println("formatedDate1 :"+formatedDate1);
		model.addAttribute("serverTime1", formatedDate1);
		
		String formatedDate2 = dateFormat2.format(date);
		System.out.println("formatedDate2 :"+formatedDate2);
		model.addAttribute("serverTime2", formatedDate2);
		
		String formatedDate3 = dateFormat3.format(date);
		System.out.println("formatedDate3 :"+formatedDate3);
		model.addAttribute("serverTime3", formatedDate3);
		
		
		return "home";
	}
}
