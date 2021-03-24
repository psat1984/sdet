package com.sdet.JavaActivity1;

public class Car {
	
	    //Class Member Variables
	    String color;
	    String brand;
	    String type;
	    int make;
	    String transmission;
	    int tyres;
	    int year;
	    int doors;
		
	    //Class Methods
	    public void characterstics(){
		System.out.println("Color of the Car: " + color);
		System.out.println("make of the Car: " + make);
		System.out.println("transmission of the Car: " + transmission);
		System.out.println("Purchase of the car: " + year);
		System.out.println("Number of doors on the car: " + doors);
	    	System.out.println("Number of tyres on the car: " + tyres);
	    }

	    public void accelerate() {
		System.out.println("Car is moving forward.");
	    }
		
	    public void brake() {
		System.out.println("Car has stopped.");
	    }
	}
	 


