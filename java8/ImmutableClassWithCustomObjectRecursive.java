final class Employee2 {
    private final String empName;
    private final int age;
    private final Address2 address;
    public Employee2(String name, int age, Address2 address) {
        super();
        this.empName = name;
        this.age = age;
        this.address = new Address2(address.getAddressType(), address.getAddress(), address.getCoordinates());
    }
    public String getEmpName() {
        return empName;
    }
    public int getAge() {
        return age;
    }
    /* public Address getAddress() {
       return address;
       }
    */
    public Address2 getAddress() throws CloneNotSupportedException {
        return (Address2) address.clone();
    }
}

class Coordinates {
    int longitude;

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    int latitude;

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public Coordinates(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
// Address.java
class Address2 implements Cloneable {
    public String addressType;
    public String address;
    public Coordinates coordinates;
    public Address2(String addressType, String address, Coordinates coordinates) {
        super();
        this.addressType = addressType;
        this.address = address;
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude());
    }
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address Type - "+addressType+", address - "+address+", city - "+coordinates;
    }
}

// MainClass.java
public class ImmutableClassWithCustomObjectRecursive {
    public static void main(String[] args) throws Exception {
        Coordinates c = new Coordinates(3, 4);
        Employee2 emp = new Employee2("Adithya", 34, new Address2("Home", "Madhapur", c));
        Address2 address = emp.getAddress();
        System.out.println(address);
        address.setAddress("Hi-tech City");
        address.setAddressType("Office");
        c.setLatitude(1);
        c.setLongitude(2);
        address.setCoordinates(c);
        System.out.println(emp.getAddress());
    }
}