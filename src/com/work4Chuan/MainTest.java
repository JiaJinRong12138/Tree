package com.work4Chuan;

public class MainTest {

    public static void main(String[] args) throws Exception {

        IStringTest str1 = new IStringTest("a1234488");
        IStringTest str2 = new IStringTest("A1234488");

        System.out.println(str1.toUpperCase());
        System.out.println(str1.compareToIgnorceCase(str2));
        str1.printPrevious();
        System.out.println(str1.deleteCharAt(1));

        IStringTest S = new IStringTest("abcabcd");
        IStringTest T = new IStringTest("abcd");
        IStringTest S1 = new IStringTest("aaaaaaaa");
        IStringTest T1 = new IStringTest("aac");

        System.out.println(S.getBFCount(T, 0));
        System.out.println(S.getKMPCount(T, 0));

        System.out.println(S1.getBFCount(T1, 0));
        System.out.println(S1.getKMPCount(T1, 0));

        IStringTest pattern = new IStringTest("abccbab");
        IStringTest pattern1 = new IStringTest("abcaababc");
        pattern.displayNext();
        pattern1.displayNext();





    }

}
