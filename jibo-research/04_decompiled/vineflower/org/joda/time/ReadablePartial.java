package org.joda.time;

public interface ReadablePartial extends Comparable<ReadablePartial> {
   int a();

   int a(int var1);

   int a(DateTimeFieldType var1);

   DateTimeFieldType b(int var1);

   boolean b(DateTimeFieldType var1);

   Chronology c();
}
