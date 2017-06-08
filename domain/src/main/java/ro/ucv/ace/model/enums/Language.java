package ro.ucv.ace.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Geo on 15.11.2016.
 */
public enum Language {
    C("c"), JAVA("java"), CSHARP("csharp");

    private String name;

    Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static Map<String, Language> namesMap = new HashMap<>(3);

    static {
        namesMap.put("c", C);
        namesMap.put("java", JAVA);
        namesMap.put("csharp", CSHARP);
    }

    @JsonCreator
    public static Language forValue(String value) {
        return namesMap.get(value.toLowerCase());
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Language> entry : namesMap.entrySet()) {
            if (entry.getValue() == this) {
                return entry.getKey();
            }
        }

        return null; // or fail
    }
}
