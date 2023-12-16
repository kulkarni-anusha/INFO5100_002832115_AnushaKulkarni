import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {
            // Read JSON data from file
            String jsonData = new String(Files.readAllBytes(Paths.get("Books.json")));

            // Parse JSON
            JSONObject jsonJsonObject = new JSONObject(jsonData);
            System.out.println("\nJSON PARSER OUTPUT:\n" + jsonJsonObject.toString(4));

            // Add an additional entry programmatically to JSON
            JSONObject newBookJson = new JSONObject()
                    .put("title", "Three Thousand Stitches")
               .put("publishedYear", 2017)
                .put("numberOfPages", 250)
                .put("authors", new JSONArray().put("Sudha Murthy"));

            jsonJsonObject.getJSONObject("BookShelf").getJSONArray("Book").put(newBookJson);

            // Print updated JSON
            System.out.println("\nUPDATED JSON AFTER ADDING NEW ENTRY:\n" + jsonJsonObject.toString(4));

            // Convert JSON back to XML
            String updatedXmlData = XML.toString(jsonJsonObject);
            System.out.println("\nXML FROM UPDATED JSON:\n" + formatXml(updatedXmlData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Format XML for better readability
    private static String formatXml(String xmlString) {
        return xmlString.replaceAll("><", ">\n<");
    }
}
