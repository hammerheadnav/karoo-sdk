/**
 * Copyright (c) 2021 Hammerhead Navigation Inc.
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

package io.hammerhead.samplemodule.java.powerhr;

import android.graphics.drawable.Drawable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import io.hammerhead.sample.R;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.Dependency;
import io.hammerhead.sdk.v0.datatype.SdkDataType;
import io.hammerhead.sdk.v0.datatype.formatter.BuiltInFormatter;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;
import io.hammerhead.sdk.v0.datatype.view.BuiltInView;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class PowerHeartRateDataType extends SdkDataType {
    public PowerHeartRateDataType(@NotNull SdkContext context) {
        super(context);
    }

    @NotNull
    @Override
    public String getTypeId() {
        return "power-hr";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Power/HR";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Ratio of power / heart rate";
    }

    @Nullable
    @Override
    public List<Drawable> displayIcons() {
        return Arrays.asList(getContext().getDrawable(R.drawable.ic_power_hr));
    }

    @NotNull
    @Override
    public List<Dependency> getDependencies() {
        return Arrays.asList(Dependency.HEART_RATE, Dependency.POWER);
    }

    @Override
    public double getSampleValue() {
        return 1.25;
    }

    @NotNull
    @Override
    public SdkView newView() {
        return new BuiltInView.Numeric(getContext());
    }

    @NotNull
    @Override
    public SdkFormatter newFormatter() {
        return new BuiltInFormatter.Numeric(2);
    }

    @NotNull
    @Override
    public SdkTransformer newTransformer() {
        return new PowerHeartRateTransformer(getContext());
    }
}
