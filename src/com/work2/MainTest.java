package com.work2;

import com.work2.CIrclesqQueue;

public class MainTest {

    public static void main(String[] args) throws Exception {
        String str[] = new String[]{
          "A",
          "B",
          "C",
          "D",
          "E",
          "F",
          "G",
        };

        CIrclesqQueue cq = new CIrclesqQueue(100);

        cq.clear();

        for(String s : str){
            cq.offer(s);
        }
        cq.disPlay();

        cq.offer("x");
        for(int i = 0; i<3; i++){
            cq.poll();
        }
        cq.disPlay();

        int l = cq.length();
        for(int i = 0; i<l; i++){
            cq.poll();
        }
        cq.disPlay();


    }

}
