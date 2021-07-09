public class Lamp {
    private double shiningAmount;
    private String typeAutoorManual;
    private boolean battery;
    private int globRating;

    public Lamp(double shiningAmount, String typeAutoorManual, boolean battery, int globRating) {
        this.shiningAmount = shiningAmount;
        this.typeAutoorManual = typeAutoorManual;
        this.battery = battery;
        this.globRating = globRating;
    }


    public void turnOn(){
        this.battery = true;
        System.out.println("turning lamp on");
    }
    public double getShiningAmount() {
        return shiningAmount;
    }

    public void setShiningAmount(double shiningAmount) {
        this.shiningAmount = shiningAmount;
    }

    public String getTypeAutoorManual() {
        return typeAutoorManual;
    }

    public void setTypeAutoorManual(String typeAutoorManual) {
        this.typeAutoorManual = typeAutoorManual;
    }

    public boolean isBattery() {
        return battery;
    }

    public void setBattery(boolean battery) {
        this.battery = battery;
    }

    public int getGlobRating() {
        return globRating;
    }

    public void setGlobRating(int globRating) {
        this.globRating = globRating;
    }
}
