package com.google.api.client.json;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JsonParser {
   private static WeakHashMap<Class<?>, Field> cachedTypemapFields = new WeakHashMap<>();
   private static final Lock lock = new ReentrantLock();

   private static Field getCachedTypemapFieldFor(Class<?> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 4
      // 003: aload 0
      // 004: ifnonnull 00c
      // 007: aload 4
      // 009: astore 0
      // 00a: aload 0
      // 00b: areturn
      // 00c: getstatic com/google/api/client/json/JsonParser.lock Ljava/util/concurrent/locks/Lock;
      // 00f: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 014: getstatic com/google/api/client/json/JsonParser.cachedTypemapFields Ljava/util/WeakHashMap;
      // 017: aload 0
      // 018: invokevirtual java/util/WeakHashMap.containsKey (Ljava/lang/Object;)Z
      // 01b: ifeq 034
      // 01e: getstatic com/google/api/client/json/JsonParser.cachedTypemapFields Ljava/util/WeakHashMap;
      // 021: aload 0
      // 022: invokevirtual java/util/WeakHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 025: checkcast java/lang/reflect/Field
      // 028: astore 0
      // 029: getstatic com/google/api/client/json/JsonParser.lock Ljava/util/concurrent/locks/Lock;
      // 02c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 031: goto 00a
      // 034: aload 0
      // 035: invokestatic com/google/api/client/util/ClassInfo.of (Ljava/lang/Class;)Lcom/google/api/client/util/ClassInfo;
      // 038: invokevirtual com/google/api/client/util/ClassInfo.getFieldInfos ()Ljava/util/Collection;
      // 03b: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 040: astore 6
      // 042: aconst_null
      // 043: astore 4
      // 045: aload 6
      // 047: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 04c: ifeq 100
      // 04f: aload 6
      // 051: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 056: checkcast com/google/api/client/util/FieldInfo
      // 059: invokevirtual com/google/api/client/util/FieldInfo.getField ()Ljava/lang/reflect/Field;
      // 05c: astore 5
      // 05e: aload 5
      // 060: ldc com/google/api/client/json/JsonPolymorphicTypeMap
      // 062: invokevirtual java/lang/reflect/Field.getAnnotation (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      // 065: checkcast com/google/api/client/json/JsonPolymorphicTypeMap
      // 068: astore 7
      // 06a: aload 7
      // 06c: ifnull 0fd
      // 06f: aload 4
      // 071: ifnonnull 0f3
      // 074: bipush 1
      // 075: istore 3
      // 076: iload 3
      // 077: ldc "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s"
      // 079: bipush 1
      // 07a: anewarray 4
      // 07d: dup
      // 07e: bipush 0
      // 07f: aload 0
      // 080: aastore
      // 081: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/String;[Ljava/lang/Object;)V
      // 084: aload 5
      // 086: invokevirtual java/lang/reflect/Field.getType ()Ljava/lang/Class;
      // 089: invokestatic com/google/api/client/util/Data.isPrimitive (Ljava/lang/reflect/Type;)Z
      // 08c: ldc "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s"
      // 08e: bipush 2
      // 08f: anewarray 4
      // 092: dup
      // 093: bipush 0
      // 094: aload 0
      // 095: aastore
      // 096: dup
      // 097: bipush 1
      // 098: aload 5
      // 09a: invokevirtual java/lang/reflect/Field.getType ()Ljava/lang/Class;
      // 09d: aastore
      // 09e: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/String;[Ljava/lang/Object;)V
      // 0a1: aload 7
      // 0a3: invokeinterface com/google/api/client/json/JsonPolymorphicTypeMap.typeDefinitions ()[Lcom/google/api/client/json/JsonPolymorphicTypeMap$TypeDef; 1
      // 0a8: astore 7
      // 0aa: invokestatic com/google/api/client/util/Sets.newHashSet ()Ljava/util/HashSet;
      // 0ad: astore 4
      // 0af: aload 7
      // 0b1: arraylength
      // 0b2: ifle 0f8
      // 0b5: bipush 1
      // 0b6: istore 3
      // 0b7: iload 3
      // 0b8: ldc "@JsonPolymorphicTypeMap must have at least one @TypeDef"
      // 0ba: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/Object;)V
      // 0bd: aload 7
      // 0bf: arraylength
      // 0c0: istore 2
      // 0c1: bipush 0
      // 0c2: istore 1
      // 0c3: iload 1
      // 0c4: iload 2
      // 0c5: if_icmpge 123
      // 0c8: aload 7
      // 0ca: iload 1
      // 0cb: aaload
      // 0cc: astore 8
      // 0ce: aload 4
      // 0d0: aload 8
      // 0d2: invokeinterface com/google/api/client/json/JsonPolymorphicTypeMap$TypeDef.key ()Ljava/lang/String; 1
      // 0d7: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 0da: ldc "Class contains two @TypeDef annotations with identical key: %s"
      // 0dc: bipush 1
      // 0dd: anewarray 4
      // 0e0: dup
      // 0e1: bipush 0
      // 0e2: aload 8
      // 0e4: invokeinterface com/google/api/client/json/JsonPolymorphicTypeMap$TypeDef.key ()Ljava/lang/String; 1
      // 0e9: aastore
      // 0ea: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/String;[Ljava/lang/Object;)V
      // 0ed: iinc 1 1
      // 0f0: goto 0c3
      // 0f3: bipush 0
      // 0f4: istore 3
      // 0f5: goto 076
      // 0f8: bipush 0
      // 0f9: istore 3
      // 0fa: goto 0b7
      // 0fd: goto 045
      // 100: getstatic com/google/api/client/json/JsonParser.cachedTypemapFields Ljava/util/WeakHashMap;
      // 103: aload 0
      // 104: aload 4
      // 106: invokevirtual java/util/WeakHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 109: pop
      // 10a: getstatic com/google/api/client/json/JsonParser.lock Ljava/util/concurrent/locks/Lock;
      // 10d: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 112: aload 4
      // 114: astore 0
      // 115: goto 00a
      // 118: astore 0
      // 119: getstatic com/google/api/client/json/JsonParser.lock Ljava/util/concurrent/locks/Lock;
      // 11c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 121: aload 0
      // 122: athrow
      // 123: aload 5
      // 125: astore 4
      // 127: goto 0fd
      // try (10 -> 19): 130 null
      // try (22 -> 27): 130 null
      // try (29 -> 42): 130 null
      // try (48 -> 81): 130 null
      // try (83 -> 89): 130 null
      // try (98 -> 111): 130 null
      // try (120 -> 125): 130 null
   }

   private void parse(ArrayList<Type> var1, Object var2, CustomizeJsonParser var3) throws IOException {
      if (var2 instanceof GenericJson) {
         ((GenericJson)var2).setFactory(this.getFactory());
      }

      JsonToken var7 = this.startParsingObjectOrArray();
      Class var9 = var2.getClass();
      ClassInfo var8 = ClassInfo.of(var9);
      boolean var5 = GenericData.class.isAssignableFrom(var9);
      JsonToken var6 = var7;
      if (!var5) {
         var6 = var7;
         if (Map.class.isAssignableFrom(var9)) {
            this.parseMap(null, (Map<String, Object>)var2, Types.getMapValueParameter(var9), var1, var3);
            return;
         }
      }

      for (; var6 == JsonToken.FIELD_NAME; var6 = this.nextToken()) {
         String var11 = this.getText();
         this.nextToken();
         if (var3 != null && var3.stopAt(var2, var11)) {
            break;
         }

         FieldInfo var10 = var8.getFieldInfo(var11);
         if (var10 != null) {
            if (var10.isFinal() && !var10.isPrimitive()) {
               throw new IllegalArgumentException("final array/object fields are not supported");
            }

            Field var12 = var10.getField();
            int var4 = var1.size();
            var1.add(var12.getGenericType());
            Object var13 = this.parseValue(var12, var10.getGenericType(), var1, var2, var3, true);
            var1.remove(var4);
            var10.setValue(var2, var13);
         } else if (var5) {
            ((GenericData)var2).set(var11, this.parseValue(null, null, var1, var2, var3, true));
         } else {
            if (var3 != null) {
               var3.handleUnrecognizedKey(var2, var11);
            }

            this.skipChildren();
         }
      }
   }

   private <T> void parseArray(Field var1, Collection<T> var2, Type var3, ArrayList<Type> var4, CustomizeJsonParser var5) throws IOException {
      for (JsonToken var6 = this.startParsingObjectOrArray(); var6 != JsonToken.END_ARRAY; var6 = this.nextToken()) {
         var2.add(this.parseValue(var1, var3, var4, var2, var5, true));
      }
   }

   private void parseMap(Field var1, Map<String, Object> var2, Type var3, ArrayList<Type> var4, CustomizeJsonParser var5) throws IOException {
      for (JsonToken var6 = this.startParsingObjectOrArray(); var6 == JsonToken.FIELD_NAME; var6 = this.nextToken()) {
         String var7 = this.getText();
         this.nextToken();
         if (var5 != null && var5.stopAt(var2, var7)) {
            break;
         }

         var2.put(var7, this.parseValue(var1, var3, var4, var2, var5, true));
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final Object parseValue(Field var1, Type var2, ArrayList<Type> var3, Object var4, CustomizeJsonParser var5, boolean var6) throws IOException {
      Type var13 = Data.resolveWildcardTypeOrTypeVariable(var3, var2);
      if (var13 instanceof Class) {
         var2 = (Class)var13;
      } else {
         var2 = null;
      }

      Class var11 = var2;
      if (var13 instanceof ParameterizedType) {
         var11 = Types.getRawClass((ParameterizedType)var13);
      }

      Object var125;
      if (var11 == Void.class) {
         this.skipChildren();
         var125 = null;
      } else {
         var125 = this.getCurrentToken();

         label766: {
            label755: {
               label767: {
                  label768: {
                     label769: {
                        label770: {
                           label750: {
                              label797: {
                                 label845: {
                                    try {
                                       switch (<unrepresentable>.$SwitchMap$com$google$api$client$json$JsonToken[this.getCurrentToken().ordinal()]) {
                                          case 1:
                                          case 4:
                                          case 5:
                                             break label750;
                                          case 2:
                                          case 3:
                                             break label770;
                                          case 6:
                                          case 7:
                                             break;
                                          case 8:
                                          case 9:
                                             break label769;
                                          case 10:
                                             break label768;
                                          case 11:
                                             break label845;
                                          default:
                                             break label797;
                                       }
                                    } catch (IllegalArgumentException var79) {
                                       var4 = var79;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }

                                    label798: {
                                       label728:
                                       if (var13 != null) {
                                          try {
                                             if (var11 == boolean.class) {
                                                break label728;
                                             }
                                          } catch (IllegalArgumentException var78) {
                                             var4 = var78;
                                             var125 = new StringBuilder();
                                             var97 = this.getCurrentName();
                                             if (var97 == null) {
                                                break label755;
                                             }
                                             break label767;
                                          }

                                          if (var11 != null) {
                                             try {
                                                if (var11.isAssignableFrom(Boolean.class)) {
                                                   break label728;
                                                }
                                             } catch (IllegalArgumentException var77) {
                                                var4 = var77;
                                                var125 = new StringBuilder();
                                                var97 = this.getCurrentName();
                                                if (var97 == null) {
                                                   break label755;
                                                }
                                                break label767;
                                             }
                                          }

                                          var6 = false;
                                          break label798;
                                       }

                                       var6 = true;
                                    }

                                    try {
                                       Preconditions.checkArgument(var6, "expected type Boolean or boolean but got %s", var13);
                                       if (var125 == JsonToken.VALUE_TRUE) {
                                          return Boolean.TRUE;
                                       }
                                    } catch (IllegalArgumentException var76) {
                                       var4 = var76;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }

                                    try {
                                       var125 = Boolean.FALSE;
                                    } catch (IllegalArgumentException var40) {
                                       var4 = var40;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }

                                    return var125;
                                 }

                                 label799: {
                                    label707:
                                    if (var11 != null) {
                                       try {
                                          if (!var11.isPrimitive()) {
                                             break label707;
                                          }
                                       } catch (IllegalArgumentException var75) {
                                          var4 = var75;
                                          var125 = new StringBuilder();
                                          var97 = this.getCurrentName();
                                          if (var97 == null) {
                                             break label755;
                                          }
                                          break label767;
                                       }

                                       var6 = false;
                                       break label799;
                                    }

                                    var6 = true;
                                 }

                                 try {
                                    Preconditions.checkArgument(var6, "primitive number field but found a JSON null");
                                 } catch (IllegalArgumentException var73) {
                                    var4 = var73;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }

                                 label691:
                                 if (var11 != null) {
                                    try {
                                       if ((var11.getModifiers() & 1536) == 0) {
                                          break label691;
                                       }

                                       if (Types.isAssignableToOrFrom(var11, Collection.class)) {
                                          return Data.nullOf(Data.newCollectionInstance(var13).getClass());
                                       }
                                    } catch (IllegalArgumentException var74) {
                                       var4 = var74;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }

                                    try {
                                       if (Types.isAssignableToOrFrom(var11, Map.class)) {
                                          return Data.nullOf(Data.newMapInstance(var11).getClass());
                                       }
                                    } catch (IllegalArgumentException var72) {
                                       var4 = var72;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }
                                 }

                                 try {
                                    return Data.nullOf(Types.getRawArrayComponentType(var3, var13));
                                 } catch (IllegalArgumentException var14) {
                                    var4 = var14;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }
                              }

                              try {
                                 String var101 = String.valueOf(String.valueOf(var125));
                                 var125 = new StringBuilder(var101.length() + 27);
                                 IllegalArgumentException var98 = new IllegalArgumentException(
                                    var125.append("unexpected JSON node type: ").append(var101).toString()
                                 );
                                 throw var98;
                              } catch (IllegalArgumentException var71) {
                                 var4 = var71;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           boolean var120;
                           label681: {
                              label680: {
                                 try {
                                    if (!Types.isArray(var13)) {
                                       break label680;
                                    }
                                 } catch (IllegalArgumentException var70) {
                                    var4 = var70;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }

                                 var120 = false;
                                 break label681;
                              }

                              var120 = true;
                           }

                           try {
                              Preconditions.checkArgument(var120, "expected object or map type but got %s", var13);
                           } catch (IllegalArgumentException var69) {
                              var4 = var69;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           Field var121;
                           if (var6) {
                              try {
                                 var121 = getCachedTypemapFieldFor(var11);
                              } catch (IllegalArgumentException var68) {
                                 var4 = var68;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           } else {
                              var121 = null;
                           }

                           Object var12 = null;
                           var125 = var12;
                           if (var11 != null) {
                              var125 = var12;
                              if (var5 != null) {
                                 try {
                                    var125 = var5.newInstanceForObject(var4, var11);
                                 } catch (IllegalArgumentException var67) {
                                    var4 = var67;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }
                              }
                           }

                           boolean var7;
                           label661: {
                              label660: {
                                 if (var11 != null) {
                                    try {
                                       if (Types.isAssignableToOrFrom(var11, Map.class)) {
                                          break label660;
                                       }
                                    } catch (IllegalArgumentException var66) {
                                       var4 = var66;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }
                                 }

                                 var7 = 0;
                                 break label661;
                              }

                              var7 = 1;
                           }

                           if (var121 != null) {
                              try {
                                 var4 = new GenericJson();
                              } catch (IllegalArgumentException var65) {
                                 var4 = var65;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           } else {
                              var4 = var125;
                              if (var125 == null) {
                                 if (!var7 && var11 != null) {
                                    try {
                                       var4 = Types.newInstance(var11);
                                    } catch (IllegalArgumentException var63) {
                                       var4 = var63;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }
                                 } else {
                                    try {
                                       var4 = Data.newMapInstance(var11);
                                    } catch (IllegalArgumentException var64) {
                                       var4 = var64;
                                       var125 = new StringBuilder();
                                       var97 = this.getCurrentName();
                                       if (var97 == null) {
                                          break label755;
                                       }
                                       break label767;
                                    }
                                 }
                              }
                           }

                           int var8;
                           try {
                              var8 = var3.size();
                           } catch (IllegalArgumentException var62) {
                              var4 = var62;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           if (var13 != null) {
                              try {
                                 var3.add(var13);
                              } catch (IllegalArgumentException var61) {
                                 var4 = var61;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           label632:
                           if (var7) {
                              label630: {
                                 try {
                                    if (GenericData.class.isAssignableFrom(var11)) {
                                       break label632;
                                    }

                                    if (Map.class.isAssignableFrom(var11)) {
                                       var125 = Types.getMapValueParameter(var13);
                                       break label630;
                                    }
                                 } catch (IllegalArgumentException var60) {
                                    var4 = var60;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }

                                 var125 = null;
                              }

                              if (var125 != null) {
                                 try {
                                    this.parseMap(var1, (Map<String, Object>)var4, var125, var3, var5);
                                    break label766;
                                 } catch (IllegalArgumentException var50) {
                                    var4 = var50;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }
                              }
                           }

                           try {
                              this.parse(var3, var4, var5);
                           } catch (IllegalArgumentException var59) {
                              var4 = var59;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           if (var13 != null) {
                              try {
                                 var3.remove(var8);
                              } catch (IllegalArgumentException var58) {
                                 var4 = var58;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           var125 = var4;
                           if (var121 == null) {
                              return var125;
                           }

                           try {
                              var125 = ((GenericJson)var4).get(var121.getName());
                           } catch (IllegalArgumentException var57) {
                              var4 = var57;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           if (var125 != null) {
                              var6 = true;
                           } else {
                              var6 = false;
                           }

                           try {
                              Preconditions.checkArgument(var6, "No value specified for @JsonPolymorphicTypeMap field");
                              var123 = var125.toString();
                              var125 = var121.getAnnotation(JsonPolymorphicTypeMap.class);
                           } catch (IllegalArgumentException var56) {
                              var4 = var56;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           String var107 = null;

                           try {
                              var122 = var125.typeDefinitions();
                              var8 = var122.length;
                           } catch (IllegalArgumentException var55) {
                              var4 = var55;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           var7 = 0;

                           while (true) {
                              var125 = var107;
                              if (var7 >= var8) {
                                 break;
                              }

                              var125 = var122[var7];

                              try {
                                 if (var125.key().equals(var123)) {
                                    var125 = var125.ref();
                                    break;
                                 }
                              } catch (IllegalArgumentException var54) {
                                 var4 = var54;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }

                              var7++;
                           }

                           if (var125 != null) {
                              var6 = true;
                           } else {
                              var6 = false;
                           }

                           label781: {
                              try {
                                 var107 = String.valueOf(var123);
                                 if (var107.length() != 0) {
                                    var107 = "No TypeDef annotation found with key: ".concat(var107);
                                    break label781;
                                 }
                              } catch (IllegalArgumentException var53) {
                                 var4 = var53;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }

                              try {
                                 var107 = new String("No TypeDef annotation found with key: ");
                              } catch (IllegalArgumentException var52) {
                                 var4 = var52;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              Preconditions.checkArgument(var6, var107);
                              JsonFactory var110 = this.getFactory();
                              JsonParser var106 = var110.createJsonParser(var110.toString(var4));
                              var106.startParsing();
                              return var106.parseValue(var1, var125, var3, null, null, false);
                           } catch (IllegalArgumentException var51) {
                              var4 = var51;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        boolean var9;
                        try {
                           var9 = Types.isArray(var13);
                        } catch (IllegalArgumentException var49) {
                           var4 = var49;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }

                        label800: {
                           label565:
                           if (var13 != null && !var9) {
                              if (var11 != null) {
                                 try {
                                    if (Types.isAssignableToOrFrom(var11, Collection.class)) {
                                       break label565;
                                    }
                                 } catch (IllegalArgumentException var48) {
                                    var4 = var48;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }
                              }

                              var6 = false;
                              break label800;
                           }

                           var6 = true;
                        }

                        try {
                           Preconditions.checkArgument(var6, "expected collection or array type but got %s", var13);
                        } catch (IllegalArgumentException var47) {
                           var4 = var47;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }

                        var125 = null;
                        Collection var10 = (Collection)var125;
                        if (var5 != null) {
                           var10 = (Collection)var125;
                           if (var1 != null) {
                              try {
                                 var10 = var5.newInstanceForArray(var4, var1);
                              } catch (IllegalArgumentException var46) {
                                 var4 = var46;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }
                        }

                        Collection var85 = var10;
                        if (var10 == null) {
                           try {
                              var85 = Data.newCollectionInstance(var13);
                           } catch (IllegalArgumentException var45) {
                              var4 = var45;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        if (var9) {
                           try {
                              var4 = Types.getArrayComponentType(var13);
                           } catch (IllegalArgumentException var43) {
                              var4 = var43;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        } else {
                           label540: {
                              if (var11 != null) {
                                 try {
                                    if (Iterable.class.isAssignableFrom(var11)) {
                                       var4 = Types.getIterableParameter(var13);
                                       break label540;
                                    }
                                 } catch (IllegalArgumentException var44) {
                                    var4 = var44;
                                    var125 = new StringBuilder();
                                    var97 = this.getCurrentName();
                                    if (var97 == null) {
                                       break label755;
                                    }
                                    break label767;
                                 }
                              }

                              var4 = null;
                           }
                        }

                        try {
                           var4 = Data.resolveWildcardTypeOrTypeVariable(var3, var4);
                           this.parseArray(var1, var85, var4, var3, var5);
                        } catch (IllegalArgumentException var42) {
                           var4 = var42;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }

                        if (!var9) {
                           return var85;
                        }

                        try {
                           return Types.toArray(var85, Types.getRawArrayComponentType(var3, var4));
                        } catch (IllegalArgumentException var41) {
                           var4 = var41;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }
                     }

                     label801: {
                        label520:
                        if (var1 != null) {
                           try {
                              if (var1.getAnnotation(JsonString.class) == null) {
                                 break label520;
                              }
                           } catch (IllegalArgumentException var39) {
                              var4 = var39;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           var6 = false;
                           break label801;
                        }

                        var6 = true;
                     }

                     try {
                        Preconditions.checkArgument(var6, "number type formatted as a JSON number cannot use @JsonString annotation");
                     } catch (IllegalArgumentException var38) {
                        var4 = var38;
                        var125 = new StringBuilder();
                        var97 = this.getCurrentName();
                        if (var97 == null) {
                           break label755;
                        }
                        break label767;
                     }

                     label509: {
                        if (var11 != null) {
                           try {
                              if (!var11.isAssignableFrom(BigDecimal.class)) {
                                 break label509;
                              }
                           } catch (IllegalArgumentException var37) {
                              var4 = var37;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        try {
                           return this.getDecimalValue();
                        } catch (IllegalArgumentException var36) {
                           var4 = var36;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }
                     }

                     if (var11 == BigInteger.class) {
                        try {
                           return this.getBigIntegerValue();
                        } catch (IllegalArgumentException var22) {
                           var4 = var22;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }
                     } else {
                        label499: {
                           if (var11 != Double.class) {
                              try {
                                 if (var11 != double.class) {
                                    break label499;
                                 }
                              } catch (IllegalArgumentException var35) {
                                 var4 = var35;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              return this.getDoubleValue();
                           } catch (IllegalArgumentException var34) {
                              var4 = var34;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        label490: {
                           if (var11 != Long.class) {
                              try {
                                 if (var11 != long.class) {
                                    break label490;
                                 }
                              } catch (IllegalArgumentException var33) {
                                 var4 = var33;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              return this.getLongValue();
                           } catch (IllegalArgumentException var32) {
                              var4 = var32;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        label481: {
                           if (var11 != Float.class) {
                              try {
                                 if (var11 != float.class) {
                                    break label481;
                                 }
                              } catch (IllegalArgumentException var31) {
                                 var4 = var31;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              return this.getFloatValue();
                           } catch (IllegalArgumentException var30) {
                              var4 = var30;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        label472: {
                           if (var11 != Integer.class) {
                              try {
                                 if (var11 != int.class) {
                                    break label472;
                                 }
                              } catch (IllegalArgumentException var29) {
                                 var4 = var29;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              return this.getIntValue();
                           } catch (IllegalArgumentException var28) {
                              var4 = var28;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        label463: {
                           if (var11 != Short.class) {
                              try {
                                 if (var11 != short.class) {
                                    break label463;
                                 }
                              } catch (IllegalArgumentException var27) {
                                 var4 = var27;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              return this.getShortValue();
                           } catch (IllegalArgumentException var26) {
                              var4 = var26;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        label454: {
                           if (var11 != Byte.class) {
                              try {
                                 if (var11 != byte.class) {
                                    break label454;
                                 }
                              } catch (IllegalArgumentException var25) {
                                 var4 = var25;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           try {
                              return this.getByteValue();
                           } catch (IllegalArgumentException var24) {
                              var4 = var24;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }
                        }

                        try {
                           String var102 = String.valueOf(String.valueOf(var13));
                           StringBuilder var99 = new StringBuilder(var102.length() + 30);
                           IllegalArgumentException var87 = new IllegalArgumentException(
                              var99.append("expected numeric type but got ").append(var102).toString()
                           );
                           throw var87;
                        } catch (IllegalArgumentException var23) {
                           var4 = var23;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }
                     }
                  }

                  label785: {
                     label440: {
                        label439: {
                           try {
                              var125 = this.getText().trim().toLowerCase(Locale.US);
                              if (var11 == float.class) {
                                 break label439;
                              }
                           } catch (IllegalArgumentException var21) {
                              var4 = var21;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           label435:
                           if (var11 != Float.class) {
                              try {
                                 if (var11 == double.class) {
                                    break label435;
                                 }
                              } catch (IllegalArgumentException var20) {
                                 var4 = var20;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }

                              if (var11 != Double.class) {
                                 break label440;
                              }
                           }
                        }

                        try {
                           if (var125.equals("nan") || var125.equals("infinity") || var125.equals("-infinity")) {
                              break label785;
                           }
                        } catch (IllegalArgumentException var19) {
                           var4 = var19;
                           var125 = new StringBuilder();
                           var97 = this.getCurrentName();
                           if (var97 == null) {
                              break label755;
                           }
                           break label767;
                        }
                     }

                     label802: {
                        label418:
                        if (var11 != null) {
                           try {
                              if (!Number.class.isAssignableFrom(var11)) {
                                 break label418;
                              }
                           } catch (IllegalArgumentException var18) {
                              var4 = var18;
                              var125 = new StringBuilder();
                              var97 = this.getCurrentName();
                              if (var97 == null) {
                                 break label755;
                              }
                              break label767;
                           }

                           if (var1 != null) {
                              try {
                                 if (var1.getAnnotation(JsonString.class) != null) {
                                    break label418;
                                 }
                              } catch (IllegalArgumentException var17) {
                                 var4 = var17;
                                 var125 = new StringBuilder();
                                 var97 = this.getCurrentName();
                                 if (var97 == null) {
                                    break label755;
                                 }
                                 break label767;
                              }
                           }

                           var6 = false;
                           break label802;
                        }

                        var6 = true;
                     }

                     try {
                        Preconditions.checkArgument(var6, "number field formatted as a JSON string must use the @JsonString annotation");
                     } catch (IllegalArgumentException var16) {
                        var4 = var16;
                        var125 = new StringBuilder();
                        var97 = this.getCurrentName();
                        if (var97 == null) {
                           break label755;
                        }
                        break label767;
                     }
                  }

                  try {
                     return Data.parsePrimitiveValue(var13, this.getText());
                  } catch (IllegalArgumentException var15) {
                     var4 = var15;
                     var125 = new StringBuilder();
                     var97 = this.getCurrentName();
                     if (var97 == null) {
                        break label755;
                     }
                  }
               }

               var125.append("key ").append(var97);
            }

            if (var1 != null) {
               if (var97 != null) {
                  var125.append(", ");
               }

               var125.append("field ").append(var1);
            }

            throw new IllegalArgumentException(var125.toString(), var4);
         }

         var125 = (String)var4;
      }

      return var125;
   }

   private JsonToken startParsing() throws IOException {
      JsonToken var2 = this.getCurrentToken();
      if (var2 == null) {
         var2 = this.nextToken();
      }

      boolean var1;
      if (var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkArgument(var1, "no JSON input found");
      return var2;
   }

   private JsonToken startParsingObjectOrArray() throws IOException {
      JsonToken var2 = this.startParsing();
      switch (<unrepresentable>.$SwitchMap$com$google$api$client$json$JsonToken[var2.ordinal()]) {
         case 1:
            var2 = this.nextToken();
            boolean var1;
            if (var2 != JsonToken.FIELD_NAME && var2 != JsonToken.END_OBJECT) {
               var1 = false;
            } else {
               var1 = true;
            }

            Preconditions.checkArgument(var1, var2);
            break;
         case 2:
            var2 = this.nextToken();
      }

      return var2;
   }

   public abstract void close() throws IOException;

   public abstract BigInteger getBigIntegerValue() throws IOException;

   public abstract byte getByteValue() throws IOException;

   public abstract String getCurrentName() throws IOException;

   public abstract JsonToken getCurrentToken();

   public abstract BigDecimal getDecimalValue() throws IOException;

   public abstract double getDoubleValue() throws IOException;

   public abstract JsonFactory getFactory();

   public abstract float getFloatValue() throws IOException;

   public abstract int getIntValue() throws IOException;

   public abstract long getLongValue() throws IOException;

   public abstract short getShortValue() throws IOException;

   public abstract String getText() throws IOException;

   public abstract JsonToken nextToken() throws IOException;

   public final <T> T parse(Class<T> var1) throws IOException {
      return this.parse(var1, null);
   }

   @Beta
   public final <T> T parse(Class<T> var1, CustomizeJsonParser var2) throws IOException {
      return (T)this.parse(var1, false, var2);
   }

   public Object parse(Type var1, boolean var2) throws IOException {
      return this.parse(var1, var2, null);
   }

   @Beta
   public Object parse(Type var1, boolean var2, CustomizeJsonParser var3) throws IOException {
      try {
         if (!Void.class.equals(var1)) {
            this.startParsing();
         }

         ArrayList var4 = new ArrayList();
         return this.parseValue(null, var1, var4, null, var3, true);
      } finally {
         if (var2) {
            this.close();
         }
      }
   }

   public final void parse(Object var1) throws IOException {
      this.parse(var1, null);
   }

   @Beta
   public final void parse(Object var1, CustomizeJsonParser var2) throws IOException {
      ArrayList var3 = new ArrayList();
      var3.add(var1.getClass());
      this.parse(var3, var1, var2);
   }

   public final <T> T parseAndClose(Class<T> var1) throws IOException {
      return this.parseAndClose(var1, null);
   }

   @Beta
   public final <T> T parseAndClose(Class<T> var1, CustomizeJsonParser var2) throws IOException {
      try {
         return this.parse(var1, var2);
      } finally {
         this.close();
      }
   }

   public final void parseAndClose(Object var1) throws IOException {
      this.parseAndClose(var1, null);
   }

   @Beta
   public final void parseAndClose(Object var1, CustomizeJsonParser var2) throws IOException {
      try {
         this.parse(var1, var2);
      } finally {
         this.close();
      }
   }

   public final <T> Collection<T> parseArray(Class<?> var1, Class<T> var2) throws IOException {
      return this.parseArray(var1, var2, null);
   }

   @Beta
   public final <T> Collection<T> parseArray(Class<?> var1, Class<T> var2, CustomizeJsonParser var3) throws IOException {
      Collection var4 = Data.newCollectionInstance(var1);
      this.parseArray(var4, var2, var3);
      return var4;
   }

   public final <T> void parseArray(Collection<? super T> var1, Class<T> var2) throws IOException {
      this.parseArray(var1, var2, null);
   }

   @Beta
   public final <T> void parseArray(Collection<? super T> var1, Class<T> var2, CustomizeJsonParser var3) throws IOException {
      this.parseArray(null, var1, var2, new ArrayList<>(), var3);
   }

   public final <T> Collection<T> parseArrayAndClose(Class<?> var1, Class<T> var2) throws IOException {
      return this.parseArrayAndClose(var1, var2, null);
   }

   @Beta
   public final <T> Collection<T> parseArrayAndClose(Class<?> var1, Class<T> var2, CustomizeJsonParser var3) throws IOException {
      try {
         return this.parseArray(var1, var2, var3);
      } finally {
         this.close();
      }
   }

   public final <T> void parseArrayAndClose(Collection<? super T> var1, Class<T> var2) throws IOException {
      this.parseArrayAndClose(var1, var2, null);
   }

   @Beta
   public final <T> void parseArrayAndClose(Collection<? super T> var1, Class<T> var2, CustomizeJsonParser var3) throws IOException {
      try {
         this.parseArray(var1, var2, var3);
      } finally {
         this.close();
      }
   }

   public abstract JsonParser skipChildren() throws IOException;

   public final String skipToKey(Set<String> var1) throws IOException {
      JsonToken var2 = this.startParsingObjectOrArray();

      while (true) {
         if (var2 != JsonToken.FIELD_NAME) {
            var3 = null;
            break;
         }

         String var4 = this.getText();
         this.nextToken();
         if (var1.contains(var4)) {
            var3 = var4;
            break;
         }

         this.skipChildren();
         var2 = this.nextToken();
      }

      return var3;
   }

   public final void skipToKey(String var1) throws IOException {
      this.skipToKey(Collections.singleton(var1));
   }
}
