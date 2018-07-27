package library.factories;

import library.api.Appender;
import library.api.Layout;
import library.enums.ReportLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AppenderFactory {

    private static final String PATH = "library.impl.аppenders.";
    private static final String CLASS_IS_MISSING = "Class is missing";

    private AppenderFactory() {

    }

    @SuppressWarnings("unchecked")
    public static Appender create(String appenderType, String layoutType, ReportLevel reportLevel) {
        Layout layout = LayoutFactory.create(layoutType);

        try {
            Class<Appender> appenderClass = (Class<Appender>) Class.forName(PATH + appenderType);

            Constructor<Appender> appenderConstructor = appenderClass.getDeclaredConstructor(Layout.class);

            Appender appender = appenderConstructor.newInstance(layout);
            appender.setReportLevel(reportLevel);

            return appender;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException(CLASS_IS_MISSING);
    }
}
