package hexlet.code;

public class App {
    public static void main(String[] args) {
        var valid = new Validator();
        var shem = valid.string();
        /*shem.required();*/
        /*shem.minLength(3);*/
        shem.isValid("dsas");
        System.out.println(shem.toString());
    }
}
