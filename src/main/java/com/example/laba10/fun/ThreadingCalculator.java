package com.example.laba10.fun;
import com.example.laba10.HelloController;

public class ThreadingCalculator implements Runnable{

    private HelloController main;

    private double a;
    private double b;
    private int n;

    public ThreadingCalculator() {

    }

    public ThreadingCalculator(double a, double b, int n, HelloController helloController) {

        this.a = a;
        this.b = b;
        this.n = n;
        this.main = helloController;
    }

    @Override
    public void run() {

        double v = calculate(a,b,n);
        main.sendResult(v);
    }


    public double calculate(double a, double b, int n) {
        double s = 0;
        double h = (b-a)/n;
        for (int i = 0; i < n; i++) {
            double x = a + i*h + h/2;
            double y = Function.calc(x);
            s += y;
        }
        return s * h;
    }
}
