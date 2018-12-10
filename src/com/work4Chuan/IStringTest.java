package com.work4Chuan;

public class IStringTest implements IString {

    //字符数组，用于存放串值
    private char[] strValue;
    //串长度
    int curlen = 0;
    private int count = 0;

    public IStringTest() {

        this.strValue = new char[0];
        curlen = 0;

    }

    public IStringTest(String str) {
        char[] tempString = str.toCharArray();//转换为字符数组
        strValue = tempString;
        curlen = str.length();
    }

    public IStringTest(char[] strValue) {
        this.strValue = new char[strValue.length];
        for(int i = 0; i<strValue.length; i++){
            this.strValue[i] = strValue[i];
        }
    }

    @Override
    public String toString() {

        return String.valueOf(this.strValue);

    }

    @Override
    public void clear() {
        this.curlen = 0;
    }

    @Override
    public boolean isEmpty() {
        if(this.curlen == 0){
            return true;
        }
        return false;
    }

    @Override
    public int getLength() {
        return curlen;
    }

    @Override
    public char charAt(int index) throws Exception {
        //判断index的合法性
        if(index < 0 || index > this.curlen){
            throw new Exception("位置不合法");
        }
        return this.strValue[index];
    }

    //求字串
    @Override
    public IString substring(int begin, int end) {

        if(begin < 0 || end > curlen || end < begin){
            throw new StringIndexOutOfBoundsException("位置不合法");
        }
        if(begin ==0 && end == this.curlen){
            return this;
        }else{
            char[] buffer = new char[end - begin];
            for(int i = 0; i<buffer.length; i++){
                buffer[i] = this.strValue[i + begin];
            }
            return new IStringTest(buffer);
        }
    }

    @Override
    public IString insert(int offset, IString str) throws Exception {

        if((offset < 0) || (offset > this.curlen)){
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.getLength();
        int newCount = this.curlen + len;
        if(newCount > strValue.length){
            allocate(newCount);
        }
        for(int i = this.curlen - 1; i >= offset; i--){
            strValue[len + i] = strValue[i];
        }
        for(int i = 0; i<len; i++){
            strValue[offset + i] = str.charAt(i);
        }
        this.curlen = newCount;
        return this;

    }

    @Override
    public IString delete(int begin, int end) {

        if(begin < 0 || end > this.curlen || end < begin){
            throw new StringIndexOutOfBoundsException("位置不合法");
        }
        for(int i = 0; i<curlen - end; i++){
            strValue[begin + i] = strValue[end + i];
        }

        curlen = curlen - (end - begin);
        char[] temp = new char[curlen];
        for(int i = 0; i<curlen; i++){
            temp[i] = strValue[i];
        }
        return new IStringTest(temp);
    }

    @Override
    public IString concat(String str) {

        return null;
    }

    @Override
    public int compareTo(IStringTest str) {

        int len1 = this.curlen;
        int len2 = str.curlen;
        int n = Math.min(len1, len2);
        char[] s1 = this.strValue;
        char[] s2 = str.strValue;
        int k = 0;
        while(k < n){
            char ch1 = s1[k];
            char ch2 = s2[k];
            if(ch1 != ch2){
                return ch1 - ch2;
            }
            k ++;
        }
        return len1 - len2;
    }

    @Override
    public int indexOf(IString str) {
        return 0;
    }

    //扩充字符串的存储空间
    public void allocate(int newCapacity){

        char[] temp = strValue;
        strValue = new char[newCapacity];
        for(int i = 0; i<temp.length; i++){
            strValue[i] = temp[i];
        }

    }

    /*
    * public IString toUpperCase() //返回将所有小写字母转换为大写的串
   public int compareToIgnorceCase(SeqString s) //比较两个串的大小，忽略字母大小写
public void printPrevious() //将串反序输出，从后向前
 public IString deleteCharAt(int i) //删除第i个字符，返回当前串
*/

    public IString deleteCharAt(int i){

        return this.delete(i-1, i);
    }

    public void printPrevious(){

        for(int i = this.curlen-1; i >= 0; i--){
            System.out.print(this.strValue[i]);
        }
        System.out.println();
    }

    public int compareToIgnorceCase(IStringTest str) throws Exception {

        IStringTest ist = (IStringTest) this.toUpperCase();
        for(int i = 0; i<this.getLength(); i++){
            this.strValue[i] = ist.strValue[i];
        }
        return compareTo((IStringTest) str.toUpperCase());

    }

    public IString toUpperCase() throws Exception {

        for(int i = 0; i<this.curlen; i++){
            if(charAt(i) >= 'a' && charAt(i) <= 'z'){
                this.strValue[i] -= 32;
            }
        }
        return this;
    }

    public int getBFCount(IString T, int start) throws Exception {
        this.indexOf_BF(T, start);
        return this.count;
    }
    public int getKMPCount(IString T, int start) throws Exception {
        this.indexOf_KMP(T, start);
        return this.count;
    }

    public void displayNext() throws Exception {
        int[] next = getNext(this);
        for (int n:next) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
    //请设计类，分别统计BF算法和KMP算法的比较次数
    public int indexOf_BF(IString t, int start) throws Exception {

        this.count = 0;
        if(this != null & t!=null && t.getLength() > 0 && this.getLength() >= t.getLength()){
            int slen, tlen, i = start, j = 0;
            slen = this.getLength();
            tlen = t.getLength();
            while ((i < slen) && (j < tlen)){
                this.count ++;
                if(this.charAt(i) == t.charAt(j)){
                    i ++;
                    j ++;
                }else{
                    i = i - j + 1;
                    j = 0;
                }
            }
            if(j >= t.getLength()){
                return i - tlen;
            }else{
                return -1;
            }
        }

        return  -1;
    }


    private int[] getNext(IString T) throws Exception {
        int[] next = new int[T.getLength()];
        int j = 2;
        int k = 0;
        next[0] = -1;
        next[1] = 0;
        while (j < T.getLength() - 1){
            if(T.charAt(j) == T.charAt(k)){
                next[j + 1] = k + 1;
                j ++;
                k ++;
            }else if(k == 0){
                next[j + 1] = 0;
                j ++;
            }else{
                k = next[k];
            }
        }
        return next;
    }

    public int indexOf_KMP(IString T, int start) throws Exception {

        this.count = 0;
        int[] next = getNext(T);
        int i = start;
        int j = 0;
        while (i < this.getLength() && j < T.getLength()){
            this.count ++;
            if(j == -1 || this.charAt(i) == T.charAt(j)){
                 i ++;
                 j ++;
            }else{
                j = next[j];
            }
        }
        if(j < T.getLength()){
            return -1;
        }
        else{
            return (i - T.getLength());
        }
    }

}
