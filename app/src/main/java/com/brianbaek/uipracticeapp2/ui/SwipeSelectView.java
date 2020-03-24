package com.brianbaek.uipracticeapp2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.brianbaek.uipracticeapp2.R;

public class SwipeSelectView extends ViewGroup {
    BaseAdapter baseAdapter;

    GestureDetector mGestureDetector;

    private int visibleViewCount;
    private int curPos;
    private int baseLine;

    private DataSetObserver mDataSetObserver;

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

        typedArray.recycle();
    }

    private void init(Context context) {
        mDataSetObserver = new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }
        };

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.UNSPECIFIED:

                width = widthMeasureSpec;

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.EXACTLY:
                width = w;
                break;
        }

        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.UNSPECIFIED:

                height = heightMeasureSpec;

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.EXACTLY:
                height = h;
                break;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);
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
        if (this.baseAdapter != null)
            this.baseAdapter.unregisterDataSetObserver(mDataSetObserver);

        this.baseAdapter = baseAdapter;
        this.baseAdapter.registerDataSetObserver(mDataSetObserver);
    }


}
