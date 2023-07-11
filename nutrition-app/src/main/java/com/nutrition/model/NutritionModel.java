package com.nutrition.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class NutritionModel {
		@Id
		private int food_id;
		private String food_name;
		private int food_quantity;
		private int food_calories;
		
		
		public int getFood_id() {
			return food_id;
		}
		public void setFood_id(int food_id) {
			this.food_id = food_id;
		}
		public String getFood_name() {
			return food_name;
		}
		public void setFood_name(String food_name) {
			this.food_name = food_name;
		}
		public int getFood_quantity() {
			return food_quantity;
		}
		public void setFood_quantity(int food_quantity) {
			this.food_quantity = food_quantity;
		}
		public int getFood_calories() {
			return food_calories;
		}
		public void setFood_calories(int food_calories) {
			this.food_calories = food_calories;
		}
		@Override
		public String toString() {
			return "NutritionModel [food_id=" + food_id + ", food_name=" + food_name + ", food_quantity=" + food_quantity
					+ ", food_calories=" + food_calories + "]";
		}
	}
