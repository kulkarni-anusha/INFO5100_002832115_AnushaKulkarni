package com.example.finalprojectjava;

/*This is a custom exception class that extends the Java Exception class.
 It is used to represent exceptions specific to image conversion operations in the application.*/
// Exception class for ImageConversion
public class ImageConversionException extends Exception {
    public ImageConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}