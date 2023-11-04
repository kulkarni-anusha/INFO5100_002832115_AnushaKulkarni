import java.io.*;

public class SerializeDeserialize {
    public static void serialize(Shape shape, String shapeData) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(shapeData);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(shape);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Shape deserialize(String shapeData) {
        try (FileInputStream fileInputStream = new FileInputStream(shapeData);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Shape) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}