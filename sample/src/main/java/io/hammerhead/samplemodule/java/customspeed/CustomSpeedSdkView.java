/*
 * Copyright 2021 Hammerhead Navigation, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hammerhead.samplemodule.java.customspeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.hammerhead.sample.R;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class CustomSpeedSdkView extends SdkView {
    public CustomSpeedSdkView(Context context) {
        super(context);
    }

    @Override
    public View createView(LayoutInflater layoutInflater, ViewGroup parent) {
        return layoutInflater.inflate(R.layout.custom_speed_view, parent, false);
    }

    @Override
    public void onUpdate(View view, double value) {
        TextView textSpeed = view.findViewById(R.id.text_speed);
        textSpeed.setText(getContext().getString(R.string.valid));
        TextView numericSpeed = view.findViewById(R.id.numeric_speed);
        numericSpeed.setVisibility(View.VISIBLE);
        StringBuilder numericValue = new StringBuilder();
        numericValue.append(String.format("%.2f", value));
        numericSpeed.setText(numericValue.reverse());
    }

    @Override
    public void onInvalid(View view) {
        TextView textSpeed = view.findViewById(R.id.text_speed);
        textSpeed.setText(getContext().getString(R.string.invalid));
        TextView numericSpeed = view.findViewById(R.id.numeric_speed);
        numericSpeed.setVisibility(View.GONE);
    }
}
