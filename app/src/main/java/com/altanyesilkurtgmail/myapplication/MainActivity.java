package com.altanyesilkurtgmail.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.opencv.core.Core.split;
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
    Button kamera;
    Button histogram;
    Button atresh;
    Button tresh;
    Button otsu;
    Button islem;
    Button deneme;

    Button deneme2;
    Button deneme3;
    Button deneme4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.loadLibrary("opencv_java3");

        image = (ImageView) findViewById(R.id.imageView);
        //image2 = (ImageView) findViewById(R.id.imageView3);
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
        kamera=(Button)findViewById(R.id.button4);
         histogram=(Button)findViewById(R.id.button5) ;
        atresh=(Button)findViewById(R.id.button6);
        tresh=(Button)findViewById(R.id.button7);
        otsu=(Button)findViewById(R.id.button8);
        islem = (Button)findViewById(R.id.button9) ;
        deneme= (Button)findViewById(R.id.button76);
        deneme2=(Button)findViewById(R.id.button77);
deneme3=(Button)findViewById(R.id.button78);

deneme4=(Button)findViewById(R.id.button79);


        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a532);
                Mat rgba = new Mat(bitmap.getWidth(), bitmap.getHeight(), CvType.CV_8UC4);
                Utils.bitmapToMat(bitmap, rgba);
                Imgproc.resize(rgba,rgba,new Size(1022,767));
                Mat gray = new Mat();
                Imgproc.cvtColor(rgba, gray, Imgproc.COLOR_BGR2GRAY);
                int[] fn = {1,2,4,8,16,32,64,128};
                 int[] Table = {
                         0,1,2,3,4,58,5,6,7,58,58,58,8,58,9,10,11,58,58,58,58,58,58,58,12,58,58,58,
                         13,58,
                         14,15,16,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,17,58,58,58,58,58,58
                        ,58,18,
                         58,58,58,19,58,20,21,22,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58
                        ,58,58,
                         58,58,58,58,58,58,58,58,58,58,58,58,23,58,58,58,58,58,58,58,58,58,58,58,58
                        ,58,
                         58,58,24,58,58,58,58,58,58,58,25,58,58,58,26,58,27,28,29,30,58,31,58,58,58
                        ,32,58,
                         58,58,58,58,58,58,33,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,34,58,58
                        ,58,58,
                         58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58,58
                        ,58,
                         58,35,36,37,58,38,58,58,58,39,58,58,58,58,58,58,58,40,58,58,58,58,58,58,58
                        ,58,58,
                         58,58,58,58,58,58,41,42,43,58,44,58,58,58,45,58,58,58,58,58,58,58,46,47,48
                        ,58,49,
                         58,58,58,50,51,52,58,53,54,55,56,57 };
                double [] hist=new double[59];
                List<Double> ar = new ArrayList<Double>();
                for (int k = 0; k < 59; k++) {
                    for (int i = 1; i < gray.rows() - 1; i++) {
                        for (int j = 1; j < gray.cols() - 1; j++) {
                            double[] center1 = gray.get(i, j);
                            int x1 = (int) center1[0];
                            int[] lbparr1 = lbpArray(gray, i, j, x1);
                            int a = malbp(lbparr1, fn);
                            hist[Table[a]]++;

                        }
                    }
                    ar.add( hist[k]);
                }*/
                //  System.out.println("ar");


                //double train[][]=satir;


                double dist = 999999999;
                int z = 0;
                int value = 2;

                double[] kiyas = {100157, 22910, 39357, 48028, 57305, 70548, 98805, 77296, 104004, 121110, 139095, 138636, 153881, 225148, 210435, 171536, 220133, 216990, 253080, 303560, 118545, 89144, 263649, 285696, 361775, 345514, 305019, 107660, 115333, 295380, 361522, 433632, 437547, 215696, 178465, 66996, 442483, 630800, 590577, 456520, 200613, 256830, 548035, 624008, 270450, 178572, 77409, 645408, 557522, 208800, 218280, 343876, 272791, 95904, 277035, 345016, 99180, 845466, 7200655};


                List<String> array = new ArrayList<>();
                try {
                    InputStream is = getResources().openRawResource(R.raw.train);
                    InputStreamReader isr = new InputStreamReader(is, Charset.forName("ISO-8859-9"));
                    BufferedReader bf = new BufferedReader(isr);
                    String line = bf.readLine();

                    while (line != null) {
                        array.add(line);
                        line = bf.readLine();
                    }
                    bf.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (int l = 0 ;l < array.size(); l++) {

                    double totalDist = 0;
                    String line = array.get(l);
                    String[] parts = line.split(",\\s*");
                    int[] ints= new int[parts.length];



                    for (int i = 0; i < parts.length; i++) {

                        try {
                            ints[i] = Integer.valueOf(parts[i]);
                            Integer.parseInt(parts[i]);
                            z = ints[59];
                        } catch (NumberFormatException e) {
                            e.printStackTrace();

                        }

                    }

                    for (int j = 0; j < 59; j++) {

                        if (ints[j] >= kiyas[j]) {

                            double x = Math.sqrt(Math.pow(ints[j], 2) - Math.pow(kiyas[j], 2));
                            x = Math.floor(x);
                            totalDist = totalDist + x;
                        } else {

                            double x = Math.sqrt(Math.abs(Math.pow(ints[j], 2) - Math.pow(kiyas[j], 2)));
                            x = Math.floor(x);
                            totalDist = totalDist + x;
                        }

                    }

                    if (totalDist < dist) {
                        dist = totalDist;
                        value = z;

                    }
                }
                if(value==0)

                {
                    System.out.println("benign");
                }
                else if(value==1)

                {
                    System.out.println("malign");
                }
                else

                {
                    System.out.println("aaa");
                }
            }
        });

          rLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat rgba = new Mat(bitmap.getWidth(), bitmap.getHeight(), CvType.CV_8UC4);
                Utils.bitmapToMat(bitmap,rgba);
                Size rgbaSize = rgba.size();
                int histSize = 150;
                MatOfInt histogramSize = new MatOfInt(histSize);
                int histogramHeight = (int) rgbaSize.height;
                int binWidth = 5;
                MatOfFloat histogramRange = new MatOfFloat(0f, 256f);

                Scalar[] colorsRgb = new Scalar[]{new Scalar(200, 0, 0, 255), new Scalar(0, 200, 0, 255), new Scalar(0, 0, 200, 255)};
                MatOfInt[] channels = new MatOfInt[]{new MatOfInt(0), new MatOfInt(1), new MatOfInt(2)};

                Mat[] histograms = new Mat[]{new Mat(), new Mat(), new Mat()};
                Mat histMatBitmap = new Mat(rgbaSize, rgba.type());

                for (int i = 0; i < channels.length; i++) {
                    Imgproc.calcHist(Collections.singletonList(rgba), channels[i], new Mat(), histograms[i], histogramSize, histogramRange);
                    Core.normalize(histograms[i], histograms[i], histogramHeight, 0, Core.NORM_INF);
                    for (int j = 0; j < histSize; j++) {

                        Point p1 = new Point(binWidth * (j - 1), histogramHeight - Math.round(histograms[i].get(j - 1, 0)[0]));
                        Point p2 = new Point(binWidth * j, histogramHeight - Math.round(histograms[i].get(j, 0)[0]));
                        Imgproc.line(histMatBitmap, p1, p2, colorsRgb[i], 2, 8, 0);

                    }
                    for (int j = 0; j < histSize; j++) {
                        Point p1 = new Point(binWidth * (j - 1), histogramHeight - Math.round(histograms[i].get(j - 1, 0)[0]));
                        Point p2 = new Point(binWidth * j, histogramHeight - Math.round(histograms[i].get(j, 0)[0]));
                        Imgproc.line(histMatBitmap, p1, p2, colorsRgb[i], 2, 8, 0);

                    }

                }

                Bitmap histBitmap = Bitmap.createBitmap(histMatBitmap.cols(), histMatBitmap.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(histMatBitmap, histBitmap);
                image.setImageBitmap(histBitmap);
               }
           });

        resize.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat image = new Mat(bitmap.getWidth(), bitmap.getHeight(), CvType.CV_8UC4);
                Utils.bitmapToMat(bitmap,image);
                Imgproc.resize(image,image,new Size(1022,767));
                System.out.println("Coverting the image to grayscale");
                List<Mat> mv = new ArrayList<Mat>();
                split(image, mv);
                Mat channel1 = mv.get(0);
                Mat channel2 = mv.get(1);
                Mat channel3 = mv.get(2);
                System.out.println("Image is split into three channels.");
                int[] fn = weighingfunc();
                Mat malbp1 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat malbp2 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat malbp3 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat malbp4 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp1 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp2 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp3 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp4 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp5 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp6 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp7 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());
                Mat mdlbp8 = new Mat(channel1.rows(), channel1.cols(), channel1.channels());

                for (int i = 1; i < channel1.rows() - 1; i++)
                    for (int j = 1; j < channel1.cols() - 1; j++) {
                        double[] center1 = channel1.get(i, j);
                        int x1 = (int) center1[0];
                        double[] center2 = channel2.get(i, j);
                        int x2 = (int) center2[0];
                        double[] center3 = channel3.get(i, j);
                        int x3 = (int) center3[0];
                        int[] lbparr1 = lbpArray(channel1, i, j, x1);
                        int[] lbparr2 = lbpArray(channel2, i, j, x2);
                        int[] lbparr3 = lbpArray(channel3, i, j, x3);

                        int[] mam = mam(lbparr1, lbparr2, lbparr3);
                        int[] mdm = mdm(lbparr1, lbparr2, lbparr3);

                        int[] malbptn1 = malbpn(mam, 0);
                        int[] malbptn2 = malbpn(mam, 1);
                        int[] malbptn3 = malbpn(mam, 2);
                        int[] malbptn4 = malbpn(mam, 3);

                        int malbpt1 = malbp(malbptn1, fn);
                        int malbpt2 = malbp(malbptn2, fn);
                        int malbpt3 = malbp(malbptn3, fn);
                        int malbpt4 = malbp(malbptn4, fn);

                        int[][] mdlbptn = mdlbptn(mdm);
                        int[] mdlbpt = mdlbpt(mdlbptn, fn);

                        //Generating the images

                        malbp1.put(i, j, malbpt1);
                        malbp2.put(i, j, malbpt2);
                        malbp3.put(i, j, malbpt3);
                        malbp4.put(i, j, malbpt4);

                        mdlbp1.put(i, j, mdlbpt[0]);
                        mdlbp2.put(i, j, mdlbpt[1]);
                        mdlbp3.put(i, j, mdlbpt[2]);
                        mdlbp4.put(i, j, mdlbpt[3]);
                        mdlbp5.put(i, j, mdlbpt[4]);
                        mdlbp6.put(i, j, mdlbpt[5]);
                        mdlbp7.put(i, j, mdlbpt[6]);
                        mdlbp8.put(i, j, mdlbpt[7]);

                        CalculateHist(malbp1);
                        System.out.println("Calculating the Multichannel Adder based LBP...");


                        //Calculating the Feature vectors
                        CalculateFVadder(malbp1, malbp2, malbp3, malbp4);
                        CalculateFVdecoder(mdlbp1, mdlbp2, mdlbp3, mdlbp4, mdlbp5, mdlbp6, mdlbp7, mdlbp8);
                        System.out.println("Program bitti");
                    }
            }
        });


        crop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);

                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);
                Utils.bitmapToMat(bmp, srcMat);
                Rect roi = new Rect(bmp.getWidth()/5, bmp.getHeight()/5,bmp.getWidth()-bmp.getWidth()/5*2, bmp.getHeight()- bmp.getHeight()/5*2);
                Mat cropped = new Mat(srcMat, roi);


                Bitmap bitmap3 = Bitmap.createBitmap( bmp.getWidth()-bmp.getWidth()/5*2, bmp.getHeight()- bmp.getHeight()/5*2, Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(cropped,bitmap3);

                Mat a=Mat.zeros(bmp.getHeight(),bmp.getWidth(),CvType.CV_8UC3);
                Bitmap bitmap2 = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(a,bitmap2);

                for(int i=0;i<cropped.cols();i++){
                  for (int j=0;j<cropped.rows();j++){
                   int data = bitmap3.getPixel(i, j);
                      bitmap2.setPixel(i+bitmap2.getWidth()/5, j+bitmap2.getHeight()/5 , data);


                   }
                }

                image.setImageBitmap(bitmap2);

                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/req_images");
                myDir.mkdirs();
                String fname = "aa171.processed2" + ".jpg";
                File file = new File(myDir, fname);
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap2.compress(Bitmap.CompressFormat.JPEG,90, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        gauss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();
                Imgproc.cvtColor(srcMat, gray, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.GaussianBlur(gray, edges, new Size(45, 45), 0);
                Imgproc.GaussianBlur(gray, edges,new Size(3,3),2);
                Bitmap bitmap = Bitmap.createBitmap(
                        bmp.getWidth(), bmp.getHeight(),
                        Bitmap.Config.ARGB_8888);

                Utils.matToBitmap(edges, bitmap);
                image.setImageBitmap(bitmap);

            }
        });

        medyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();
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
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                int width = bmp.getWidth();
                int height = bmp.getHeight();
                int[] pixels = new int[width * height];
                bmp.getPixels(pixels, 0, width, 0, 0, width, height);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();
                Size size = new Size(45, 45);
                Point point = new Point(20, 30);
                Imgproc.cvtColor(srcMat, gray,Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.blur(gray, edges,size, point, Core.BORDER_DEFAULT);
                Bitmap bitmap = Bitmap.createBitmap(
                        bmp.getWidth(), bmp.getHeight(),
                        Bitmap.Config.ARGB_8888);

                Utils.matToBitmap(edges, bitmap);

                image.setImageBitmap(bitmap);
                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/req_images");
                myDir.mkdirs();
                String fname = "a199.processed2" + ".jpg";
                File file = new File(myDir, fname);
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG,90, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    canny.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

                Utils.bitmapToMat(bmp, srcMat);
                Mat gray = new Mat();
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
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);
            Mat srcMat = new Mat(bmp.getHeight(), bmp.getWidth(), CvType.CV_8UC3);

            Utils.bitmapToMat(bmp, srcMat);
            Mat gray = new Mat();
            Imgproc.cvtColor(srcMat, gray, Imgproc.COLOR_BGR2GRAY);
            Size kSize = new Size(3, 3);
            Mat blur=new Mat();
            Imgproc.GaussianBlur(gray, blur, kSize, 0);
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
                Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat img = new Mat(bmp5.getHeight(), bmp5.getWidth(), CvType.CV_8UC3);
                Utils.bitmapToMat(bmp5, img);
                Mat filter = new Mat();
                Imgproc.cvtColor(img,filter, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.Laplacian(filter,edges,-1);
                Bitmap bitmap=Bitmap.createBitmap(bmp5.getWidth(),bmp5.getHeight(),Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(edges,bitmap);
                 image.setImageBitmap(bitmap);

            }
        });

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent kamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(kamera,33);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                Mat imageMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC3, new Scalar(4));
                Bitmap myBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Utils.bitmapToMat(myBitmap, imageMat);
                Size size = new Size(45, 45);
                Point point = new Point(20, 30);

                Mat gray = new Mat();
                // Converting the image from color to Gray
                Imgproc.cvtColor(imageMat, gray, Imgcodecs.IMREAD_COLOR);
                Mat edges = new Mat();
                Imgproc.blur(gray, edges, size, point, Core.BORDER_DEFAULT);

                Mat grayMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
                Imgproc.cvtColor(edges, grayMat, Imgproc.COLOR_RGBA2GRAY);


                Mat dst1 = new Mat();
                Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size((2 * 2) + 1, (2 * 2) + 1));
                Imgproc.dilate(grayMat, dst1, kernel);

                Mat edge = new Mat();
                Imgproc.blur(dst1, edge, new Size(45, 45));
                Mat thresholdMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
                Imgproc.threshold(edge, thresholdMat, 128, 255, Imgproc.THRESH_OTSU);
                List<MatOfPoint> contours = new ArrayList<>();
                Mat hierarchy = new Mat();

                Imgproc.threshold(edge, thresholdMat, 140, 255, Imgproc.THRESH_BINARY_INV);

                Imgproc.fillPoly(thresholdMat, contours, new Scalar(0));

                Mat dst = new Mat();
                Mat kernel1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size((2 * 2) + 1, (2 * 2) + 1));
                Imgproc.dilate(thresholdMat, dst, kernel1);

                Rect roi = new Rect(dst.width() / 3, dst.height() / 3, dst.width() - dst.width() / 3, dst.height() - dst.height() / 3);
                Mat cropped = new Mat(dst, roi);
                //Bitmap bittmap = Bitmap.createBitmap(1500, 1550,Bitmap.Config.ARGB_8888);
                Mat srcMat5 = new Mat(681, 476, CvType.CV_8U, new Scalar(0));
                cropped.copyTo(srcMat5);

                Bitmap bittmap1 = Bitmap.createBitmap(dst.width(), dst.height(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(dst, bittmap1);
                image.setImageBitmap(bittmap1);


            }

        });

