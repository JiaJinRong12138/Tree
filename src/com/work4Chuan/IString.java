package com.work4Chuan;

public interface IString {

    public void clear();
    public boolean isEmpty();
    public int getLength();
    public char charAt(int index) throws Exception;
    public IString substring(int begin, int end);

    IString insert(int offset, IString str) throws Exception;

    public IString delete(int begin, int end);
    public IString concat(String str);
    public int compareTo(IStringTest str);
    public int indexOf(IString str);

}
