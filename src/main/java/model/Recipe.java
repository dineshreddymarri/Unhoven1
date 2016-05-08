package main.java.model;

import java.util.ArrayList;

public class Recipe {
	private int number_of_servings;
	private long recipe_id;
	private ArrayList<Ingredient> ingredients;
	private User author;


	public int getNumber_of_servings() {
		return number_of_servings;
	}


	public void setNumber_of_servings(int number_of_servings) {
		this.number_of_servings = number_of_servings;
	}


	public long getRecipe_id() {
		return recipe_id;
	}


	public void setRecipe_id(long recipe_id) {
		this.recipe_id = recipe_id;
	}


	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}

}
