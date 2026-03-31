package mealplangenerator;
public class MealGenerator {
    public static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generating personalized meal...");
        System.out.println("Selected Type: " + meal.getMealType());
        meal.prepareMeal();
    }
}

