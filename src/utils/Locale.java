package utils;

import java.util.HashMap;
import java.util.Map;

public class Locale {
    private static final Map<String, String[]> languages = new HashMap<>();

    static {
        languages.put("bg", new String[]{"Bulgarian", "Български"});
        languages.put("bs", new String[]{"Bosnian", "Bosanski"});
        languages.put("cs", new String[]{"Czech", "Čeština"});
        languages.put("da", new String[]{"Danish", "Dansk"});
        languages.put("de", new String[]{"German", "Deutsch"});
        languages.put("el", new String[]{"Greek", "ελληνικά"});
        languages.put("en", new String[]{"English", "English"});
        languages.put("eo", new String[]{"Esperanto", "Esperanta"});
        languages.put("es", new String[]{"Spanish", "Español"});
        languages.put("fi", new String[]{"Finnish", "Suomi"});
        languages.put("fr", new String[]{"French", "Français"});
        languages.put("hr", new String[]{"Croatian", "Hrvatski"});
        languages.put("hu", new String[]{"Hungarian", "Magyar"});
        languages.put("is", new String[]{"Icelandic", "Íslenska"});
        languages.put("it", new String[]{"Italian", "Italiano"});
        languages.put("la", new String[]{"Latin", "Latina"});
        languages.put("nl", new String[]{"Dutch", "Nederlands"});
        languages.put("no", new String[]{"Norwegian", "Norsk"});
        languages.put("pl", new String[]{"Polish", "Polski"});
        languages.put("pt", new String[]{"Portuguese", "Português"});
        languages.put("ro", new String[]{"Romanian", "Română"});
        languages.put("ru", new String[]{"Russian", "Русский"});
        languages.put("sk", new String[]{"Slovak", "Slovenčina"});
        languages.put("sq", new String[]{"Albanian", "Shqip"});
        languages.put("sr", new String[]{"Serbian", "Српски"});
        languages.put("sv", new String[]{"Swedish", "Svensk"});
        languages.put("tr", new String[]{"Turkish", "Türkçe"});
    }

    public String getNative(String lang) {
        String[] langArray = languages.get(lang);
        if (langArray != null && langArray.length > 1) {
            return langArray[1];
        } else {
            throwInvalidLanguageException(lang);
            return null;
        }
    }

    public String getEnglish(String lang) {
        String[] langArray = languages.get(lang);
        if (langArray != null && langArray.length > 0) {
            return langArray[0];
        } else {
            throwInvalidLanguageException(lang);
            return null;
        }
    }

    public static void validateLanguage(String lang) {
        if (!languages.containsKey(lang)) {
            throwInvalidLanguageException(lang);
        }
    }

    private static void throwInvalidLanguageException(String lang) {
        String validLangs = String.join(", ", languages.keySet());
        throw new IllegalArgumentException("Invalid language code: " + lang + ". Available languages are: " + validLangs);
    }
}