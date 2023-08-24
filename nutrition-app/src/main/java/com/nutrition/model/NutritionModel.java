package com.nutrition.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NutritionModel {
		@Id
		@GeneratedValue
		private int foodid;
		@Column(unique=true)
		private String foodname;
		private int quantity;
		private String servingsize;
		private int calories;


		public String getFoodname() {
			return foodname;
		}

		public void setFoodname(String foodname) {
			this.foodname = foodname;
		}
		

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getCalories() {
			return calories;
		}

		public void setCalories(int calories) {
			this.calories = calories;
		}
		

		public String getServingsize() {
			return servingsize;
		}

		public void setServingsize(String servingsize) {
			this.servingsize = servingsize;
		}

		@Override
		public String toString() {
			return "NutritionModel [foodname=" + foodname + ", quantity=" + quantity + ", calories=" + calories
					+ ", servingsize=" + servingsize + "]";
		}

}
