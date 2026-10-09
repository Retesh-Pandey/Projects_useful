import java.util.ArrayList;
import java.util.List;

// Car class
class Car {
    private String model;
    private String engineType;
    private double price;

    public Car(String model, String engineType, double price) {
        this.model = model;
        this.engineType = engineType;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getEngineType() {
        return engineType;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Engine: " + engineType + ", Price: $" + price);
    }
}

// ProductionLine class
class ProductionLine {
    private List<Car> carsProduced;

    public ProductionLine() {
        carsProduced = new ArrayList<>();
    }

    public void produceCar(String model, String engineType, double price) {
        Car car = new Car(model, engineType, price);
        carsProduced.add(car);
        System.out.println("Produced: " + model);
    }

    public void showProduction() {
        System.out.println("\n--- Cars Produced ---");
        for (Car car : carsProduced) {
            car.displayInfo();
        }
    }
}

// Company class
class Company {
    private String name;
    private ProductionLine productionLine;

    public Company(String name) {
        this.name = name;
        this.productionLine = new ProductionLine();
    }

    public void produceCar(String model, String engineType, double price) {
        productionLine.produceCar(model, engineType, price);
    }

    public void showCompanyProduction() {
        System.out.println("\nCompany: " + name);
        productionLine.showProduction();
    }
}

// Main class
public class CarProductionCompany {
    public static void main(String[] args) {
        Company company = new Company("Retesh Motors");

        company.produceCar("Sedan X1", "Petrol", 15000);
        company.produceCar("SUV Z5", "Diesel", 25000);
        company.produceCar("Eco E2", "Electric", 30000);

        company.showCompanyProduction();
    }
}
