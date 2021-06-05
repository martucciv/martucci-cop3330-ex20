package ex20;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Veronica Martucci
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        App app = new App();
        double orderAmount = app.inputOrderAmount();
        String state = app.inputState();
        String county = app.inputCounty();
        double taxrate = app.determineTaxRate(state, county);
        double tax = app.calculateTax(taxrate, orderAmount);
        String taxRounded = app.roundTax(tax);
        double total = app.calculateTotal(orderAmount, tax);
        String output = app.generateOutput(total, taxRounded, state);
        System.out.println(output);
    }

    public double inputOrderAmount(){
        System.out.print("What is the order amount? ");
        String str = input.nextLine();
        return Double.parseDouble(str);
    }

    public String inputState(){
        System.out.print("What state do you live in? ");
        return input.nextLine();
    }

    public String inputCounty(){
        System.out.print("What county do you live in? ");
        return input.nextLine();
    }

    public double determineTaxRate(String state, String county){
        double taxrate = 0.0;
        if(state.equals("Wisconsin")){
            taxrate = .05;
            if(county.equals("Eau Claire")){
                taxrate = taxrate + 0.005;
            }
            else if(county.equals("Dunn")){
                taxrate = taxrate + 0.004;
            }
        }

        if(state.equals("Illinois")){
            taxrate = 0.08;
        }
        return taxrate;
    }

    public double calculateTax(double taxrate, double orderAmount){
        return taxrate * orderAmount;
    }

    public double calculateTotal(double orderAmount, double tax){
        return orderAmount + tax;
    }

    public String roundTax(double tax){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(tax);
    }

    public String generateOutput(double total, String taxRounded, String state){
        if(state.equals("Wisconsin") || state.equals("Illinois")){
            return "The tax is $" +taxRounded+ ".\nThe total is $" +total+ "." ;
        }
        else
            return "The total is $" +total+ ".";
    }
}
