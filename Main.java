//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] listOfNumbers = {1,2,4,8,16,32,64,128};
        listOfNumbers[5] = 0;

        for (int i = 0; i < listOfNumbers.length; i++) {
            System.out.println((int) Math.pow(listOfNumbers[i], 2));
        }

        String[] carbonaraIngredients = {"bucatini","guanciale","egg","pecorino","black pepper"};
        System.out.println("Authentic carbonara:");
        for (int i = 0; i < carbonaraIngredients.length; i++) {
            System.out.println(carbonaraIngredients[i]);
        }
        // same with instructions...

        int error = 0;
        int[] test_output_data = {1,2,4,8,16,32,64,128};
        int[] test_estimates = {1,2,2,8,15,32,102,130};

        if(test_estimates.length != test_output_data.length) {
            System.out.println("test_estimates and test_output_data needs to be equal length!");
            return;
        }

        for (int i = 0; i < test_estimates.length; i++) {
            error += (int) Math.pow((test_output_data[i] - test_estimates[i]),2);
        }

        System.out.println("Error in our model: " + Math.sqrt(error));

        // Example: do the ingredients but in the OOP way
        Ingredient ingredient1 = new Ingredient("X");
        ingredient1.setInstructions("Put water in large pot and salt the water a lot. Boil for 9 minutes or until al dente.");
        Ingredient ingredient2 = new Ingredient("Y");
        Ingredient ingredient3 = new Ingredient("Z");
        Ingredient ingredient4 = new Ingredient("XY");

        Ingredient[] ingredients = {ingredient1, ingredient2, ingredient3, ingredient4};
        for (int i = 0; i < ingredients.length; i++) {
            System.out.println(ingredients[i].getInstructions());
        }

        // null values: show that I can set to null, but you should generally avoid this...
        // this is rather practise from C/C++ where you may want to free some memory
        // in Java there is very little reasons to do it, because you have garbage collector
        // -- little bit like a wash disher or laundry machine or human immunity
        // not something intelligent, but automated and complex and reliable
    }
}