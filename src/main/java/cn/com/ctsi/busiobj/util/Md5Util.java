package cn.com.ctsi.busiobj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * Created by zjq on 2016/11/7.
 */
public class Md5Util {
    /**
     * The constant S11.
     */
// RFC1321中定义的标准4*4矩阵的常量定义。
    static final int S11 = 7, /**
     * The S 12.
     */
    S12 = 12, /**
     * The S 13.
     */
    S13 = 17, /**
     * The S 14.
     */
    S14 = 22;
    /**
     * The S 21.
     */
    static final int S21 = 5, /**
     * The S 22.
     */
    S22 = 9, /**
     * The S 23.
     */
    S23 = 14, /**
     * The S 24.
     */
    S24 = 20;
    /**
     * The S 31.
     */
    static final int S31 = 4, /**
     * The S 32.
     */
    S32 = 11, /**
     * The S 33.
     */
    S33 = 16, /**
     * The S 34.
     */
    S34 = 23;
    /**
     * The S 41.
     */
    static final int S41 = 6, /**
     * The S 42.
     */
    S42 = 10, /**
     * The S 43.
     */
    S43 = 15, /**
     * The S 44.
     */
    S44 = 21;
    /**
     * The constant PADDING.
     */
// 按RFC1321标准定义不可变byte型数组PADDING
    static final byte[] PADDING = {
            -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0
    };
    private static char hexDigits[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    /**
     * The Result str.
     */
// 最新一次计算结果的16进制ASCII字符串表示，代表了16个字符串形式的MD5值
    public String resultStr;
    /**
     * The Digest.
     */
// 最新一次计算结果的2进制数组表示，一共16个字节，代表了128bit形式的MD5值
    public byte[] digest = new byte[16];
    // MD5计算过程中的3组核心数据，采用数组形式存放
    private long[] state = new long[4]; // 计算状态(分别对应a b c d)
    private byte[] buffer = new byte[64]; // 分配64个字节私有缓冲区
    private long[] count = new long[2]; // 位个数

    /**
     * Instantiates a new Md 5 util.
     */
// 标准的构造函数，调用md5Init函数进行初始化工作
    public Md5Util() {
        md5Init();
        return;
    }

    // 把byte型数据转换为无符号long型数据
    private static long byteToul(byte b) {
        return b > 0 ? b : (b & 0x7F + 128);
    }

    // 把byte类型的数据转换成十六进制ASCII字符表示
    private static String byteToHEX(byte in) {
        char[] DigitStr = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        char[] out = new char[2];
        out[0] = DigitStr[(in >> 4) & 0x0F]; // 取高4位
        out[1] = DigitStr[in & 0x0F]; // 取低4位
        String s = new String(out);
        return s;
    }

    /**
     * Gets md 5 by file.
     *
     * @param file the file
     * @return the md 5 by file
     */
    public static String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            MappedByteBuffer byteBuffer =
                    in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            in.close();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * Gets md 5.
     *
     * @param source the source
     * @return the md 5
     */
    public static String getMD5(byte[] source) {
        String s = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * File md 5 string.
     *
     * @param inputFile the input file
     * @return the string
     */
    public static String fileMD5(File inputFile) {
        // 缓冲区大小（这个可以抽出一个参数）
        int bufferSize = 256 * 1024;
        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream = null;
        try {
            // 拿到一个MD5转换器（同样，这里可以换成SHA1）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 使用DigestInputStream
            fileInputStream = new FileInputStream(inputFile);
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
            // read的过程中进行MD5处理，直到读完文件
            byte[] buffer = new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0) ;
            // 获取最终的MessageDigest
            messageDigest = digestInputStream.getMessageDigest();
            // 拿到结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            // 同样，把字节数组转换成字符串
            return byteArrayToHex(resultByteArray);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                digestInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Byte array to hex string.
     *
     * @param b the b
     * @return the string
     */
    public static String byteArrayToHex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1) {
                hs = hs + "";
            }
        }
        return hs;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        File file1 = new File("d:\\test\\632.jpg");
        System.out.println(Md5Util.fileMD5(file1));
    }

