import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
    private final String stringVariable;
    private final int intVariable;
    private final Map<String, String> mapVariable;

    public ImmutableClass(String stringVariable, int intVariable, Map<String, String> mapVariable) {
        this.stringVariable = stringVariable;
        this.intVariable = intVariable;
        this.mapVariable = new HashMap<>(mapVariable);
    }

    public String getStringVariable() {
        return stringVariable;
    }

    public int getIntVariable() {
        return intVariable;
    }

    public Map<String, String> getMapVariable() {
        return new HashMap<> (mapVariable);
//        return Collections.unmodifiableMap(mapVariable);
    }

}
