package hexlet.code.schemas;

import java.util.Objects;

import static java.util.Objects.isNull;

public class StringSchema extends BaseSchema<String>{
    public void required() {
        addCheck("required",value -> {
            return !isNull(value) && !value.isEmpty();
        });
    }

    public void minLength(int length) {
        addCheck("minLength", value -> length <= value.length() );
    }

    public void contains(String text) {
        addCheck("contains", value -> text.contains(value));
    }

}
