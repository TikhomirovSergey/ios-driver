/*
 * Copyright 2012 ios-driver committers.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the Licence at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License
 *  is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied. See the License for the specific language governing permissions and limitations under
 *  the License.
 */

package org.uiautomation.ios.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiautomation.ios.UIAModels.UIAElement;
import org.uiautomation.ios.UIAModels.configuration.WorkingMode;
import org.uiautomation.ios.UIAModels.predicate.AndCriteria;
import org.uiautomation.ios.UIAModels.predicate.Criteria;
import org.uiautomation.ios.UIAModels.predicate.LocationCriteria;
import org.uiautomation.ios.UIAModels.predicate.TypeCriteria;

public class MultiWindowTest extends BaseSeleniumTest {

  @Test
  public void canSwitchBetweenWindows() {
    driver.get(appServer.whereIs("click_frames.html"));
    //http://localhost:7694/common/click_frames.html
    driver.switchTo().frame("source");

    driver.findElement(By.id("new-window")).click();
    driver.switchTo().defaultContent();

    // native + 2 web windows.
    Assert.assertEquals(driver.getWindowHandles().size(), 3);

    Assert.assertEquals(driver.getTitle(), "click frames");
    Assert.assertTrue(driver.getCurrentUrl().endsWith("click_frames.html"));
    driver.switchTo().window("Web_2");
    Assert.assertEquals(driver.getTitle(), "XHTML Test Page");
    Assert.assertTrue(driver.getCurrentUrl().endsWith("xhtmlTest.html"));
    driver.switchTo().window("Web_1");
    Assert.assertEquals(driver.getTitle(), "click frames");
    Assert.assertTrue(driver.getCurrentUrl().endsWith("click_frames.html"));

  }

  @Test
  public void canNavigateBetweenWindows() throws InterruptedException {
    driver.get(appServer.whereIs("click_frames.html"));
    //http://localhost:7694/common/click_frames.html
    driver.switchTo().frame("source");

    driver.findElement(By.id("new-window")).click();
    //Thread.sleep(5000);
    driver.switchTo().window(WorkingMode.Native.toString());
    long start = System.currentTimeMillis();
    driver.executeScript("new SafariPageNavigator().enter().next(2);");
    System.out.println("duration : " + (System.currentTimeMillis() - start) + "ms");
    //Thread.sleep(5000);

  }


  public static void main(String[] args) {

    Criteria c = new AndCriteria(new TypeCriteria(UIAElement.class), new LocationCriteria(0, 10));

    System.out.println(c.stringify());

  }


}