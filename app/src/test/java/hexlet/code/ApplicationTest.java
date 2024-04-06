package hexlet.code;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ApplicationTest {
    @Test
    public void testString() {
        var v = new Validator();
        var schema = v.string();
        schema.required();
        schema.minLength(4);
        schema.contains("is null");
        var expected = true;
        assertThat(schema.isValid("null")).isEqualTo(true);
    }
    @Test
    public void testNumber() {
        var v = new Validator();
        var schema = v.number();
        schema.required();
        schema.positive();
        schema.range(-5, 10);

        assertThat(schema.isValid(1)).isEqualTo(true);
        //TODO добавить тестов
    }
    @Test
    public void testMap() {
        var v = new Validator();
        var schema = v.map();
        schema.required();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        schema.isValid(data);
        schema.sizeof(2);
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isEqualTo(true);
    }
}
