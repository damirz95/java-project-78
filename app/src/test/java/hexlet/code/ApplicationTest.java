package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ApplicationTest {

    @Test
    public void testString() {
        var v = new Validator();
        var schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("hello")).isTrue();

        schema.minLength(4);
        assertThat(schema.isValid("one")).isFalse();
        assertThat(schema.isValid("first string")).isTrue();

        schema.contains("one");
        assertThat(schema.isValid("one punch")).isTrue();
        assertThat(schema.isValid("punch")).isFalse();

        schema.contains("hello");
        assertThat(schema.isValid("helloWorld")).isTrue();
        assertThat(schema.isValid("help")).isFalse();

    }

    @Test
    public void testNumber() {
        var v = new Validator();
        var schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.positive();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(10)).isTrue();

        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

        schema.range(6, 9);
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(10)).isFalse();
    }

    @Test
    public void testMap() {
        var v = new Validator();
        var schema = v.map();

        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);
        assertThat(schema.isValid(data)).isFalse();

        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2).contains("Smith"));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "John");
        human3.put("lastName", "Mark");
        assertThat(schema.isValid(human3)).isFalse();
    }
}
