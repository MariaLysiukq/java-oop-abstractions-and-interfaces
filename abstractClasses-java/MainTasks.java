public class MainTasks {
    public static void main(String[] args) {
        System.out.println("авдання 2");
        Point p = new Point(0, 0);
        p.moveTo(5.5, 10.2);
        System.out.println("Point coordinates: X=" + p.getX() + ", Y=" + p.getY());

        System.out.println("\nЗавдання 3");
        Smartphone phone = new Smartphone(46.4825, 30.7233);
        double[] coords = phone.getCoordinates();
        System.out.println("Smartphone GPS: " + coords[0] + ", " + coords[1]);
        phone.makeCall();

        System.out.println("\nЗавдання 4");
        Car car1 = new Car(15000, 2015, 120);
        Car car2 = new Car(15000, 2018, 110);
        int compareResult = car1.compareTo(car2);
        
        if (compareResult < 0) {
            System.out.println("car1 'менший' за car2");
        } else if (compareResult > 0) {
            System.out.println("car1 'більший' за car2");
        } else {
            System.out.println("Автомобілі рівні");
        }
    }
}