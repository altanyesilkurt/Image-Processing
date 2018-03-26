package com.altanyesilkurtgmail.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ALTAN on 21.12.2017.
 */
public class Main2ActivityTest {
@Rule
    public ActivityTestRule <MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity=null;
@Before
    public void setUp() throws Exception{
    mActivity=mActivityTestRule.getActivity();

}
@Test
    public void Test() throws Exception{
    View view = mActivity.findViewById(R.id.imageView);
    assertNotNull(view);
}
@After
    public void tearDown() throws Exception{
      mActivity=null;

}

}