import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class TriviumMain {
    final static byte[] ciper = new byte[288];
    final static byte[] key = new byte[80];
    final static byte[] vector = new byte[80];
    static byte t1, t2, t3;
    static byte z;
    final static byte[]message = new byte[100];

    public static void genKeyV() {
        for (int i = 0; i < key.length; i++) {
            key[i] = (byte) (Math.random() * (2));
            vector[i] = (byte) (Math.random() * (2));

        }
//        System.out.println("Key = " + Arrays.toString(key));
//        System.out.println("Vector = " + Arrays.toString(vector));
    }
    public static void genMessage(){
        for (int i = 0; i < message.length; i++) {
           message[i] = (byte) (Math.random() * (2));
        }
    }

    static int m;

    public static void createKey() {
        for (int i = 0; i < 93; i++) {
            if (i < 80) {
                ciper[i] = key[i];
            } else {
                ciper[i] = 0;
            }
        }
        for (int i = 93; i < 177; i++) {
            if (i < 173) {
                ciper[i] = vector[m];
            } else {
                ciper[i] = 0;
            }
            m++;
        }
        for (int i = 177; i < 288; i++) {
            if (i < 285) {
                ciper[i] = 0;
            } else {
                ciper[i] = 1;
            }
        }
        m = 0;
        //System.out.println("Поток до цикла" + Arrays.toString(ciper));
        long len = 4 * 288;
        for (int i = 0; i < len; i++) {
            t1 = (byte) (ciper[65] ^ ciper[90] & ciper[91] ^ ciper[92] ^ ciper[170]);
            t2 = (byte) (ciper[161] ^ ciper[174] & ciper[175] ^ ciper[176] ^ ciper[263]);
            t3 = (byte) (ciper[242] ^ ciper[285] & ciper[286] ^ ciper[287] ^ ciper[68]);
            //System.out.println(t1+" "+t2+" "+t3);
            for (int j = 91; j >= 0; j--) {
                if (j == 0) {
                    ciper[1] = ciper[0];
                    ciper[0] = t3;
                } else {
                    ciper[j + 1] = ciper[j];
                }
            }
            for (int j = 175; j >= 93; j--) {
                if (j == 93) {
                    ciper[94] = ciper[93];
                    ciper[93] = t1;
                } else {
                    ciper[j + 1] = ciper[j];
                }
            }
            for (int j = 286; j >= 177; j--) {
                if (j == 177) {
                    ciper[178] = ciper[177];
                    ciper[177] = t2;
                } else {
                    ciper[j + 1] = ciper[j];
                }
            }
        }
//        System.out.println("Поток после цикла = " + Arrays.toString(ciper));

    }
//    public static void generateCiper() {
//        //System.out.println(Arrays.toString(ciper));
//        for (int i = 0; i < 1000000; i++) {
//            t1 = (byte) (ciper[65] ^ ciper[92]);
//            t2 = (byte) (ciper[161] ^ ciper[176]);
//            t3 = (byte) (ciper[242] ^ ciper[287]);
//            //System.out.println(t1+" "+t2+" "+t3);
//            z = (byte) (t1 ^ t2 ^ t3);
//            //System.out.println(z);
//            t1 = (byte) (t1 ^ ciper[90] & ciper[91] ^ ciper[170]);
//            t2 = (byte) (t2 ^ ciper[174] & ciper[175] ^ ciper[263]);
//            t3 = (byte) (t3 ^ ciper[285] & ciper[286] ^ ciper[68]);
//
//            for (int j = 91; j >= 0; j--) {
//                if (j == 0) {
//                    ciper[1] = ciper[0];
//                    ciper[0] = t3;
//                } else {
//                    ciper[j + 1] = ciper[j];
//                }
//            }
//            for (int j = 175; j >= 93; j--) {
//                if (j == 93) {
//                    ciper[94] = ciper[93];
//                    ciper[93] = t1;
//                } else {
//                    ciper[j + 1] = ciper[j];
//                }
//            }
//            for (int j = 286; j >= 177; j--) {
//                if (j == 177) {
//                    ciper[178] = ciper[177];
//                    ciper[177] = t2;
//                } else {
//                    ciper[j + 1] = ciper[j];
//                }
//            }
//        }
//            System.out.println("Message = "+message[i]+" "+"Result = "+(z^message[i]));
//            System.out.println("Result = "+(z^(z^message[i])));
        //}
    public static void generateCiper1() {
        t1 = (byte) (ciper[65] ^ ciper[92]);
        t2 = (byte) (ciper[161] ^ ciper[176]);
        t3 = (byte) (ciper[242] ^ ciper[287]);
        //System.out.println(t1+" "+t2+" "+t3);
        z = (byte) (t1 ^ t2 ^ t3);
        //System.out.println(z);
        t1 = (byte) (t1 ^ ciper[90] & ciper[91] ^ ciper[170]);
        t2 = (byte) (t2 ^ ciper[174] & ciper[175] ^ ciper[263]);
        t3 = (byte) (t3 ^ ciper[285] & ciper[286] ^ ciper[68]);

        ciper[92] = ciper[91];
        ciper[91] = ciper[90];
        ciper[90] = ciper[89];
        ciper[89] = ciper[88];
        ciper[88] = ciper[87];
        ciper[87] = ciper[86];
        ciper[86] = ciper[85];
        ciper[85] = ciper[84];
        ciper[84] = ciper[83];
        ciper[83] = ciper[82];
        ciper[82] = ciper[81];
        ciper[81] = ciper[80];
        ciper[80] = ciper[79];
        ciper[79] = ciper[78];
        ciper[78] = ciper[77];
        ciper[77] = ciper[76];
        ciper[76] = ciper[75];
        ciper[75] = ciper[74];
        ciper[74] = ciper[73];
        ciper[73] = ciper[72];
        ciper[72] = ciper[71];
        ciper[71] = ciper[70];
        ciper[70] = ciper[69];
        ciper[69] = ciper[68];
        ciper[68] = ciper[67];
        ciper[67] = ciper[66];
        ciper[66] = ciper[65];
        ciper[65] = ciper[64];
        ciper[64] = ciper[63];
        ciper[63] = ciper[62];
        ciper[62] = ciper[61];
        ciper[61] = ciper[60];
        ciper[60] = ciper[59];
        ciper[59] = ciper[58];
        ciper[58] = ciper[57];
        ciper[57] = ciper[56];
        ciper[56] = ciper[55];
        ciper[55] = ciper[54];
        ciper[54] = ciper[53];
        ciper[53] = ciper[52];
        ciper[52] = ciper[51];
        ciper[51] = ciper[50];
        ciper[50] = ciper[49];
        ciper[49] = ciper[48];
        ciper[48] = ciper[47];
        ciper[47] = ciper[46];
        ciper[46] = ciper[45];
        ciper[45] = ciper[44];
        ciper[44] = ciper[43];
        ciper[43] = ciper[42];
        ciper[42] = ciper[41];
        ciper[41] = ciper[40];
        ciper[40] = ciper[39];
        ciper[39] = ciper[38];
        ciper[38] = ciper[37];
        ciper[37] = ciper[36];
        ciper[36] = ciper[35];
        ciper[35] = ciper[34];
        ciper[34] = ciper[33];
        ciper[33] = ciper[32];
        ciper[32] = ciper[31];
        ciper[31] = ciper[30];
        ciper[30] = ciper[29];
        ciper[29] = ciper[28];
        ciper[28] = ciper[27];
        ciper[27] = ciper[26];
        ciper[26] = ciper[25];
        ciper[25] = ciper[24];
        ciper[24] = ciper[23];
        ciper[23] = ciper[22];
        ciper[22] = ciper[21];
        ciper[21] = ciper[20];
        ciper[20] = ciper[19];
        ciper[19] = ciper[18];
        ciper[18] = ciper[17];
        ciper[17] = ciper[16];
        ciper[16] = ciper[15];
        ciper[15] = ciper[14];
        ciper[14] = ciper[13];
        ciper[13] = ciper[12];
        ciper[12] = ciper[11];
        ciper[11] = ciper[10];
        ciper[10] = ciper[9];
        ciper[9] = ciper[8];
        ciper[8] = ciper[7];
        ciper[7] = ciper[6];
        ciper[6] = ciper[5];
        ciper[5] = ciper[4];
        ciper[4] = ciper[3];
        ciper[3] = ciper[2];
        ciper[2] = ciper[1];
        ciper[1] = ciper[0];
        ciper[0] = t3;

        ciper[176] = ciper[175];
        ciper[175] = ciper[174];
        ciper[174] = ciper[173];
        ciper[173] = ciper[172];
        ciper[172] = ciper[171];
        ciper[171] = ciper[170];
        ciper[170] = ciper[169];
        ciper[169] = ciper[168];
        ciper[168] = ciper[167];
        ciper[167] = ciper[166];
        ciper[166] = ciper[165];
        ciper[165] = ciper[164];
        ciper[164] = ciper[163];
        ciper[163] = ciper[162];
        ciper[162] = ciper[161];
        ciper[161] = ciper[160];
        ciper[160] = ciper[159];
        ciper[159] = ciper[158];
        ciper[158] = ciper[157];
        ciper[157] = ciper[156];
        ciper[156] = ciper[155];
        ciper[155] = ciper[154];
        ciper[154] = ciper[153];
        ciper[153] = ciper[152];
        ciper[152] = ciper[151];
        ciper[151] = ciper[150];
        ciper[150] = ciper[149];
        ciper[149] = ciper[148];
        ciper[148] = ciper[147];
        ciper[147] = ciper[146];
        ciper[146] = ciper[145];
        ciper[145] = ciper[144];
        ciper[144] = ciper[143];
        ciper[143] = ciper[142];
        ciper[142] = ciper[141];
        ciper[141] = ciper[140];
        ciper[140] = ciper[139];
        ciper[139] = ciper[138];
        ciper[138] = ciper[137];
        ciper[136] = ciper[135];
        ciper[135] = ciper[134];
        ciper[134] = ciper[133];
        ciper[133] = ciper[132];
        ciper[132] = ciper[131];
        ciper[131] = ciper[130];
        ciper[130] = ciper[129];
        ciper[129] = ciper[128];
        ciper[128] = ciper[127];
        ciper[127] = ciper[126];
        ciper[126] = ciper[125];
        ciper[125] = ciper[124];
        ciper[124] = ciper[123];
        ciper[123] = ciper[122];
        ciper[122] = ciper[121];
        ciper[121] = ciper[120];
        ciper[120] = ciper[119];
        ciper[119] = ciper[118];
        ciper[118] = ciper[117];
        ciper[117] = ciper[116];
        ciper[116] = ciper[115];
        ciper[115] = ciper[114];
        ciper[114] = ciper[113];
        ciper[113] = ciper[112];
        ciper[112] = ciper[111];
        ciper[111] = ciper[110];
        ciper[110] = ciper[109];
        ciper[109] = ciper[108];
        ciper[108] = ciper[107];
        ciper[107] = ciper[106];
        ciper[106] = ciper[105];
        ciper[105] = ciper[104];
        ciper[104] = ciper[103];
        ciper[103] = ciper[102];
        ciper[102] = ciper[101];
        ciper[101] = ciper[100];
        ciper[100] = ciper[99];
        ciper[99] = ciper[98];
        ciper[98] = ciper[97];
        ciper[97] = ciper[96];
        ciper[96] = ciper[95];
        ciper[95] = ciper[94];
        ciper[94] = ciper[93];
        ciper[93] = t1;

        ciper[287] = ciper[286];
        ciper[286] = ciper[285];
        ciper[285] = ciper[284];
        ciper[284] = ciper[283];
        ciper[283] = ciper[282];
        ciper[282] = ciper[281];
        ciper[281] = ciper[280];
        ciper[280] = ciper[279];
        ciper[279] = ciper[278];
        ciper[278] = ciper[277];
        ciper[277] = ciper[276];
        ciper[276] = ciper[275];
        ciper[275] = ciper[274];
        ciper[274] = ciper[273];
        ciper[273] = ciper[272];
        ciper[272] = ciper[271];
        ciper[271] = ciper[270];
        ciper[270] = ciper[269];
        ciper[269] = ciper[268];
        ciper[268] = ciper[267];
        ciper[267] = ciper[266];
        ciper[266] = ciper[265];
        ciper[265] = ciper[264];
        ciper[264] = ciper[263];
        ciper[263] = ciper[262];
        ciper[262] = ciper[261];
        ciper[261] = ciper[260];
        ciper[260] = ciper[259];
        ciper[259] = ciper[258];
        ciper[258] = ciper[257];
        ciper[257] = ciper[256];
        ciper[256] = ciper[255];
        ciper[255] = ciper[254];
        ciper[254] = ciper[253];
        ciper[253] = ciper[252];
        ciper[252] = ciper[251];
        ciper[251] = ciper[250];
        ciper[250] = ciper[249];
        ciper[249] = ciper[248];
        ciper[248] = ciper[247];
        ciper[247] = ciper[246];
        ciper[246] = ciper[245];
        ciper[245] = ciper[244];
        ciper[244] = ciper[243];
        ciper[243] = ciper[242];
        ciper[242] = ciper[241];
        ciper[241] = ciper[240];
        ciper[240] = ciper[239];
        ciper[239] = ciper[238];
        ciper[238] = ciper[237];
        ciper[237] = ciper[236];
        ciper[236] = ciper[235];
        ciper[235] = ciper[234];
        ciper[234] = ciper[233];
        ciper[233] = ciper[232];
        ciper[232] = ciper[231];
        ciper[231] = ciper[230];
        ciper[230] = ciper[229];
        ciper[229] = ciper[228];
        ciper[228] = ciper[227];
        ciper[227] = ciper[226];
        ciper[226] = ciper[225];
        ciper[225] = ciper[224];
        ciper[224] = ciper[223];
        ciper[223] = ciper[222];
        ciper[222] = ciper[221];
        ciper[221] = ciper[220];
        ciper[220] = ciper[219];
        ciper[219] = ciper[218];
        ciper[218] = ciper[217];
        ciper[217] = ciper[216];
        ciper[216] = ciper[215];
        ciper[215] = ciper[214];
        ciper[214] = ciper[213];
        ciper[213] = ciper[212];
        ciper[212] = ciper[211];
        ciper[211] = ciper[210];
        ciper[210] = ciper[209];
        ciper[209] = ciper[208];
        ciper[208] = ciper[207];
        ciper[207] = ciper[206];
        ciper[206] = ciper[205];
        ciper[205] = ciper[204];
        ciper[204] = ciper[203];
        ciper[203] = ciper[202];
        ciper[202] = ciper[201];
        ciper[201] = ciper[200];
        ciper[200] = ciper[199];
        ciper[199] = ciper[198];
        ciper[198] = ciper[197];
        ciper[197] = ciper[196];
        ciper[196] = ciper[195];
        ciper[195] = ciper[194];
        ciper[194] = ciper[193];
        ciper[193] = ciper[192];
        ciper[192] = ciper[191];
        ciper[191] = ciper[190];
        ciper[190] = ciper[189];
        ciper[189] = ciper[188];
        ciper[188] = ciper[187];
        ciper[187] = ciper[186];
        ciper[186] = ciper[185];
        ciper[185] = ciper[184];
        ciper[184] = ciper[183];
        ciper[183] = ciper[182];
        ciper[182] = ciper[181];
        ciper[181] = ciper[180];
        ciper[180] = ciper[179];
        ciper[179] = ciper[178];
        ciper[178] = ciper[177];
        ciper[177] = t2;
    }
    public static void test1Gb() {
        long result;
        double timeTest, readyTime = 0;
        genKeyV();
        createKey();
        int u = (1024 * 1024 * 1024);
        for (int i = 0; i < u; i++) {
            timeTest = System.currentTimeMillis();
            generateCiper1();
            result = (byte) (z ^ 1);
            timeTest = System.currentTimeMillis() - timeTest;
            readyTime += timeTest;
        }
        System.out.println("Final Time init took: " + ((readyTime / 1000) / 8) + " ms");
        System.out.println("Final Speed init took: " + (u/8) / ((readyTime * 1000) / 8) + " bytes/pack");
    }

    public static void testOnSmallPacket(int bytes, int packages, int keys) {
        double timeTest, readyTime = 0;
        long result;
        long m = (bytes * packages)*8;
        for (int r = 0; r < 3000; r++) {
            for (int y = 0; y < keys; y++) {
                genKeyV();
                createKey();
                for (int x = 0; x < m; x++) {
                    timeTest = System.currentTimeMillis();
                    generateCiper1();
                    result = (byte) (z ^ 1);
                    timeTest = System.currentTimeMillis() - timeTest;
                    readyTime = readyTime + timeTest;

                }
            }
        }
        System.out.println("Final Time init took: " + ((readyTime) / 3) + " mks");
        System.out.println("Final Speed pack/mks took: " + (packages * keys) / ((readyTime / 3)) + " mks");
        System.out.println("Final Speed byte/mks took: " + bytes / ((readyTime / 3)) + " mks");
    }
    public static void initKey_7000(int keys){
        double timeTest, readyTime = 0;
        genKeyV();
        for (int z = 0; z < 3000; z++) {
            for (int i = 0; i < keys; i++) {
                timeTest = System.currentTimeMillis();
                createKey();
                timeTest = System.currentTimeMillis() - timeTest;
                readyTime += timeTest;
            }
        }
        readyTime /= 3000000;
        System.out.println("     Algorithm: trivium | Initialization speed: " + readyTime + " mks | " +
                7000/readyTime + " cycles/setting | " + 7000 / readyTime * 1000 + "setting/sec");
        System.out.println();

    }
    public static void initKey_500(int keys){
        double timeTest, readyTime = 0;
        genKeyV();
        for (int z = 0; z < 3000; z++) {
            for (int i = 0; i < keys; i++) {
                timeTest = System.currentTimeMillis();
                createKey();
                timeTest = System.currentTimeMillis() - timeTest;
                readyTime += timeTest;
            }
        }
        readyTime /= 3000;
        System.out.println("     Algorithm: trivium | Initialization speed: " + readyTime + " mks | " +
                500/readyTime + " cycles/setting | " + 500 / readyTime * 1000 + "setting/sec");
        System.out.println();

    }
    public static void main(String[] args) {
        System.out.println("Testing 1Gb...");
        test1Gb();
        System.out.println();
        System.out.println("Testing 40 bytes, 10 keys, 35 packages");
        testOnSmallPacket(40,35,10);
        System.out.println();
        System.out.println("Testing 576 bytes, 10 keys, 12 packages");
        testOnSmallPacket(576,12,10);
        System.out.println();
        System.out.println("Testing 1500 bytes, 1 key, 50 packages");
        testOnSmallPacket(1500,50,1);
        System.out.println();
        System.out.println("Testing init 7000 keys");
        initKey_7000(7000);
        System.out.println();
        System.out.println("Testing init 500 keys");
        initKey_500(500);
        System.out.println();

    }
}
