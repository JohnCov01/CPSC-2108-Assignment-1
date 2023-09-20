package org.csu.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class SubwayRoute {
    private String[][] subwayMap;
    private String stop1;
    private int stop1x;
    private int stop1y;
    private String stop2;
    private int stop2x;
    private int stop2y;

    public String[][] getSubwayMap() {
        return subwayMap;
    }

    public void setSubwayMap(String[][] subwayMap) {
        this.subwayMap = subwayMap;
    }

    public String getStop1() {
        return stop1;
    }

    public void setStop1(String stop1) {
        this.stop1 = stop1;
    }

    public int getStop1x() {
        return stop1x;
    }

    public void setStop1x(int stop1x) {
        this.stop1x = stop1x;
    }

    public int getStop1y() {
        return stop1y;
    }

    public void setStop1y(int stop1y) {
        this.stop1y = stop1y;
    }

    public String getStop2() {
        return stop2;
    }

    public void setStop2(String stop2) {
        this.stop2 = stop2;
    }

    public int getStop2x() {
        return stop2x;
    }

    public void setStop2x(int stop2x) {
        this.stop2x = stop2x;
    }

    public int getStop2y() {
        return stop2y;
    }

    public void setStop2y(int stop2y) {
        this.stop2y = stop2y;
    }

    public int findPositionX(String stop) {
        for(int y = 0; y < subwayMap.length; y++) {
            for(int x = 0; x < subwayMap[y].length; x++) {
                if(subwayMap[y][x].equals(stop)){
                    return x;
                }
            }
        }
        return -1;
    }

    public int findPositionY(String stop) {
        int yStop = 0;
        for(int y = 0; y < subwayMap.length; y++) {
            for(int x = 0; x < subwayMap[y].length; x++) {
                if(subwayMap[y][x].equals(stop)){
                    return y;
                }
            }
        }
        return -1;
    }

    public void findStop1Position() {
        setStop1x(findPositionX(stop1));
        setStop1y(findPositionY(stop1));
    }

    public void findStop2Position() {
        setStop2x(findPositionX(stop2));
        setStop2y(findPositionY(stop2));
    }

    public String gotoPositionX(int start, int stop, int yAxis) {
        String pathX = "";
        int i = start;
        if(start < stop) {
            while (i != (stop + 1)) {
                pathX += subwayMap[yAxis][i] + ", ";
                i++;
            }
        }
        else if(start > stop) {
            while (i != (stop - 1)) {
                pathX += subwayMap[yAxis][i] + ", ";
                i--;
            }
        }
        return pathX;
    }

    public String gotoPositionY(int start, int stop, int xAxis) {
        if(stop1x == stop2x){
            return "";
        }
        String pathY = "";
        int i = start;
        if(start > stop) {
            while(i != stop) {
                i--;
                pathY += subwayMap[i][xAxis] + ", ";
            }
        }
        else if(start < stop) {
            while(i != stop) {
                i++;
                pathY += subwayMap[i][xAxis] + ", ";
            }
        }
        return pathY;
    }

    @Override
    public String toString(){
        if(stop1y > stop2y || stop1y < stop2y) {                                                    // This if statement is for if the starting station is
            return "The path from " + stop1 + " to " + stop2 + " is:\n" +                           // for when the starting station is route 2 or 3 and
                     gotoPositionY(stop1y, stop2y, stop1x) + gotoPositionX(stop1x, stop2x, stop2y); // the last station is route 1. It isn't the best, but
        }                                                                                           // it works.
        return "The path from " + stop1 + " to " + stop2 + " is:\n" +
                gotoPositionX(stop1x, stop2x, stop1y) + gotoPositionY(stop1y, stop2y, stop2x);
    }

}
