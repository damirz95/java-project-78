package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    public void required() {
        addCheck("required", value -> true);
    }
    public void sizeof() {

    }
}
