import java.util.*;


class ClassTypeComparator implements Comparator<Device> {
    @Override
    public int compare(Device a, Device b) {
        if(a instanceof Dishwasher) {
            return -1;
        } else if(a instanceof Refrigerator) {
            if(b instanceof Dishwasher) return 1;
            else return -1;
        } else {
            if(b instanceof Dishwasher || b instanceof Refrigerator) return 1;
            else return -1;
        }
    }
}

class BrandComparator implements Comparator<Device> {
    public int compare(Device a, Device b) {
        return a.getBrand().compareToIgnoreCase(b.getBrand());
    }
}

public class Catalog {
    private List<Device> deviceList;

    public Catalog() {
        this.deviceList = new ArrayList<>();
    }

    public void addDevice(Device a) {
        this.deviceList.add(a);
    }

    public void sortByClass() {
        Collections.sort(deviceList,new ClassTypeComparator());
    }

    public void sortByBrand() {
        Collections.sort(deviceList, new BrandComparator());
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "deviceList=" + deviceList +
                '}';
    }
}
