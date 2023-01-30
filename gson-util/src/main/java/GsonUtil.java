import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class GsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(GsonUtil.class);
    private static Gson GSON;
    private static JsonParser jsonParser;

    public GsonUtil() {
    }

    public static String toJsonStr(Object object) {
        return object == null ? null : GSON.toJson(object);
    }

    public static JsonObject parseJsonObject(String jsonstr) {
        return StringUtils.isBlank(jsonstr) ? null : jsonParser.parse(jsonstr).getAsJsonObject();
    }

    public static JsonArray parseJsonArray(String jsonstr) {
        return StringUtils.isBlank(jsonstr) ? null : jsonParser.parse(jsonstr).getAsJsonArray();
    }

    public static <T> T parseObj(String json, Class<T> classOfT) {
        return json == null ? null : GSON.fromJson(json, classOfT);
    }

    public static <T> List<T> parseList(String json, Class<T> clazz) {
        return json == null ? null : (List) parseObj(json, (Type) (new ParameterizedTypeImpl(clazz)));
    }

    public static <T> List<Map<String, T>> parseListMap(String gsonString) {
        return (List) parseObj(gsonString, (new TypeToken<List<Map<String, T>>>() {
        }).getType());
    }

    public static <T> Map<String, T> parseMap(String gsonString) {
        return (Map) parseObj(gsonString, (new TypeToken<Map<String, T>>() {
        }).getType());
    }

    public static <T> T parseObj(String json, Type typeOfT) {
        return json == null ? null : GSON.fromJson(json, typeOfT);
    }

    static {
        GSON = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").registerTypeAdapter(LocalDateTime.class, new TimeSerialzerAdapter()).registerTypeAdapter(LocalDateTime.class, new TimeDeserializerAdapter()).enableComplexMapKeySerialization().disableHtmlEscaping().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
        jsonParser = new JsonParser();
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {
        private Class clazz;

        ParameterizedTypeImpl(Class clazz) {
            this.clazz = clazz;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{this.clazz};
        }

        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }

    private static class TimeDeserializerAdapter implements JsonDeserializer<LocalDateTime> {
        private TimeDeserializerAdapter() {
        }

        public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        }
    }

    private static class TimeSerialzerAdapter implements JsonSerializer<LocalDateTime> {
        private TimeSerialzerAdapter() {
        }

        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        }
    }
}

