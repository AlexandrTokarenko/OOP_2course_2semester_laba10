package com.example.laba10.fun;

public class Function {


    public static double calc(double x) {
        return Math.sin(2*x)*Math.cos(3*x);
    }

}

/*public class Function {

    private double a;
    private double b;
    private int n;
    private double h;

    public Function(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.h = (b-a)/n;
    }


    public double calc() {
        double s = 0;
        for (int i = 0; i < n; i++) {
            double x = a + i*h + h/2;
            double y = Math.sin(2*x)*Math.cos(3*x);
            s += y;
        }
        return s * h;
    }
}*/



    /*public double calc() {
        double s = 0;
        for (int i = 0; i < n; i++) {
            double x = a + i*h;
            double y = Math.sin(x);
            s += y;
        }
        return h * s;
        //return IntStream.range(0, n).mapToDouble(i -> a + i * h).map(operator).sum() * h;
    }*/