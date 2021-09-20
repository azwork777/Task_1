package ru.vsu.cs.zhikhorev_a_a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double smallRadius = inputRadius("наименьшей");
        double middleRadius = inputRadius("средней");
        double largeRadius = inputRadius("наибольшей");

        checkError(smallRadius, middleRadius, largeRadius);

        double space = calculateSpaceOfPaintedPart(smallRadius, middleRadius, largeRadius);

        outputSpace(space);
    }

    static double inputRadius(String name) {
        System.out.printf("Введите радиус %s окружности: ", name);
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        if (r <= 0) {
            System.out.println("Ошибка при вводе данных: радиус не может быть меньше или равен нулю");
            System.exit(1);
        }
        return r;
    }


    static void checkError(double small, double middle, double large) {
        if (small >= middle || small >= large || middle >= large) {
            System.out.println("Ошибка: данные введены не в том порядке, либо присутствуют несколько равных значений");
            System.exit(1);
        }
    }

    static double calculateSpaceOfPaintedPart(double r1, double r2, double r3) {
        double calc1, calc2, result;
        calc1 = (Math.PI * r2 * r2) - (Math.PI * r1 * r1);
        calc2 = (4 * r3 * r3) - (Math.PI * r3 * r3);
        result = calc1 + calc2;
        return result;
    }

    static void outputSpace(double spaceOfPart) {
        System.out.println("Площадь фигуры = " + spaceOfPart);
    }

}