    /**
     * 获得两次MD5加密的字符串
     *
     * @param str the str
     * @return twice md 5 of string
     */
    public String getTwiceMD5ofString(String str) {
        return getMD5ofStr(getMD5ofStr(str));
    }

    /**
     * MD5_Encoding类提供的主要的接口函数getMD5ofStr，用来进行数据加密变换。
     * <p>
     * <p>调用其可对任意字符串进行加密运算，并以字符串形式返回加密结果。
     *
     * @param in the in
     * @return md 5 of str
     */
    public String getMD5ofStr(String in) {
        md5Init(); // 初始化
        md5Update(in.getBytes(), in.length()); // 调用MD5的主计算过程
        md5Final(); // 输出结果到digest数组中
        for (int i = 0; i < 16; i++) {
            resultStr += byteToHEX(digest[i]); // 将digest数组中的每个byte型数据转为16进制形式的字符串
        }
        return resultStr;
    }

    // md5初始化函数.初始化核心变量.
    private void md5Init() {
        state[0] = 0x67452301L; // 定义state为RFC1321中定义的标准幻数
        state[1] = 0xefcdab89L; // 定义state为RFC1321中定义的标准幻数
        state[2] = 0x98badcfeL; // 定义state为RFC1321中定义的标准幻数
        state[3] = 0x10325476L; // 定义state为RFC1321中定义的标准幻数
        count[0] = count[1] = 0L; // 初始化为0
        resultStr = ""; // 初始化resultStr字符串为空
        for (int i = 0; i < 16; i++) {
            digest[i] = 0; // 初始化digest数组元素为0
        }
        return;
    }

    // 定义F G H I 为4个基数 ，即为4个基本的MD5函数,进行简单的位运算
    private long F(long x, long y, long z) {
        return (x & y) | ((~x) & z);
    }

    private long G(long x, long y, long z) {
        return (x & z) | (y & (~z));
    }

    private long H(long x, long y, long z) {
        return x ^ y ^ z;
    }

    private long I(long x, long y, long z) {
        return y ^ (x | (~z));
    }

