package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class BasicHeader implements Serializable, Cloneable, Header {
   private static final long serialVersionUID = -5427236326487562174L;
   private final String name;
   private final String value;

   public BasicHeader(String var1, String var2) {
      this.name = Args.notNull(var1, "Name");
      this.value = var2;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   @Override
   public HeaderElement[] getElements() throws ParseException {
      HeaderElement[] var1;
      if (this.value != null) {
         var1 = BasicHeaderValueParser.parseElements(this.value, null);
      } else {
         var1 = new HeaderElement[0];
      }

      return var1;
   }

   @Override
   public String getName() {
      return this.name;
   }

   @Override
   public String getValue() {
      return this.value;
   }

   @Override
   public String toString() {
      return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
   }
}
