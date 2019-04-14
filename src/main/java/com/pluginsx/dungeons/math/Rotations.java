package com.pluginsx.dungeons.math;

public class Rotations
{

    public static double[] rotate(double a, double b, double x, double y, double theta)
    {
        //Rotates the point (x, y) around (a, b) by theta radians.
        double e = x - a;
        double f = y - b;

        double costheta = Math.cos(theta);
        double sintheta = Math.sin(theta);

        double vals[] = new double[2];

        vals[0] = (e * costheta - f * sintheta) + x;
        vals[1] = (e * sintheta + f * costheta) + y;

        return vals;
    }

    public static double[] rotate(double x, double y, double theta)
    {
        //Rotates the point (x, y) around the origin by theta radians.

        double costheta = Math.cos(theta);
        double sintheta = Math.sin(theta);

        double vals[] = new double[2];

        vals[0] = (x * costheta - y * sintheta);
        vals[1] = (x * sintheta + y * costheta);

        return vals;
    }


}
