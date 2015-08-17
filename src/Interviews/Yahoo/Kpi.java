package Interviews.Yahoo;

/**
 * Created by yizhao on 8/17/15.
 */
import java.util.HashMap;

/*
 *
 * 问题：
 * We have one thread what regularly updates the data hash
 * and we have multiple worker threads reading the data and updating the
 * impressionCounter. Make this class Thread safe.
 */


class Kpi {
    private int impressionCounter;
    private HashMap<Integer, String> data = null;

    public void Kpi(){
        impressionCounter = 0;
        data = new HashMap<Integer, String>();
    }

    public void updateData() {
    }

    public String getData(int key){
        return data.get(key);
    }


    /*
    *
        问题出在：
        2个不同的thread同时叫了incImp()
        one thread -> incImp(), impressionCounter++
        another thread -> incImp(), impressionCounter++
        impressionCounter == 2
        invalid for the atomic operation
    *
    * */
    /*
    * 解法是加上synchronized
    * */
    public synchronized void incImp() {
        //synchronized(this){
        impressionCounter++;
        // }
    }

    // github, maven,

}

