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


/**
 * Utility class with methods for finding and initializing views
 *
 * If you use libraries like <a href="http://jakewharton.github.io/butterknife/">Butter Knife</a> you don't need the
 * current class and its methods.
 *
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ViewUtils {
    private static final org.slf4j.Logger mLogger = LoggerFactory.getLogger(ViewUtils.class
            .getSimpleName());


    /**
     * Noninstantiable utility class
     */
    private ViewUtils() {
        throw new AssertionError("Non-instantiable utility class");
    }


    /**
     * Finds a button view
     *
     * @param view       The parent view
     * @param resourceId  ID of the resource
     * @return  Button if successful or null otherwise
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
     * @param resourceId  ID of the resource
     * @return  Button if successful
     * @throws  IllegalStateException  if view with such ID is not found
     */
    public static Button findButtonX(View view, int resourceId) {
        Button ret = (Button) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find Button with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize a button with OnClickListener
     * @param view  Parent view
     * @param resourceId  ID of the resource
     * @param listener  On click listener
     * @return  Button if successful or IllegalStateException
     */
    public static Button initButton(View view, int resourceId, View.OnClickListener listener) {
        Button ret = findButtonX(view, resourceId);
        ret.setOnClickListener(listener);

        return ret;
    }


    /**
     * Finds TextView
     * @param view  Parent view
     * @param resourceId  ID of the TextView
     * @return text view or null if view is not found
     */
    public static TextView findTextView(View view, int resourceId) {
        TextView ret = (TextView) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find TextView with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds TextView or throws IllegalStateException if not found
     * @param view  Parent view
     * @param resourceId  ID of the TextView
     * @return text view
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static TextView findTextViewX(View view, int resourceId) {
        TextView ret = (TextView) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find TextView with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds EditText
     * @param view Parent view
     * @param resourceId  ID of the EditText
     * @return  edit text or null if view is not found
     */
    public static EditText findEditText(View view, int resourceId) {
        EditText ret = (EditText) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find EditText with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds EditText  or throws IllegalStateException if not found
     * @param view  Parent view
     * @param resourceId  ID of the EditText
     * @return  edit text
     * @throws  IllegalStateException  if view with such ID is not found
     */
    public static EditText findEditTextX(View view, int resourceId) {
        EditText ret = (EditText) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find EditText with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize EditText with TextWatcher
     * @param view  Parent view
     * @param resourceId  ID of the EditText
     * @return  edit text
     * @throws  IllegalStateException  if view with such ID is not found
     */
    public static EditText initEditText(View view, int resourceId, TextWatcher watcher) {
        EditText ret = findEditTextX(view, resourceId);
        if (watcher != null) {
            ret.addTextChangedListener(watcher);
        }

        return ret;
    }


    /**
     * Finds RadioGroup view
     * @param view  Parent view
     * @param resourceId  ID of the RadioGroup
     * @return  radio group or null if view is not found
     */
    public static RadioGroup findRadioGroup(View view, int resourceId) {
        RadioGroup ret = (RadioGroup) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find RadioGroup with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds RadioGroup view
     * @param view  Parent view
     * @param resourceId  ID of the RadioGroup
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static RadioGroup findRadioGroupX(View view, int resourceId) {
        RadioGroup ret = (RadioGroup) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find RadioGroup with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize RadioGroup view with OnCheckedChangeListener
     * @param view  Parent view
     * @param resourceId  ID of the RadioGroup
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static RadioGroup initRadioGroup(View view,
                                            int resourceId,
                                            RadioGroup.OnCheckedChangeListener listener) {

        RadioGroup ret = findRadioGroupX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    /**
     * Finds CheckBox view
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return  check box or null if view is not found
     */
    public static CheckBox findCheckBox(View view, int resourceId) {
        CheckBox ret = (CheckBox) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find CheckBox with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds CheckBox view
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return  check box
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static CheckBox findCheckBoxX(View view, int resourceId) {
        CheckBox ret = (CheckBox) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find CheckBox with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize CheckBox with OnCheckedChangeListener
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return  check box
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static CheckBox initCheckBox(View view,
                                        int resourceId,
                                        CompoundButton.OnCheckedChangeListener listener) {

        CheckBox ret = findCheckBoxX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    /**
     * Finds ToggleButton
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ToggleButton of null if view is not found
     */
    public static ToggleButton findToggleButton(View view, int resourceId) {
        ToggleButton ret = (ToggleButton) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ToggleButton with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds ToggleButton
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ToggleButton
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static ToggleButton findToggleButtonX(View view, int resourceId) {
        ToggleButton ret = (ToggleButton) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find ToggleButton with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize ToggleButton with OnCheckedChangeListener
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ToggleButton
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static ToggleButton initToggleButton(View view,
                                                int resourceId,
                                                CompoundButton.OnCheckedChangeListener listener) {
        ToggleButton ret = findToggleButtonX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    /**
     * Finds ListView
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ListView or null if not found
     */
    public static ListView findListView(View view, int resourceId) {
        ListView ret = (ListView) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ListView with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds ListView
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ListView
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static ListView findListViewX(View view, int resourceId) {
        ListView ret = (ListView) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find ListView with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds ImageView
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ImageView or null if not found
     */
    public static ImageView findImageView(View view, int resourceId) {
        ImageView ret = (ImageView) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find ImageView with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds ImageView
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return ImageView
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static ImageView findImageViewX(View view, int resourceId) {
        ImageView ret = (ImageView) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find ImageView with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds Spinner
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return Spinner or null if not found
     */
    public static Spinner findSpinner(View view, int resourceId) {
        Spinner ret = (Spinner) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find Spinner with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds Spinner
     * @param view  Parent view
     * @param resourceId  ID of the view
     * @return Spinner
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static Spinner findSpinnerX(View view, int resourceId) {
        Spinner ret = (Spinner) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find Spinner with id = " + resourceId);
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
     * @return TimePicker
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static TimePicker findTimePickerX(View view, int resourceId) {
        TimePicker ret = (TimePicker) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find TimePicker with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds View
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return View or null if not found
     */
    public static View findView(View view, int resourceId) {
        View ret = view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find View with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds View
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return View
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static View findViewX(View view, int resourceId) {
        View ret = view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find View with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds RadioButton
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return RadioButton or null if not found
     */
    public static RadioButton findRadioButton(View view, int resourceId) {
        RadioButton ret = (RadioButton) view.findViewById(resourceId);
        if (ret == null) {
            mLogger.warn("Cannot find RadioButton with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Finds RadioButton
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return RadioButton or null if not found
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static RadioButton findRadioButtonX(View view, int resourceId) {
        RadioButton ret = (RadioButton) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find RadioButton with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize RadioButton with OnCheckedChangeListener
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return RadioButton or null if not found
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static RadioButton initRadioButton(View view,
                                              int resourceId,
                                              CompoundButton.OnCheckedChangeListener listener
    ) {
        RadioButton ret = findRadioButtonX(view, resourceId);
        ret.setOnCheckedChangeListener(listener);

        return ret;
    }


    /**
     * Finds an ImageButton view
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
     * Finds an ImageButton view or throws exception if not found
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return ImageButton if successful
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static ImageButton findImageButtonX(View view, int resourceId) {
        ImageButton ret = (ImageButton) view.findViewById(resourceId);
        if (ret == null) {
            throw new IllegalStateException("Cannot find ImageButton with id = " + resourceId);
        }

        return ret;
    }


    /**
     * Initialize ImageButton with OnClickListener
     *
     * @param view       The parent view
     * @param resourceId ID of the resource
     * @return ImageButton if successful
     * @throws IllegalStateException  if view with such ID is not found
     */
    public static ImageButton initImageButton(View view, int resourceId, View.OnClickListener listener) {
        ImageButton ret = findImageButtonX(view, resourceId);
        ret.setOnClickListener(listener);

        return ret;
    }
}
