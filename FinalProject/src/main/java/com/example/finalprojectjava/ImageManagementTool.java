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
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageManagementTool extends Application {

    private ComboBox<String> imageCombo;
    private Label downloadTips;
    private ImageConverterFactory converterFactory;
    private List<ImageInfo> uploadedImages = new ArrayList<>();

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
        Label headingLabel1 = new Label("QuickPic Converter");
        headingLabel1.setStyle("-fx-text-fill: #040813; -fx-font-size: 16pt; -fx-font-family: Helvetica;");
        HBox headingBox = new HBox();
        headingBox.setAlignment(Pos.TOP_CENTER);
        headingBox.getChildren().add(headingLabel1);

        // create upload button
        Button button1 = new Button("Upload images");
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

        uploadAndFormatBox.getChildren().addAll(headingBox, button1, imageCombo, downloadButton);

        // Set up the main VBox
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(uploadAndFormatBox);

        // Set up the ScrollPane for thumbnails
        ScrollPane scrollPane = new ScrollPane();
        FlowPane thumbnailsPane = new FlowPane(10, 10);
        thumbnailsPane.setAlignment(Pos.CENTER);
        thumbnailsPane.setPadding(new Insets(10));
        Color lightBlueColor = Color.rgb(230, 246, 254);

        scrollPane.setStyle("-fx-background: #" + Integer.toHexString(lightBlueColor.hashCode()).substring(0, 6) + ";");

        scrollPane.setContent(thumbnailsPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);


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

            for (ImageInfo imageInfo : uploadedImages) {
                imageInfo.getImageView().setEffect(filterAdjust);
            }
        });

        HBox colorFilterBox = new HBox(10);
        colorFilterBox.setAlignment(Pos.CENTER);
        colorFilterBox.getChildren().addAll(colorCombo);

        // Adding Color Filter settings to vBox
        vBox.getChildren().addAll(colorFilterBox, scrollPane);

        // Handle image upload button click
        button1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);
            // Display selected images
            if (selectedFiles != null && !selectedFiles.isEmpty()) {
                for (File selectedFile : selectedFiles) {
                    Image image = new Image(selectedFile.toURI().toString());
                    ImageView thumbnail = createThumbnail(image);
                    Label imageInfoLabel = new Label(getImageInfo(selectedFile, image));
                    ImageInfo imageInfo = new ImageInfo(image, thumbnail, imageInfoLabel, selectedFile);

                    // Add thumbnail and image info to the FlowPane
                    thumbnailsPane.getChildren().addAll(createThumbnailContainer(thumbnail, imageInfoLabel));
                    // Displaying image properties (name, height, width, size)
                    uploadedImages.add(imageInfo);
                }

                // Enable the download button
                downloadButton.setDisable(false);
            }
        });

        // Handle download button click
        downloadButton.setOnAction(event -> {
            try {
                // Get selected image format and color filter
                String selectedExtension = imageCombo.getValue();
                String colorFilter = colorCombo.getValue();

                // Check if both format and filter are selected
                if (selectedExtension != null && colorFilter != null) {
                    // Iterate through the uploaded images
                    for (ImageInfo imageInfo : uploadedImages) {
                        // Get the original extension of the image file
                        String originalExtension = getFileExtension(imageInfo.getFile());

                        // Check if the selected format matches the original extension
                        if (selectedExtension.equalsIgnoreCase(originalExtension) && "None".equalsIgnoreCase(colorFilter)) {
                            // Display a message if the image is already in the selected format
                            Platform.runLater(() -> {
                                imageInfo.getImageInfoLabel().setText("Image is already in the ." + originalExtension.toLowerCase() + " format.");
                                imageInfo.getImageInfoLabel().setStyle("-fx-text-fill: orange; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                            });
                        } else {
                            // If different, prompt user to choose save location
                            FileChooser saveChooser = new FileChooser();
                            saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedExtension, "*." + selectedExtension.toLowerCase()));

                            File savedFile = saveChooser.showSaveDialog(stage);

                            if (savedFile != null) {
                                // Apply color filter to the image
                                Image filteredImage = applyColorFilter(imageInfo.getImage(), colorFilter);
                                 /*When a user selects an image format for download,
                                    an instance of ImageConverterFactoryImpl is created based on the selected extension.
                                    Then, the createImageConverter() method is called to obtain an ImageConverter instance.
                                    Finally, this ImageConverter is used to convert and save the image*/
                                // Use the factory to create the converter
                                converterFactory = new ImageConverterFactoryImpl(selectedExtension.toUpperCase());
                                ImageConverter imageConverter = converterFactory.createImageConverter();

                                // Convert and save the filtered image
                                imageConverter.convertAndSave(filteredImage, savedFile);

                                // Display success message
                                Platform.runLater(() -> {
                                    imageInfo.getImageInfoLabel().setText("Download successfully");
                                    imageInfo.getImageInfoLabel().setStyle("-fx-text-fill: green; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                                });
                            } else {
                                // Display message if download is canceled
                                Platform.runLater(() -> {
                                    imageInfo.getImageInfoLabel().setText("Download canceled");
                                    imageInfo.getImageInfoLabel().setStyle("-fx-text-fill: red; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                                });
                            }
                        }
                    }
                }
            } catch (ImageConversionException | IllegalArgumentException ex) {
                // Handle exceptions and display an error message
                Platform.runLater(() -> {
                    downloadTips.setText("Download failed! Try another image.");
                    downloadTips.setStyle("-fx-text-fill: red; -fx-font-size : 12pt; -fx-font-family : Helvetica");
                    ex.printStackTrace();
                });
            }
        });
        downloadTips = new Label();


        // Set up the HBox for displaying download tips
        HBox downloadBox = new HBox(5);
        downloadBox.setAlignment(Pos.CENTER);
        downloadBox.setPadding(new Insets(5));
        downloadBox.getChildren().addAll(downloadTips);

        // Add the downloadBox to the main VBox
        vBox.getChildren().add(downloadBox);

        // Add the main VBox to the root
        root.getChildren().add(vBox);

        // Create the main scene
        Scene scene = new Scene(root, 750, 650);
        stage.setScene(scene);
        stage.show();
    }

    // Method to create a container for thumbnail and image info
    private VBox createThumbnailContainer(ImageView thumbnail, Label imageInfoLabel) {
        VBox container = new VBox(5);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(thumbnail, imageInfoLabel);
        return container;
    }

    // Method to create a thumbnail ImageView with fixed dimensions
    private ImageView createThumbnail(Image image) {
        ImageView thumbnail = new ImageView(image);
        thumbnail.setFitWidth(100);
        thumbnail.setFitHeight(100);
        return thumbnail;
    }

    // Display image properties
    private String getImageInfo(File file, Image image) {
        return "Image Name: " + file.getName() + "\n" +
                "Width: " + image.getWidth() + " pixels\n" +
                "Height: " + image.getHeight() + " pixels\n" +
                "Size : " + (file.length() / 1024) + " KB";
    }

    // Method to extract the file extension from a given file
    private String getFileExtension(File file) {
        // Get the name of the file
        String fileName = file.getName();

        // Find the index of the last dot (.) in the file name
        int dotIndex = fileName.lastIndexOf('.');

        // If no dot is found, return an empty string; otherwise, return the substring after the dot
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    // Class representing information about an uploaded image
    private class ImageInfo {
        // The original image
        private final Image image;

        // The thumbnail image view
        private final ImageView imageView;

        // Label displaying information about the image
        private final Label imageInfoLabel;

        // The file associated with the image
        private final File file;

        // Constructor to initialize the ImageInfo object
        public ImageInfo(Image image, ImageView imageView, Label imageInfoLabel, File file) {
            this.image = image;
            this.imageView = imageView;
            this.imageInfoLabel = imageInfoLabel;
            this.file = file;
        }

        // Getter method to retrieve the original image
        public Image getImage() {
            return image;
        }

        // Getter method to retrieve the thumbnail image view
        public ImageView getImageView() {
            return imageView;
        }

        // Getter method to retrieve the label displaying image information
        public Label getImageInfoLabel() {
            return imageInfoLabel;
        }


        public File getFile() {
            return file;
        }
    }

    // Apply color filter to an image using the specified color filter and ColorAdjust object
    private void applyColorFilter(String colorFilter, ColorAdjust filterAdjust) {
        // Check if a color filter is specified
        if (colorFilter != null) {
            // Initialize values for hue and saturation
            double hueValue = 0.0;
            double saturationValue = 0.0;

            // Switch statement to determine the values based on the selected color filter
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
                    // Default case for unknown color filters
                    break;
            }

            // Set the hue and saturation values to the ColorAdjust object
            filterAdjust.setHue(hueValue);
            filterAdjust.setSaturation(saturationValue);
        }
    }

    // Method to apply color filter to the image
    private Image applyColorFilter(Image originalImage, String colorFilter) {
        if (colorFilter != null) {
            ColorAdjust filterAdjust = new ColorAdjust();
            applyColorFilter(colorFilter, filterAdjust);

            // Create a temporary ImageView to apply the filter
            ImageView filteredImageView = new ImageView(originalImage);
            filteredImageView.setEffect(filterAdjust);

            // Create a new image from the filtered ImageView
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(javafx.scene.paint.Color.TRANSPARENT);
            return filteredImageView.snapshot(parameters, null);
        }

        return originalImage;
    }
}