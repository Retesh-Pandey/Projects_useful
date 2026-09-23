import java.util.*;

class Shoe {
    private String type;
    private String brand;

    public Shoe(String type, String brand) {
        this.type = type;
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand + " " + type;
    }
}

class Person {
    private String name;
    private List<Shoe> favoriteShoes;

    public Person(String name) {
        this.name = name;
        this.favoriteShoes = new ArrayList<>();
    }

    public void addInterest(Shoe shoe) {
        favoriteShoes.add(shoe);
    }

    public void showInterests() {
        System.out.println(name + " is interested in:");
        for (Shoe shoe : favoriteShoes) {
            System.out.println("- " + shoe);
        }
    }
}

public class ShoeInterestDemo {
    public static void main(String[] args) {
        Shoe sneaker = new Shoe("Sneakers", "Nike");
        Shoe formal = new Shoe("Formal Shoes", "Allen Solly");
        Shoe boots = new Shoe("Boots", "Woodland");

        Person person = new Person("Retesh");
        person.addInterest(sneaker);
        person.addInterest(boots);

        person.showInterests();
    }
}
