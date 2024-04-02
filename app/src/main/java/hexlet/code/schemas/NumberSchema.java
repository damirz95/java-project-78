package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public void required() {

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
