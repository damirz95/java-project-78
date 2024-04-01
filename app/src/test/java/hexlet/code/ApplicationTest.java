package hexlet.code;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void testOne() {
        var v = new Validator();
        var schema = v.string();
        schema.required();
        schema.contains("test1 or test");
        var expected = true;
        assertThat(expected).isEqualTo(schema.isValid(""));
    }
    @Test
    public void testTwo() {
        var v = new Validator();
        var schema = v.string();
        schema.minLength(10);
        schema.minLength(4);
        var expected = true;
        assertThat(expected).isEqualTo(schema.isValid("Hexlet"));
    }
}
