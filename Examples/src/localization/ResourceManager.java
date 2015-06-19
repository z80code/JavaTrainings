package localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by igor on 19.06.2015.
 */
public class ResourceManager {

    private static ResourceManager ourInstance = new ResourceManager();
    private ResourceBundle resourceBundle;

    private final String RESOURCE_NAME = "localization.strings";

    public static ResourceManager getInstance() {
        return ourInstance;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
    }
}
