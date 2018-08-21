package com.example.hieph.golfappretrofit.asymmetricgridview;

import android.os.Parcelable;

public interface AsymmetricItem extends Parcelable {
  int getColumnSpan();
  int getRowSpan();
  String getImgae();
}
