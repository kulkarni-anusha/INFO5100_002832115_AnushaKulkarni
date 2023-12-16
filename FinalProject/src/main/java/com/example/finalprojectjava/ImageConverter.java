package com.example.finalprojectjava;

import javafx.scene.image.Image;

import java.io.File;

/* This interface, named ImageConverter, declares a method named convertAndSave.
The purpose of this interface is to define a contract for classes that will perform image conversion operations.
The method convertAndSave takes an Image object (representing the input image) and a File object
(representing the output file where the converted image should be saved).*/
// Interface for ImageConverter
public interface ImageConverter {
    void convertAndSave(Image inputImage, File outputImage) throws ImageConversionException;
}