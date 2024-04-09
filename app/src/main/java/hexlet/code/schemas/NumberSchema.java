package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return null;
    }

    public NumberSchema range(int min, int max) {
        /*Predicate<Integer> predicate = value -> min <= value && value <= max;*/
        addCheck("range", value -> min <= value && value <= max);
        return null;
    }

    public NumberSchema positive() {
        /*Predicate<Integer> predicate = value -> value > 0;*/
        addCheck("positive", value -> value > 0);
        return null;
    }

}
