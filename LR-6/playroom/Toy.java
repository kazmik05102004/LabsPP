package playroom;

public class Toy {
    private String name;
    private String type;
    private String price;
    private String gender;
    private String size;

    public Toy(String name, String type, String price, String gender, String ageCategory) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.gender = gender;
        this.size = ageCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Назва:'" + name + '\'' +
                ", тип:'" + type + '\'' +
                ", ціна:'" + price + '\'' +
                ", стать:'" + gender + '\'' +
                ", розмір:'" + size + '\n';
    }
}
