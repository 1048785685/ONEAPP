package com.soully.oneapp.Gson.yingshi.ID;

/**
 * Created by Soully on 2017/2/19.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("verse")
    @Expose
    private String verse;
    @SerializedName("verse_en")
    @Expose
    private String verseEn;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("revisedscore")
    @Expose
    private String revisedscore;
    @SerializedName("releasetime")
    @Expose
    private String releasetime;
    @SerializedName("scoretime")
    @Expose
    private String scoretime;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList> authorList = null;
    @SerializedName("servertime")
    @Expose
    private Integer servertime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getVerseEn() {
        return verseEn;
    }

    public void setVerseEn(String verseEn) {
        this.verseEn = verseEn;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRevisedscore() {
        return revisedscore;
    }

    public void setRevisedscore(String revisedscore) {
        this.revisedscore = revisedscore;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getScoretime() {
        return scoretime;
    }

    public void setScoretime(String scoretime) {
        this.scoretime = scoretime;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<AuthorList> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList> authorList) {
        this.authorList = authorList;
    }

    public Integer getServertime() {
        return servertime;
    }

    public void setServertime(Integer servertime) {
        this.servertime = servertime;
    }

}