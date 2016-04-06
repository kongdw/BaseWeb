package k0n9.common.plugins.stripes;

import com.google.gson.FieldAttributes;

/**
 * gson 序列化时需要忽略的class类型与annotation类型
 * 使用:
 *
 * @author David Kong
 * @version 1.0
 * @JsonIgnore private String password;
 */
public class JsonExclusionStrategy implements com.google.gson.ExclusionStrategy {

    private Class<?> typeToSkip;

    public JsonExclusionStrategy() {
        this(null);
    }

    public JsonExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return (typeToSkip != null && clazz == typeToSkip);
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(JsonIgnore.class) != null;
    }
}