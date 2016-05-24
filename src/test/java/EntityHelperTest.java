import k0n9.module.archive.entity.Archive;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Kong
 * @version 1.0
 */
public class EntityHelperTest {

    public static void main(String[] args) {
        System.out.println(convertSearchColumn("category.name", Archive.class));
    }

    public static String camelhumpToUnderline(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() + i, matcher.end() + i, "_" + matcher.group().toLowerCase());
        }
        if (builder.charAt(0) == '_') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }


    public static String convertSearchColumn(String property, Class<?> clazz) {
        String[] namesSplits = StringUtils.split(property, ".");
        Field field = null;
        String columnName = "";
        String tableName = "";
        Class entityClass = clazz;
        for (String namesSplit : namesSplits) {
            field = FieldUtils.getField(entityClass, namesSplit, true);
            entityClass = field.getType();
        }
        if (field != null) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                columnName = column.name();
            } else {
                columnName = camelhumpToUnderline(field.getName());
            }
            Class<?> fieldClass = field.getDeclaringClass();
            Table table = fieldClass.getAnnotation(Table.class);
            if (table != null) {
                tableName = table.name();
            } else {
                tableName = camelhumpToUnderline(fieldClass.getSimpleName());
            }
        }
        return tableName + "." + columnName;
    }
}
