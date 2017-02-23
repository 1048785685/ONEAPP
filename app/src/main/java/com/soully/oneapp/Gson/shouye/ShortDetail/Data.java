package com.soully.oneapp.Gson.shouye.ShortDetail;

/**
 * Created by amanda on 2017/2/16.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("content_id")
    @Expose
    private String contentId;
    @SerializedName("hp_title")
    @Expose
    private String hpTitle;
    @SerializedName("sub_title")
    @Expose
    private String subTitle;
    @SerializedName("hp_author")
    @Expose
    private String hpAuthor;
    @SerializedName("auth_it")
    @Expose
    private String authIt;
    @SerializedName("hp_author_introduce")
    @Expose
    private String hpAuthorIntroduce;
    @SerializedName("hp_content")
    @Expose
    private String hpContent;
    @SerializedName("hp_makettime")
    @Expose
    private String hpMakettime;
    @SerializedName("hide_flag")
    @Expose
    private String hideFlag;
    @SerializedName("wb_name")
    @Expose
    private String wbName;
    @SerializedName("wb_img_url")
    @Expose
    private String wbImgUrl;
    @SerializedName("last_update_date")
    @Expose
    private String lastUpdateDate;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("guide_word")
    @Expose
    private String guideWord;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("anchor")
    @Expose
    private String anchor;
    @SerializedName("editor_email")
    @Expose
    private String editorEmail;
    @SerializedName("top_media_type")
    @Expose
    private String topMediaType;
    @SerializedName("top_media_file")
    @Expose
    private String topMediaFile;
    @SerializedName("top_media_image")
    @Expose
    private String topMediaImage;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("author")
    @Expose
    private List<Author> author = null;
    @SerializedName("maketime")
    @Expose
    private String maketime;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList> authorList = null;
    @SerializedName("next_id")
    @Expose
    private Integer nextId;
    @SerializedName("previous_id")
    @Expose
    private String previousId;
    @SerializedName("tag_list")
    @Expose
    private List<Object> tagList = null;
    @SerializedName("share_list")
    @Expose
    private ShareList shareList;
    @SerializedName("praisenum")
    @Expose
    private Integer praisenum;
    @SerializedName("sharenum")
    @Expose
    private Integer sharenum;
    @SerializedName("commentnum")
    @Expose
    private Integer commentnum;

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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getHpAuthor() {
        return hpAuthor;
    }

    public void setHpAuthor(String hpAuthor) {
        this.hpAuthor = hpAuthor;
    }

    public String getAuthIt() {
        return authIt;
    }

    public void setAuthIt(String authIt) {
        this.authIt = authIt;
    }

    public String getHpAuthorIntroduce() {
        return hpAuthorIntroduce;
    }

    public void setHpAuthorIntroduce(String hpAuthorIntroduce) {
        this.hpAuthorIntroduce = hpAuthorIntroduce;
    }

    public String getHpContent() {
        return hpContent;
    }

    public void setHpContent(String hpContent) {
        this.hpContent = hpContent;
    }

    public String getHpMakettime() {
        return hpMakettime;
    }

    public void setHpMakettime(String hpMakettime) {
        this.hpMakettime = hpMakettime;
    }

    public String getHideFlag() {
        return hideFlag;
    }

    public void setHideFlag(String hideFlag) {
        this.hideFlag = hideFlag;
    }

    public String getWbName() {
        return wbName;
    }

    public void setWbName(String wbName) {
        this.wbName = wbName;
    }

    public String getWbImgUrl() {
        return wbImgUrl;
    }

    public void setWbImgUrl(String wbImgUrl) {
        this.wbImgUrl = wbImgUrl;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getGuideWord() {
        return guideWord;
    }

    public void setGuideWord(String guideWord) {
        this.guideWord = guideWord;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getEditorEmail() {
        return editorEmail;
    }

    public void setEditorEmail(String editorEmail) {
        this.editorEmail = editorEmail;
    }

    public String getTopMediaType() {
        return topMediaType;
    }

    public void setTopMediaType(String topMediaType) {
        this.topMediaType = topMediaType;
    }

    public String getTopMediaFile() {
        return topMediaFile;
    }

    public void setTopMediaFile(String topMediaFile) {
        this.topMediaFile = topMediaFile;
    }

    public String getTopMediaImage() {
        return topMediaImage;
    }

    public void setTopMediaImage(String topMediaImage) {
        this.topMediaImage = topMediaImage;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getMaketime() {
        return maketime;
    }

    public void setMaketime(String maketime) {
        this.maketime = maketime;
    }

    public List<AuthorList> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList> authorList) {
        this.authorList = authorList;
    }

    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    public String getPreviousId() {
        return previousId;
    }

    public void setPreviousId(String previousId) {
        this.previousId = previousId;
    }

    public List<Object> getTagList() {
        return tagList;
    }

    public void setTagList(List<Object> tagList) {
        this.tagList = tagList;
    }

    public ShareList getShareList() {
        return shareList;
    }

    public void setShareList(ShareList shareList) {
        this.shareList = shareList;
    }

    public Integer getPraisenum() {
        return praisenum;
    }

    public void setPraisenum(Integer praisenum) {
        this.praisenum = praisenum;
    }

    public Integer getSharenum() {
        return sharenum;
    }

    public void setSharenum(Integer sharenum) {
        this.sharenum = sharenum;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

}