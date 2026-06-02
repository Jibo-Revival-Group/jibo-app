package org.joda.time.convert;

import org.joda.time.Chronology;

public interface InstantConverter extends Converter {
   long a(Object var1, Chronology var2);

   Chronology b(Object var1, Chronology var2);
}
