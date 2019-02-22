package com.example.revereselogistics;

public class ReturnInfo {

    private String mdate;
    private String mtime;
    private String mwholesalerid;
    private String mreturnid;

    public ReturnInfo(String whid,String rid,String d,String t){
        mwholesalerid = whid;
        mreturnid = rid;
        mdate = d;
        mtime = t;
    }

    public String getMwholesalerid(){
        return mwholesalerid;
    }
    public String getMreturnid(){
        return mreturnid;
    }
    public String getMdate(){
        return mdate;
    }
    public String getMtime(){
        return mtime;
    }
}
