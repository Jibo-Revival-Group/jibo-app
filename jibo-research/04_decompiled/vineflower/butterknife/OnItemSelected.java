package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnItemSelected {
   enum Callback {
      ITEM_SELECTED,
      NOTHING_SELECTED;

      private static final OnItemSelected.Callback[] $VALUES = new OnItemSelected.Callback[]{
         OnItemSelected.Callback.ITEM_SELECTED, OnItemSelected.Callback.NOTHING_SELECTED
      };
   }
}
