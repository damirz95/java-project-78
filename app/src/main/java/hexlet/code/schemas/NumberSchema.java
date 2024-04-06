package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {
    public void required() {
        addCheck("required", Objects::nonNull);
        /*Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer != null;
            }
        };
        addCheck("required", predicate);*/
    }

    public void range(int min, int max) {
        /*Predicate<Integer> predicate = value -> min <= value && value <= max;*/
        addCheck("range", value -> min <= value && value <= max);

    }

    public void positive() {
        /*Predicate<Integer> predicate = value -> value > 0;*/
        addCheck("positive", value -> value > 0);
    }

}
