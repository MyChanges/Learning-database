package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * Created by haiwang on 2017/7/10.
 */

public class CheckableRelativeLayout extends RelativeLayout implements Checkable{

    private boolean mChecked;
    private static final int[]  CHECKED_STATE_SET = {android.R.attr.state_checked};

    public CheckableRelativeLayout(Context context) {
        super(context);
    }

    public CheckableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean performClick() {
//        setChecked(true);
//        return super.performClick();
//    }

    @Override
    public void setChecked(boolean checked) {
        if(mChecked != checked){
            mChecked = checked;
            refreshDrawableState();
        }
    }

    @Override
    protected int[] onCreateDrawableState(final int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace+1);
        if(isChecked())
            mergeDrawableStates(drawableState,CHECKED_STATE_SET);
        return drawableState;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable drawable = getBackground();
        if(drawable != null) {
            final int[] myDrawableState = getDrawableState();
            drawable.setState(myDrawableState);
            invalidate();
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    static class SaveState extends BaseSavedState {
        boolean checked;

        public SaveState(Parcel in) {
            super(in);
            checked = (Boolean) in.readValue(null);
        }

        public SaveState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeValue(checked);
        }

        public static final Parcelable.Creator<SaveState> CREATOR = new Creator<CheckableRelativeLayout.SaveState>() {

            @Override
            public SaveState[] newArray(int size) {
                return new SaveState[size];
            }

            @Override
            public SaveState createFromParcel(Parcel source) {
                return createFromParcel(source);
            }
        };
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superParcelable = super.onSaveInstanceState();
        SaveState ss = new SaveState(superParcelable);
        ss.checked = isChecked();
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SaveState ss = (SaveState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
    }

}
