package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

public class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        addCheck("required", value -> !isNull(value));
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> size == value.size());
        return this;
    }

    public void shape(Map<String, BaseSchema> map) {
        addCheck("shape", shapeCheck(map));
    }

    public Predicate<Map> shapeCheck(Map<String, BaseSchema> inputSchema) {
        return map -> {
            for (Map.Entry<String, BaseSchema> entry: inputSchema.entrySet()) {
                String key = entry.getKey();
                Map name = (Map) map;
                var data = name.get(key);
                var schema = inputSchema.get(key);
                if (!schema.isValid(data)) {
                    return false;
                }
            }
            return true;
        };
    }
}
