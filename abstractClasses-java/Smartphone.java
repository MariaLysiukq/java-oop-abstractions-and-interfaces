public class Smartphone implements GPS, Cellular {
    private double latitude;
    private double longitude;

    public Smartphone(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double[] getCoordinates() {
        return new double[]{latitude, longitude};
    }

    @Override
    public void makeCall() {
        System.out.println("Calling...");
    }

    @Override
    public void receiveCall() {
        System.out.println("Receiving call...");
    }
}