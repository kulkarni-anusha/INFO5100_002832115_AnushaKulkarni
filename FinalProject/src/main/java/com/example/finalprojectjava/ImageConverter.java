package com.example.finalprojectjava;

import java.io.File;

// Interface for ImageConverter
public interface ImageConverter {
    void convertAndSave(File inputImage, File outputImage) throws ImageConversionException;
}

