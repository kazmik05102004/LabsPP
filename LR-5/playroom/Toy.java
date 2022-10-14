package playroom;

public class Toy {
    public String name;
    public String type;
    public int price;
    public String gender;
    public int ageCategory;

    public Toy(String name, String type, int price, String gender, int ageCategory) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.gender = gender;
        this.ageCategory = ageCategory;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }
}
