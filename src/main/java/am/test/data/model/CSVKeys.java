package am.test.data.model;

/**
 * Created by karlen on 4/16/17.
 */
public enum CSVKeys {

    KEY("Key"),
    ABOVE_TRESHOLD("Above treshold"),
    DATE("Date"),
    HOUR("Hour"),
    DAY_OF_THE_WEEK("The day of the week"),
    REGION("Region");

    private final String name;

    CSVKeys(String name) {
        this.name = name;
    }

    public static boolean conteinsName(final String name) {
        for (CSVKeys csvKeys : CSVKeys.values()) {
            if (csvKeys.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getNames() {
        CSVKeys[] values = CSVKeys.values();
        int length = values.length;
        String[] names = new String[length];
        for (int i = 0; i < length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }

    public String getName() {
        return name;
    }
}
