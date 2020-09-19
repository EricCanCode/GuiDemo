/**
Author: Eric Haynes

Program: Sales Tax Calculator Program

File: Automobile.java

Description: Presents default constructor, SalesTax method, and toString needed to
             perform calculations for standard vehicles that aren't hybrid or electric

Date: Created 09-15-2020
 */

public class Automobile {
    // values for automobile
    String make;
    int price;
    double taxRate = .05;

    // constructor to initialize automobile make and price
    public Automobile(String make, int price) {
        this.make = make;
        this.price = price;
    }

    //method for automobile sales tax
    double SalesTax() {
        return this.price * taxRate;
    }

    //default automobile toString
    public String toString() { //make, model, price, and sales tax

        return "Make and Model: " + make + "\n" + " Price: " + price +
                "\n" + " Sales Tax: " + SalesTax() + "\n";
    }
}


