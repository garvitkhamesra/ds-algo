/**
 * Created by dot on 12/4/20 9:53 AM
 * Package: PACKAGE_NAME
 */
public class HTMlEntityParser {
    public String entityParser(String text) {
        if (text.contains("&quot;")) {
            text = text.replaceAll("&quot;", "\"");
        }
        if (text.contains("&apos;")) {
            text = text.replaceAll("&apos;", "'");
        }
        if (text.contains("&amp;")) {
            text = text.replaceAll("&amp;", "&");
        }
        if (text.contains("&gt;")) {
            text = text.replaceAll("&gt;", ">");
        }
        if (text.contains("&lt;")) {
            text = text.replaceAll("&lt;", "<");
        }
        if (text.contains("&frasl;")) {
            text = text.replaceAll("&frasl;", "/");
        }

        return text;
    }
}
