package com.horcu.apps.maura.widget.floatinglabel.instantpicker;

import android.content.Context;
import android.util.AttributeSet;


import com.horcu.apps.maura.R;

import java.text.DateFormat;

/**
 * A widget to pick one or more items from a list
 * <p/>
 * Created by Vincent Mimoun-Prat @ MarvinLabs, 28/08/2014.
 */
public class FloatingLabelTimePicker<TimeInstantT extends TimeInstant> extends FloatingLabelInstantPicker<TimeInstantT> {

    // =============================================================================================
    // Lifecycle
    // ==

    public FloatingLabelTimePicker(Context context) {
        super(context);
    }

    public FloatingLabelTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatingLabelTimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    // =============================================================================================
    // Overridden methods
    // ==


    @Override
    protected int getDefaultDrawableRightResId() {
        return R.drawable.ic_timepicker;
    }

    @Override
    protected InstantPrinter<TimeInstantT> getDefaultInstantPrinter() {
        return new JavaTimePrinter<TimeInstantT>(DateFormat.SHORT);
    }
}
