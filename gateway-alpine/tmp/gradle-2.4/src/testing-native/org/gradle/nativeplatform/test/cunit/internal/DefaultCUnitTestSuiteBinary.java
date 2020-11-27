/*
 * Copyright 2014 the original author or authors.
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

package org.gradle.nativeplatform.test.cunit.internal;

import org.gradle.api.internal.project.taskfactory.ITaskFactory;
import org.gradle.internal.reflect.Instantiator;
import org.gradle.nativeplatform.NativeComponentSpec;
import org.gradle.nativeplatform.internal.NativeBinarySpecInternal;
import org.gradle.nativeplatform.internal.resolve.NativeDependencyResolver;
import org.gradle.nativeplatform.test.cunit.CUnitTestSuiteBinarySpec;
import org.gradle.nativeplatform.test.cunit.CUnitTestSuiteSpec;
import org.gradle.nativeplatform.test.internal.DefaultNativeTestSuiteBinarySpec;
import org.gradle.platform.base.binary.BaseBinarySpec;
import org.gradle.platform.base.internal.BinaryNamingScheme;

public class DefaultCUnitTestSuiteBinary extends DefaultNativeTestSuiteBinarySpec implements CUnitTestSuiteBinarySpec {

    public static DefaultCUnitTestSuiteBinary create(NativeComponentSpec owner, NativeBinarySpecInternal testedBinary, BinaryNamingScheme namingScheme, NativeDependencyResolver resolver, Instantiator instantiator, ITaskFactory taskFactory) {
        DefaultCUnitTestSuiteBinary spec = BaseBinarySpec.create(DefaultCUnitTestSuiteBinary.class, namingScheme.getLifecycleTaskName(), instantiator, taskFactory);
        spec.setComponent(owner);
        spec.setTestedBinary(testedBinary);
        spec.setNamingScheme(namingScheme);
        spec.setResolver(resolver);
        return spec;
    }

    @Override
    public CUnitTestSuiteSpec getTestSuite() {
        return getComponent();
    }

    @Override
    public CUnitTestSuiteSpec getComponent() {
        return (CUnitTestSuiteSpec) super.getComponent();
    }
}
