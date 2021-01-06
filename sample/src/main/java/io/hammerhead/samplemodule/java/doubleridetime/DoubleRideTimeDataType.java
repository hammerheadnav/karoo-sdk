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
package io.hammerhead.samplemodule.java.doubleridetime;

import android.graphics.drawable.Drawable;

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

public class DoubleRideTimeDataType extends SdkDataType {
    public DoubleRideTimeDataType(SdkContext context) {
        super(context);
    }

    @Override
    public String getTypeId() {
        return "double-ride-time";
    }

    @Override
    public String getDisplayName() {
        return "RideTimeX2";
    }

    @Override
    public String getDescription() {
        return "Takes the ride time and doubles it";
    }

    @Override
    public List<Drawable> displayIcons() {
        return Arrays.asList(getContext().getDrawable(R.drawable.ic_double_ride_time));
    }

    @Override
    public boolean getSummaryField() {
        return true;
    }

    @Override
    public List<Dependency> getDependencies() {
        return Arrays.asList(Dependency.RIDE_TIME);
    }

    @Override
    public double getSampleValue() {
        return 11.0;
    }

    @Override
    public SdkView newView() {
        return new BuiltInView.Numeric(getContext());
    }

    @Override
    public SdkFormatter newFormatter() {
        return new BuiltInFormatter.Numeric(0);
    }

    @Override
    public SdkTransformer newTransformer() {
        return new DoubleRideTimeTransformer(getContext());
    }
}