histogram.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.v);
        Mat img = new Mat(bmp5.getHeight(), bmp5.getWidth(), CvType.CV_8UC3);
        Utils.bitmapToMat(bmp5, img);

        Mat equ = new Mat();
        img.copyTo(equ);

        Imgproc.blur(equ, equ, new Size(3, 3));

        Imgproc.cvtColor(equ, equ, Imgproc.COLOR_BGR2YCrCb);
        List<Mat> channels = new ArrayList<Mat>();

       Core.split(equ, channels);
        Imgproc.equalizeHist(channels.get(0), channels.get(0));
       Core.merge(channels, equ);
        Imgproc.cvtColor(equ, equ, Imgproc.COLOR_YCrCb2BGR);
        Mat gray = new Mat();
        Imgproc.cvtColor(equ, gray, Imgproc.COLOR_BGR2GRAY);
        Mat grayOrig = new Mat();
        Imgproc.cvtColor(img, grayOrig, Imgproc.COLOR_BGR2GRAY);
        Bitmap bitmap=Bitmap.createBitmap(bmp5.getWidth(),bmp5.getHeight(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(equ,bitmap);
        image.setImageBitmap(bitmap);

    }
});


      atresh.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
              Mat imageMat = new Mat (bitmap.getHeight(), bitmap.getWidth(),
                      CvType.CV_8U, new Scalar(4));
              Bitmap myBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
              Utils.bitmapToMat(myBitmap, imageMat);
              Mat grayMat = new Mat ( bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
              Imgproc.cvtColor(imageMat, grayMat, Imgproc.COLOR_RGB2GRAY, 1);
              Mat thresholdMat = new Mat ( bitmap.getHeight(), bitmap.getWidth(),
                      CvType.CV_8U, new Scalar(1));
           Imgproc.adaptiveThreshold(grayMat, thresholdMat ,255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 5, 4);
              Bitmap bittmap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);
              thresholdMat.convertTo(thresholdMat, CvType.CV_8UC1);
              Utils.matToBitmap(thresholdMat, bittmap);
              image.setImageBitmap(bittmap);
          }
      });

        tresh.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View view) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                    Mat imageMat = new Mat (bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(4));
                    Bitmap myBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    Utils.bitmapToMat(myBitmap, imageMat);
                    Mat grayMat = new Mat ( bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
                    Imgproc.cvtColor(imageMat, grayMat, Imgproc.COLOR_RGB2GRAY, 1);
                Mat thresholdMat = new Mat ( bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
                Imgproc.threshold(grayMat, thresholdMat , 128, 255, Imgproc.THRESH_BINARY_INV);
                List<MatOfPoint> contours = new ArrayList<>();
                Mat fill = new Mat(thresholdMat.size(), thresholdMat.type());
                thresholdMat.copyTo(fill);
                Mat mask = Mat.zeros(thresholdMat.rows() + 2, thresholdMat.cols() + 2, thresholdMat.type());
                thresholdMat.copyTo(mask.submat(1, 1, thresholdMat.rows() + 1, thresholdMat.cols() + 1));

                Imgproc.floodFill(fill, mask, new Point(0,0), new Scalar(255,255,255));
                Core.subtract(fill, thresholdMat, thresholdMat);

                Mat white = new Mat(thresholdMat.size(), thresholdMat.type(),new Scalar(255,255,255));
                Core.subtract(white, thresholdMat, thresholdMat);

                    Bitmap bittmap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);
                    thresholdMat.convertTo(thresholdMat, CvType.CV_8UC1);

                    Utils.matToBitmap(thresholdMat, bittmap);

                    image.setImageBitmap(bittmap);

                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/req_images");
                myDir.mkdirs();
                String fname = "a185.processed2" + ".jpg";
                File file = new File(myDir, fname);
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bittmap.compress(Bitmap.CompressFormat.PNG,90, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                }
        });

                otsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);

                Mat imageMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC3, new Scalar(4));
                Bitmap myBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Utils.bitmapToMat(myBitmap, imageMat);
                Size size = new Size(45, 45);

                Mat grayMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
                Imgproc.cvtColor(imageMat, grayMat, Imgproc.COLOR_RGBA2GRAY);

                Mat dst1 = new Mat();
                Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size((2* 2) + 1, (2 * 2) + 1));
                Imgproc.dilate(grayMat, dst1, kernel);
                Mat edge = new Mat();
                Imgproc.Laplacian(dst1,edge,-1);
                Imgproc.GaussianBlur(dst1,edge,size,0,0);

                Mat thresholdMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
                Imgproc.threshold(edge, thresholdMat, 128, 255, Imgproc.THRESH_OTSU);

                List<MatOfPoint> contours = new ArrayList<>();
                Mat hierarchy = new Mat();

               Imgproc.threshold(edge, thresholdMat, 128, 255, Imgproc.THRESH_BINARY_INV);


                Mat dst = new Mat();
                Mat kernel1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size((2* 2) + 1, (2 * 2) + 1));
                Imgproc.dilate(thresholdMat, dst, kernel1);

                Bitmap bittmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

                Utils.matToBitmap(dst, bittmap);

                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/req_images");
                myDir.mkdirs();
                String fname = "a11402a.processed" + ".jpg";
                File file = new File(myDir, fname);
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bittmap.compress(Bitmap.CompressFormat.JPEG,90, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                image.setImageBitmap(bittmap);
            }


        });
