package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class NamedLoggerBase implements Serializable, Logger {
   protected String b;

   public String a() {
      return this.b;
   }

   protected Object readResolve() throws ObjectStreamException {
      return LoggerFactory.a(this.a());
   }
}
