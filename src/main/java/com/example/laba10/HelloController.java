package com.example.laba10;

import com.example.laba10.fun.ThreadingCalculator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloController {

    @FXML private Label textTime;
    @FXML private Label textCount;
    @FXML private TextArea stepField;
    @FXML private TextArea countField;


    private double totalSum = 0;
    private int finished = 0;
    private long time = 0;

    Lock lock;
    Condition condition;

    public void calculateAndWrite() {
        calculate();
        write();
    }

    public void write() {

        textCount.setText("Значення інтегралу: " + String.format("%.4f",totalSum));
        textTime.setText("Час виконання обчислення: " + time);
    }

    public void calculate() {

        double a = 0;
        double b = Math.PI/2;
        int n = Integer.parseInt(stepField.getText());
        int nThreads = Integer.parseInt(countField.getText());
        double delta = (b-a)/nThreads;
        finished = 0;
        totalSum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            ThreadingCalculator calculator = new ThreadingCalculator(a+i*delta,a+(i+1)*delta,n/nThreads,this);
            new Thread(calculator).start();
        }
        lock = new ReentrantLock();
        condition = lock.newCondition();
        try {
            lock.lock();
            while (finished < nThreads) {
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        long finish = System.currentTimeMillis();
        time = finish - start;
    }


    public void sendResult(double v) {
        try {
            lock.lock();
            totalSum += v;
            finished++;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

