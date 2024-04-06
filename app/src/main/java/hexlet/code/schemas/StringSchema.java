package hexlet.code.schemas;

import static java.util.Objects.isNull;

public class StringSchema extends BaseSchema<String>{
    public void required() {
        addCheck("required",value -> !isNull(value) && !value.isEmpty());
    }

    public void minLength(int length) {
        addCheck("minLength", value -> length <= value.length());
    }

    public void contains(String text) {
        addCheck("contains", value -> text.contains(value));
    }

}
