package com.altanyesilkurtgmail.myapplication;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class MainActivity extends AppCompatActivity {
    ImageView image;
    ImageView image2;
    Button rotate;
    Button rLeft;
    Button resize;
    Button crop;
  Button gauss;
Button canny;
    Button sobel;
Button medyan;
    Button average;
    Button laplacian;

    private Bitmap bmp;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.loadLibrary("opencv_java3");


        image = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView3);
        rotate = (Button) findViewById(R.id.button);
        resize = (Button) findViewById(R.id.button1);
        crop = (Button) findViewById(R.id.button2);
        rLeft= (Button) findViewById(R.id.button3);
        gauss = (Button) findViewById(R.id.button17);
        medyan=(Button)  findViewById(R.id.button18);
        average=(Button)  findViewById(R.id.button19);
        canny=(Button)  findViewById(R.id.button24);
        sobel=(Button)  findViewById(R.id.button25);
        laplacian=(Button)findViewById(R.id.button26);


        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.c);
                image.setRotation(image.getRotation() + 10);
                image.setImageResource(R.drawable.c);


            }
        });


        rLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.c);
                image.setRotation(image.getRotation() - 10);
                image.setImageResource(R.drawable.c);
            }
        });

        resize.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.c);

                        Mat rgbMat = new Mat(bitmap1.getWidth(), bitmap1.getHeight(), CvType.CV_8UC4);
                       Mat gryMat = new Mat();
                       Utils.bitmapToMat(bitmap1, rgbMat);
                       Imgproc.cvtColor(rgbMat, gryMat, Imgcodecs.IMREAD_COLOR);
                       int nHeight =100;
                        int nWidth  = 100;
                        Mat mat_template = new Mat(nHeight, nWidth, CvType.CV_8UC1);
                       Imgproc.resize(gryMat, mat_template, new Size(nWidth, nHeight));
                      Bitmap bitmap = Bitmap.createBitmap(
                           nHeight, nWidth,
                        Bitmap.Config.ARGB_8888);
                Imgproc.resize(gryMat, mat_template, new Size(nWidth, nHeight));
                Utils.matToBitmap(mat_template,bitmap);
                image.setImageBitmap(bitmap);
            }
        });


        crop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.c);
              Bitmap a=resizeAndCropCenter(bmp,100,true);
                image.setImageBitmap(a);


            }
        });


        gauss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.c);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();

                // Converting the image from color to Gray
                Imgproc.cvtColor(srcMat, gray, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.GaussianBlur(gray, edges, new Size(45, 45), 0);
                Bitmap bitmap = Bitmap.createBitmap(
                        bmp.getWidth(), bmp.getHeight(),
                        Bitmap.Config.ARGB_8888);
                Imgproc.GaussianBlur(gray, edges,new Size(3,3),2);

                Utils.matToBitmap(edges, bitmap);
                image.setImageBitmap(bitmap);
            }
        });

        medyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.c);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();

                // Converting the image from color to Gray
                Imgproc.cvtColor(srcMat, gray, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.medianBlur(gray, edges,15);
                Bitmap bitmap = Bitmap.createBitmap(
                        bmp.getWidth(), bmp.getHeight(),
                        Bitmap.Config.ARGB_8888);

                Utils.matToBitmap(edges, bitmap);
                image.setImageBitmap(bitmap);
            }
        });
        average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.c);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                int width = bmp.getWidth();
                int height = bmp.getHeight();
                int[] pixels = new int[width * height];
                bmp.getPixels(pixels, 0, width, 0, 0, width, height);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();
                Size size = new Size(45, 45);
                Point point = new Point(20, 30);


                // Converting the image from color to Gray
               Imgproc.cvtColor(srcMat, gray,Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.blur(gray, edges,size, point, Core.BORDER_DEFAULT);
                Bitmap bitmap = Bitmap.createBitmap(
                        bmp.getWidth(), bmp.getHeight(),
                        Bitmap.Config.ARGB_8888);

                Utils.matToBitmap(edges, bitmap);

                image.setImageBitmap(bitmap);
            }
        });

    canny.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.c);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();

                // Converting the image from color to Gray
                Imgproc.cvtColor(srcMat, gray, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.Canny(gray, edges, 60, 60 * 3);

                Bitmap bitmap = Bitmap.createBitmap(
                        bmp.getWidth(), bmp.getHeight(),
                        Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(edges, bitmap);

            image.setImageBitmap(bitmap);
        }
    });

         sobel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.c);
            Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

            Utils.bitmapToMat(bmp, srcMat);
            Mat gray = new Mat();

            Imgproc.cvtColor(srcMat, gray, Imgcodecs.IMREAD_COLOR);
            Mat edges = new Mat();
            Imgproc.Sobel(gray, edges,-1,2,1);

            Bitmap bitmap = Bitmap.createBitmap(
                    bmp.getWidth(), bmp.getHeight(),
                    Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(edges, bitmap);
            image.setImageBitmap(bitmap);

        }
    });
        laplacian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.c);
                Mat srcMat5 = new Mat(bmp5.getHeight(), bmp5.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp5, srcMat5);
                Mat filter = new Mat();
                Imgproc.cvtColor(srcMat5,filter, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.Laplacian(filter,edges,-1);
                Bitmap bittmap=Bitmap.createBitmap(bmp5.getWidth(),bmp5.getHeight(),Bitmap.Config.ARGB_8888);

                Utils.matToBitmap(edges,bittmap);
                image.setImageBitmap(bittmap);




            }
        });


}

    private Bitmap JPGtoRGB888(Bitmap img) {
        Bitmap result = null;

        int numPixels = img.getWidth() * img.getHeight();
        int[] pixels = new int[numPixels];

//        Jpeg pikselleri elde edin, her int bir piksele ait renk değeridir
        img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

//      Uygun biçimde bitmap oluştur
        result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);