    // FF,GG,HH和II调用F,G,H,I函数进行进一步变换
    private long FF(long a, long b, long c, long d, long x, long s, long ac) {
        a += F(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s)); // 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    private long GG(long a, long b, long c, long d, long x, long s, long ac) {
        a += G(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s)); // 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    private long HH(long a, long b, long c, long d, long x, long s, long ac) {
        a += H(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s)); // 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    private long II(long a, long b, long c, long d, long x, long s, long ac) {
        a += I(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s)); // 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    // MD5的主计算过程，input是需要变换的二进制字节串，inputlen是长度
    private void md5Update(byte[] input, int inputLen) {
        int i = 0, index, partLen;
        byte[] block = new byte[64]; // 分配64个字节缓冲区
        // 根据count计算index值。这里long型数据右移时使用无符号右移运算符>>>
        index = (int) (count[0] >>> 3) & 0x3F;
        if ((count[0] += (inputLen << 3)) < (inputLen << 3)) {
            count[1]++;
        }
        count[1] += (inputLen >>> 29); // 这里int型数据右移时使用无符号右移运算符>>>
        partLen = 64 - index; // 计算partLen值
        if (inputLen >= partLen) {
            md5Memcpy(buffer, input, index, 0, partLen);
            md5Transform(buffer);
            for (i = partLen; i + 63 < inputLen; i += 64) {
                md5Memcpy(block, input, 0, i, 64);
                md5Transform(block);
            }
            index = 0;
        } else {
            i = 0;
        }
        md5Memcpy(buffer, input, index, i, inputLen - i);
    }

    // 整理和填写输出结果，结果放到数组digest中。
    private void md5Final() {
        byte[] bits = new byte[8];
        int index, padLen;
        Encode(bits, count, 8);
        index = (int) (count[0] >>> 3) & 0x3f; // 这里long型数据右移时使用无符号右移运算符>>>
        padLen = (index < 56) ? (56 - index) : (120 - index);
        md5Update(PADDING, padLen);
        md5Update(bits, 8);
        Encode(digest, state, 16);
    }

    // byte数组的块拷贝函数，将input数组中的起始位置为inpos，长度len的数据拷贝到output数组起始位置outpos处。
    private void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos, int len) {
        int i;
        for (i = 0; i < len; i++) {
            output[outpos + i] = input[inpos + i];
        }
    }

    // MD5核心变换计算程序，由md5Update函数调用，block是分块的原始字节数组
    private void md5Transform(byte block[]) {
        long a = state[0], b = state[1], c = state[2], d = state[3];
        long[] x = new long[16];
        Decode(x, block, 64);
        // 进行4级级联运算
        // 第1级
        a = FF(a, b, c, d, x[0], S11, 0xd76aa478L); /* 1 */
        d = FF(d, a, b, c, x[1], S12, 0xe8c7b756L); /* 2 */
        c = FF(c, d, a, b, x[2], S13, 0x242070dbL); /* 3 */
        b = FF(b, c, d, a, x[3], S14, 0xc1bdceeeL); /* 4 */
        a = FF(a, b, c, d, x[4], S11, 0xf57c0fafL); /* 5 */
        d = FF(d, a, b, c, x[5], S12, 0x4787c62aL); /* 6 */
        c = FF(c, d, a, b, x[6], S13, 0xa8304613L); /* 7 */
        b = FF(b, c, d, a, x[7], S14, 0xfd469501L); /* 8 */
        a = FF(a, b, c, d, x[8], S11, 0x698098d8L); /* 9 */
        d = FF(d, a, b, c, x[9], S12, 0x8b44f7afL); /* 10 */
        c = FF(c, d, a, b, x[10], S13, 0xffff5bb1L); /* 11 */
        b = FF(b, c, d, a, x[11], S14, 0x895cd7beL); /* 12 */
        a = FF(a, b, c, d, x[12], S11, 0x6b901122L); /* 13 */
        d = FF(d, a, b, c, x[13], S12, 0xfd987193L); /* 14 */
        c = FF(c, d, a, b, x[14], S13, 0xa679438eL); /* 15 */
        b = FF(b, c, d, a, x[15], S14, 0x49b40821L); /* 16 */

        // 第2级
        a = GG(a, b, c, d, x[1], S21, 0xf61e2562L); /* 17 */
        d = GG(d, a, b, c, x[6], S22, 0xc040b340L); /* 18 */
        c = GG(c, d, a, b, x[11], S23, 0x265e5a51L); /* 19 */
        b = GG(b, c, d, a, x[0], S24, 0xe9b6c7aaL); /* 20 */
        a = GG(a, b, c, d, x[5], S21, 0xd62f105dL); /* 21 */
        d = GG(d, a, b, c, x[10], S22, 0x2441453L); /* 22 */
        c = GG(c, d, a, b, x[15], S23, 0xd8a1e681L); /* 23 */
        b = GG(b, c, d, a, x[4], S24, 0xe7d3fbc8L); /* 24 */
        a = GG(a, b, c, d, x[9], S21, 0x21e1cde6L); /* 25 */
        d = GG(d, a, b, c, x[14], S22, 0xc33707d6L); /* 26 */
        c = GG(c, d, a, b, x[3], S23, 0xf4d50d87L); /* 27 */
        b = GG(b, c, d, a, x[8], S24, 0x455a14edL); /* 28 */
        a = GG(a, b, c, d, x[13], S21, 0xa9e3e905L); /* 29 */
        d = GG(d, a, b, c, x[2], S22, 0xfcefa3f8L); /* 30 */
        c = GG(c, d, a, b, x[7], S23, 0x676f02d9L); /* 31 */
        b = GG(b, c, d, a, x[12], S24, 0x8d2a4c8aL); /* 32 */

        // 第3级
        a = HH(a, b, c, d, x[5], S31, 0xfffa3942L); /* 33 */
        d = HH(d, a, b, c, x[8], S32, 0x8771f681L); /* 34 */
        c = HH(c, d, a, b, x[11], S33, 0x6d9d6122L); /* 35 */
        b = HH(b, c, d, a, x[14], S34, 0xfde5380cL); /* 36 */
        a = HH(a, b, c, d, x[1], S31, 0xa4beea44L); /* 37 */
        d = HH(d, a, b, c, x[4], S32, 0x4bdecfa9L); /* 38 */
        c = HH(c, d, a, b, x[7], S33, 0xf6bb4b60L); /* 39 */
        b = HH(b, c, d, a, x[10], S34, 0xbebfbc70L); /* 40 */
        a = HH(a, b, c, d, x[13], S31, 0x289b7ec6L); /* 41 */
        d = HH(d, a, b, c, x[0], S32, 0xeaa127faL); /* 42 */
        c = HH(c, d, a, b, x[3], S33, 0xd4ef3085L); /* 43 */
        b = HH(b, c, d, a, x[6], S34, 0x4881d05L); /* 44 */
        a = HH(a, b, c, d, x[9], S31, 0xd9d4d039L); /* 45 */
        d = HH(d, a, b, c, x[12], S32, 0xe6db99e5L); /* 46 */
        c = HH(c, d, a, b, x[15], S33, 0x1fa27cf8L); /* 47 */
        b = HH(b, c, d, a, x[2], S34, 0xc4ac5665L); /* 48 */

        // 第4级
        a = II(a, b, c, d, x[0], S41, 0xf4292244L); /* 49 */
        d = II(d, a, b, c, x[7], S42, 0x432aff97L); /* 50 */
        c = II(c, d, a, b, x[14], S43, 0xab9423a7L); /* 51 */
        b = II(b, c, d, a, x[5], S44, 0xfc93a039L); /* 52 */
        a = II(a, b, c, d, x[12], S41, 0x655b59c3L); /* 53 */
        d = II(d, a, b, c, x[3], S42, 0x8f0ccc92L); /* 54 */
        c = II(c, d, a, b, x[10], S43, 0xffeff47dL); /* 55 */
        b = II(b, c, d, a, x[1], S44, 0x85845dd1L); /* 56 */
        a = II(a, b, c, d, x[8], S41, 0x6fa87e4fL); /* 57 */
        d = II(d, a, b, c, x[15], S42, 0xfe2ce6e0L); /* 58 */
        c = II(c, d, a, b, x[6], S43, 0xa3014314L); /* 59 */
        b = II(b, c, d, a, x[13], S44, 0x4e0811a1L); /* 60 */
        a = II(a, b, c, d, x[4], S41, 0xf7537e82L); /* 61 */
        d = II(d, a, b, c, x[11], S42, 0xbd3af235L); /* 62 */
        c = II(c, d, a, b, x[2], S43, 0x2ad7d2bbL); /* 63 */
        b = II(b, c, d, a, x[9], S44, 0xeb86d391L); /* 64 */

        // 分别累加到state[0],state[1],state[2],state[3]
        state[0] += a;
        state[1] += b;
        state[2] += c;
        state[3] += d;
    }

    // 将long型数组按顺序拆成byte型数组,长度为len
    private void Encode(byte[] output, long[] input, int len) {
        int i, j;
        for (i = 0, j = 0; j < len; i++, j += 4) {
            output[j] = (byte) (input[i] & 0xffL);
            output[j + 1] = (byte) ((input[i] >>> 8) & 0xffL);
            output[j + 2] = (byte) ((input[i] >>> 16) & 0xffL);
            output[j + 3] = (byte) ((input[i] >>> 24) & 0xffL);
        }
    }

    // 将byte型数组按顺序合成long型数组，长度为len
    private void Decode(long[] output, byte[] input, int len) {
        int i, j;
        for (i = 0, j = 0; j < len; i++, j += 4) {
            output[i] =
                    byteToul(input[j])
                            | (byteToul(input[j + 1]) << 8)
                            | (byteToul(input[j + 2]) << 16)
                            | (byteToul(input[j + 3]) << 24);
        }
        return;
    }
}
