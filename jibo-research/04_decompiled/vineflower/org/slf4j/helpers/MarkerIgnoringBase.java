package org.slf4j.helpers;

import org.slf4j.Logger;

public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
   @Override
   public String toString() {
      return this.getClass().getName() + "(" + this.a() + ")";
   }
}
