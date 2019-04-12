package com.pluginsx.dungeons.math;

public class Rotations
{

    public static void rotate(double a, double b, double x, double y, Double c, Double d, double theta)
    {
        //Rotates the point (x, y) around (a, b) by theta radians.
        double e = x - a;
        double f = y - b;

        double costheta = Math.cos(theta);
        double sintheta = Math.sin(theta);

        c = (e * costheta - f * sintheta) + x;
        d = (e * sintheta + f * costheta) + y;
    }

    public static void rotate(double x, double y, Double c, Double d, double theta)
    {
        //Rotates the point (x, y) around the origin by theta radians.

        double costheta = Math.cos(theta);
        double sintheta = Math.sin(theta);

        c = (x * costheta - y * sintheta);
        d = (x * sintheta + y * costheta);
    }


}
