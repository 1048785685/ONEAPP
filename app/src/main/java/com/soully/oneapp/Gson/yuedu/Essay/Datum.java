package com.soully.oneapp.Gson.yuedu.Essay;

/**
 * Created by amanda on 2017/2/16.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("content_id")
    @Expose
    private String contentId;
    @SerializedName("hp_title")
    @Expose
    private String hpTitle;
    @SerializedName("hp_makettime")
    @Expose
    private String hpMakettime;
    @SerializedName("guide_word")
    @Expose
    private String guideWord;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("author")
    @Expose
    private List<Author> author = null;
    @SerializedName("has_audio")
    @Expose
    private Boolean hasAudio;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList> authorList = null;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getHpTitle() {
        return hpTitle;
    }

    public void setHpTitle(String hpTitle) {
        this.hpTitle = hpTitle;
    }

    public String getHpMakettime() {
        return hpMakettime;
    }

    public void setHpMakettime(String hpMakettime) {
        this.hpMakettime = hpMakettime;
    }

    public String getGuideWord() {
        return guideWord;
    }

    public void setGuideWord(String guideWord) {
        this.guideWord = guideWord;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Boolean getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public List<AuthorList> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList> authorList) {
        this.authorList = authorList;
    }

}
