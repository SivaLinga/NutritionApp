package com.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.dao.Nutritionrepo;
import com.nutrition.model.NutritionModel;

@Service
public class NutritionService {
	@Autowired
	Nutritionrepo nr;
	
	public Nutritionrepo food(NutritionModel nutritionmodel) {
		return (Nutritionrepo) nr.save(nutritionmodel);
		
	}
	

}
