package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters {
   public static final TypeAdapter<String> A = new TypeAdapter<String>() {
      public String a(JsonReader var1) throws IOException {
         JsonToken var2 = var1.f();
         String var3;
         if (var2 == JsonToken.NULL) {
            var1.j();
            var3 = null;
         } else if (var2 == JsonToken.BOOLEAN) {
            var3 = Boolean.toString(var1.i());
         } else {
            var3 = var1.h();
         }

         return var3;
      }

      public void a(JsonWriter var1, String var2) throws IOException {
         var1.b(var2);
      }
   };
   public static final TypeAdapter<BigDecimal> B = new TypeAdapter<BigDecimal>() {
      public BigDecimal a(JsonReader var1) throws IOException {
         BigDecimal var3;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var3 = null;
         } else {
            try {
               var3 = new BigDecimal(var1.h());
            } catch (NumberFormatException var2) {
               throw new JsonSyntaxException(var2);
            }
         }

         return var3;
      }

      public void a(JsonWriter var1, BigDecimal var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapter<BigInteger> C = new TypeAdapter<BigInteger>() {
      public BigInteger a(JsonReader var1) throws IOException {
         BigInteger var3;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var3 = null;
         } else {
            try {
               var3 = new BigInteger(var1.h());
            } catch (NumberFormatException var2) {
               throw new JsonSyntaxException(var2);
            }
         }

         return var3;
      }

      public void a(JsonWriter var1, BigInteger var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapterFactory D = a(String.class, A);
   public static final TypeAdapter<StringBuilder> E = new TypeAdapter<StringBuilder>() {
      public StringBuilder a(JsonReader var1) throws IOException {
         StringBuilder var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = new StringBuilder(var1.h());
         }

         return var2;
      }

      public void a(JsonWriter var1, StringBuilder var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.toString();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory F = a(StringBuilder.class, E);
   public static final TypeAdapter<StringBuffer> G = new TypeAdapter<StringBuffer>() {
      public StringBuffer a(JsonReader var1) throws IOException {
         StringBuffer var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = new StringBuffer(var1.h());
         }

         return var2;
      }

      public void a(JsonWriter var1, StringBuffer var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.toString();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory H = a(StringBuffer.class, G);
   public static final TypeAdapter<URL> I = new TypeAdapter<URL>() {
      public URL a(JsonReader var1) throws IOException {
         Object var2 = null;
         URL var4;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var4 = (URL)var2;
         } else {
            String var3 = var1.h();
            var4 = (URL)var2;
            if (!"null".equals(var3)) {
               var4 = new URL(var3);
            }
         }

         return var4;
      }

      public void a(JsonWriter var1, URL var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.toExternalForm();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory J = a(URL.class, I);
   public static final TypeAdapter<URI> K = new TypeAdapter<URI>() {
      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public URI a(JsonReader var1) throws IOException {
         Object var2 = null;
         URI var6;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var6 = (URI)var2;
         } else {
            String var3;
            try {
               var3 = var1.h();
            } catch (URISyntaxException var5) {
               throw new JsonIOException(var5);
            }

            var6 = (URI)var2;

            try {
               if (!"null".equals(var3)) {
                  var6 = new URI(var3);
               }
            } catch (URISyntaxException var4) {
               throw new JsonIOException(var4);
            }
         }

         return var6;
      }

      public void a(JsonWriter var1, URI var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.toASCIIString();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory L = a(URI.class, K);
   public static final TypeAdapter<InetAddress> M = new TypeAdapter<InetAddress>() {
      public InetAddress a(JsonReader var1) throws IOException {
         InetAddress var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = InetAddress.getByName(var1.h());
         }

         return var2;
      }

      public void a(JsonWriter var1, InetAddress var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.getHostAddress();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory N = b(InetAddress.class, M);
   public static final TypeAdapter<UUID> O = new TypeAdapter<UUID>() {
      public UUID a(JsonReader var1) throws IOException {
         UUID var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = UUID.fromString(var1.h());
         }

         return var2;
      }

      public void a(JsonWriter var1, UUID var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.toString();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory P = a(UUID.class, O);
   public static final TypeAdapter<Currency> Q = (new TypeAdapter<Currency>() {
      public Currency a(JsonReader var1) throws IOException {
         return Currency.getInstance(var1.h());
      }

      public void a(JsonWriter var1, Currency var2) throws IOException {
         var1.b(var2.getCurrencyCode());
      }
   }).nullSafe();
   public static final TypeAdapterFactory R = a(Currency.class, Q);
   public static final TypeAdapterFactory S = new TypeAdapterFactory() {
      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         TypeAdapter var3;
         if (var2.getRawType() != Timestamp.class) {
            var3 = null;
         } else {
            var3 = new TypeAdapter<Timestamp>(this, var1.a(Date.class)) {
               final TypeAdapter a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public Timestamp a(JsonReader var1) throws IOException {
                  Date var2x = (Date)this.a.read(var1);
                  Timestamp var3x;
                  if (var2x != null) {
                     var3x = new Timestamp(var2x.getTime());
                  } else {
                     var3x = null;
                  }

                  return var3x;
               }

               public void a(JsonWriter var1, Timestamp var2x) throws IOException {
                  this.a.write(var1, var2x);
               }
            };
         }

         return var3;
      }
   };
   public static final TypeAdapter<Calendar> T = new TypeAdapter<Calendar>() {
      public Calendar a(JsonReader var1) throws IOException {
         int var3 = 0;
         GregorianCalendar var10;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var10 = null;
         } else {
            var1.c();
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;

            while (var1.f() != JsonToken.END_OBJECT) {
               String var9 = var1.g();
               int var2 = var1.m();
               if ("year".equals(var9)) {
                  var8 = var2;
               } else if ("month".equals(var9)) {
                  var7 = var2;
               } else if ("dayOfMonth".equals(var9)) {
                  var6 = var2;
               } else if ("hourOfDay".equals(var9)) {
                  var5 = var2;
               } else if ("minute".equals(var9)) {
                  var4 = var2;
               } else if ("second".equals(var9)) {
                  var3 = var2;
               }
            }

            var1.d();
            var10 = new GregorianCalendar(var8, var7, var6, var5, var4, var3);
         }

         return var10;
      }

      public void a(JsonWriter var1, Calendar var2) throws IOException {
         if (var2 == null) {
            var1.f();
         } else {
            var1.d();
            var1.a("year");
            var1.a(var2.get(1));
            var1.a("month");
            var1.a(var2.get(2));
            var1.a("dayOfMonth");
            var1.a(var2.get(5));
            var1.a("hourOfDay");
            var1.a(var2.get(11));
            var1.a("minute");
            var1.a(var2.get(12));
            var1.a("second");
            var1.a(var2.get(13));
            var1.e();
         }
      }
   };
   public static final TypeAdapterFactory U = b(Calendar.class, GregorianCalendar.class, T);
   public static final TypeAdapter<Locale> V = new TypeAdapter<Locale>() {
      public Locale a(JsonReader var1) throws IOException {
         String var2 = null;
         Locale var4;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var4 = var2;
         } else {
            StringTokenizer var3 = new StringTokenizer(var1.h(), "_");
            String var5;
            if (var3.hasMoreElements()) {
               var5 = var3.nextToken();
            } else {
               var5 = null;
            }

            if (var3.hasMoreElements()) {
               var2 = var3.nextToken();
            } else {
               var2 = null;
            }

            String var7;
            if (var3.hasMoreElements()) {
               var7 = var3.nextToken();
            } else {
               var7 = null;
            }

            if (var2 == null && var7 == null) {
               var4 = new Locale(var5);
            } else if (var7 == null) {
               var4 = new Locale(var5, var2);
            } else {
               var4 = new Locale(var5, var2, var7);
            }
         }

         return var4;
      }

      public void a(JsonWriter var1, Locale var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.toString();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory W = a(Locale.class, V);
   public static final TypeAdapter<JsonElement> X = new TypeAdapter<JsonElement>() {
      public JsonElement a(JsonReader var1) throws IOException {
         JsonElement var3;
         switch (<unrepresentable>.a[var1.f().ordinal()]) {
            case 1:
               var3 = new JsonPrimitive(new LazilyParsedNumber(var1.h()));
               break;
            case 2:
               var3 = new JsonPrimitive(var1.i());
               break;
            case 3:
               var3 = new JsonPrimitive(var1.h());
               break;
            case 4:
               var1.j();
               var3 = JsonNull.a;
               break;
            case 5:
               JsonArray var4 = new JsonArray();
               var1.a();

               while (var1.e()) {
                  var4.a(this.a(var1));
               }

               var1.b();
               var3 = var4;
               break;
            case 6:
               JsonObject var2 = new JsonObject();
               var1.c();

               while (var1.e()) {
                  var2.a(var1.g(), this.a(var1));
               }

               var1.d();
               var3 = var2;
               break;
            default:
               throw new IllegalArgumentException();
         }

         return var3;
      }

      public void a(JsonWriter var1, JsonElement var2) throws IOException {
         if (var2 == null || var2.k()) {
            var1.f();
         } else if (var2.j()) {
            var2 = var2.n();
            if (var2.p()) {
               var1.a(var2.b());
            } else if (var2.a()) {
               var1.a(var2.g());
            } else {
               var1.b(var2.c());
            }
         } else if (var2.h()) {
            var1.b();
            Iterator var5 = var2.m().iterator();

            while (var5.hasNext()) {
               this.a(var1, (JsonElement)var5.next());
            }

            var1.c();
         } else {
            if (!var2.i()) {
               throw new IllegalArgumentException("Couldn't write " + var2.getClass());
            }

            var1.d();

            for (Entry var3 : var2.l().a()) {
               var1.a((String)var3.getKey());
               this.a(var1, (JsonElement)var3.getValue());
            }

            var1.e();
         }
      }
   };
   public static final TypeAdapterFactory Y = b(JsonElement.class, X);
   public static final TypeAdapterFactory Z = new TypeAdapterFactory() {
      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         Class var5 = var2.getRawType();
         TypeAdapters.EnumTypeAdapter var3;
         if (Enum.class.isAssignableFrom(var5) && var5 != Enum.class) {
            Class var4 = var5;
            if (!var5.isEnum()) {
               var4 = var5.getSuperclass();
            }

            var3 = new TypeAdapters.EnumTypeAdapter(var4);
         } else {
            var3 = null;
         }

         return var3;
      }
   };
   public static final TypeAdapter<Class> a = (new TypeAdapter<Class>() {
      public Class a(JsonReader var1) throws IOException {
         throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
      }

      public void a(JsonWriter var1, Class var2) throws IOException {
         throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + var2.getName() + ". Forgot to register a type adapter?");
      }
   }).nullSafe();
   public static final TypeAdapterFactory b = a(Class.class, a);
   public static final TypeAdapter<BitSet> c = (new TypeAdapter<BitSet>() {
      public BitSet a(JsonReader var1) throws IOException {
         BitSet var6 = new BitSet();
         var1.a();
         JsonToken var5 = var1.f();
         int var2 = 0;

         while (var5 != JsonToken.END_ARRAY) {
            boolean var4;
            switch (<unrepresentable>.a[var5.ordinal()]) {
               case 1:
                  if (var1.m() != 0) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }
                  break;
               case 2:
                  var4 = var1.i();
                  break;
               case 3:
                  String var8 = var1.h();

                  int var3;
                  try {
                     var3 = Integer.parseInt(var8);
                  } catch (NumberFormatException var7) {
                     throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + var8);
                  }

                  if (var3 != 0) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }
                  break;
               default:
                  throw new JsonSyntaxException("Invalid bitset value type: " + var5);
            }

            if (var4) {
               var6.set(var2);
            }

            var2++;
            var5 = var1.f();
         }

         var1.b();
         return var6;
      }

      public void a(JsonWriter var1, BitSet var2) throws IOException {
         var1.b();
         int var5 = var2.length();

         for (int var3 = 0; var3 < var5; var3++) {
            byte var4;
            if (var2.get(var3)) {
               var4 = 1;
            } else {
               var4 = 0;
            }

            var1.a(var4);
         }

         var1.c();
      }
   }).nullSafe();
   public static final TypeAdapterFactory d = a(BitSet.class, c);
   public static final TypeAdapter<Boolean> e = new TypeAdapter<Boolean>() {
      public Boolean a(JsonReader var1) throws IOException {
         Boolean var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else if (var1.f() == JsonToken.STRING) {
            var2 = Boolean.parseBoolean(var1.h());
         } else {
            var2 = var1.i();
         }

         return var2;
      }

      public void a(JsonWriter var1, Boolean var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapter<Boolean> f = new TypeAdapter<Boolean>() {
      public Boolean a(JsonReader var1) throws IOException {
         Boolean var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = Boolean.valueOf(var1.h());
         }

         return var2;
      }

      public void a(JsonWriter var1, Boolean var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = "null";
         } else {
            var3 = var2.toString();
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory g = a(boolean.class, Boolean.class, e);
   public static final TypeAdapter<Number> h = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         Byte var4;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var4 = null;
         } else {
            byte var2;
            try {
               var2 = (byte)var1.m();
            } catch (NumberFormatException var3) {
               throw new JsonSyntaxException(var3);
            }

            var4 = var2;
         }

         return var4;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapterFactory i = a(byte.class, Byte.class, h);
   public static final TypeAdapter<Number> j = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         Short var4;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var4 = null;
         } else {
            short var2;
            try {
               var2 = (short)var1.m();
            } catch (NumberFormatException var3) {
               throw new JsonSyntaxException(var3);
            }

            var4 = var2;
         }

         return var4;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapterFactory k = a(short.class, Short.class, j);
   public static final TypeAdapter<Number> l = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         Integer var4;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var4 = null;
         } else {
            int var2;
            try {
               var2 = var1.m();
            } catch (NumberFormatException var3) {
               throw new JsonSyntaxException(var3);
            }

            var4 = var2;
         }

         return var4;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapterFactory m = a(int.class, Integer.class, l);
   public static final TypeAdapter<AtomicInteger> n = (new TypeAdapter<AtomicInteger>() {
      public AtomicInteger a(JsonReader var1) throws IOException {
         try {
            return new AtomicInteger(var1.m());
         } catch (NumberFormatException var2) {
            throw new JsonSyntaxException(var2);
         }
      }

      public void a(JsonWriter var1, AtomicInteger var2) throws IOException {
         var1.a(var2.get());
      }
   }).nullSafe();
   public static final TypeAdapterFactory o = a(AtomicInteger.class, n);
   public static final TypeAdapter<AtomicBoolean> p = (new TypeAdapter<AtomicBoolean>() {
      public AtomicBoolean a(JsonReader var1) throws IOException {
         return new AtomicBoolean(var1.i());
      }

      public void a(JsonWriter var1, AtomicBoolean var2) throws IOException {
         var1.a(var2.get());
      }
   }).nullSafe();
   public static final TypeAdapterFactory q = a(AtomicBoolean.class, p);
   public static final TypeAdapter<AtomicIntegerArray> r = (new TypeAdapter<AtomicIntegerArray>() {
      public AtomicIntegerArray a(JsonReader var1) throws IOException {
         ArrayList var4 = new ArrayList();
         var1.a();

         while (var1.e()) {
            try {
               var4.add(var1.m());
            } catch (NumberFormatException var5) {
               throw new JsonSyntaxException(var5);
            }
         }

         var1.b();
         int var3 = var4.size();
         AtomicIntegerArray var6 = new AtomicIntegerArray(var3);

         for (int var2 = 0; var2 < var3; var2++) {
            var6.set(var2, (Integer)var4.get(var2));
         }

         return var6;
      }

      public void a(JsonWriter var1, AtomicIntegerArray var2) throws IOException {
         var1.b();
         int var3 = 0;

         for (int var4 = var2.length(); var3 < var4; var3++) {
            var1.a(var2.get(var3));
         }

         var1.c();
      }
   }).nullSafe();
   public static final TypeAdapterFactory s = a(AtomicIntegerArray.class, r);
   public static final TypeAdapter<Number> t = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         Long var5;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var5 = null;
         } else {
            long var2;
            try {
               var2 = var1.l();
            } catch (NumberFormatException var4) {
               throw new JsonSyntaxException(var4);
            }

            var5 = var2;
         }

         return var5;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapter<Number> u = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         Float var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = (float)var1.k();
         }

         return var2;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapter<Number> v = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         Double var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = var1.k();
         }

         return var2;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapter<Number> w = new TypeAdapter<Number>() {
      public Number a(JsonReader var1) throws IOException {
         JsonToken var2 = var1.f();
         LazilyParsedNumber var3;
         switch (<unrepresentable>.a[var2.ordinal()]) {
            case 1:
            case 3:
               var3 = new LazilyParsedNumber(var1.h());
               break;
            case 2:
            default:
               throw new JsonSyntaxException("Expecting number, got: " + var2);
            case 4:
               var1.j();
               var3 = null;
         }

         return var3;
      }

      public void a(JsonWriter var1, Number var2) throws IOException {
         var1.a(var2);
      }
   };
   public static final TypeAdapterFactory x = a(Number.class, w);
   public static final TypeAdapter<Character> y = new TypeAdapter<Character>() {
      public Character a(JsonReader var1) throws IOException {
         Character var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            String var3 = var1.h();
            if (var3.length() != 1) {
               throw new JsonSyntaxException("Expecting character, got: " + var3);
            }

            var2 = var3.charAt(0);
         }

         return var2;
      }

      public void a(JsonWriter var1, Character var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = String.valueOf(var2);
         }

         var1.b(var3);
      }
   };
   public static final TypeAdapterFactory z = a(char.class, Character.class, y);

   public static <TT> TypeAdapterFactory a(TypeToken<TT> var0, TypeAdapter<TT> var1) {
      return new TypeAdapterFactory(var0, var1) {
         final TypeToken a;
         final TypeAdapter b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
            TypeAdapter var3;
            if (var2.equals(this.a)) {
               var3 = this.b;
            } else {
               var3 = null;
            }

            return var3;
         }
      };
   }

   public static <TT> TypeAdapterFactory a(Class<TT> var0, TypeAdapter<TT> var1) {
      return new TypeAdapterFactory(var0, var1) {
         final Class a;
         final TypeAdapter b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
            TypeAdapter var3;
            if (var2.getRawType() == this.a) {
               var3 = this.b;
            } else {
               var3 = null;
            }

            return var3;
         }

         @Override
         public String toString() {
            return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
         }
      };
   }

   public static <TT> TypeAdapterFactory a(Class<TT> var0, Class<TT> var1, TypeAdapter<? super TT> var2) {
      return new TypeAdapterFactory(var0, var1, var2) {
         final Class a;
         final Class b;
         final TypeAdapter c;

         {
            this.a = var1;
            this.b = var2x;
            this.c = var3;
         }

         @Override
         public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2x) {
            Class var3 = var2x.getRawType();
            TypeAdapter var4;
            if (var3 != this.a && var3 != this.b) {
               var4 = null;
            } else {
               var4 = this.c;
            }

            return var4;
         }

         @Override
         public String toString() {
            return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
         }
      };
   }

   public static <T1> TypeAdapterFactory b(Class<T1> var0, TypeAdapter<T1> var1) {
      return new TypeAdapterFactory(var0, var1) {
         final Class a;
         final TypeAdapter b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public <T2> TypeAdapter<T2> a(Gson var1, TypeToken<T2> var2) {
            Class var3 = var2.getRawType();
            TypeAdapter var4;
            if (!this.a.isAssignableFrom(var3)) {
               var4 = null;
            } else {
               var4 = new TypeAdapter<T1>(this, var3) {
                  final Class a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public T1 read(JsonReader var1) throws IOException {
                     Object var2x = this.b.b.read(var1);
                     if (var2x != null && !this.a.isInstance(var2x)) {
                        throw new JsonSyntaxException("Expected a " + this.a.getName() + " but was " + var2x.getClass().getName());
                     } else {
                        return (T1)var2x;
                     }
                  }

                  @Override
                  public void write(JsonWriter var1, T1 var2x) throws IOException {
                     this.b.b.write(var1, var2x);
                  }
               };
            }

            return var4;
         }

         @Override
         public String toString() {
            return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
         }
      };
   }

   public static <TT> TypeAdapterFactory b(Class<TT> var0, Class<? extends TT> var1, TypeAdapter<? super TT> var2) {
      return new TypeAdapterFactory(var0, var1, var2) {
         final Class a;
         final Class b;
         final TypeAdapter c;

         {
            this.a = var1;
            this.b = var2x;
            this.c = var3;
         }

         @Override
         public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2x) {
            Class var3 = var2x.getRawType();
            TypeAdapter var4;
            if (var3 != this.a && var3 != this.b) {
               var4 = null;
            } else {
               var4 = this.c;
            }

            return var4;
         }

         @Override
         public String toString() {
            return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.c + "]";
         }
      };
   }

   private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
      private final Map<String, T> a = new HashMap<>();
      private final Map<T, String> b = new HashMap<>();

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public EnumTypeAdapter(Class<T> var1) {
         int var4;
         Enum[] var8;
         try {
            var8 = (Enum[])var1.getEnumConstants();
            var4 = var8.length;
         } catch (NoSuchFieldException var15) {
            throw new AssertionError(var15);
         }

         for (int var2 = 0; var2 < var4; var2++) {
            Enum var9 = var8[var2];

            String var6;
            SerializedName var10;
            try {
               var6 = var9.name();
               var10 = var1.getField(var6).getAnnotation(SerializedName.class);
            } catch (NoSuchFieldException var14) {
               throw new AssertionError(var14);
            }

            if (var10 != null) {
               int var5;
               String var7;
               try {
                  var7 = var10.a();
                  var17 = var10.b();
                  var5 = var17.length;
               } catch (NoSuchFieldException var13) {
                  throw new AssertionError(var13);
               }

               int var3 = 0;

               while (true) {
                  var6 = var7;
                  if (var3 >= var5) {
                     break;
                  }

                  var6 = var17[var3];

                  try {
                     this.a.put(var6, (T)var9);
                  } catch (NoSuchFieldException var12) {
                     throw new AssertionError(var12);
                  }

                  var3++;
               }
            }

            try {
               this.a.put(var6, (T)var9);
               this.b.put((T)var9, var6);
            } catch (NoSuchFieldException var11) {
               throw new AssertionError(var11);
            }
         }
      }

      public T a(JsonReader var1) throws IOException {
         Enum var2;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var2 = null;
         } else {
            var2 = this.a.get(var1.h());
         }

         return (T)var2;
      }

      public void a(JsonWriter var1, T var2) throws IOException {
         String var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = this.b.get(var2);
         }

         var1.b(var3);
      }
   }
}
