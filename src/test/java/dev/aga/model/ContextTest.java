package dev.aga.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextTest {
    @Test
    void testDeserWithoutAfterburner() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Test");
        data.put("id", 1);

        Context context = mapper.convertValue(data, Context.class);
        assertEquals("Test", context.getName());
        assertEquals(1, context.getId());
    }

    @Test
    void testDeserWithAfterburnerAndWithoutValueClassLoader() {
        ObjectMapper mapper = new ObjectMapper().registerModule(new AfterburnerModule().setUseValueClassLoader(false));
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Test");
        data.put("id", 1);
        Context context = mapper.convertValue(data, Context.class);
        assertEquals("Test", context.getName());
        assertEquals(1, context.getId());
    }
}
