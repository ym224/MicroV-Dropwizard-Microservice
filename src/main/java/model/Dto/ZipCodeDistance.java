package model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZipCodeDistance {

    @JsonProperty
    private double distance;

    public ZipCodeDistance(){}

    public ZipCodeDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCodeDistance that = (ZipCodeDistance) o;

        return Double.compare(that.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(distance);
        return (int) (temp ^ (temp >>> 32));
    }
}
