package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnPageChange {
   enum Callback {
      PAGE_SCROLLED,
      PAGE_SCROLL_STATE_CHANGED,
      PAGE_SELECTED;

      private static final OnPageChange.Callback[] $VALUES = new OnPageChange.Callback[]{
         OnPageChange.Callback.PAGE_SELECTED, OnPageChange.Callback.PAGE_SCROLLED, OnPageChange.Callback.PAGE_SCROLL_STATE_CHANGED
      };
   }
}
