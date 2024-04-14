package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ApplicationTest {
    private final Validator v = new Validator();

    @Test
    public void testString() {
        var schema = v.string().required().minLength(2).contains("what");
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
    }
    @Test
    public void testNumber() {
        var schema = v.number();
        schema.range(0, 10);
        schema.positive();
        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
    }
    @Test
    public void testMap() {
        var schema = v.map();
        schema.required();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        schema.sizeof(2);
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isEqualTo(true);
    }

    @Test
    public void testShape() {
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(schema.isValid(human1)).isEqualTo(true);
    }
}
