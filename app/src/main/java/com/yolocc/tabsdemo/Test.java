package com.yolocc.tabsdemo;

/**
 */
public class Test {

    public String s;

    public void getS() throws NullPointerException{
        try {

            System.out.println("s:"+s.length());
        } catch (NullPointerException e) {
            throw new NullPointerException("Sjjjtring is null");
        }
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("heheh");
        stringBuffer.append(false);
        stringBuffer.delete(2,3);
        A b = new B(true,"123","234");
        System.out.println(b.getData() + b.isSuccess());
        System.out.println("stringBuffer:"+stringBuffer);

        String s = "hahah";
        Test test = new Test();
        test.getS();

    }
}
