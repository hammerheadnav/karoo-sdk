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

package io.hammerhead.samplemodule.java.customspeed;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.Dependency;
import io.hammerhead.sdk.v0.datatype.SdkDataType;
import io.hammerhead.sdk.v0.datatype.formatter.BuiltInFormatter;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;
import io.hammerhead.sdk.v0.datatype.transformer.BuiltInTransformer;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class CustomSpeedDataType extends SdkDataType {
    public CustomSpeedDataType(SdkContext context) {
        super(context);
    }

    @NotNull
    @Override
    public String getTypeId() {
        return "custom-speed";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Custom Speed";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Shows speed in custom view";
    }

    @NotNull
    @Override
    public List<Dependency> getDependencies() {
        return Arrays.asList(Dependency.SPEED);
    }

    @Override
    public double getSampleValue() {
        return 13.0;
    }

    @NotNull
    @Override
    public SdkView newView() {
        return new CustomSpeedSdkView(getContext());
    }

    @NotNull
    @Override
    public SdkFormatter newFormatter() {
        return new BuiltInFormatter.Numeric(1);
    }

    @NotNull
    @Override
    public SdkTransformer newTransformer() {
        return new BuiltInTransformer.Identity(getContext());
    }
}
