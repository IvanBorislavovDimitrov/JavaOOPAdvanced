package library.impl.аppenders;

import library.api.Layout;
import library.enums.ReportLevel;
import library.io.impl.OutputWriteImpl;
import library.io.interfaces.OutputWriter;

public class ConsoleAppender extends BaseAppender  {

    private OutputWriter outputWriter;

    public ConsoleAppender(Layout layout) {
        super(layout);
        this.outputWriter = new OutputWriteImpl();
        this.messages = 0;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.getReportLevel().ordinal() <= reportLevel.ordinal()) {
            String log = this.getLayout().format(time, message, reportLevel.name());
            this.messages++;
            this.outputWriter.writeLine(log);
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type:" +
                " %s, Report level: %s, Messages appended: %d", this.getClass().getSimpleName(),
                super.getLayout().getClass().getSimpleName(),
                super.getReportLevel().name(), this.messages);
    }
}
