package application.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static java.text.MessageFormat.format;

@Slf4j
public class PropertyManager {

    public static String getProperty(String name) {
        return getPropertyOptional(name)
                .orElseThrow(() -> new NullPointerException(format("Missing property {0}", name)));
    }

    public static String getProperty(String name, String defaultValue) {
        return getPropertyOptional(name).orElse(defaultValue);
    }

    public static Long getPropertyAsLong(String name, Long defaultValue) {
        return getPropertyOptional(name).map(Long::valueOf).orElse(defaultValue);
    }

    public static int getPropertyAsInt(String name, int defaultValue) {
        return getPropertyOptional(name).map(Integer::valueOf).orElse(defaultValue);
    }

    public static boolean getPropertyAsBoolean(String name, boolean defaultValue) {
        return getPropertyOptional(name).map(Boolean::valueOf).orElse(defaultValue);
    }

    private static Optional<String> getPropertyOptional(String name) {
        return Optional.ofNullable(System.getenv(name));
    }
}
