package transitvehiclespeedcalculator;

public class TransitVehicle {
    private double stationCount;
    private double accelerationRate; // m/s^2
    private double decelerationRate; // m/s^2
    private double stationDwellTime; // s
    private double lineLength; // m
    private double topSpeed; // m/s

    public double stationSpacing;
    public double averageSpeed;

    public double[] attributes = {stationCount, accelerationRate, decelerationRate, stationDwellTime, lineLength, topSpeed};

    private double timeWithoutStations;
    private double timeLossAtEachStation;
    private double totalTimeRequired;

    public TransitVehicle(double stationCount, double accelerationRate, double decelerationRate, double stationDwellTime, double lineLength, double topSpeed) {
        this.stationCount = stationCount;
        this.accelerationRate = accelerationRate;
        this.decelerationRate = decelerationRate;
        this.stationDwellTime = stationDwellTime;
        this.lineLength = lineLength;
        this.topSpeed = topSpeed / 3.6; //Convert km/h to m/s
    }

    public void determineTrainSpeed() {
        stationSpacing = lineLength/stationCount;
        averageSpeed = 3.6 * (stationSpacing)/(stationDwellTime + (4 * topSpeed)/(accelerationRate + decelerationRate) + (stationSpacing/topSpeed - topSpeed/accelerationRate/2 - topSpeed/decelerationRate/2));
        double[] attributes = {stationCount, accelerationRate, decelerationRate, stationDwellTime, lineLength, topSpeed * 3.6};
        this.attributes = attributes;
    }

    public void determineTrainSpeedAlternative() {
        stationSpacing = lineLength/stationCount;
        timeWithoutStations = lineLength/topSpeed;
        timeLossAtEachStation = stationDwellTime + topSpeed/accelerationRate/2 + topSpeed/decelerationRate/2;
        totalTimeRequired = timeWithoutStations + stationCount * timeLossAtEachStation;
        averageSpeed = lineLength/totalTimeRequired;
    }
}