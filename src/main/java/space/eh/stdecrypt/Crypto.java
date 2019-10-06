package space.eh.stdecrypt;

class Crypto {

    private static int d(final int n) {
        final long n2 = n & 0xFFFFFFFFL;
        return (int) ((n2 & 0x7F7F7F7FL) << 1 ^ ((n2 & 0xFFFFFFFF80808080L) >> 7) * 27L);
    }

    private static int a(final int n, final int n2) {
        final long n3 = n & 0xFFFFFFFFL;
        return (int) (n3 >> n2 * 8 | n3 << 32 - n2 * 8);
    }

    static int polynom2(int n) {
        final int d3;
        final int d2;
        final int d = d(d2 = d(d3 = d(n)));
        n ^= d;
        return d3 ^ (d2 ^ d ^ a(d3 ^ n, 3) ^ a(d2 ^ n, 2) ^ a(n, 1));
    }

    static int polynom(int n) {
        return (d(n) ^ a(n ^ d(n), 3) ^ a(n, 2) ^ a(n, 1));
    }
}
