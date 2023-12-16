package com.example.finalprojectjava;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class ImageManagementTool extends Application {

    private ComboBox<String> imageCombo;
    private Label downloadTips;
    private ImageConverterFactory converterFactory;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the main VBox for the layout
        VBox root = new VBox(10);
        root.setStyle("-fx-background-color: #e6f6fe;");
        stage.setTitle("Image Management Tool");

        // Set up the heading label
        Label headingLabel1 = new Label("\n\nQuickPic Converter");
        headingLabel1.setStyle("-fx-text-fill: #040813; -fx-font-size: 16pt; -fx-font-family: Helvetica;");
        HBox headingBox = new HBox();
        headingBox.setAlignment(Pos.TOP_CENTER);
        headingBox.getChildren().add(headingLabel1);

        // create upload button
        Button button1 = new Button("Upload an image");
        button1.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size: 12pt; -fx-font-family: Helvetica;");

        // creating dropdown options for image extensions
        ObservableList<String> dropdownOptions = FXCollections.observableArrayList(
                "PNG",
                "JPG",
                "GIF"
        );
        imageCombo = new ComboBox<>(dropdownOptions);
        imageCombo.setPromptText("Select Image Format");
        imageCombo.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size: 12pt; -fx-font-family: Helvetica");

        // create download button
        Button downloadButton = new Button("Download");
        downloadButton.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size : 12pt; -fx-font-family : Helvetica");
        downloadButton.setDisable(true);

        // Set up the VBox for image upload and format selection
        VBox uploadAndFormatBox = new VBox(10);
        uploadAndFormatBox.setAlignment(Pos.CENTER);
        uploadAndFormatBox.setPadding(new Insets(50, 10, 10, 10));

        uploadAndFormatBox.getChildren().addAll(button1, imageCombo, downloadButton);

        // Set up the main VBox
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(headingBox, uploadAndFormatBox);

        // Set up the ImageView and image info label
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label imageInfoLabel = new Label();

        // Set up Color Filter ComboBox
        ObservableList<String> colorOptions = FXCollections.observableArrayList(
                "None",
                "Blue",
                "Red",
                "Green",
                "Black-and-white"
        );

        ComboBox<String> colorCombo = new ComboBox<>(colorOptions);
        colorCombo.setPromptText("Select Color Filter");
        colorCombo.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size: 12pt; -fx-font-family: Helvetica");

        // Handle color filter selection
        colorCombo.setOnAction(event -> {
            ColorAdjust filterAdjust = new ColorAdjust();
            applyColorFilter(colorCombo.getValue(), filterAdjust);
            imageView.setEffect(filterAdjust);
        });

        HBox colorFilterBox = new HBox(10);
        colorFilterBox.setAlignment(Pos.CENTER);
        colorFilterBox.getChildren().addAll(colorCombo);

        // Adding Color Filter settings to vBox
        vBox.getChildren().addAll(colorFilterBox, imageView);

        // Handle image upload button click
        button1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(stage);
            // Display selected image
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);

                // Displaying image properties (name, height, width, size)
                String imageInfo = "Image Name: " + selectedFile.getName() + "\n" +
                        "Width: " + image.getWidth() + " pixels\n" +
                        "Height: " + image.getHeight() + " pixels\n" +
                        "Size : " + (selectedFile.length() / 1024) + " KB";

                imageInfoLabel.setText(imageInfo);

                // Clear previous content from vBox
                vBox.getChildren().clear();
                vBox.getChildren().addAll(headingBox, uploadAndFormatBox, colorFilterBox, imageView, imageInfoLabel);

                // Enable the download button
                downloadButton.setDisable(false);

                // Handle download button click
                downloadButton.setOnAction(event -> {
                    try {
                        String selectedExtension = imageCombo.getValue();
                        String colorFilter = colorCombo.getValue();

                        if (selectedExtension != null && colorFilter != null) {
                            String originalExtension = getFileExtension(selectedFile);

                            if (selectedExtension.equalsIgnoreCase(originalExtension)) {
                                downloadTips.setText("Image is already in the ." + originalExtension.toLowerCase() + " Format. \nChoose a different extension for image download.");
                            } else {
                                FileChooser saveChooser = new FileChooser();
                                saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedExtension, "*." + selectedExtension.toLowerCase()));

                                File savedFile = saveChooser.showSaveDialog(stage);

                                if (savedFile != null) {
                                    // Apply color filter to the original image
                                    Image filteredImage = applyFilter(imageView.getImage(), colorFilter);
                                    /*When a user selects an image format for download,
                                    an instance of ImageConverterFactoryImpl is created based on the selected extension.
                                    Then, the createImageConverter() method is called to obtain an ImageConverter instance.
                                    Finally, this ImageConverter is used to convert and save the image.*/
                                    // Use the factory to create the converter
                                    converterFactory = new ImageConverterFactoryImpl(selectedExtension.toUpperCase());
                                    ImageConverter imageConverter = converterFactory.createImageConverter();
                                    imageConverter.convertAndSave(filteredImage, savedFile);

                                    Platform.runLater(() -> {
                                        downloadTips.setText("Download successfully");
                                        downloadTips.setStyle("-fx-text-fill: green; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                                    });
                                } else {
                                    Platform.runLater(() -> {
                                        downloadTips.setText("Download canceled");
                                        downloadTips.setStyle("-fx-text-fill: red; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                                    });
                                }
                            }
                        }
                    } catch (ImageConversionException | IllegalArgumentException ex) {
                        Platform.runLater(() -> {
                            downloadTips.setText("Download failed! Try another image.");
                            downloadTips.setStyle("-fx-text-fill: red; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                            ex.printStackTrace();
                        });
                    }
                });

                // Add download button to the vBox
                vBox.getChildren().add(downloadButton);

                downloadTips = new Label();

                HBox downloadBox = new HBox(5);
                downloadBox.setAlignment(Pos.CENTER);
                downloadBox.setPadding(new Insets(5));
                downloadBox.getChildren().addAll(downloadTips);

                vBox.getChildren().add(downloadBox);
            }
        });

        downloadTips = new Label();

        HBox downloadBox = new HBox(5);
        downloadBox.setAlignment(Pos.CENTER);
        downloadBox.setPadding(new Insets(5));
        downloadBox.getChildren().addAll(downloadTips);

        vBox.getChildren().add(downloadBox);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 500, 600);
        stage.setScene(scene);
        stage.show();
    }

    // method to apply colour filter to the image based on various values of hue and saturation
    private void applyColorFilter(String colorFilter, ColorAdjust filterAdjust) {
        if (colorFilter != null) {
            double hueValue = 0.0;
            double saturationValue = 0.0;

            switch (colorFilter.toLowerCase()) {
                case "blue":
                    hueValue = 0.8;
                    break;
                case "red":
                    hueValue = -0.2;
                    break;
                case "green":
                    hueValue = 0.2;
                    break;
                case "none":
                    hueValue = 0.0;
                    break;
                case "black-and-white":
                    saturationValue = -1.0;
                    break;
                default:
                    break;
            }

            filterAdjust.setHue(hueValue);
            filterAdjust.setSaturation(saturationValue);
        }
    }

    // method to get the file extension
    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    // Helper method to apply color filter to the image and return filtered image
    private Image applyFilter(Image originalImage, String colorFilter) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(javafx.scene.paint.Color.TRANSPARENT);
        ImageView snapshotView = new ImageView(originalImage);

        ColorAdjust filterAdjust = new ColorAdjust();
        applyColorFilter(colorFilter, filterAdjust);

        snapshotView.setEffect(filterAdjust);

        return snapshotView.snapshot(params, null);
    }
}