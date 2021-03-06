package com.example.hieph.golfappretrofit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

final class DemoUtils {
    int currentOffset;
    String currentoffer;
    DemoUtils() {
    }

    public List<DemoItem> moarItems(int qty) {
        List<DemoItem> items = new ArrayList<>();

        for (int i = 0; i < qty; i++) {
            int colSpan = Math.random() < 0.2f ? 2 : 1;
            // Swap the next 2 lines to have items with variable
            // column/row span.
            // int rowSpan = Math.random() < 0.2f ? 2 : 1;
            int rowSpan = colSpan;
            DemoItem item = new DemoItem(colSpan, rowSpan, currentOffset + i,currentoffer);
            items.add(item);
        }

        currentOffset += qty;

        return items;
    }

}
