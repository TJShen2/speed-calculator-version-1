package transitvehiclespeedcalculator;

public class TransitVehicle {
    
    private String name;
    public String getName() { return name; }
    public void setName(String value) { name = value; }

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

    private double percentTopSpeed;
    public double getPercentTopSpeed() { return percentTopSpeed; }
    public void setPercentTopSpeed(double value) { percentTopSpeed = value; }

    //For determineTrainSpeed()
    private double accelerationTime;
    private double accelerationDistance;

    private double decelerationTime;
    private double decelerationDistance;

    private double minimumDistance;
    private double topSpeedTime;
    private double averageSpeedDuringAcceleration;
    private double averageSpeedDuringDeceleration;

    //For determineTrainSpeedAlternative()
    private double timeWithoutStations;
    private double timeLossAtEachStation;
    private double totalTimeRequired;

    public TransitVehicle(String name, double stationCount, double accelerationRate, double decelerationRate, double stationDwellTime, double lineLength, double topSpeed) {
        double[] attributes = {stationCount, accelerationRate, decelerationRate, stationDwellTime, lineLength, topSpeed * 3.6};

        this.name = name;
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

        accelerationTime = topSpeed/accelerationRate;
        accelerationDistance = (accelerationRate * Math.pow(accelerationTime, 2))/2;

        decelerationTime = topSpeed/decelerationRate;
        decelerationDistance = (decelerationRate * Math.pow(decelerationTime, 2))/2;

        minimumDistance = accelerationDistance + decelerationDistance;

        if (stationSpacing <= minimumDistance) {
            topSpeedTime = 0;

            double accelerationPercent = accelerationDistance/minimumDistance; //percent of the time the train is accelerating
            accelerationDistance = stationSpacing * accelerationPercent;
            accelerationTime *= (stationSpacing/minimumDistance);
            averageSpeedDuringAcceleration = (accelerationRate * accelerationTime)/2;

            double decelerationPercent = 1 - accelerationPercent; //percent of the time the train is decelerating
            decelerationDistance = stationSpacing * decelerationPercent;
            decelerationTime = (stationSpacing/minimumDistance);
            averageSpeedDuringDeceleration = (decelerationRate * decelerationTime)/2;

        } else {
            double topSpeedDistance = stationSpacing - minimumDistance;
            topSpeedTime = topSpeedDistance/topSpeed;

            double accelerationPercent = accelerationDistance/minimumDistance; //percent of the time the train is accelerating
            accelerationDistance = minimumDistance * accelerationPercent;
            averageSpeedDuringAcceleration = (accelerationRate * accelerationTime)/2;

            double decelerationPercent = 1 - accelerationPercent; //percent of the time the train is decelerating
            decelerationDistance = minimumDistance * decelerationPercent;
            averageSpeedDuringDeceleration = (decelerationRate * decelerationTime)/2;
        }

        double totalTime = stationDwellTime + accelerationTime + decelerationTime + topSpeedTime;
        averageSpeed = 3.6 * (accelerationTime * averageSpeedDuringAcceleration + decelerationTime * averageSpeedDuringDeceleration + topSpeedTime * topSpeed)/totalTime;
        percentTopSpeed = topSpeedTime/totalTime * 100;
        attributes[5] = topSpeed * 3.6;
    }

    public void determineTrainSpeedAlternative() {
        stationSpacing = lineLength/stationCount;
        timeWithoutStations = lineLength/topSpeed;
        timeLossAtEachStation = stationDwellTime + topSpeed/accelerationRate/2 + topSpeed/decelerationRate/2;
        totalTimeRequired = timeWithoutStations + stationCount * timeLossAtEachStation;
        averageSpeed = lineLength/totalTimeRequired;
        attributes[5] = topSpeed * 3.6;
    }
}