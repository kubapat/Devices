import java.util.Objects;

public class Washer extends Device {
    private int rotations;

    public Washer(String brand, String modelCode, String capacity, String energyLabel, int price, int rotations) {
        super(brand, modelCode, capacity, energyLabel, price);
        this.rotations = rotations;
    }

    public int getRotations() {
        return rotations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Washer washer = (Washer) o;
        return rotations == washer.rotations;
    }

    @Override
    public String toString() {
        return "Washer{" +
                "brand='" + brand + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", capacity='" + capacity + '\'' +
                ", energyLabel='" + energyLabel + '\'' +
                ", price=" + price +
                ", rotations=" + rotations +
                '}';
    }
}
