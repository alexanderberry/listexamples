package com.example.berry.listexamples;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by per6 on 9/27/17.
 */
public class SuperHero implements Parcelable, Comparable<SuperHero> {
    private String name;
    private String description;
    public int resourceId;
    private int ranking;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public SuperHero(String name, String description, int resourceId) {
        this.name = name;
        this.description = description;
        this.resourceId = resourceId;
    }

    public SuperHero(String name, String description, int ranking, int resourceId) {
        this.name = name;
        this.description = description;
        this.resourceId = resourceId;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return name;
    }

    protected SuperHero(Parcel in) {
        name = in.readString();
        description = in.readString();
        resourceId = in.readInt();
        ranking = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(resourceId);
        dest.writeInt(ranking);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SuperHero> CREATOR = new Parcelable.Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

    @Override
    public int compareTo(@NonNull SuperHero other) {
        return this.ranking - other.ranking;
    }
}