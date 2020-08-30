package com.demo.makefirstpr_android;

import java.util.ArrayList;

public class Contributors {

    private ArrayList<String> ContributorList;

    public ArrayList<String> getContributorList() {
        return ContributorList;
    }

    public Contributors() {

        ContributorList = new ArrayList<>();

        //Add your GitHub Username here
        ContributorList.add("devsoftzz");
    }
}
