package com.soully.oneapp.Gson.shouye.yuedi;

/**
 * Created by Soully on 2017/2/15.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("question_id")
    @Expose
    private String questionId;
    @SerializedName("question_title")
    @Expose
    private String questionTitle;
    @SerializedName("answer_title")
    @Expose
    private String answerTitle;
    @SerializedName("answer_content")
    @Expose
    private String answerContent;
    @SerializedName("question_makettime")
    @Expose
    private String questionMakettime;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList__> authorList = null;
    @SerializedName("asker_list")
    @Expose
    private List<AskerList> askerList = null;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getQuestionMakettime() {
        return questionMakettime;
    }

    public void setQuestionMakettime(String questionMakettime) {
        this.questionMakettime = questionMakettime;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public List<AuthorList__> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList__> authorList) {
        this.authorList = authorList;
    }

    public List<AskerList> getAskerList() {
        return askerList;
    }

    public void setAskerList(List<AskerList> askerList) {
        this.askerList = askerList;
    }

}
