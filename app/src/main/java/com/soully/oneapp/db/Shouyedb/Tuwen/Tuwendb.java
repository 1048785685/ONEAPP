package com.soully.oneapp.db.Shouyedb.Tuwen;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Soully on 2017/2/16.
 */

public class Tuwendb extends JSONObject{
   String[] hpcontent = new String[10];
    JSONArray hpImfUrl = new JSONArray();
    JSONArray hpAuthor = new JSONArray();
    JSONArray hpTextAuthors= new JSONArray();
    JSONArray praisenum = new JSONArray();
    JSONArray sharenum = new JSONArray();


    public JSONArray getSharenum() {

        return sharenum;
    }

    public void setSharenum(JSONArray sharenum) {
        this.sharenum = sharenum;
    }

    public JSONArray getPraisenum() {

        return praisenum;
    }

    public void setPraisenum(JSONArray praisenum) {
        this.praisenum = praisenum;
    }

    public JSONArray getHpTextAuthors() {

        return hpTextAuthors;
    }

    public void setHpTextAuthors(JSONArray hpTextAuthors) {
        this.hpTextAuthors = hpTextAuthors;
    }

    public JSONArray getHpImfUrl() {

        return hpImfUrl;
    }

    public void setHpImfUrl(JSONArray hpImfUrl) {
        this.hpImfUrl = hpImfUrl;
    }

    public String[] getHpcontent() {
        return hpcontent;
    }

    public void setHpcontent(String[] hpcontent) {
        this.hpcontent = hpcontent;
    }

    public JSONArray getHpAuthor() {

        return hpAuthor;
    }

    public void setHpAuthor(JSONArray hpAuthor) {
        this.hpAuthor = hpAuthor;
    }
}
