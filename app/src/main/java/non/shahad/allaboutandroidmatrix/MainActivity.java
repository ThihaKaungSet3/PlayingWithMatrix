package non.shahad.allaboutandroidmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MatrixX";
    private ImageView mImageView;
    // d means Drawable
    private  int dWidth;
    private  int dHeight;

    // v means View
    private  int vWidth;
    private  int vHeight;

    private Matrix imageMatrix;
    private Matrix original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.img);
        original = mImageView.getImageMatrix();
        mutateImageMatrix();
        init();

    }


    private void init(){
        dWidth = mImageView.getDrawable().getIntrinsicWidth();
        dHeight = mImageView.getDrawable().getIntrinsicHeight();

        vWidth = mImageView.getMeasuredWidth();
        vHeight = mImageView.getMeasuredHeight();

        Log.i(TAG, "init: " + "dWidth= " + dWidth + "dHeight=" + dHeight + "vWidth=" + vWidth + "vHeight=" + vHeight );
    }

    private void translate(){
        imageMatrix.setTranslate(Math.round((vWidth - dWidth ) * 0.5f) ,Math.round((vHeight - dHeight) * 0.5f));
        mImageView.setImageMatrix(imageMatrix);
    }

    private void scale(){
//        imageMatrix.setScale(0.5f,0.5f,dWidth/2f,dHeight/2f);
        imageMatrix.setScale(0.5f,0.5f);
        mImageView.setImageMatrix(imageMatrix);


    }

    private void rotate(){
        imageMatrix.setRotate(30f,dWidth / 2f,dHeight / 2f);
        mImageView.setImageMatrix(imageMatrix);
    }

    private void skew(){
        imageMatrix.setSkew(1f,0f,dWidth / 2f, dHeight / 2f);
        mImageView.setImageMatrix(imageMatrix);
    }

    private void backToNormal(){
        mImageView.setImageMatrix(original);
    }

    void mutateImageMatrix(){
        imageMatrix = mImageView.getImageMatrix();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.translate : translate();
                break;
            case R.id.rotate: rotate();
                break;
            case R.id.scale: scale();
                break;
            case R.id.skew: skew();
                break;
            case R.id.original: backToNormal();
        }
    }
}
