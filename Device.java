import java.util.Objects;

public abstract class Device {
    protected String brand;
    protected String modelCode;
    protected String capacity;
    protected String energyLabel;
    protected int price;

    public Device(String brand, String modelCode, String capacity, String energyLabel, int price) {
        this.brand = brand;
        this.modelCode = modelCode;
        this.capacity = capacity;
        this.energyLabel = energyLabel;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelCode() {
        return modelCode;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getEnergyLabel() {
        return energyLabel;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return capacity == device.capacity && price == device.price && Objects.equals(brand, device.brand) && Objects.equals(modelCode, device.modelCode) && Objects.equals(energyLabel, device.energyLabel);
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", capacity='" + capacity + '\'' +
                ", energyLabel='" + energyLabel + '\'' +
                ", price=" + price +
                '}';
    }
}
