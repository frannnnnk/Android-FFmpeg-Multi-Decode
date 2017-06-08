package com.vonchenchen.android_video_demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.vonchenchen.android_video_demos.codec.CodecWrapper;
import com.vonchenchen.android_video_demos.codec.FrameRender;

import java.io.File;
import java.io.InputStream;

import static java.lang.System.currentTimeMillis;

public class MainActivity extends BaseActivity {

    FrameRender mFrameRender;
    FrameRender mFrameRender1;
    FrameRender mFrameRender2;

    //private CodecWrapper mCodecWrapper;
    private SurfaceView mTestSurface;
    private SurfaceHolder mHolder;

    //private CodecWrapper mCodecWrapper1;
    private SurfaceView mTestSurface1;
    private SurfaceHolder mHolder1;

    private SurfaceView mTestSurface2;
    private SurfaceHolder mHolder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestSurface = (SurfaceView) findViewById(R.id.sv_test);
        mHolder = mTestSurface.getHolder();

        mTestSurface1 = (SurfaceView) findViewById(R.id.sv_test1);
        mHolder1 = mTestSurface1.getHolder();

        mTestSurface2 = (SurfaceView) findViewById(R.id.sv_test2);
        mHolder2 = mTestSurface2.getHolder();

        String path = FileUtil.getFilePath(MainActivity.this);
        File dir = new File(path);
        dir.mkdirs();

        mFrameRender = new FrameRender(mHolder.getSurface());
        mFrameRender1 = new FrameRender(mHolder1.getSurface());
        mFrameRender2 = new FrameRender(mHolder2.getSurface());

        mHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test_decode(mFrameRender);
                    }
                });
                thread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        mHolder1.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test_decode(mFrameRender1);
                    }
                });
                thread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        mHolder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test_decode(mFrameRender2);
                    }
                });
                thread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }

    private void test_decode(FrameRender frameRender){

        InputStream inputStream = getResources().openRawResource(R.raw.video_data);
        //InputStream inputStream = getResources().openRawResource(R.raw.ds);
        //InputStream inputStream = getResources().openRawResource(R.raw.cuc_ieschool);
        byte[] buffer = new byte[1024*8];

        //FrameRender frameRender = new FrameRender(mHolder.getSurface());

        int len;
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                long start = System.currentTimeMillis();
                frameRender.decodeStream(buffer, len);
                long end = System.currentTimeMillis();
                Log.i("mCodecWrapper", "spend "+(end-start));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
