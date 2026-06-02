package org.apache.http.message;

import java.util.BitSet;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public class TokenParser {

    /* JADX INFO: renamed from: CR */
    public static final char f15712CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';

    /* JADX INFO: renamed from: HT */
    public static final char f15713HT = '\t';
    public static final TokenParser INSTANCE = new TokenParser();

    /* JADX INFO: renamed from: LF */
    public static final char f15714LF = '\n';

    /* JADX INFO: renamed from: SP */
    public static final char f15715SP = ' ';

    public static BitSet INIT_BITSET(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return bitSet;
    }

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    public String parseToken(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!parserCursor.atEnd()) {
            char cCharAt = charArrayBuffer.charAt(parserCursor.getPos());
            if (bitSet != null && bitSet.get(cCharAt)) {
                break;
            }
            if (isWhitespace(cCharAt)) {
                skipWhiteSpace(charArrayBuffer, parserCursor);
                z = true;
            } else {
                if (z && sb.length() > 0) {
                    sb.append(f15715SP);
                }
                copyContent(charArrayBuffer, parserCursor, bitSet, sb);
                z = false;
            }
        }
        return sb.toString();
    }

    public String parseValue(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!parserCursor.atEnd()) {
            char cCharAt = charArrayBuffer.charAt(parserCursor.getPos());
            if (bitSet != null && bitSet.get(cCharAt)) {
                break;
            }
            if (isWhitespace(cCharAt)) {
                skipWhiteSpace(charArrayBuffer, parserCursor);
                z = true;
            } else if (cCharAt == '\"') {
                if (z && sb.length() > 0) {
                    sb.append(f15715SP);
                }
                copyQuotedContent(charArrayBuffer, parserCursor, sb);
                z = false;
            } else {
                if (z && sb.length() > 0) {
                    sb.append(f15715SP);
                }
                copyUnquotedContent(charArrayBuffer, parserCursor, bitSet, sb);
                z = false;
            }
        }
        return sb.toString();
    }

    public void skipWhiteSpace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound && isWhitespace(charArrayBuffer.charAt(pos2)); pos2++) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    public void copyContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(cCharAt)) || isWhitespace(cCharAt)) {
                break;
            }
            pos++;
            sb.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    public void copyUnquotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(cCharAt)) || isWhitespace(cCharAt) || cCharAt == '\"') {
                break;
            }
            pos++;
            sb.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    public void copyQuotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, StringBuilder sb) {
        int i;
        if (!parserCursor.atEnd()) {
            int pos = parserCursor.getPos();
            int pos2 = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            if (charArrayBuffer.charAt(pos) == '\"') {
                int i2 = pos + 1;
                int i3 = pos2 + 1;
                boolean z = false;
                while (true) {
                    if (i3 >= upperBound) {
                        i = i2;
                        break;
                    }
                    char cCharAt = charArrayBuffer.charAt(i3);
                    if (z) {
                        if (cCharAt != '\"' && cCharAt != '\\') {
                            sb.append(ESCAPE);
                        }
                        sb.append(cCharAt);
                        z = false;
                    } else if (cCharAt == '\"') {
                        i = i2 + 1;
                        break;
                    } else if (cCharAt == '\\') {
                        z = true;
                    } else if (cCharAt != '\r' && cCharAt != '\n') {
                        sb.append(cCharAt);
                    }
                    i3++;
                    i2++;
                }
                parserCursor.updatePos(i);
            }
        }
    }
}
