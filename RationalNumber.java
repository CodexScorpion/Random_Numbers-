public class RationalNumber {
    private int numerator;
    private int denominator;

    // Constructor that takes in numerator and denominator
    public RationalNumber(int numerator, int denominator) {
        // Check if denominator is zero and throw exception if true
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        // Simplify numerator and denominator using the greatest common divisor (gcd)
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // Static method that takes in a string and returns a new RationalNumber object
    public static RationalNumber parse(String s) {
        String[] parts = s.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new RationalNumber(numerator, denominator);
    }

    // Getters for numerator and denominator
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Adds two rational numbers and returns a new RationalNumber object
    public RationalNumber add(RationalNumber other) {
        int newDenominator = denominator * other.getDenominator();
        int newNumerator = numerator * other.getDenominator() + other.getNumerator() * denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Subtracts two rational numbers and returns a new RationalNumber object
    public RationalNumber subtract(RationalNumber other) {
        int newDenominator = denominator * other.getDenominator();
        int newNumerator = numerator * other.getDenominator() - other.getNumerator() * denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Multiplies two rational numbers and returns a new RationalNumber object
    public RationalNumber multiply(RationalNumber other) {
        int newNumerator = numerator * other.getNumerator();
        int newDenominator = denominator * other.getDenominator();
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Divides two rational numbers and returns a new RationalNumber object
    public RationalNumber divide(RationalNumber other) {
        if (other.getNumerator() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int newNumerator = numerator * other.getDenominator();
        int newDenominator = denominator * other.getNumerator();
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Compares two rational numbers and returns -1, 0, or 1 depending on their relationship
    public int compareTo(RationalNumber other) {
        int thisNumerator = numerator * other.getDenominator();
        int otherNumerator = other.getNumerator() * denominator;
        if (thisNumerator < otherNumerator) {
            return -1;
        } else if (thisNumerator > otherNumerator) {
            return 1;
        } else {
            return 0;
        }
    }

    // Converts the rational number to a decimal value
    public double toDouble() {
        return (double) numerator / denominator;
    }

    // Returns a new RationalNumber object that is the absolute value of the original
    public RationalNumber abs() {
        return new RationalNumber(Math.abs(numerator), denominator);
    }

    // Private helper method that simplifies a fraction using the greatest common divisor (gcd)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
