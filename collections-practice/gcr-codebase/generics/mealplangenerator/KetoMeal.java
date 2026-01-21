package mealplangenerator;
public class KetoMeal implements MealPlan {
    @Override
    public void prepareMeal() {
        System.out.println("Preparing Keto Meal: Eggs, Cheese, Avocado");
    }
    @Override
    public String getMealType() {
        return "Keto";
    }
}

