package hexlet.code.schemas;

import java.util.ArrayList;

public class StringSchema {
    private boolean requiredStatus;
    private int minLength;
    private String controlText;
    public void required() {
        this.requiredStatus = true;
    }
    public void minLength(int length) {
        this.minLength = length;
    }
    public void contains(String text) {
        this.controlText = text;
    }
    public boolean isValid(String text) {
        ArrayList<Boolean> flags = new ArrayList<>();
        if(requiredStatus) {
            flags.add(isRequired(text));
        } else {
            flags.add(true);
        }
        if (minLength > 0) {
            flags.add(isSize(text));
        } else {
            flags.add(true);
        }
        if( controlText !=null ) {
            flags.add(isContains(text));
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
    public boolean isRequired(String text) {
        return !text.isEmpty() && text != null;
    }
    public boolean isContains(String text) {
        return controlText.contains(text);
    }
    public boolean isSize(String text) {
        return text.length() >= minLength;
    }
    @Override
    public String toString() {
        return "StringSchema{" +
                "requiredStatus=" + requiredStatus +
                ", minLength=" + minLength +
                ", controlText='" + controlText + '\'' +
                '}';
    }
}