islem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
        Mat imageMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC3, new Scalar(4));
        Bitmap myBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(myBitmap, imageMat);
       Size size = new Size(45, 45);
       Point point = new Point(20, 30);
        Mat edges = new Mat();
        Mat a=new Mat();

         Imgproc.GaussianBlur(imageMat,edges,size,0,0,Core.BORDER_CONSTANT);
        Mat grayMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
        Imgproc.cvtColor(edges, grayMat, Imgproc.COLOR_RGBA2GRAY);

       Mat thresholdMat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
        Imgproc.threshold(grayMat, thresholdMat, 128, 255, Imgproc.THRESH_OTSU);
        Imgproc.threshold(grayMat, thresholdMat, 128, 255, Imgproc.THRESH_BINARY_INV);
        thresholdMat.convertTo(thresholdMat, CvType.CV_8UC1);

        Mat dst = new Mat();
            Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size((2* 2) + 1, (2 * 2) + 1));
        Imgproc.dilate(thresholdMat, dst, kernel);

        Bitmap bittmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Utils.matToBitmap(dst, bittmap);

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/req_images");
        myDir.mkdirs();
        String fname = "a290.processed" + ".jpg";
        File file = new File(myDir, fname);
        try {
            FileOutputStream out = new FileOutputStream(file);
            bittmap.compress(Bitmap.CompressFormat.JPEG,90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        image.setImageBitmap(bittmap);



    }

});

