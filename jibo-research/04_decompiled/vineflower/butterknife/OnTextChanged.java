package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnTextChanged {
   enum Callback {
      AFTER_TEXT_CHANGED,
      BEFORE_TEXT_CHANGED,
      TEXT_CHANGED;

      private static final OnTextChanged.Callback[] $VALUES = new OnTextChanged.Callback[]{
         OnTextChanged.Callback.TEXT_CHANGED, OnTextChanged.Callback.BEFORE_TEXT_CHANGED, OnTextChanged.Callback.AFTER_TEXT_CHANGED
      };
   }
}