//       Renkleri piksellere set et
        result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());

        return result;
    }

    public static Bitmap applyGaussianBlur(Bitmap src) {
        double[][] GaussianBlurConfig = new double[][]{
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };
        ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
        convMatrix.applyConfig(GaussianBlurConfig);
        convMatrix.Factor = 30;
        convMatrix.Offset = 0;
        return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);
    }


    public static Bitmap applyHueFilter(Bitmap source, int level) {
        // get image size
        int width = source.getWidth();
        int height = source.getHeight();
        int[] pixels = new int[width * height];
        float[] HSV = new float[3];
        // get pixel array from source
        source.getPixels(pixels, 0, width, 0, 0, width, height);

        int index = 0;
        // iteration through pixels
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                // get current index in 2D-matrix
                index = y * width + x;
                // convert to HSV
                Color.colorToHSV(pixels[index], HSV);
                // increase Saturation level
                HSV[0] *= level;
                HSV[0] = (float) Math.max(0.0, Math.min(HSV[0], 360.0));
                // take color back
            }       pixels[index] |= Color.HSVToColor(HSV);

        }
        // output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmOut.setPixels(pixels, 0, width, 0, 0, width, height);

        return bmOut;
    }

    public static Bitmap resizeAndCropCenter(Bitmap bitmap, int size, boolean recycle) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        if (w == size && h == size) return bitmap;
        // scale the image so that the shorter side equals to the target;
        // the longer side will be center-cropped.
        float scale = (float) size / Math.min(w,  h);
        Bitmap target = Bitmap.createBitmap(size, size, getConfig(bitmap));
        int width = Math.round(scale * bitmap.getWidth());
        int height = Math.round(scale * bitmap.getHeight());
        Canvas canvas = new Canvas(target);
        canvas.translate((size - width) / 2f, (size - height) / 2f);
        canvas.scale(scale, scale);
        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        if (recycle) bitmap.recycle();
        return target;
    }

    private static Bitmap.Config getConfig(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return config;
    }


    }
