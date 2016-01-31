/*
 * Copyright (C) 2012-2015 Ognyan Bankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bolyartech.forge.android.misc;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;


/**
 * Utility class that provides static methods for manipulating images
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ImageUtils {
    /**
     * Noninstantiable utility class
     */
    private ImageUtils() {
        throw new AssertionError();
    }


    /**
     * Resize bitmap to max width or height. Resulting image will not have dimension bigger than specified.
     *
     * @param srcBitmap Source bitmap
     * @param maxSizeX  Max width
     * @param maxSizeY  Max height
     * @return Resulting bitmap
     */
    public static Bitmap bitmapResizeToMaxXorY(Bitmap srcBitmap, int maxSizeX, int maxSizeY) {
        Bitmap ret = null;

        if (srcBitmap != null && maxSizeX > 0 && maxSizeY > 0) {
            Float origSizeX = (float) srcBitmap.getWidth();
            Float origSizeY = (float) srcBitmap.getHeight();

            if (origSizeX > maxSizeX || origSizeY > maxSizeY) {
                float origRatio = origSizeX / origSizeY;
                float destRatio = maxSizeX / maxSizeY;

                float targetSizeX;
                float targetSizeY;

                if (origRatio >= destRatio) {
                    if (maxSizeX >= origSizeX) {
                        targetSizeX = origSizeX;
                    } else {
                        targetSizeX = maxSizeX;
                    }

                    targetSizeY = targetSizeX / origRatio;
                } else {
                    if (maxSizeY >= origSizeY) {
                        targetSizeY = origSizeY;
                    } else {
                        targetSizeY = maxSizeY;
                    }

                    targetSizeX = targetSizeY * origRatio;
                }

                ret = Bitmap.createScaledBitmap(srcBitmap,
                        (int) targetSizeX,
                        (int) targetSizeY,
                        false);
            } else {
                // original image is smaller than destination sizes so we are returning original
                ret = srcBitmap;
            }
        }

        return ret;
    }


    /**
     * Creates {@link Bitmap} from asset file
     *
     * @param context Context to be used
     * @param strName Name of the asset
     * @return Resulting bitmap
     * @throws IOException if file error occurs
     */
    public static Bitmap getBitmapFromAsset(Context context, String strName) throws IOException {
        AssetManager assetManager = context.getAssets();

        InputStream istr;

        istr = assetManager.open(strName);

        return BitmapFactory.decodeStream(istr);
    }
}
