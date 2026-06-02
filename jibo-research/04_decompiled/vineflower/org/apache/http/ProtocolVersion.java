package org.apache.http;

import java.io.Serializable;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class ProtocolVersion implements Serializable, Cloneable {
   private static final long serialVersionUID = 8950662842175091068L;
   protected final int major;
   protected final int minor;
   protected final String protocol;

   public ProtocolVersion(String var1, int var2, int var3) {
      this.protocol = Args.notNull(var1, "Protocol name");
      this.major = Args.notNegative(var2, "Protocol minor version");
      this.minor = Args.notNegative(var3, "Protocol minor version");
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public int compareToVersion(ProtocolVersion var1) {
      Args.notNull(var1, "Protocol version");
      Args.check(this.protocol.equals(var1.protocol), "Versions for different protocols cannot be compared: %s %s", this, var1);
      int var3 = this.getMajor() - var1.getMajor();
      int var2 = var3;
      if (var3 == 0) {
         var2 = this.getMinor() - var1.getMinor();
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof ProtocolVersion)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.protocol.equals(var1.protocol) || this.major != var1.major || this.minor != var1.minor) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public ProtocolVersion forVersion(int var1, int var2) {
      ProtocolVersion var3;
      if (var1 == this.major && var2 == this.minor) {
         var3 = this;
      } else {
         var3 = new ProtocolVersion(this.protocol, var1, var2);
      }

      return var3;
   }

   public final int getMajor() {
      return this.major;
   }

   public final int getMinor() {
      return this.minor;
   }

   public final String getProtocol() {
      return this.protocol;
   }

   public final boolean greaterEquals(ProtocolVersion var1) {
      boolean var2;
      if (this.isComparable(var1) && this.compareToVersion(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.protocol.hashCode() ^ this.major * 100000 ^ this.minor;
   }

   public boolean isComparable(ProtocolVersion var1) {
      boolean var2;
      if (var1 != null && this.protocol.equals(var1.protocol)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public final boolean lessEquals(ProtocolVersion var1) {
      boolean var2;
      if (this.isComparable(var1) && this.compareToVersion(var1) <= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.protocol);
      var1.append('/');
      var1.append(Integer.toString(this.major));
      var1.append('.');
      var1.append(Integer.toString(this.minor));
      return var1.toString();
   }
}
