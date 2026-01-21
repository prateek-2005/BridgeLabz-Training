package mealplangenerator;
public class Main {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        Meal<VegetarianMeal> meal1 = new Meal<>(veg);
        meal1.showMeal();
        MealGenerator.generateMeal(vegan);
        MealGenerator.generateMeal(keto);
    }
}

