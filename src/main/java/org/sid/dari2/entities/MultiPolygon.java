package org.sid.dari2.entities;
import java.util.ArrayList;
import java.lang.Double;




public class MultiPolygon extends Geometry
{
    private ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> coordinates;

    public MultiPolygon()
    {

    }

    public ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> getCoordinates()
    {

        return coordinates;
    }

    public void setCoordinates(ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> coordinates)
    {

        this.coordinates = coordinates;
    }
}
