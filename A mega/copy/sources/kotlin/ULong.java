package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

@JvmInline
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bL\u0010JJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u001dJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u000bJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\"J\u001e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010\u001fJ\u001e\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010\u001fJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u001dJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bY\u0010\u001fJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bZ\u0010\u000bJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b[\u0010\"J\u0010\u0010\\\u001a\u00020]H\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020aH\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\b¢\u0006\u0004\bf\u0010gJ\u0010\u0010h\u001a\u00020\rH\b¢\u0006\u0004\bi\u0010/J\u0010\u0010j\u001a\u00020\u0003H\b¢\u0006\u0004\bk\u0010\u0005J\u0010\u0010l\u001a\u00020mH\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0016\u0010t\u001a\u00020\u000eH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010_J\u0016\u0010v\u001a\u00020\u0011H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010/J\u0016\u0010x\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010\u0005J\u0016\u0010z\u001a\u00020\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010oJ\u001b\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ULong.kt */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m367boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m373constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m379equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m425unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m380equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m385hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m413toByteimpl(long j) {
        return (byte) ((int) j);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m416toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m417toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m418toShortimpl(long j) {
        return (short) ((int) j);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m422toULongsVKNKU(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m379equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m385hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m425unboximpl() {
        return this.data;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.ulongCompare(m425unboximpl(), ((ULong) obj).m425unboximpl());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ULong.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m368compareTo7apg3OU(long j, byte b) {
        return Long.compareUnsigned(j, m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m372compareToxj2QHRw(long j, short s) {
        return Long.compareUnsigned(j, m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m371compareToWZ4Q5Ns(long j, int i) {
        return Long.compareUnsigned(j, m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m369compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(m425unboximpl(), j);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static int m370compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final long m397plus7apg3OU(long j, byte b) {
        return m373constructorimpl(j + m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final long m400plusxj2QHRw(long j, short s) {
        return m373constructorimpl(j + m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final long m399plusWZ4Q5Ns(long j, int i) {
        return m373constructorimpl(j + m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m398plusVKZWuLQ(long j, long j2) {
        return m373constructorimpl(j + j2);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final long m388minus7apg3OU(long j, byte b) {
        return m373constructorimpl(j - m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final long m391minusxj2QHRw(long j, short s) {
        return m373constructorimpl(j - m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final long m390minusWZ4Q5Ns(long j, int i) {
        return m373constructorimpl(j - m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m389minusVKZWuLQ(long j, long j2) {
        return m373constructorimpl(j - j2);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final long m409times7apg3OU(long j, byte b) {
        return m373constructorimpl(j * m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final long m412timesxj2QHRw(long j, short s) {
        return m373constructorimpl(j * m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final long m411timesWZ4Q5Ns(long j, int i) {
        return m373constructorimpl(j * m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m410timesVKZWuLQ(long j, long j2) {
        return m373constructorimpl(j * j2);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final long m375div7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final long m378divxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final long m377divWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m376divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m552ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final long m403rem7apg3OU(long j, byte b) {
        return Long.remainderUnsigned(j, m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final long m406remxj2QHRw(long j, short s) {
        return Long.remainderUnsigned(j, m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final long m405remWZ4Q5Ns(long j, int i) {
        return Long.remainderUnsigned(j, m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m404remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m553ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final long m381floorDiv7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m373constructorimpl(((long) b) & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final long m384floorDivxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m373constructorimpl(((long) s) & 65535));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final long m383floorDivWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m373constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m382floorDivVKZWuLQ(long j, long j2) {
        return Long.divideUnsigned(j, j2);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m392mod7apg3OU(long j, byte b) {
        return UByte.m217constructorimpl((byte) ((int) Long.remainderUnsigned(j, m373constructorimpl(((long) b) & 255))));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m395modxj2QHRw(long j, short s) {
        return UShort.m480constructorimpl((short) ((int) Long.remainderUnsigned(j, m373constructorimpl(((long) s) & 65535))));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m394modWZ4Q5Ns(long j, int i) {
        return UInt.m294constructorimpl((int) Long.remainderUnsigned(j, m373constructorimpl(((long) i) & 4294967295L)));
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m393modVKZWuLQ(long j, long j2) {
        return Long.remainderUnsigned(j, j2);
    }

    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    private static final long m386incsVKNKU(long j) {
        return m373constructorimpl(j + 1);
    }

    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    private static final long m374decsVKNKU(long j) {
        return m373constructorimpl(j - 1);
    }

    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    private static final ULongRange m401rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, (DefaultConstructorMarker) null);
    }

    /* renamed from: rangeUntil-VKZWuLQ  reason: not valid java name */
    private static final ULongRange m402rangeUntilVKZWuLQ(long j, long j2) {
        return URangesKt.m1476untileb3DHEI(j, j2);
    }

    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    private static final long m407shlsVKNKU(long j, int i) {
        return m373constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    private static final long m408shrsVKNKU(long j, int i) {
        return m373constructorimpl(j >>> i);
    }

    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    private static final long m366andVKZWuLQ(long j, long j2) {
        return m373constructorimpl(j & j2);
    }

    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    private static final long m396orVKZWuLQ(long j, long j2) {
        return m373constructorimpl(j | j2);
    }

    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    private static final long m424xorVKZWuLQ(long j, long j2) {
        return m373constructorimpl(j ^ j2);
    }

    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    private static final long m387invsVKNKU(long j) {
        return m373constructorimpl(~j);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m420toUBytew2LRezQ(long j) {
        return UByte.m217constructorimpl((byte) ((int) j));
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m423toUShortMh2AYeg(long j) {
        return UShort.m480constructorimpl((short) ((int) j));
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m421toUIntpVg5ArA(long j) {
        return UInt.m294constructorimpl((int) j);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m415toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m414toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m419toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    public String toString() {
        return m419toStringimpl(this.data);
    }
}
