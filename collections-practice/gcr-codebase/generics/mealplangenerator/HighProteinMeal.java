package mealplangenerator;
public class HighProteinMeal implements MealPlan {
    @Override
    public void prepareMeal() {
        System.out.println("Preparing High Protein Meal: Chicken, Paneer, Protein Shake");
    }
    @Override
    public String getMealType() {
        return "High Protein";
    }
}

