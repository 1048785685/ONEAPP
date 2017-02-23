package com.soully.oneapp.Gson.Tianqi.Gson;

/**
 * Created by Soully on 2017/2/9.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Gson {

    @SerializedName("HeWeather5")
    @Expose
    private List<HeWeather5> heWeather5 = null;

    public List<HeWeather5> getHeWeather5() {
        return heWeather5;
    }

    public void setHeWeather5(List<HeWeather5> heWeather5) {
        this.heWeather5 = heWeather5;
    }

}