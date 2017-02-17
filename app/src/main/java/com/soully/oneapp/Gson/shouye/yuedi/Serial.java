package com.soully.oneapp.Gson.shouye.yuedi;

/**
 * Created by Soully on 2017/2/15.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Serial {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("serial_id")
    @Expose
    private String serialId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("excerpt")
    @Expose
    private String excerpt;
    @SerializedName("read_num")
    @Expose
    private String readNum;
    @SerializedName("maketime")
    @Expose
    private String maketime;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("author")
    @Expose
    private Author_ author;
    @SerializedName("has_audio")
    @Expose
    private Boolean hasAudio;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList_> authorList = null;
    @SerializedName("serial_list")
    @Expose
    private List<String> serialList = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    public String getMaketime() {
        return maketime;
    }

    public void setMaketime(String maketime) {
        this.maketime = maketime;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public Author_ getAuthor() {
        return author;
    }

    public void setAuthor(Author_ author) {
        this.author = author;
    }

    public Boolean getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public List<AuthorList_> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList_> authorList) {
        this.authorList = authorList;
    }

    public List<String> getSerialList() {
        return serialList;
    }

    public void setSerialList(List<String> serialList) {
        this.serialList = serialList;
    }

}