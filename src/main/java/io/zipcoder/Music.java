package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        int forwardMethod = playList.length, backwardMethod = playList.length, temp=0;
        List<Integer> endingIndex= new ArrayList<Integer>();
        //for multiple copies of q
        for (int i=0; i< playList.length;i++){
            if (playList[i].equals(selection)) {
                endingIndex.add(i);
            }
        }
        for (Integer s: endingIndex) {
            if (s > startIndex) {
                temp=s-startIndex;
                if (temp<forwardMethod)
                    forwardMethod = temp;
                temp=startIndex + (playList.length - s);
                if (temp<backwardMethod)
                    backwardMethod = temp;
            }
            if (s < startIndex){
                temp= (playList.length-startIndex)+s;
                if (temp<forwardMethod)
                    forwardMethod = temp;
                temp=startIndex-s;
                if (temp<backwardMethod)
                    backwardMethod = temp;
            }
        }
        return forwardMethod<backwardMethod?forwardMethod:backwardMethod;
    }
}
