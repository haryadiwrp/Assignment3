package com.hacktiv8.assignment3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

public class CovidCases {

    @SerializedName("cases")
    @Expose
    private String totalCases;

    @SerializedName("recovered")
    @Expose
    private  String totalRecovery;

    @SerializedName("deaths")
    @Expose
    private  String totalDeaths;

    public String getTotalCases() {
        return  totalCases;
    }

    public String getTotalRecovery() {
        return totalRecovery;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalCases(CovidCases covidCases) {
        this.totalCases = totalCases;
    }

    public void setTotalRecovery(CovidCases covidCases) {
        this.totalRecovery = totalRecovery;
    }

    public void setTotalDeaths(CovidCases covidCases) {
        this.totalDeaths = totalDeaths;
    }
}
