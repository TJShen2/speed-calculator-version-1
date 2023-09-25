package transitvehiclespeedcalculator;

public class TransitVehicle {
    
    private double stationCount;
    private double accelerationRate; // m/s^2
    private double decelerationRate; // m/s^2
    private double stationDwellTime; // s
    private double lineLength; // m
    private double topSpeed; // m/s

    private double stationSpacing;
    public double getStationSpacing() { return stationSpacing; }
    public void setStationSpacing(double value) { stationSpacing = value; }

    private double averageSpeed;
    public double getAverageSpeed() { return averageSpeed; }
    public void setAverageSpeed(double value) { averageSpeed = value; }

    private double[] attributes = {6};
    public double[] getAttributes() { return attributes; }
    public void setAttributes(double[] value) { attributes = value; }

    private double timeWithoutStations;
    private double timeLossAtEachStation;
    private double totalTimeRequired;

    public TransitVehicle(double stationCount, double accelerationRate, double decelerationRate, double stationDwellTime, double lineLength, double topSpeed) {
        double[] attributes = {stationCount, accelerationRate, decelerationRate, stationDwellTime, lineLength, topSpeed * 3.6};

        this.stationCount = stationCount;
        this.accelerationRate = accelerationRate;
        this.decelerationRate = decelerationRate;
        this.stationDwellTime = stationDwellTime;
        this.lineLength = lineLength;
        this.topSpeed = topSpeed / 3.6; //Convert km/h to m/s
        this.attributes = attributes;
    }

    public void determineTrainSpeed() {
        stationSpacing = lineLength/stationCount;
        averageSpeed = 3.6 * (stationSpacing)/(stationDwellTime + (4 * topSpeed)/(accelerationRate + decelerationRate) + (stationSpacing/topSpeed - topSpeed/accelerationRate/2 - topSpeed/decelerationRate/2));
        attributes[5] = topSpeed * 3.6;
    }

    public void determineTrainSpeedAlternative() {
        stationSpacing = lineLength/stationCount;
        timeWithoutStations = lineLength/topSpeed;
        timeLossAtEachStation = stationDwellTime + topSpeed/accelerationRate/2 + topSpeed/decelerationRate/2;
        totalTimeRequired = timeWithoutStations + stationCount * timeLossAtEachStation;
        averageSpeed = lineLength/totalTimeRequired;
    }
}