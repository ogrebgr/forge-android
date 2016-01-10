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

package com.bolyartech.forge.misc;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import org.slf4j.LoggerFactory;


@SuppressWarnings({"WeakerAccess", "unused"})
public class ViewUtils {
    private static final org.slf4j.Logger mLogger = LoggerFactory.getLogger(ViewUtils.class
            .getSimpleName());


    /**
     * Noninstantiable utility class
     */
    private ViewUtils() {
        throw new AssertionError();
    }


    /**
     * Finds a button view
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return ButtonView if successful or null otherwise
     */
    public static Button findButton(View view, int resourceId) {
        Button ret = (Button) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find Button with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds a button view or throws exception if not found
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return ButtonView if successful or RuntimeException
     */
    public static Button findButtonX(View view, int resourceId) {
        Button ret = (Button) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find Button with id = " + resourceId);
        }

        return ret;
    }


    public static Button initButton(View view, int resourceId, View.OnClickListener listener) {
        Button ret = findButtonX(view, resourceId);
        ret.setOnClickListener(listener);

        return ret;
    }


    public static TextView findTextView(View view, int resourceId) {
        TextView ret = (TextView) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find TextView with id = " + resourceId);
        }

        return ret;
    }


    public static TextView findTextViewX(View view, int resourceId) {
        TextView ret = (TextView) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find TextView with id = " + resourceId);
        }

        return ret;
    }


    public static EditText findEditText(View view, int resourceId) {
        EditText ret = (EditText) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find EditText with id = " + resourceId);
        }

        return ret;
    }


    public static EditText findEditTextX(View view, int resourceId) {
        EditText ret = (EditText) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find EditText with id = " + resourceId);
        }

        return ret;
    }


    public static EditText initEditText(View view, int resourceId, TextWatcher watcher) {
        EditText ret = findEditTextX(view, resourceId);
        if (watcher != null) {
            ret.addTextChangedListener(watcher);
        }

        return ret;
    }


    public static RadioGroup findRadioGroup(View view, int resourceId) {
        RadioGroup ret = (RadioGroup) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find RadioGroup with id = " + resourceId);
        }

        return ret;
    }


    public static RadioGroup findRadioGroupX(View view, int resourceId) {
        RadioGroup ret = (RadioGroup) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find RadioGroup with id = " + resourceId);
        }

        return ret;
    }


    public static RadioGroup initRadioGroup(View view,
                                            int resourceId,
                                            RadioGroup.OnCheckedChangeListener listener) {

        RadioGroup ret = findRadioGroupX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    public static CheckBox findCheckBox(View view, int resourceId) {
        CheckBox ret = (CheckBox) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find CheckBox with id = " + resourceId);
        }

        return ret;
    }


    public static CheckBox findCheckBoxX(View view, int resourceId) {
        CheckBox ret = (CheckBox) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find CheckBox with id = " + resourceId);
        }

        return ret;
    }


    public static CheckBox initCheckBox(View view,
                                        int resourceId,
                                        CompoundButton.OnCheckedChangeListener listener) {

        CheckBox ret = findCheckBoxX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    public static ToggleButton findToggleButton(View view, int resourceId) {
        ToggleButton ret = (ToggleButton) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ToggleButton with id = " + resourceId);
        }

        return ret;
    }


    public static ToggleButton findToggleButtonX(View view, int resourceId) {
        ToggleButton ret = (ToggleButton) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find ToggleButton with id = " + resourceId);
        }

        return ret;
    }


    public static ToggleButton initToggleButton(View view,
                                                int resourceId,
                                                CompoundButton.OnCheckedChangeListener listener) {
        ToggleButton ret = findToggleButtonX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    public static ListView findListView(View view, int resourceId) {
        ListView ret = (ListView) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ListView with id = " + resourceId);
        }

        return ret;
    }


    public static ListView findListViewX(View view, int resourceId) {
        ListView ret = (ListView) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find ListView with id = " + resourceId);
        }

        return ret;
    }


    public static ImageView findImageView(View view, int resourceId) {
        ImageView ret = (ImageView) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ImageView with id = " + resourceId);
        }

        return ret;
    }


    public static ImageView findImageViewX(View view, int resourceId) {
        ImageView ret = (ImageView) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find ImageView with id = " + resourceId);
        }

        return ret;
    }


    public static Spinner findSpinner(View view, int resourceId) {
        Spinner ret = (Spinner) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find Spinner with id = " + resourceId);
        }

        return ret;
    }


    public static Spinner findSpinnerX(View view, int resourceId) {
        Spinner ret = (Spinner) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find Spinner with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds a TimePicker view
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return TimePicker if successful or null otherwise
     */
    public static TimePicker findTimePicker(View view, int resourceId) {
        TimePicker ret = (TimePicker) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find TimePicker with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds a TimePicker view or throws exception if not found
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return TimePicker if successful or RuntimeException
     */
    public static TimePicker findTimePickerX(View view, int resourceId) {
        TimePicker ret = (TimePicker) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find TimePicker with id = " + resourceId);
        }

        return ret;
    }


    public static View findView(View view, int resourceId) {
        View ret = view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find View with id = " + resourceId);
        }

        return ret;
    }


    public static View findViewX(View view, int resourceId) {
        View ret = view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find View with id = " + resourceId);
        }

        return ret;
    }


    public static RadioButton findRadioButton(View view, int resourceId) {
        RadioButton ret = (RadioButton) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find RadioButton with id = " + resourceId);
        }

        return ret;
    }


    public static RadioButton findRadioButtonX(View view, int resourceId) {
        RadioButton ret = (RadioButton) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find RadioButton with id = " + resourceId);
        }

        return ret;
    }


    public static RadioButton initRadioButton(View view,
                                              int resourceId,
                                              CompoundButton.OnCheckedChangeListener listener
    ) {
        RadioButton ret = findRadioButtonX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    /**
     * Finds a button view
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return ImageButton if successful or null otherwise
     */
    public static ImageButton findImageButton(View view, int resourceId) {
        ImageButton ret = (ImageButton) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ImageButton with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds a button view or throws exception if not found
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return ImageButton if successful or RuntimeException
     */
    public static ImageButton findImageButtonX(View view, int resourceId) {
        ImageButton ret = (ImageButton) view.findViewById(resourceId);
        if (ret == null) {
            throw new RuntimeException("Cannot find ImageButton with id = " + resourceId);
        }

        return ret;
    }


    public static ImageButton initImageButton(View view, int resourceId, View.OnClickListener listener) {
        ImageButton ret = findImageButtonX(view, resourceId);
        ret.setOnClickListener(listener);

        return ret;
    }
}
