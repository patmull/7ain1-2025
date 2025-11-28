import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> ingredientsCarbonara = new ArrayList<>();
        ingredientsCarbonara.add("bucatini");
        ingredientsCarbonara.add("guanciale");
        ingredientsCarbonara.add("garlic");
        ingredientsCarbonara.add("pecorino");
        ingredientsCarbonara.add("vejce");
        ingredientsCarbonara.add("černý pepř");

        for(int i = 0; i < ingredientsCarbonara.size(); i++) {
            System.out.println(ingredientsCarbonara.get(i));
        }

        System.out.println("Carbonara ingredients:");
        for(String ingredient : ingredientsCarbonara) {
            System.out.println(ingredient);
        }
        ingredientsCarbonara.remove("garlic");
        System.out.println("Authentic carbonara ingredients:");
        for(String ingredient : ingredientsCarbonara) {
            System.out.println(ingredient);
        }

        String searchedIngredient = "garlic";
        System.out.println("Does authentic carbonoara contains " + searchedIngredient + "?");
        System.out.println(ingredientsCarbonara.contains("garlic"));

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