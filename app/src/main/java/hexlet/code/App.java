package hexlet.code;

public class App {
    public static void main(String[] args) {
        var valid = new Validator();
        var shem = valid.number();
        /*shem.required();*/
        /*shem.minLength(3);*/
        shem.range(2, 4);
        System.out.println(shem.toString());
    }
}
