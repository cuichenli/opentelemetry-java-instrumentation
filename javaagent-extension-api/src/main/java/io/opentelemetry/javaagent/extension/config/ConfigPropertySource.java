/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.extension.config;

import io.opentelemetry.javaagent.extension.Ordered;
import io.opentelemetry.sdk.autoconfigure.spi.AutoConfigurationCustomizer;
import io.opentelemetry.sdk.autoconfigure.spi.AutoConfigurationCustomizerProvider;
import java.util.Map;
import java.util.function.Supplier;

/**
 * A service provider that allows to override default OTel agent configuration. Properties returned
 * by implementations of this interface will be used after the following methods fail to find a
 * non-empty property value: system properties, environment variables, properties configuration
 * file.
 *
 * <p>This is a service provider interface that requires implementations to be registered in a
 * provider-configuration file stored in the {@code META-INF/services} resource directory.
 *
 * @deprecated Use the {@link AutoConfigurationCustomizerProvider} and {@link
 *     AutoConfigurationCustomizer#addPropertiesSupplier(Supplier)} instead.
 */
@Deprecated
public interface ConfigPropertySource extends Ordered {

  /**
   * Returns all properties whose default values are overridden by this property source. Key of the
   * map is the propertyName (same as system property name, e.g. {@code otel.traces.exporter}),
   * value is the property value.
   */
  Map<String, String> getProperties();
}