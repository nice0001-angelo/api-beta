/**
 * 
 */
package net.jin.controller;

import java.text.*;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author njh
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.get(DateFormat.LONG, DateFormat.LONG, Locale);
		
		return "home";
	}
}
