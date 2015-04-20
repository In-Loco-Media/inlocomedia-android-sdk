package com.inlocomedia.ads.sample.activities.util;

import java.io.Serializable;

import in.ubee.api.ads.AdType;

public class ListItem implements Serializable {

    private static final long serialVersionUID = -7594719657894342914L;

    private AdType adType;

    private ItemType type;

    public enum ItemType {
        HEADER, DISPLAY, INTERSTITIAL, NATIVE, DFP_MEDIATION, ADMOB_MEDIATION, MOPUB_MEDIATION, NOTIFICATION, FEED, AD_VIEW_USING_XML;
    }

    private String displayableString;

    public ListItem(String displayableString, ItemType type) {
        this.displayableString = displayableString;
        this.setType(type);
    }

    public ListItem(String displayableString, AdType adType, ItemType type) {
        this.displayableString = displayableString;
        this.adType = adType;
        this.setType(type);
    }

    public AdType getAdType() {
        return adType;
    }

    public void setAdType(AdType type) {
        this.adType = type;
    }

    public String getDisplayableString() {
        return displayableString;
    }

    public void setDisplayableString(String displayableString) {
        this.displayableString = displayableString;
    }

    @Override
    public String toString() {
        return displayableString.toString();
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
