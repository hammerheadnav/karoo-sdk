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

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.hammerhead.sample.R;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class CustomSpeedSdkView extends SdkView {
    public CustomSpeedSdkView(Context context) {
        super(context);
    }

    private static final double MAX_SPEED = 17.0; // mps

    @NotNull
    @Override
    public View createView(LayoutInflater layoutInflater, @NotNull ViewGroup parent) {
        return layoutInflater.inflate(R.layout.custom_speed_view, parent, false);
    }

    @Override
    public void onUpdate(@NotNull View view, double value, @Nullable String formattedValue) {
        TextView statusText = view.findViewById(R.id.status_text);
        statusText.setVisibility(View.GONE);
        if (formattedValue != null) {
            TextView speedText = view.findViewById(R.id.speed_text);
            speedText.setVisibility(View.VISIBLE);
            speedText.setText(formattedValue);
        }
        CircularProgressBar speedGauge = view.findViewById(R.id.speed_gauge);
        speedGauge.setVisibility(View.VISIBLE);
        double progressPct = (value / MAX_SPEED) * 100f;
        if (progressPct > 100.0) {
            progressPct = 100.0;
        }
        speedGauge.setProgress((float) progressPct);
    }

    @Override
    public void onInvalid(View view) {
        TextView statusText = view.findViewById(R.id.status_text);
        statusText.setVisibility(View.VISIBLE);
        statusText.setText(getContext().getString(R.string.disconnected));
        TextView speedText = view.findViewById(R.id.speed_text);
        speedText.setVisibility(View.GONE);
        CircularProgressBar speedGauge = view.findViewById(R.id.speed_gauge);
        speedGauge.setVisibility(View.GONE);
    }
}
