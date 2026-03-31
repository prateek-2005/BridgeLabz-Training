package mealplangenerator;
public class VegetarianMeal implements MealPlan {
    @Override
    public void prepareMeal() {
        System.out.println("Preparing Vegetarian Meal: Dal, Roti, Sabzi");
    }
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
}