deneme.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.v);
        Mat imageMat = new Mat (bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(4));
        Bitmap myBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(myBitmap, imageMat);
        Mat grayMat = new Mat ( bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
        Imgproc.cvtColor(imageMat, grayMat, Imgproc.COLOR_RGBA2GRAY);

        Mat thresholdMat = new Mat ( bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(1));
        Imgproc.threshold(grayMat, thresholdMat , 128, 255, Imgproc.THRESH_OTSU);
        Imgproc.threshold(grayMat, thresholdMat , 128, 255, Imgproc.THRESH_BINARY_INV);
        thresholdMat.convertTo(thresholdMat, CvType.CV_8UC1);
        Mat dst = new Mat();
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size((2*2) + 1, (2*2)+1));
        Imgproc.dilate(thresholdMat, dst, kernel);
        Mat foreground = new Mat(imageMat.size(), CvType.CV_8UC3, new Scalar(255, 255, 255));
        imageMat.copyTo(foreground, dst);

        Bitmap bittmap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(foreground, bittmap);

           Log.e("hata","durdu");
        image.setImageBitmap(bittmap);




    }
});
       deneme2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.v);
               Mat mat = new Mat(bmp5.getHeight(), bmp5.getWidth(), CvType.CV_8UC3);
               Utils.bitmapToMat(bmp5, mat);






               //Converters.vector_Mat_to_Mat( cluster(mat,2));
               //Bitmap bittmap=Bitmap.createBitmap(bmp5.getWidth(),bmp5.getHeight(),Bitmap.Config.ARGB_8888);
             //  Utils.matToBitmap((Mat)  cluster(mat,2), bittmap);
              // image.setImageBitmap(bittmap);
           }
       });

