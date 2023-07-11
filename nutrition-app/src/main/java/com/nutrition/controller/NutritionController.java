package com.nutrition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nutrition.dao.Nutritionrepo;
import com.nutrition.model.NutritionModel;
import com.nutrition.service.NutritionService;


@Controller
public class NutritionController {
	@Autowired
	NutritionService nutritionService;

    @RequestMapping("home")
    public String home(){
        return "home";
    }
    @RequestMapping("searchfood")
	public String searchfood() {
		return "searchfood.jsp";
	}
    @RequestMapping("customfood")
	public String customfood() {

		return "Customfood.jsp";
	}
    @RequestMapping(path = "foodservice", consumes ={MediaType.ALL_VALUE})
	public String foodService(@RequestBody NutritionModel nutritionmodel) {
		System.out.print("HELLOO");
		Nutritionrepo ns=nutritionService.food(nutritionmodel);
		System.out.println(ns);
		return "FoodTrack.jsp";
	}
    


}