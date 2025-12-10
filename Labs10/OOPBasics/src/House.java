public class House {
    public int area; // *
    double areaDecimal;
    private String colorText;
    private Color color;

    House(double area) {
        this.areaDecimal = area;
    }

    House() {
        this.color = new Color("white");
    }

    House(int area) {
        this.area = area;
    }

    public void heatOn() {
        System.out.println("Turning heat on...");
    }

    public void lockDoors() {
        System.out.println("Locking doors...");
    }

    public void setColor(String colorText) {
        colorText = "black";
        this.colorText = colorText;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getColorText() {
        return this.colorText;
    }

    public String getOwnColorText() {
        return this.color.colorName;
    }

    @Override
    public String toString() {
        return "House: " +
                "area: " + area +
                ", color text: " + colorText;
    }
}
