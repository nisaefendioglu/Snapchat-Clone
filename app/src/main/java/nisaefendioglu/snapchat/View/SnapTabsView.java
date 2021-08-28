
package nisaefendioglu.snapchat.View;


import android.animation.ArgbEvaluator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import nisaefendioglu.snapchat.Fragment.Settings;
import nisaefendioglu.snapchat.R;

public class SnapTabsView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private ImageView mCapturePhotoBtn;
    private ImageView mChatBtn;
    private ImageView mStoryBtn,settings;
    private View mIndicator;

    private float mCenterTranslationY;
    private float mTranslationY;
    private float mIndicatorTranslationX;
    private float mEndViewsTranslationX;

    private int mCenterColor;
    private int mOffsetColor;
    private ArgbEvaluator mColorEval;


    public SnapTabsView(@NonNull Context context) {
        this(context, null);
    }

    public SnapTabsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnapTabsView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_snap_tabs,this,true);

        mCapturePhotoBtn =   findViewById(R.id.capture_photo_btn);
        mChatBtn =  findViewById(R.id.chat_btn);
        mStoryBtn =   findViewById(R.id.story_btn);
        settings = findViewById(R.id.settings);

        final int centerPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 122,
                getContext().getResources().getDisplayMetrics());



        mCapturePhotoBtn.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                mCenterTranslationY = getHeight() - mCapturePhotoBtn.getBottom();
                float distanceBetween = mCapturePhotoBtn.getX() - mChatBtn.getX();
                mEndViewsTranslationX = distanceBetween - centerPadding;
                mTranslationY =  getHeight() - mChatBtn.getBottom();
                mIndicatorTranslationX = centerPadding;

                mCapturePhotoBtn.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            }

        });

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(position == 0) {
            setUpViews(
                    1 - positionOffset,
                    .7f + (positionOffset * .3f),
                    (1 - positionOffset) * mCenterTranslationY,
                    -mIndicatorTranslationX * (1-positionOffset)
            );
        }
        else if(position == 1) {
            setUpViews(
                    positionOffset,
                    .7f + ((1 - positionOffset) * .3f),
                    positionOffset * mCenterTranslationY,
                    mIndicatorTranslationX * positionOffset
            );
        }
    }

    private void setUpViews(float fractionFromCenter, float centerScale, float centerTransY, float indicatorTransX) {
        mIndicator.setAlpha(fractionFromCenter);
        mIndicator.setScaleX(fractionFromCenter);

        mChatBtn.setTranslationX(-mEndViewsTranslationX * fractionFromCenter);
        mStoryBtn.setTranslationX(mEndViewsTranslationX * fractionFromCenter);

        mCapturePhotoBtn.setScaleX(centerScale);
        mCapturePhotoBtn.setScaleY(centerScale);

        mCapturePhotoBtn.setTranslationY(centerTransY);
        mChatBtn.setTranslationY(mTranslationY-50);
        mStoryBtn.setTranslationY(mTranslationY-50);

        mIndicator.setTranslationX(indicatorTransX);

    }


    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}