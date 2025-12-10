public class Main {
    public static void main(String[] args) {
        House house = new House(30);
        House house2 = new House(35);
        House house3 = new House(45.6);
        String colorText = "white";
        System.out.println("Before calling setColor()");
        System.out.println(colorText);
        house.setColor(colorText);
        System.out.println("After calling setColor()");
        System.out.println(colorText);
        // Color color1 = new Color("orange");
        // house.setColor(color1);
        house.setColor(new Color("orange"));

        System.out.println(house.getColorText());
        System.out.println(house.area);

        house.area = 100000;
        // house.color = "black"; // ERROR
        System.out.println(house.area);

        System.out.println(house);

        for(String ingredients
                : Ingredient.ingredients) {
            System.out.println(ingredients);
        }
    }
}