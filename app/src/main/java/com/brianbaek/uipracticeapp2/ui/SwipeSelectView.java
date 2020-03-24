package com.brianbaek.uipracticeapp2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.brianbaek.uipracticeapp2.R;

public class SwipeSelectView extends ViewGroup {
    BaseAdapter baseAdapter;

    private int visibleViewCount;
    private int curPos;
    private int baseLine;

    public SwipeSelectView(Context context) {
        super(context);
    }

    public SwipeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeSelectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SwipeSelectView);

        visibleViewCount = typedArray.getInt(R.styleable.SwipeSelectView_visibleViewCount, 3);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


    }

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

//        public LayoutParams(MarginLayoutParams source) {
//            super(source);
//        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.baseAdapter = baseAdapter;

    }
}
