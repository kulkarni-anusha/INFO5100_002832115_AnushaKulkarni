package com.example.finalprojectjava;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

/* The ImageConverterFactoryImpl class implements the ImageConverterFactory interface.
 It takes an image type as a parameter during construction,
 and its createImageConverter method creates an instance of ImageConverter based on the specified image type. */

// Implementation of ImageConverterFactory
class ImageConverterFactoryImpl implements ImageConverterFactory {
    private String imageType;

    public ImageConverterFactoryImpl(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public ImageConverter createImageConverter() {
        return new ImageConverter() {
            @Override
            public void convertAndSave(Image inputImage, File outputImage) throws ImageConversionException {
                try {
                    // Get image dimensions
                    int width = (int) inputImage.getWidth();
                    int height = (int) inputImage.getHeight();

                    // Create a PixelReader
                    PixelReader pixelReader = inputImage.getPixelReader();

                    // Create a WritablePixelFormat with the appropriate byte order
                    WritablePixelFormat<IntBuffer> format = WritablePixelFormat.getIntArgbInstance();

                    // Create a buffer for the pixel data
                    int[] buffer = new int[width * height];
                    pixelReader.getPixels(0, 0, width, height, format, buffer, 0, width);

                    // Create BufferedImage without using SwingFXUtils
                    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // Use TYPE_INT_RGB
                    bufferedImage.setRGB(0, 0, width, height, buffer, 0, width);

                    // Perform image conversion
                    ImageIO.write(bufferedImage, imageType.toLowerCase(), outputImage);
                } catch (IOException e) {
                    throw new ImageConversionException(imageType + " conversion failed", e);
                }
            }
        };
    }
}