package com.bolyartech.forge.misc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by ogre on 2015-10-21
 */
public class ActivityUtilsTest {
    private static final String KEY1 = "key1";
    private static final String KEY2 = "key2";


    @Test
    public void test_interceptLongParam() {
        Bundle b = mock(Bundle.class);
        when(b.getLong(KEY1)).thenReturn(-1l);
        when(b.getLong(KEY2)).thenReturn(123l);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptLongParam(b, intent, KEY1) == -1);

        // tests if intercepting from savedInstanceState works
        when(b.getLong(KEY1)).thenReturn(123l);
        assertTrue(ActivityUtils.interceptLongParam(b, intent, KEY1) == 123);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getLong(KEY1)).thenReturn(123l);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptLongParam(null, intent, KEY1) == 123);

        // tests if intercepting from savedInstanceState gets first
        when(b.getLong(KEY1)).thenReturn(123l);
        when(forIntent.getLong(KEY1)).thenReturn(123456l);
        assertTrue(ActivityUtils.interceptLongParam(b, intent, KEY1) == 123);
    }


    @Test
    public void test_interceptIntParam() {
        Bundle b = mock(Bundle.class);
        when(b.getInt(KEY1, -1)).thenReturn(-1);
        when(b.getInt(KEY2, -1)).thenReturn(123);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptIntParam(b, intent, KEY1) == -1);

        // tests if intercepting from savedInstanceState works
        when(b.getInt(KEY1, -1)).thenReturn(123);
        assertTrue(ActivityUtils.interceptIntParam(b, intent, KEY1) == 123);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getInt(KEY1, -1)).thenReturn(123);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptIntParam(null, intent, KEY1) == 123);

        // tests if intercepting from savedInstanceState gets first
        when(b.getInt(KEY1, -1)).thenReturn(123);
        when(forIntent.getInt(KEY1, -1)).thenReturn(123456);
        assertTrue(ActivityUtils.interceptIntParam(b, intent, KEY1) == 123);
    }


    @Test
    public void test_interceptParcelableParam() {
        Parcelable parcel = mock(Parcelable.class);

        Bundle b = mock(Bundle.class);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptParcelableParam(b, intent, KEY1) == null);

        // tests if intercepting from savedInstanceState works
        when(b.getParcelable(KEY1)).thenReturn(parcel);
        assertTrue(ActivityUtils.interceptParcelableParam(b, intent, KEY1) == parcel);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getParcelable(KEY1)).thenReturn(parcel);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptParcelableParam(null, intent, KEY1) == parcel);

        // tests if intercepting from savedInstanceState gets first
        Parcelable parcel2 = mock(Parcelable.class);
        when(b.getParcelable(KEY1)).thenReturn(parcel2);
        assertTrue(ActivityUtils.interceptParcelableParam(b, intent, KEY1) == parcel2);
    }


    @Test
    public void test_interceptStringParam() {
        Bundle b = mock(Bundle.class);
        when(b.getString(KEY1)).thenReturn(null);
        when(b.getString(KEY2)).thenReturn("123");
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptStringParam(b, intent, KEY1) == null);

        // tests if intercepting from savedInstanceState works
        when(b.getString(KEY1)).thenReturn("123");
        assertTrue(ActivityUtils.interceptStringParam(b, intent, KEY1).equals("123"));

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getString(KEY1)).thenReturn("123");
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptStringParam(null, intent, KEY1).equals("123"));

        // tests if intercepting from savedInstanceState gets first
        when(b.getString(KEY1)).thenReturn("123");
        when(forIntent.getString(KEY1)).thenReturn("123456");
        assertTrue(ActivityUtils.interceptStringParam(b, intent, KEY1).equals("123"));
    }


    @Test
    public void test_interceptBooleanParam() {
        Bundle b = mock(Bundle.class);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(!ActivityUtils.interceptBooleanParam(b, intent, KEY1));

        // tests if intercepting from savedInstanceState works
        when(b.getBoolean(KEY1, false)).thenReturn(true);
        assertTrue(ActivityUtils.interceptBooleanParam(b, intent, KEY1));

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getBoolean(KEY1, false)).thenReturn(true);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptBooleanParam(null, intent, KEY1));

        // tests if intercepting from savedInstanceState gets first
        when(b.getBoolean(KEY1, false)).thenReturn(true);
        when(forIntent.getBoolean(KEY1, false)).thenReturn(false);
        assertTrue(ActivityUtils.interceptBooleanParam(b, intent, KEY1));
    }


    @Test
    public void test_interceptFloatParam() {
        Bundle b = mock(Bundle.class);
        when(b.getFloat(KEY1, 0)).thenReturn(0f);
        when(b.getFloat(KEY2, 0)).thenReturn(3.14f);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptFloatParam(b, intent, KEY1) == 0);

        // tests if intercepting from savedInstanceState works
        when(b.getFloat(KEY1, 0)).thenReturn(3.14f);
        assertTrue(ActivityUtils.interceptFloatParam(b, intent, KEY1) == 3.14f);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getFloat(KEY1, 0)).thenReturn(3.14f);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptFloatParam(null, intent, KEY1) == 3.14f);

        // tests if intercepting from savedInstanceState gets first
        when(b.getFloat(KEY1, 0)).thenReturn(3.14f);
        when(forIntent.getFloat(KEY1, 0)).thenReturn(3.14159f);
        assertTrue(ActivityUtils.interceptFloatParam(b, intent, KEY1) == 3.14f);
    }


    @Test
    public void test_interceptDoubleParam() {
        Bundle b = mock(Bundle.class);
        when(b.getDouble(KEY1, 0)).thenReturn(0d);
        when(b.getDouble(KEY2, 0)).thenReturn(3.14d);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptDoubleParam(b, intent, KEY1) == 0);

        // tests if intercepting from savedInstanceState works
        when(b.getDouble(KEY1, 0)).thenReturn(3.14d);
        assertTrue(ActivityUtils.interceptDoubleParam(b, intent, KEY1) == 3.14d);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getDouble(KEY1, 0)).thenReturn(3.14d);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptDoubleParam(null, intent, KEY1) == 3.14d);

        // tests if intercepting from savedInstanceState gets first
        when(b.getDouble(KEY1, 0)).thenReturn(3.14d);
        when(forIntent.getDouble(KEY1, 0)).thenReturn(3.14159d);
        assertTrue(ActivityUtils.interceptDoubleParam(b, intent, KEY1) == 3.14d);
    }


    @Test
    public void test_interceptByteParam() {
        Bundle b = mock(Bundle.class);
        when(b.getByte(KEY1, (byte) 0)).thenReturn((byte) 0);
        when(b.getByte(KEY2, (byte) 0)).thenReturn((byte) 123);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptByteParam(b, intent, KEY1) == 0);

        // tests if intercepting from savedInstanceState works
        when(b.getByte(KEY1, (byte) 0)).thenReturn((byte) 123);
        assertTrue(ActivityUtils.interceptByteParam(b, intent, KEY1) == 123);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getByte(KEY1, (byte) 0)).thenReturn((byte) 123);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptByteParam(null, intent, KEY1) == 123);

        // tests if intercepting from savedInstanceState gets first
        when(b.getByte(KEY1, (byte) 0)).thenReturn((byte) 123);
        when(forIntent.getByte(KEY1, (byte) 0)).thenReturn((byte) 255);
        assertTrue(ActivityUtils.interceptByteParam(b, intent, KEY1) == (byte) 123);
    }


    @Test
    public void test_interceptCharParam() {
        Bundle b = mock(Bundle.class);
        when(b.getChar(KEY1, (char) 0)).thenReturn((char) 0);
        when(b.getChar(KEY2, (char) 0)).thenReturn((char) 123);
        Intent intent = mock(Intent.class);

        // tests if no false positives are found
        assertTrue(ActivityUtils.interceptCharParam(b, intent, KEY1) == 0);

        // tests if intercepting from savedInstanceState works
        when(b.getChar(KEY1, (char) 0)).thenReturn((char) 123);
        assertTrue(ActivityUtils.interceptCharParam(b, intent, KEY1) == 123);

        // tests if intercepting from intent works
        Bundle forIntent = mock(Bundle.class);
        when(forIntent.getChar(KEY1, (char) 0)).thenReturn((char) 123);
        when(intent.getExtras()).thenReturn(forIntent);
        assertTrue(ActivityUtils.interceptCharParam(null, intent, KEY1) == 123);

        // tests if intercepting from savedInstanceState gets first
        when(b.getChar(KEY1, (char) 0)).thenReturn((char) 123);
        when(forIntent.getChar(KEY1, (char) 0)).thenReturn((char) 255);
        assertTrue(ActivityUtils.interceptCharParam(b, intent, KEY1) == (char) 123);
    }

}
