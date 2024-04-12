package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", value -> {
            if (value == null) {
                return true;
            }
            if (min <= value && value <= max) {
                return false;
            } else {
                return false;
            }
        });
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> {
            if (value == null) {
                return true;
            }
            if (value > 0) {
                return true;
            } else {
                return false;
            }
        });
        return this;
    }
}
