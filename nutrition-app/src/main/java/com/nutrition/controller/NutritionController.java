package com.nutrition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrition.model.NutritionModel;
import com.nutrition.service.NutritionService;
import java.util.*;

@Controller
@ControllerAdvice
public class NutritionController {
	@Autowired
	NutritionService nutritionService;
	NutritionModel fooddao;

	@RequestMapping("home")
	public String home() {
		return "home";
	}

	// ajax call
	@GetMapping("foodnamelist")
	@ResponseBody
	public String getsearchfood(@RequestParam("foodName") String foodname) {
		List<String> foodnamelist = new ArrayList<String>();
		List<NutritionModel> list = nutritionService.getFoodList(foodname);
		for (NutritionModel nutritionModel : list) {
			foodnamelist.add(nutritionModel.getFoodname());
		}

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = Obj.writeValueAsString(foodnamelist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}

	@RequestMapping("searchfood")
	public ModelAndView searchfood(@RequestParam("fooditem") String foodname,ModelMap map) {
		fooddao=nutritionService.getSearchFood(foodname);
		ModelAndView mv=new ModelAndView();
		map.addAttribute("fooddao",fooddao);
        mv.addObject("fooddao",fooddao);
        mv.setViewName("searchfood");
		return mv;
	}

	@RequestMapping("customfood")
	public String customfood() {

		return "customfood";
	}

	@RequestMapping(value = "foodservice")
	public ModelAndView foodService(@ModelAttribute("food") NutritionModel nutritionModel, BindingResult result) {
		// System.out.println("nutritionmodel executed");
		// System.out.println(nutritionModel);
		fooddao = nutritionService.createFood(nutritionModel);
		ModelAndView mv=new ModelAndView();
		//System.out.println(fooddao);
		mv.addObject("fooddao", fooddao);
		mv.setViewName("home");
		return mv;
	}

}