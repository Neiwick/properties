package ru.yandex.qatools.properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.properties.exeptions.PropertyLoaderException;
import ru.yandex.qatools.properties.testdata.ProxyPropertiesFactory;

/**
 * @author Artem Eroshenko eroshenkoam
 *         3/6/13, 4:38 PM
 */
public class IncorrectValuesOverridingTest {

    @Before
    public void setupSystemProperties() {
        System.setProperty("proxy.port", "aaa");
    }

    @Test(expected = PropertyLoaderException.class)
    public void checkIncorrectValueDontOverrideDefaultValue() {
        ProxyPropertiesFactory.createProxyPropertiesWithSystemOverride();
    }

    @After
    public void clearSystemProperties() {
        System.clearProperty("proxy.port");
    }

}
