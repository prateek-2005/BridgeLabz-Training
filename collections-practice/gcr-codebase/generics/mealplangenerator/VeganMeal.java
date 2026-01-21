package mealplangenerator;
public class VeganMeal implements MealPlan {
    @Override
    public void prepareMeal() {
        System.out.println("Preparing Vegan Meal: Salad, Fruits, Plant-based food");
    }
    @Override
    public String getMealType() {
        return "Vegan";
    }
}

