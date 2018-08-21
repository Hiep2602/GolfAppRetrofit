package com.example.hieph.golfappretrofit.model;

import android.os.Parcel;
import android.support.annotation.NonNull;

import com.example.hieph.golfappretrofit.asymmetricgridview.AsymmetricItem;


/**
 * Created by hieph on 8/20/2018.
 */

public class DemoItem implements AsymmetricItem {
    private int columnSpan;
    private int rowSpan;
    private int position;
    private String image;

    public DemoItem(int columnSpan, int rowSpan, int position,String image) {
        this.columnSpan = columnSpan;
        this.rowSpan = rowSpan;
        this.position = position;
    }

//  public DemoItem(Parcel in) {
//    readFromParcel(in);
//  }

    @Override public int getColumnSpan() {
        return columnSpan;
    }

    @Override public int getRowSpan() {
        return rowSpan;
    }

    @Override
    public String getImgae() {
        return image;
    }

    public int getPosition() {
        return position;
    }

    @Override public String toString() {
        return String.format("%s: %sx%s%s", position, rowSpan, columnSpan,image);
    }

    @Override public int describeContents() {
        return 0;
    }

//  private void readFromParcel(Parcel in) {
//    columnSpan = in.readInt();
//    rowSpan = in.readInt();
//    position = in.readInt();
//  }

    @Override public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(columnSpan);
        dest.writeInt(rowSpan);
        dest.writeInt(position);
        dest.writeString(image);
    }

  /* Parcelable interface implementation */
//  public static final Parcelable.Creator<DemoItem> CREATOR = new Parcelable.Creator<DemoItem>() {
//    @Override public DemoItem createFromParcel(@NonNull Parcel in) {
//      return new DemoItem(in);
//    }

//    @Override @NonNull public DemoItem[] newArray(int size) {
//      return new DemoItem[size];
//    }
//  };
}

