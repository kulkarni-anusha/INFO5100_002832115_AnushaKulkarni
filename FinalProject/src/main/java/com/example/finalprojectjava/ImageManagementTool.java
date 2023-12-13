package com.example.finalprojectjava;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        Label imageInfoLabel = new Label();
        Label locationLabel = new Label();
        StackPane root = new StackPane();

        // Set the background color for the root node
        root.setStyle("-fx-background-color: #e6f6fe;");
        stage.setTitle("IMAGE MANAGEMENT TOOL");

        Label headingLabel1 = new Label("Imagement: Pixels meet giggles!!");
        headingLabel1.setStyle("-fx-text-fill: #040813; -fx-font-size : 15pt; -fx-font-family : Helvetica;");

        Button button1 = new Button("Upload Image");
        button1.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size : 12pt; -fx-font-family : Helvetica");

        HBox imageUploadBottom = new HBox(5);
        imageUploadBottom.setAlignment(Pos.CENTER);
        imageUploadBottom.setPadding(new Insets(5));
        imageUploadBottom.getChildren().addAll(button1);

        //creating drop down option to allow users to choose options from png,jp,jpeg and gif to convert images
        ObservableList<String> dropdownOptions = FXCollections.observableArrayList(
                "PNG",
                "JPG",
                "JPEG",
                "GIF"
        );
        imageCombo = new ComboBox<>(dropdownOptions);
        imageCombo.setPromptText("Select Image Format");
        imageCombo.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size : 12pt; -fx-font-family : Helvetica");

        HBox dropdownBox = new HBox(5);
        dropdownBox.setAlignment(Pos.CENTER);
        dropdownBox.setPadding(new Insets(5));
        dropdownBox.getChildren().addAll(imageCombo);

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(headingLabel1, imageUploadBottom, dropdownBox);

        button1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            // Displaying image properties (height, width, location)
            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);

                String imageInfo = "Image Name: " + selectedFile.getName() + "\n" +
                        "Width: " + image.getWidth() + " pixels\n" +
                        "Height: " + image.getHeight() + " pixels";

                imageInfoLabel.setText(imageInfo);
                locationLabel.setText("Image Location: " + selectedFile.getAbsolutePath());

                int thumbnailWidth = 5;
                int thumbnailHeight = 5;

                //When uploaded, show image(s) thumbnail(s) (100x100) to users on GUI
                Image thumbnail = new Image(selectedFile.toURI().toString());
                ImageView thumbnailView = new ImageView(thumbnail);
                thumbnailView.setFitHeight(100);
                thumbnailView.setFitWidth(100);

                vBox.getChildren().addAll(thumbnailView, imageInfoLabel);

                // Update the dropdown options to remove the selected extension
                String selectedExtension = getFileExtension(selectedFile.getName());
                dropdownOptions.remove(selectedExtension.toUpperCase());

                // Set the filtered options to the ComboBox
                imageCombo.setItems(dropdownOptions);
                imageCombo.getSelectionModel().clearSelection();

                // Creating Download button
                Button downloadButton = new Button("Download");
                downloadButton.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                downloadButton.setFont(Font.font("System", FontWeight.BOLD, 16));
                // Setting Download button action to allow users to download converted images
                downloadButton.setOnAction(event -> {
                    try {
                        String selectedExtensionForDownload = imageCombo.getValue().toUpperCase();
                        FileChooser saveChooser = new FileChooser();
                        saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedExtensionForDownload, "*." + selectedExtensionForDownload.toLowerCase()));
                        File savedFile = saveChooser.showSaveDialog(stage);

                        if (savedFile != null) {
                            // Use the factory to create the converter
                            converterFactory = new ImageConverterFactoryImpl(selectedExtensionForDownload);
                            ImageConverter imageConverter = converterFactory.createImageConverter();
                            imageConverter.convertAndSave(selectedFile, savedFile);
                            downloadTips.setText("Download successful");
                            downloadTips.setStyle(" -fx-text-fill: #040813; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                        } else {
                            downloadTips.setText("Download canceled");
                        }
                    } catch (ImageConversionException | IllegalArgumentException ex) {
                        downloadTips.setText("Download failed! Try again");
                        ex.printStackTrace();
                    }
                });

                // Add download button to the VBox
                vBox.getChildren().add(downloadButton);
            }
        });

        downloadTips = new Label();

        HBox downloadBox = new HBox(5);
        downloadBox.setAlignment(Pos.CENTER);
        downloadBox.setPadding(new Insets(5));
        downloadBox.getChildren().addAll(downloadTips);

        vBox.getChildren().add(downloadBox);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    // Helper method to get the file extension
    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        return (lastDotIndex == -1) ? "" : fileName.substring(lastDotIndex + 1);
    }
}
