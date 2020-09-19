/**
Author: Eric Haynes

Program: Sales Tax Calculator Program

File: Electric.java

Description: Overrides default parameters in the Automobile class
             and adds weight variable needed for electric vehicle calculations

Date: Created 09-15-2020
 */

public class Electric extends Automobile {
    private final int weight;

    public Electric(String make, int price, int weight) {
        super(make, price);
        this.make = make;
        this.price = price;
        this.weight = weight;
    }

    //sales tax method for electric cars
    @Override
    double SalesTax() {
        if (weight < 3000) {
            return (price * taxRate) - 200;
        } else {
            return (price * taxRate) - 150;
        }
    }

    //electric toString
    @Override
    public String toString() { // make, model, price, sales tax, vehicle type, and weight
        return "Make and model: " + make + "\n" + "Price: " + price + "\n" + "Sales Tax: " +
                SalesTax() + "\n" + "Electric Vehicle \n" + "Weight: " + weight + "\n";
    }
}
