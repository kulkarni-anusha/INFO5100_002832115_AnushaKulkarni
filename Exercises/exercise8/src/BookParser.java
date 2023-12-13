import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class BookParser {

    public static void main(String[] args) {
        // Sample XML
        String xmlData = "<BookShelf>" +
                "  <Book>" +
                "    <title>Harry Potter and the Deathly Hallows</title>" +
                "    <publishedYear>2007</publishedYear>" +
                "    <numberOfPages>800</numberOfPages>" +
                "    <authors>" +
                "      <author>J.K. Rowling</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>The Da Vinci Code</title>" +
                "    <publishedYear>2003</publishedYear>" +
                "    <numberOfPages>700</numberOfPages>" +
                "    <authors>" +
                "      <author>Dan Brown</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Divergent</title>" +
                "    <publishedYear>2011</publishedYear>" +
                "    <numberOfPages>500</numberOfPages>" +
                "    <authors>" +
                "      <author>Veronica Roth</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>The Vampire Diaries</title>" +
                "    <publishedYear>1991</publishedYear>" +
                "    <numberOfPages>300</numberOfPages>" +
                "    <authors>" +
                "      <author>L. J. Smith</author>" +
                "      <author>Aubrey Clark</author>" +
                "    </authors>" +
                "  </Book>" +
                "</BookShelf>";

        // Parse XML
        JSONObject jsonFromXml = XML.toJSONObject(xmlData);
        System.out.println("\nJSON FROM XML:\n" + jsonFromXml.toString(4));

        // Parse JSON
        String jsonData = "{ \"BookShelf\": { \"Book\": [" +
                " { \"title\": \"Nancy Drew\", \"publishedYear\": 1945, \"numberOfPages\": 250, \"authors\": [\" Carolyn Keene\"] }" +
                "] } }";

        JSONObject jsonObject = new JSONObject(jsonData);
        System.out.println("\nPARSED JSON:\n\n" + jsonObject.toString(4));

        // Add an additional entry programmatically
        JSONObject newBook = new JSONObject()
                .put("title", "Three Thousand Stitches")
                .put("publishedYear", 2017)
                .put("numberOfPages", 250)
                .put("authors", new JSONObject().put("author", "Sudha Murthy"));

        jsonObject.getJSONObject("BookShelf").getJSONArray("Book").put(newBook);

        // Print updated JSON
        System.out.println("\nUPDATED JSON:\n" + jsonObject.toString(4));

        // Convert JSON back to XML
        String updatedXmlData = XML.toString(jsonObject);
        System.out.println("\nXML FROM UPDATED JSON:\n" + formatXml(updatedXmlData));
    }

    // format XML for better readability
    private static String formatXml(String xmlString) {
        return xmlString.replaceAll("><", ">\n<");
    }
}