package com.soully.oneapp.Gson.shouye;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;

public class Data {

    @SerializedName("hpcontent_id")
    @Expose
    private String hpcontentId;
    @SerializedName("hp_title")
    @Expose
    private String hpTitle;
    @SerializedName("author_id")
    @Expose
    private String authorId;
    @SerializedName("hp_img_url")
    @Expose
    private String hpImgUrl;
    @SerializedName("hp_img_original_url")
    @Expose
    private String hpImgOriginalUrl;
    @SerializedName("hp_author")
    @Expose
    private String hpAuthor;
    @SerializedName("ipad_url")
    @Expose
    private String ipadUrl;
    @SerializedName("hp_content")
    @Expose
    private String hpContent;
    @SerializedName("hp_makettime")
    @Expose
    private String hpMakettime;
    @SerializedName("hide_flag")
    @Expose
    private String hideFlag;
    @SerializedName("last_update_date")
    @Expose
    private String lastUpdateDate;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("wb_img_url")
    @Expose
    private String wbImgUrl;
    @SerializedName("image_authors")
    @Expose
    private String imageAuthors;
    @SerializedName("text_authors")
    @Expose
    private String textAuthors;
    @SerializedName("image_from")
    @Expose
    private String imageFrom;
    @SerializedName("text_from")
    @Expose
    private String textFrom;
    @SerializedName("content_bgcolor")
    @Expose
    private String contentBgcolor;
    @SerializedName("template_category")
    @Expose
    private String templateCategory;
    @SerializedName("maketime")
    @Expose
    private String maketime;
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

    public String getHpcontentId() {
        return hpcontentId;
    }

    public void setHpcontentId(String hpcontentId) {
        this.hpcontentId = hpcontentId;
    }

    public String getHpTitle() {
        return hpTitle;
    }

    public void setHpTitle(String hpTitle) {
        this.hpTitle = hpTitle;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getHpImgUrl() {
        return hpImgUrl;
    }

    public void setHpImgUrl(String hpImgUrl) {
        this.hpImgUrl = hpImgUrl;
    }

    public String getHpImgOriginalUrl() {
        return hpImgOriginalUrl;
    }

    public void setHpImgOriginalUrl(String hpImgOriginalUrl) {
        this.hpImgOriginalUrl = hpImgOriginalUrl;
    }

    public String getHpAuthor() {
        return hpAuthor;
    }

    public void setHpAuthor(String hpAuthor) {
        this.hpAuthor = hpAuthor;
    }

    public String getIpadUrl() {
        return ipadUrl;
    }

    public void setIpadUrl(String ipadUrl) {
        this.ipadUrl = ipadUrl;
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

    public String getWbImgUrl() {
        return wbImgUrl;
    }

    public void setWbImgUrl(String wbImgUrl) {
        this.wbImgUrl = wbImgUrl;
    }

    public String getImageAuthors() {
        return imageAuthors;
    }

    public void setImageAuthors(String imageAuthors) {
        this.imageAuthors = imageAuthors;
    }

    public String getTextAuthors() {
        return textAuthors;
    }

    public void setTextAuthors(String textAuthors) {
        this.textAuthors = textAuthors;
    }

    public String getImageFrom() {
        return imageFrom;
    }

    public void setImageFrom(String imageFrom) {
        this.imageFrom = imageFrom;
    }

    public String getTextFrom() {
        return textFrom;
    }

    public void setTextFrom(String textFrom) {
        this.textFrom = textFrom;
    }

    public String getContentBgcolor() {
        return contentBgcolor;
    }

    public void setContentBgcolor(String contentBgcolor) {
        this.contentBgcolor = contentBgcolor;
    }

    public String getTemplateCategory() {
        return templateCategory;
    }

    public void setTemplateCategory(String templateCategory) {
        this.templateCategory = templateCategory;
    }

    public String getMaketime() {
        return maketime;
    }

    public void setMaketime(String maketime) {
        this.maketime = maketime;
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
