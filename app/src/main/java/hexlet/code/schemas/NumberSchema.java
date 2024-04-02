package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.SortedSet;

public class NumberSchema {
    private boolean requiredStatus;
    private boolean positiveStatus;
    private ArrayList<Integer> rangeArr;

    public void required() {
        this.requiredStatus = true;
    }
    public void range(int number, int number2) {
        this.rangeArr = new ArrayList<>();
        this.rangeArr.add(number);
        this.rangeArr.add(number2);
    }
    public void positive() {
        this.positiveStatus = true;
    }
    public boolean isValid(Integer number) {
        ArrayList<Boolean> flags = new ArrayList<>();
        if(requiredStatus) {
            flags.add(isRequired(number));
        } else {
            flags.add(true);
        }
        if(positiveStatus) {
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
            return true;
        } else {
            return false;
        }
    }
    public boolean isRequired(Integer number) {
        return number != null;
    }
    public boolean isPositive(Integer number) {
        if (number == null) {
            return true;
        }
        return number > 0;
    }
    public boolean isInRange(Integer number) {
        return rangeArr.get(0) <= number &&  number <= rangeArr.get(rangeArr.size() - 1) ;
    }

    @Override
    public String toString() {
        return "NumberSchema{" +
                "requiredStatus=" + requiredStatus +
                ", positiveStatus=" + positiveStatus +
                ", rangeArr=" + rangeArr +
                '}';
    }
}
