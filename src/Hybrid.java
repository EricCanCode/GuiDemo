/**
Author: Eric Haynes

Program: Sales Tax Calculator Program

File: Hybrid.java

Description: Overrides default parameters in the Automobile class
             and adds mpg variable needed for hybrid vehicle calculations

Date: Created 09-15-2020
 */

public class Hybrid extends Automobile {
    private final int mpg;

    public Hybrid(String make, int price, int mpg) {
        super(make, price);
        this.make = make;
        this.price = price;
        this.mpg = mpg;
    }

    //sales tax method for hybrid cars
    @Override
    double SalesTax() {
        if (mpg <= 40) {
            return (this.price * taxRate) - 100;
        } else {
            return (((this.price * taxRate) - 100) - ((mpg - 40) * 2));
        }
    }

    //hybrid toString
    @Override
    public String toString() { //make, model, price, sales tax, vehicle type, and mpg
        return "Make and model: " + make + "\n" + "Sales price: " + price + "\n" + "Sales Tax: " +
                SalesTax() + "\n" + "Hybrid Vehicle \n" + "MPG: " + mpg + "\n";
    }
}

