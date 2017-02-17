package com.soully.oneapp.Gson.shouye.yuedi;

/**
 * Created by Soully on 2017/2/15.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("essay")
    @Expose
    private List<Essay> essay = null;
    @SerializedName("serial")
    @Expose
    private List<Serial> serial = null;
    @SerializedName("question")
    @Expose
    private List<Question> question = null;

    public List<Essay> getEssay() {
        return essay;
    }

    public void setEssay(List<Essay> essay) {
        this.essay = essay;
    }

    public List<Serial> getSerial() {
        return serial;
    }

    public void setSerial(List<Serial> serial) {
        this.serial = serial;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

}