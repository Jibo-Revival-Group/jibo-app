package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

public abstract class InputDecorator implements Serializable {
   public abstract InputStream a(IOContext var1, InputStream var2) throws IOException;

   public abstract Reader a(IOContext var1, Reader var2) throws IOException;
}
