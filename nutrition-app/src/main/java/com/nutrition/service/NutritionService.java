package com.nutrition.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nutrition.dao.NutritionRepo;
import com.nutrition.model.NutritionModel;

@Service
public class NutritionService {
	@Autowired
	NutritionRepo nutritionRepo;
	NutritionModel fooddao;

	public NutritionModel createFood(NutritionModel nutritionModel) {
		fooddao = nutritionRepo.createFoodDetails(nutritionModel);
		// System.out.println(fooddao);
		return fooddao;

	}

	public List<NutritionModel> getFoodList(String foodname) {
		List<NutritionModel> list;
		list = nutritionRepo.getFoodList(foodname);
		return list;

	}

	public NutritionModel getSearchFood(String foodname) {
		return nutritionRepo.getSearchFood(foodname);		
	}

}
