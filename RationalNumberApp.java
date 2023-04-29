/*
Name: Joshua Lobo
PRN: 21070126127
Batch: AIML B3

OS: Mac OS 12.2.1 Monterey
java Version: 19.0.1 2022-10-18
Java(TM) SE Runtime Environment (build 19.0.1+10-21)
Java HotSpot(TM) 64-Bit Server VM (build 19.0.1+10-21, mixed mode, sharing)
*/

import java.util.Scanner;

public class RationalNumberApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Parse the command line arguments into two RationalNumber objects
            RationalNumber num1 = RationalNumber.parse(args[0]);
            RationalNumber num2 = RationalNumber.parse(args[1]);

            // Perform arithmetic operations on the RationalNumber objects
            RationalNumber sum = num1.add(num2);
            RationalNumber diff = num1.subtract(num2);
            RationalNumber product = num1.multiply(num2);
            RationalNumber quotient = num1.divide(num2);

            // Output the results to the console
            System.out.println("First rational number: " + num1.toString());
            System.out.println("Second rational number: " + num2.toString());
            System.out.println("Sum: " + sum.toString());
            System.out.println("Difference: " + diff.toString());
            System.out.println("Product: " + product.toString());
            System.out.println("Quotient: " + quotient.toString());

            // Compare the RationalNumber objects and output the result to the console
            int cmp = num1.compareTo(num2);
            if (cmp < 0) {
                System.out.println(num1.toString() + " is less than " + num2.toString());
            } else if (cmp > 0) {
                System.out.println(num1.toString() + " is greater than " + num2.toString());
            } else {
                System.out.println(num1.toString() + " is equal to " + num2.toString());
            }

            // Convert the RationalNumber objects to floating-point numbers and output the result to the console
            double float1 = num1.toDouble();
            double float2 = num2.toDouble();
            System.out.println("First rational number as float: " + float1);
            System.out.println("Second rational number as float: " + float2);

            // Find the absolute value of the RationalNumber objects and output the result to the console
            RationalNumber abs1 = num1.abs();
            RationalNumber abs2 = num2.abs();
            System.out.println("Absolute value of first rational number: " + abs1.toString());
            System.out.println("Absolute value of second rational number: " + abs2.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter two rational numbers as command line arguments.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
