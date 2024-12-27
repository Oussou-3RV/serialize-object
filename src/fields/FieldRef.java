package src.fields;

import src.annotations.Alias;
import src.annotations.Ignored;
import java.lang.reflect.Field;

public class FieldRef {
    private String name;
    private Alias aliasAnnotation;
    private Ignored ignoredAnnotation;

    private Field field;
    public FieldRef(Field field) {
        this.field = field;
    }

    public boolean isSimpleType(Class<?> type) {
        if(type != null)
            return type.isPrimitive() || type.equals(String.class) || type == Boolean.class || Number.class.isAssignableFrom(type);

        return false;
    }

    public Boolean isObjectType(Class<?> type) {
        if (type != null)
            return Iterable.class.isAssignableFrom(type) || type.isArray();

        return false;
    }
}
