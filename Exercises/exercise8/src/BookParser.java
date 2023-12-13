//
//import java.io.FileReader;
//import java.io.PrintWriter;
//import java.util.HashMap;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
//
//
//public class JsonParser {
//
//    // Creating function to read the file from given location
//
//    public static JSONObject getFile(String filePath) throws Exception {
//        // Creating an object of JSONParser for parsing JSON file
//        JSONParser jsonparser = new JSONParser();
//
//        // Creating an object of FileReader class to load the json file to be parsed
//        FileReader reader = new FileReader(filePath);
//
//        // Parsing the json data from the object `reader` and saving it as a java Object
//        // in a variable named `object`
//        Object object = jsonparser.parse(reader);
//
//        // Type casting of object from java to json
//        JSONObject bookshelfjsonobj = (JSONObject) object;
//
//        return bookshelfjsonobj;
//    }
//
//    // Creating function to print the JSON file in desired format
//
//    public static void printJsonDocument(JSONArray book) {
//        // For loop for iterating over the 3 values of the book array and printing out
//        // required information
//        // for each of the values
//        for (int i = 0; i < book.size(); i++) {
//
//            JSONObject objs = (JSONObject) book.get(i);
//
//            String title = (String) objs.get("title");
//            String publishedYear = (String) objs.get("publishedYear");
//            String numberOfPages = (String) objs.get("numberOfPages");
//            String authors = (String) objs.get("authors");
//
//            int bookNumber = i + 1;
//            System.out.println("\nThe details for book " + bookNumber + " is:");
//            System.out.println("title: " + title);
//            System.out.println("publishedYear: " + publishedYear);
//            System.out.println("numberOfPages: " + numberOfPages);
//            System.out.println("authors: " + authors);
//        }
//    }
//
//    // Unchecking the warning to supress them
//    @SuppressWarnings("unchecked")
//    // Main program
//    public static void main(String[] args) throws Exception {
//        // Calling function `getFile()` to read the JSON file from given location
//        JSONObject bookshelfjsonobj = getFile("/Users/anushakulkarni/Documents/Anusha/NEU/1_sem/AED/INFO5100_002832115_AnushaKulkarni/Exercises/exercise8/src/InputFile.json");
//
//        // Extracting json array - bookshelf
//        JSONArray array = (JSONArray) bookshelfjsonobj.get("bookshelf");
//        // Extracting the object of bookshelf array
//        JSONObject bookArray = (JSONObject) array.get(0);
//
//        // Extracting json array - Book
//        JSONArray book = (JSONArray) bookArray.get("Book");
//
//        System.out.println("=========================Printing already exisiting JSON File=========================");
//        // Calling function `printJsonDocument()` to print the JSON file
//        printJsonDocument(book);
//
//        // Creating new object to be added to the JSON array
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("title", "The Perks Of Being a Wallflower");
//        map.put("publishedYear", "1999");
//        map.put("numberOfPages", "256");
//        map.put("authors", "Stephen Chbosky");
//        JSONObject obj = new JSONObject(map);
//
//        // Adding new object to the existing JSON array
//        book.add(obj);
//
//        // Modifying the existing JSON file
//        PrintWriter pw = new PrintWriter("/Users/anushakulkarni/Documents/Anusha/NEU/1_sem/AED/INFO5100_002832115_AnushaKulkarni/Exercises/exercise8/src/InputFile.json");
//        pw.write(bookshelfjsonobj.toJSONString());
//        pw.flush();
//        pw.close();
//
//        // Calling function `getFile()` to read the updated JSON file again
//        bookshelfjsonobj = getFile("/Users/anushakulkarni/Documents/Anusha/NEU/1_sem/AED/INFO5100_002832115_AnushaKulkarni/Exercises/exercise8/src/InputFile.json");
//
//        // Extracting json array - bookshelf
//        array = (JSONArray) bookshelfjsonobj.get("bookshelf");
//        // Extracting the object of bookshelf array
//        bookArray = (JSONObject) array.get(0);
//
//        // Extracting json array - Book
//        book = (JSONArray) bookArray.get("Book");
//
//        System.out.println(
//                "=========================Adding new element to the file and printing the content again=========================");
//        // Calling function `printJsonDocument()` for printing the updated JSON file
//        printJsonDocument(book);
//
//    }
//
//}
//

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class BookParser {

    public static void main(String[] args) {
        // Sample XML
        String xmlData = "<BookShelf>" +
                "  <Book>" +
                "    <title>Updated Title</title>" +
                "    <publishedYear>2022</publishedYear>" +
                "    <numberOfPages>500</numberOfPages>" +
                "    <authors>" +
                "      <author>John Doe</author>" +
                "      <author>Jane Smith</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Data Structures and Algorithms</title>" +
                "    <publishedYear>2020</publishedYear>" +
                "    <numberOfPages>400</numberOfPages>" +
                "    <authors>" +
                "      <author>Alan Turing</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Web Development with JavaScript</title>" +
                "    <publishedYear>2021</publishedYear>" +
                "    <numberOfPages>300</numberOfPages>" +
                "    <authors>" +
                "      <author>Grace Hopper</author>" +
                "    </authors>" +
                "  </Book>" +
                "</BookShelf>";

        // Parse XML
        JSONObject jsonFromXml = XML.toJSONObject(xmlData);
        System.out.println("JSON from XML:\n" + jsonFromXml.toString(2));

        // Parse JSON
        String jsonData = "{ \"BookShelf\": { \"Book\": [" +
                " { \"title\": \"Machine Learning\", \"publishedYear\": 2019, \"numberOfPages\": 600, \"authors\": [\"Andrew Ng\"] }" +
                "] } }";

        JSONObject jsonObject = new JSONObject(jsonData);
        System.out.println("\nParsed JSON:\n" + jsonObject.toString(2));

        // Add an additional entry programmatically
        JSONObject newBook = new JSONObject()
                .put("title", "Introduction to Programming")
                .put("publishedYear", 2023)
                .put("numberOfPages", 250)
                .put("authors", new JSONArray().put("Alice Wonderland").put("Bob Builder"));

        jsonObject.getJSONObject("BookShelf").getJSONArray("Book").put(newBook);

        // Print updated JSON
        System.out.println("\nUpdated JSON:\n" + jsonObject.toString(2));

        // Convert JSON back to XML
        String updatedXmlData = XML.toString(jsonFromXml);
        System.out.println("\nXML from updated JSON:\n" + updatedXmlData);
    }
}