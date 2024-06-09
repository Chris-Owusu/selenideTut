package org.week3;

import org.testng.annotations.Test;

public class SliderTest extends BaseTest {
    SliderPage sliderPage = new SliderPage();

    @Test
    public void sliderTest() {
        sliderPage.sliderBtn().click();
        sliderPage.moveSlider(50);
    }
}
