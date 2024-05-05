package dictcc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Scraper {

    private static final Properties PROPERTIES = utils.Utils.getProperties();
    private static final int NUMBER_OF_RESULTS = Integer.parseInt(PROPERTIES.get("number_of_results").toString());
    private static final String USERAGENT = PROPERTIES.get("user_agent").toString();

    private static String url;
    private static String langFrom;
    private static String langTo;

    public Scraper(String langFrom, String langTo) {
        this.langFrom = langFrom;
        this.langTo = langTo;
        urlBuilder(langFrom, langTo);
    }

    public Translations getTranslations(String keyword) {
        Document htmlResponse = fetchResponse(keyword);

        int numFoundTranslations = 0;
        Elements[] translationElements = new Elements[NUMBER_OF_RESULTS];
        for (int i = 0; i < NUMBER_OF_RESULTS; i++) {
            try {
                Element row = htmlResponse.select("tr#tr" + (i + 1)).getFirst();
                translationElements[i] = row.select("td.td7nl");
                numFoundTranslations++;
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return new Translations(translationElements, numFoundTranslations, langFrom, langTo, keyword);
    }

    private Document fetchResponse(String keyword) {
        Document res;
        try {
            res = Jsoup
                    .connect(url + keyword)
                    .userAgent(USERAGENT)
                    .header("Accept-Language", "*")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private void urlBuilder(String langFrom, String langTo) {
        url = "https://" + langFrom + "-" + langTo + ".dict.cc/?s=";
    }
}
