@SuppressWarnings("rawtypes")
public class Car implements Comparable {
    private int price;
    private int year;
    private int horsePower;

    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public int compareTo(Object obj) {
        Car other = (Car) obj;

        int priceDifference = other.price - this.price;
        if (priceDifference != 0) {
            return priceDifference;
        }

        int yearDifference = this.year - other.year;
        if (yearDifference != 0) {
            return yearDifference;
        }

        return this.horsePower - other.horsePower;
    }
}