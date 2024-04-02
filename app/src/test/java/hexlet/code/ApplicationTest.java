package hexlet.code;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void testString() {
        var v = new Validator();
        var schema = v.string();
        schema.required();
        schema.contains("test1 or test");
        var expected = true;
        assertThat(schema.isValid("test")).isEqualTo(expected);
    }
    @Test
    public void testNumber() {
        var v = new Validator();
        var schema = v.number();
        var expected = true;
        schema.required();
        schema.range(5, 10);
        assertThat(schema.isValid(5)).isEqualTo(expected);
    }
}
