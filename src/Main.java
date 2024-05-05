import dictcc.Scraper;
import dictcc.Translations;
import utils.Locale;
import utils.Print;

import java.util.Scanner;

public class Main {

    private static final Scanner SC = new Scanner(System.in);
    private static final Print PRINT = new Print();
    private static String langFrom;
    private static String langTo;
    private static String keyword;

    public static void main(String[] args) {

        boolean restartApp = false;

        if (args.length == 3) {
            langFrom = args[0].toLowerCase();
            langTo = args[1].toLowerCase();
            keyword = args[2];
        } else {
            promptUser();
            restartApp = true;
        }

        while (true) {

            // Check if language available
            Locale.validateLanguage(langFrom);
            Locale.validateLanguage(langTo);

            Translations translations;
            Scraper scraper = new Scraper(langFrom, langTo);
            translations = scraper.getTranslations(keyword);

            translations.printTranslations();

            if (restartApp) {
                System.out.println("\n-----------------------------");
                promptUser();
            } else {
                break;
            }
        }
    }

    private static void promptUser() {
        System.out.print(PRINT.green("\nTranslate from: "));
        langFrom = SC.nextLine().toLowerCase();
        System.out.print(PRINT.green("Translate to: \t"));
        langTo = SC.nextLine().toLowerCase();
        System.out.print(PRINT.yellow("Translate word: "));
        keyword = SC.nextLine();
        System.out.println();
    }
}