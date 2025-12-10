import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String ingredients[] = {"bucatini", "pepper"};

    public static void main(String[] args) {
        enum CarbonaraRecipe {
            BUCATINI,
            GUANCIALE,
            BLACK_PEPPER
        }

        for(CarbonaraRecipe ingredient : CarbonaraRecipe.values()) {
            System.out.println(ingredient);
        }

        int dayInWeek = 3;
        switch(dayInWeek) {
            case 1:
                System.out.println("Pondělí");
            case 2:
                System.out.println("Úterý");
            case 3:
                System.out.println("Středa");
            default:
                System.out.println("je dnes.");
        }

        if(dayInWeek == 1) {
            System.out.println("Pondělí");
        } else if (dayInWeek == 2) {
            System.out.println("Úterý");
        } else if (dayInWeek == 3) {
            System.out.println("Středa");
        }
        System.out.println("je dnes.");



        ArrayList<String> recipeIngredients = new ArrayList<>();
        // String[] ingredients = {"bucatini", "guanciale", "garlic"};
        recipeIngredients.add("bucatini");
        recipeIngredients.add("guanciale");
        recipeIngredients.add("garlic");
        recipeIngredients.add("pecorino");
        recipeIngredients.add("vejce");
        recipeIngredients.add("černý pepř");

        System.out.println("Hledaná ingredience:");
        Scanner scanner = new Scanner(System.in);
        String searchedIngredientUserInput = scanner.nextLine();

        System.out.println("searchedIngredientUserInput:");
        System.out.println(searchedIngredientUserInput);

        // 1: jednoduchý způsob pomocí ArrayList a contains
        /*
        boolean doesIngredientBelongInRecipe = true;
        if(!recipeIngredients.contains(searchedIngredientUserInput)) {
            doesIngredientBelongInRecipe = false;
        }
        */
        // 2: způsob procházení "ručně" pro ArrayList, ale i klasická pole
        boolean doesIngredientBelongInRecipe = false;
        for(int i = 0; i < recipeIngredients.size(); i++) {
            if(recipeIngredients.get(i).equals(searchedIngredientUserInput)) {
                doesIngredientBelongInRecipe = true;
                break;
            }
        }

        if (doesIngredientBelongInRecipe == true) {
            System.out.println("Hledaná ingredience patří do receptu.");
        } else {
            System.out.println("Hledaná ingredience nepatří do receptu.");
            System.out.println("Do autentického receptu patří ve skutečnosti: ");
            for (String ingredient : recipeIngredients) {
                System.out.println(ingredient);
            }
        }

        System.out.println("Carbonara ingredients:");
        for(String ingredient : recipeIngredients) {
            System.out.println(ingredient);
        }
        recipeIngredients.remove("garlic");
        System.out.println("Authentic carbonara ingredients:");
        for(String ingredient : recipeIngredients) {
            System.out.println(ingredient);
        }

        String searchedIngredient = "garlic";
        System.out.println("Does authentic carbonoara contains " + searchedIngredient + "?");
        System.out.println(recipeIngredients.contains("garlic"));

        int size = 5;
        int[] measurements2 = new int[size];
        // measurements2[7] = 3; // ERROR
        // ...
        int measurement_item_1 = 45;
        measurements2[0] = measurement_item_1;
        measurements2[4] = 30;

        measurements2 = new int[1000];

        for (int i = 0; i < measurements2.length; i++) {
            System.out.println(measurements2[i]);
        }

        for(int measurement : measurements2) {
            System.out.println(measurement);
        }

        int[] estimates = {2, 4, 8, 16, 32, 64, 128};
        int[] testMeasurements = {1, 5, 10, 16, 30, 100, 120};

        if (estimates.length != testMeasurements.length) {
            System.out.println("ERROR: estimates and test sets needs have same number of items");
            return;
        }

        int error = 0;
        for (int i = 0; i < estimates.length; i++) {
            error += Math.pow(estimates[i] - testMeasurements[i],2);
        }
        System.out.println("Model error:");
        System.out.println(Math.sqrt(error));

        int[] measurement = {2, 4, 8, 16, 32, 64, 128};
        measurement[4] = 64;

        int N = 4;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum = sum + (int) Math.pow(measurement[i],2);
        }

        for(int i = 0; i < N; i++) {
            sum = sum + (int) Math.pow(measurement[i],2);
        }
        System.out.println("Result of sum: ");
        System.out.println(sum);

        Person person = new Person();
        person.firstName = "Jan";
        System.out.println(person.firstName);

        System.out.println(measurement.length);
        System.out.println("Original measurements:");

        for(int index = 0; index < measurement.length; index++) {
            System.out.println(measurement[index]);
            // measurement[index] = measurement[index] * measurement[index];
            measurement[index] = (int) Math.pow(measurement[index], 2);
            // int[] measurements2 = {12,5634,444,2342};
        }

        for(int index = 0; index < measurement.length; index++) {
            System.out.println(measurement[index]);
            measurement[index] = measurement[index] * 100;
            // int[] measurements2 = {12,5634,444,2342};
        }
        System.out.println("After conversion:");
        for (int i = 0; i < measurement.length; i++) {
            System.out.println(measurement[i]);
            // measurement2 // ERROR
        }

        String[] carbonaraIngredient = {"bucatini","guanciale","vejce","pecorino","černý pepř"};
        System.out.println("Ingredience do autentických carbonara:");
        for (int i = 0; i < carbonaraIngredient.length; i++) {
            System.out.println(carbonaraIngredient[i]);
        }

        Ingredient ingredientBucatini = new Ingredient("bucatini");
        ingredientBucatini.quantity = 400;
        ingredientBucatini.quantityUnit = "g";
        ingredientBucatini.instruction = "Dejte do hodně osolené vroucí vody a vařte 9 minut nebo dokud nejsou těstoviny al-dente";

        Ingredient ingredientGuanciale = new Ingredient("guanciale");
        ingredientGuanciale.quantity = 150;
        ingredientGuanciale.quantityUnit = "g";
        ingredientGuanciale.instruction = "Vložte na pánev a na mírném ohni opékejte do zhnědnutí.";

        Ingredient[] ingredients = {ingredientBucatini, ingredientGuanciale};

        for(int i = 0; i < ingredients.length; i++) {
            int step = i+1;
            //System.out.println("Krok č. " + (i+1) + ".");
            System.out.println("Krok č. " + step + ".");
            System.out.println(ingredients[i].name);
            System.out.println(ingredients[i].quantity + ingredients[i].quantityUnit);
            System.out.println(ingredients[i].instruction);
        }

        // if ArrayList was used:
        // ingredients.remove(ingredientBucatini);


    }
}