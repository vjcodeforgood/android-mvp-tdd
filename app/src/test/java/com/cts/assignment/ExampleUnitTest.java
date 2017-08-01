package com.cts.assignment;


import android.content.Context;
import android.content.res.AssetManager;
import android.test.mock.MockContext;

import com.cts.assignment.util.DateUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    Context context;




    @Test
    public void checkFileType() throws Exception {

        String filename = "issues.csv";
        String filenameArray[] = filename.split("\\.");
        String extension = filenameArray[filenameArray.length-1];
        assertEquals(extension,"csv");


    }

    @Test
    public void readTCSVFile() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("issues.csv");
        String s = DateUtil.readTextStream(inputStream);
        assertThat(s, notNullValue());
    }

    @Test
    public void isFileExit() throws Exception {

        context = new MockContext();
        final AssetManager assets = context.getAssets();
        final String[] names = assets.list( "" );
        assertThat(names, notNullValue());

    }

//    @Test
//    public void MockParser() throws Exception {
//        CSVPresenterImpl csvPresenter = mock(CSVPresenterImpl.class);
//        assertEquals(csvPresenter.parseCSV("issues.csv"),true);
//    }



}