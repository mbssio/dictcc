package dictcc;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Locale;
import utils.Print;

import java.util.Properties;

public class Translations {

    private static final Properties PROPERTIES = utils.Utils.getProperties();
    private static final int LINE_LENGTH = Integer.parseInt(PROPERTIES.get("line_length").toString());

    private static final Locale LOCALE = new Locale();
    private static final Print PRINT = new Print();

    private static Elements[] translationElements;
    private static int numFoundTranslations;
    private static String[][] translationsArray;

    private static String langFrom;
    private static String langTo;
    private static String keyword;

    public Translations(Elements[] translationElements, int numFoundTranslations, String langFrom, String langTo, String keyword) {
        this.translationElements = translationElements;
        this.numFoundTranslations = numFoundTranslations;
        this.translationsArray = new String[numFoundTranslations][6];

        this.langFrom = langFrom;
        this.langTo = langTo;
        this.keyword = keyword;

        if (this.numFoundTranslations > 0) {
            populateTranslationsArray();
        }
    }

    private void populateTranslationsArray() {
        for (int i = 0; i < numFoundTranslations; i++) {
            Elements translation = translationElements[i];
            Element firstLang = langFrom.equals("en") && langTo.equals("de") ? translation.getFirst() : translation.get(1);
            Element secondLang = langFrom.equals("en") && langTo.equals("de") ? translation.get(1) : translation.getFirst();

            translationsArray[i][0] = firstLang.select("a").text().replaceAll("\\[.*?]", "").trim();
            translationsArray[i][1] = firstLang.select("var").text();
            translationsArray[i][2] = firstLang.select("kbd").text();
            translationsArray[i][3] = secondLang.select("a").text().replaceAll("\\[.*?]", "").trim();
            translationsArray[i][4] = secondLang.select("var").text();
            translationsArray[i][5] = secondLang.select("kbd").text();
        }
    }

    public void printTranslations() {

        if (numFoundTranslations > 0) {

            System.out.print(LOCALE.getNative(langFrom));
            System.out.print(repeatChar(' ', (LINE_LENGTH - LOCALE.getNative(langFrom).length() + 3)));
            System.out.println(LOCALE.getNative(langTo));
            System.out.print(repeatChar('=', LOCALE.getNative(langFrom).length() + 1));
            System.out.print(repeatChar(' ', LINE_LENGTH - LOCALE.getNative(langFrom).length() + 2));
            System.out.println(repeatChar('=', LOCALE.getNative(langTo).length() + 1));

            for (int i = 0; i < numFoundTranslations; i++) {
                int lineLength = 0;
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < 6; j++) {
                    String var = translationsArray[i][j].isEmpty() ? "" : translationsArray[i][j] + " ";
                    lineLength += var.length();

                    line.append((j == 0 || j == 3) ? var : PRINT.blue(var));
                    line.append(j == 2 ? repeatChar('.', (LINE_LENGTH - lineLength)) + " = " : "");
                }
                System.out.println(line);
            }
        } else {
            System.out.println("No results found.");
        }
    }

    private String repeatChar(char c, int amount) {
        return String.valueOf(c).repeat(Math.max(0, amount));
    }

}
