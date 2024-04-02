package hexlet.code.schemas;

import java.util.ArrayList;

public class BaseSchema<T> {
    public void isVoid(T data) {
        ArrayList<Boolean> flags = new ArrayList<>();
        if(requiredStatus) {
            flags.add(isRequired(number));
        } else {
            flags.add(true);
        }
        if(T) {
            flags.add(isPositive(number));
        } else {
            flags.add(true);
        }
        if (rangeArr != null) {
            flags.add(isInRange(number));
        } else {
            flags.add(true);
        }
        int count = 0;
        for (var flag: flags) {
            if(flag) {
                count++;
            }
        }
        if(count == 3) {
            System.out.println(true);;
        } else {
            System.out.println(false);;
        }
    }
}
