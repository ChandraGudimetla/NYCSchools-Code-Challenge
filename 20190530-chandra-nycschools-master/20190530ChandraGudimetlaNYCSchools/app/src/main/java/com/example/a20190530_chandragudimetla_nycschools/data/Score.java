package com.example.a20190530_chandragudimetla_nycschools.data;

import com.google.gson.annotations.SerializedName;

public class Score {
    //    dbn: "01M448",
//    num_of_sat_test_takers: "91",
//    sat_critical_reading_avg_score: "383",
//    sat_math_avg_score: "423",
//    sat_writing_avg_score: "366",

    private String dbn;
    @SerializedName("sat_critical_reading_avg_score")
    private String readingScore;
    @SerializedName("sat_math_avg_score")
    private String mathScore;
    @SerializedName("sat_writing_avg_score")
    private String writingScore;

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(String readingScore) {
        this.readingScore = readingScore;
    }

    public String getMathScore() {
        return mathScore;
    }

    public void setMathScore(String mathScore) {
        this.mathScore = mathScore;
    }

    public String getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(String writingScore) {
        this.writingScore = writingScore;
    }
}
