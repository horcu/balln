package com.horcu.apps.balln.views;

import java.util.ArrayList;

public interface ListingsView<T> extends BaseView {
    void addItem(T item);

    void addItems(ArrayList<T> items);

    void clearItems();
}
