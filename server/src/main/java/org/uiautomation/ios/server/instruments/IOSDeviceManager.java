/*
 * Copyright 2012-2013 eBay Software Foundation and ios-driver committers
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.uiautomation.ios.server.instruments;

import org.uiautomation.ios.communication.device.DeviceType;
import org.uiautomation.ios.communication.device.DeviceVariation;
import org.uiautomation.ios.server.application.APPIOSApplication;

public interface IOSDeviceManager {

  public void install(APPIOSApplication aut);

  public void setL10N(String locale, String language);

  public void resetContentAndSettings();

  public void cleanupDevice();

  public void setKeyboardOptions();

  void setLocationPreference(boolean authorized);

  void setVariation(DeviceType device, DeviceVariation variation);

  String getDeviceSpecification(DeviceType device, DeviceVariation variation);

  void setMobileSafariOptions();

  void setSimulatorScale(String scale);

  void installTrustStore(String trustStore);
}
