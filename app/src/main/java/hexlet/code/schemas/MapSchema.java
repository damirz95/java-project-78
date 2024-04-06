package hexlet.code.schemas;

import java.util.Map;

import static java.util.Objects.isNull;

public class MapSchema extends BaseSchema<Map> {
    public void required() {
        addCheck("required", value -> !isNull(value));
    }
    public void sizeof(int size) {
        addCheck("sizeof", value -> size == value.size());
    }
}