deneme3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent intent=new Intent(getApplicationContext(),ColorBlobDetectionActivity.class);
        startActivity(intent);



    }
});


        deneme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),CameraActivity.class);
                startActivity(intent);


            }
        });
}


    public static List<Mat> cluster(Mat cutout, int k) {
        Mat samples = cutout.reshape(1, cutout.cols() * cutout.rows());
        Mat samples32f = new Mat();
        samples.convertTo(samples32f, CvType.CV_32F, 1.0 / 255.0);

        Mat labels = new Mat();
        TermCriteria criteria = new TermCriteria(TermCriteria.COUNT, 100, 1);
        Mat centers = new Mat();
        Core.kmeans(samples32f, k, labels, criteria, 1, Core.KMEANS_PP_CENTERS, centers);
        return showClusters(cutout, labels, centers);
    }

    private static List<Mat> showClusters (Mat cutout, Mat labels, Mat centers) {
        centers.convertTo(centers, CvType.CV_8UC1, 255.0);
        centers.reshape(3);

        List<Mat> clusters = new ArrayList<Mat>();
        for(int i = 0; i < centers.rows(); i++) {
            clusters.add(Mat.zeros(cutout.size(), cutout.type()));
        }

        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int i = 0; i < centers.rows(); i++) counts.put(i, 0);

        int rows = 0;
        for(int y = 0; y < cutout.rows(); y++) {
            for(int x = 0; x < cutout.cols(); x++) {
                int label = (int)labels.get(rows, 0)[0];
                int r = (int)centers.get(label, 2)[0];
                int g = (int)centers.get(label, 1)[0];
                int b = (int)centers.get(label, 0)[0];
                counts.put(label, counts.get(label) + 1);
                clusters.get(label).put(y, x, b, g, r);
                rows++;
            }
        }
        System.out.println(counts);
        return clusters;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode==33) {
            Bitmap image1 = (Bitmap) data.getExtras().get("data");
            image2.setImageBitmap(image1);
            Mat srcMat5 = new Mat(image1.getHeight(), image1.getWidth(), CvType.CV_8UC3);
            Utils.bitmapToMat(image1, srcMat5);
            Mat filter = new Mat();
            Imgproc.cvtColor(srcMat5,filter, Imgcodecs.IMREAD_COLOR);
            Mat edges = new Mat();
            Imgproc.Laplacian(filter,edges,-1);
            Bitmap bittmap=Bitmap.createBitmap(image1.getWidth(),image1.getHeight(),Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(edges,bittmap);
            image.setImageBitmap(bittmap);

        }
    }










    private static Bitmap.Config getConfig(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return config;
    }
    public static Mat olbp(Mat channel) {
        Mat dest = new Mat(channel.rows(), channel.cols(), channel.channels());

        for (int i = 1; i < channel.rows() - 1; i++) {
            for (int j = 1; j < channel.cols() - 1; j++) {
                double[] center = channel.get(i, j);
                int x = (int) center[0];
                int[] lbparr = lbpArray(channel, i, j, x);
                int dec = bin2dec(lbparr);

                dest.put(i, j, dec);
                //code |= (channel.get(i-1,j-1)) << 7;
                //String s = Arrays.toString(center);
                //System.out.println((int)Double.parseDouble(s.substring(1,s.length()-1)));
                //System.out.println(dec + " " + dest.get(i,j));
            }
        }
        //System.out.println(dest);
        //Imgcodecs.imwrite("resources/img0_try.jpg", dest);
        //System.out.println(dest);
        return dest;
    }

    public static int[] lbpArray(Mat channel, int locX, int locY, int center) {
        int[] arr = new int[8];
        if (channel.get(locX - 1, locY - 1)[0] > center)
            arr[0] = 1;
        else
            arr[0] = 0;

        if (channel.get(locX, locY - 1)[0] > center)
            arr[1] = 1;
        else
            arr[1] = 0;

        if (channel.get(locX + 1, locY - 1)[0] > center)
            arr[2] = 1;
        else
            arr[2] = 0;

        if (channel.get(locX + 1, locY)[0] > center)
            arr[3] = 1;
        else
            arr[3] = 0;

        if (channel.get(locX + 1, locY + 1)[0] > center)
            arr[4] = 1;
        else
            arr[4] = 0;

        if (channel.get(locX, locY + 1)[0] > center)
            arr[5] = 1;
        else
            arr[5] = 0;

        if (channel.get(locX - 1, locY + 1)[0] > center)
            arr[6] = 1;
        else
            arr[6] = 0;

        if (channel.get(locX - 1, locY)[0] > center)
            arr[7] = 1;
        else
            arr[7] = 0;

        return arr;

    }


    public static int bin2dec(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i] * ((int) Math.pow(2, i));
        }
        return result;
    }

    public static int[] mam(int[] a, int[] b, int[] c) {
        int[] mam = new int[8];
        for (int i = 0; i < a.length; i++) {
            mam[i] = a[i] + b[i] + c[i];
        }
        return mam;
    }

    private static int[] mdm(int[] lbparr1, int[] lbparr2, int[] lbparr3) {
        int[] mdmArr = new int[8];
        for (int i = 0; i < 8; i++) {
            mdmArr[i] = 4 * lbparr1[i] + 2 * lbparr2[i] + lbparr3[i];
        }
        return mdmArr;
    }

    private static int[] malbpn(int[] mam, int t) {
        //t denotes the output channel number
        int[] malbpnArr = new int[8];
        for(int i = 0; i<8; i++)
        {
            if(mam[i]==t)
                malbpnArr[i] = 1;
            else
                malbpnArr[i] = 0;
        }
        return malbpnArr;
    }

    private static int[][] mdlbptn(int[] mdm) {
        int[][] mdlbptnArr = new int[8][8];
        int t2 = 1;  //t2 belongs to [1, 2^c]
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (mdm[j] == t2 - 1)
                    mdlbptnArr[i][j] = 1;
                else
                    mdlbptnArr[i][j] = 0;
            }
            t2++;
        }
        return mdlbptnArr;
    }

    public static int[] weighingfunc() {
        int[] fn = new int[8];
        int count =0;
        for (int i = 0; i < 8; i++) {
            fn[i] = (int) Math.pow(2, i );
        }
        return fn;
    }

    /*public static int[] lbptn( Mat c1, Mat c2, Mat c3)
    {
       Mat temp = new Mat(c1.rows(), c2.cols(), 1);
        Core.add(c1, c2, temp);
        Core.add(c3, temp, temp);
        return  temp;
    }
    */

    public static int malbp(int[] malbpn, int[] fn) {
        int malbpVal = 0;
        for (int i = 0; i < 8; i++) {
            malbpVal = malbpVal + malbpn[i] * fn[i];
        }
        return malbpVal;
    }

    public static int[] mdlbpt(int[][] mdlbptn, int[] fn) {
        int[] mdlbpVals = new int[8];
        for (int i = 0; i < 8; i++) {
            int mdlbpVal = 0;
            for (int j = 0; j < 8; j++) {
                mdlbpVal = mdlbpVal + mdlbptn[i][j] * fn[i];
            }
            mdlbpVals[i] = mdlbpVal;
        }
        return mdlbpVals;

    }

    public static Mat maLBP(Mat mam, int t) {
        //t belongs to [1, c+1]
        Mat maLBP = new Mat(mam.rows(), mam.cols(), 1);

        Size len = maLBP.size();
        System.out.println("malbp size: " + len);

        for (int i = 0; i < (int) len.height; i++) {
            for (int j = 0; j < (int) len.width; j++) {
                double[] a = mam.get(i, j);
                // System.out.println(a[0]);
            }
        }
        return maLBP;
    }

    public static void calcHistogram(Mat img) {
        MatOfInt histsize = new MatOfInt(256);

        final MatOfFloat histRange = new MatOfFloat(0f, 256f);

        boolean accumulate = false;

        Mat hist = new Mat();

        List<Mat> hList = new ArrayList<>();
        hList.add(img);

        Imgproc.calcHist(hList, new MatOfInt(3), new Mat(), hist, histsize, histRange, accumulate);

        int hist_w = 512;
        int hist_h = 600;
        long bin_w = Math.round((double) hist_w / 256);

        Mat histImg = new Mat(hist_h, hist_w, CvType.CV_8UC1);
        Core.normalize(hist, hist, 3, histImg.rows(), Core.NORM_MINMAX);

        for (int i = 1; i < 256; i++) {
            Point p1 = new Point(bin_w * (i - 1), hist_h - Math.round(hist.get(i - 1, 0)[0]));
            Point p2 = new Point(bin_w * (i), hist_h - Math.round(hist.get(i, 0)[0]));
            Imgproc.line(histImg, p1, p2, new Scalar(255, 0, 0), 2, 8, 0);
        }
            // histImg txt dosyasına basılacak
       //Imgcodecs.imwrite("C:\\Users\\NCS\\Music\\img0_hist.jpg", histImg);

    }

    public static int[] CalculateHist(Mat img) {
        int sigma, summation = 0;
        int[] hist = new int[8];
            for (int k = 0; k < 8; k++) {
                for (int i = 0; i < img.rows(); i++) {
                    for (int j = 0; j < img.cols(); j++) {
                        if (img.get(i, j)[0] == (double) k) {
                            sigma = 1;
                            //System.out.println((double)k);
                        } else {
                            sigma = 0;
                        }
                        summation = summation + sigma;
                    }
                }
                hist[k] = summation;
            System.out.println(hist[k]);
        }
        return hist;
    }

    public static void CalculateFVadder(Mat malbp1, Mat malbp2, Mat malbp3, Mat malbp4) {
        List<Integer> FVadder = new ArrayList<Integer>();
        //System.out.println(CalculateHist(malbp1)[0]);
        for (int i = 0; i < 4; i++)
            FVadder.add(CalculateHist(malbp1)[i] / 4);
        for (int i = 0; i < 4; i++)
            FVadder.add(CalculateHist(malbp2)[i] / 4);
        for (int i = 0; i < 4; i++)
            FVadder.add(CalculateHist(malbp3)[i] / 4);
        for (int i = 0; i < 4; i++)
            FVadder.add(CalculateHist(malbp4)[i] / 4);
        System.out.println("The feature vector of the Multichannel adder based LBP - ");
        System.out.println(FVadder);
    }

    public static void CalculateFVdecoder(Mat mdlbp1, Mat mdlbp2, Mat mdlbp3, Mat mdlbp4, Mat mdlbp5, Mat mdlbp6, Mat mdlbp7, Mat mdlbp8) {
        List<Integer> FVdecoder = new ArrayList<Integer>();
        //System.out.println(CalculateHist(malbp1)[0]);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp1)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp2)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp3)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp4)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp5)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp6)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp7)[i] / 8);
        for (int i = 0; i < 4; i++)
            FVdecoder.add(CalculateHist(mdlbp8)[i] / 8);
        System.out.println("\n The feature vector of the Multichannel decoder based LBP - ");
        System.out.println(FVdecoder);

    }


    }
