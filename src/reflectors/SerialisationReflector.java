package src.reflectors;

import src.fields.FieldRef;
import src.fields.SimpleFieldRef;

import javax.lang.model.type.PrimitiveType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SerialisationReflector {
    private List<FieldRef> simpleField;
    private List<FieldRef> ObjectField;
    private List<FieldRef> CollectionField;

   private Field field;

   protected SerialisationReflector(Object o) {
       this.simpleField = new ArrayList<>();
       this.ObjectField = new ArrayList<>();
       this.CollectionField = new ArrayList<>();

       AnalyseField(o);
   }

   public void AnalyseField(Object instance) {

       Class<?> clazz = instance.getClass();

       Field[] fields = clazz.getDeclaredFields();

       for (Field field : fields) {
           field.setAccessible(true);

           FieldRef fieldRef = new FieldRef(field);

           if(fieldRef.isSimpleType(field.getType())) {
               simpleField.add(fieldRef);
           } else if (fieldRef.isObjectType(field.getType())) {
               ObjectField.add(fieldRef);
           }else
               CollectionField.add(fieldRef);

       }


   }

   public String toJson(Object instance) {

   }


}
