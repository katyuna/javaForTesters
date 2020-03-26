package ru.stqa.pft.sandbox;

public class Square {
    public double l;

    public Square (double l){ //конструктор класса
        this.l = l;
    }

    public double area (){ //метод класса для вычисления площади квадрата
        return this.l * this.l;
    }
}
