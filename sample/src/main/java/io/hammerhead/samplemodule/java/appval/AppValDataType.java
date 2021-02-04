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
package io.hammerhead.samplemodule.java.appval;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.Dependency;
import io.hammerhead.sdk.v0.datatype.SdkDataType;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;
import io.hammerhead.sdk.v0.datatype.view.BuiltInView;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class AppValDataType extends SdkDataType {
    public AppValDataType(SdkContext context) {
        super(context);
    }

    @NotNull
    @Override
    public String getTypeId() {
        return "appval";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "AppVal";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Shows a value from app";
    }

    @NotNull
    @Override
    public List<Dependency> getDependencies() {
        return Arrays.asList(Dependency.INTERVAL);
    }

    @Override
    public double getSampleValue() {
        return 22.0;
    }

    @NotNull
    @Override
    public SdkView newView() {
        return new BuiltInView.Numeric(getContext());
    }

    @NotNull
    @Override
    public SdkFormatter newFormatter() {
        return new AppValFormatter();
    }

    @NotNull
    @Override
    public SdkTransformer newTransformer() {
        return new AppValTransformer(getContext());
    }
}
