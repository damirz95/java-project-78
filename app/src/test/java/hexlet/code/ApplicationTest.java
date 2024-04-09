package hexlet.code;
import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        schema.sizeof(2);
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isEqualTo(true);
    }

    @Test
    public void testShape() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(schema.isValid(human1)).isEqualTo(true);
    }
}
