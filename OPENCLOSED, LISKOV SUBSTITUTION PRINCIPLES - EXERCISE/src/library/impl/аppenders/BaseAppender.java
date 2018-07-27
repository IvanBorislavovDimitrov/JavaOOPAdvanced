package library.impl.аppenders;

import library.api.Appender;
import library.api.Layout;
import library.enums.ReportLevel;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    protected int messages;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        if (reportLevel != null) {
            this.reportLevel = reportLevel;
        }
    }

    protected ReportLevel getReportLevel() {
        return this.reportLevel;
    }
}
