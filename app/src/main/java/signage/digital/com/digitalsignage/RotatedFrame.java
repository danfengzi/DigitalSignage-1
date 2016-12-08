package signage.digital.com.digitalsignage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Alexandre on 21/11/2016.
 */

public class RotatedFrame extends FrameLayout {

    public RotatedFrame(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RotatedFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotatedFrame(Context context) {
        super(context);
        init();
    }

    @SuppressLint("NewApi")
    private void init() {
        setPivotX(0);
        setPivotY(0);
        setRotation(-90f);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        //setTranslationX(getMeasuredHeight());
        setTranslationX(0);
        setTranslationY(getMeasuredWidth());
    }
}