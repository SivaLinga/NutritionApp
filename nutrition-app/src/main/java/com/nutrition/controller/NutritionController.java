package com.nutrition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.nutrition.model.NutritionModel;
import com.nutrition.service.NutritionService;
import java.util.*;


@Controller
@ControllerAdvice
public class NutritionController {
	@Autowired
	NutritionService nutritionService;

    @RequestMapping("home")
    public String home(){
        return "home";
    }
    
    @RequestMapping("searchfood")
	public String searchfood() {
		return "searchfood";
	}
    
    @RequestMapping("customfood")
	public String customfood() {

		return "customfood";
	}
    @RequestMapping(path="foodservice",method = RequestMethod.POST)
	public String foodService(@ModelAttribute("nutritionmodel") NutritionModel nutritionmodel, BindingResult bindingResult){    
    	System.out.println("nutritionmodel executed");
		return "home";
	}
    


}