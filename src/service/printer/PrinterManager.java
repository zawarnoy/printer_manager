package src.service.printer;

import org.springframework.stereotype.Service;
import src.service.document.DocumentProperties;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.io.File;

@Service
public class PrinterManager {

    // тут получаем принтеры
    private PrintService[] getPrinters() {
        return PrintServiceLookup.lookupPrintServices(null, null);
    }

    // смотрим по свойствам доки и подбираем подходящие принтеры
    public PrintService getPrinterByProperties(DocumentProperties properties) {
        return getPrinters()[0];
    }

    // http://qaru.site/questions/587732/java-printing-program-output-to-a-physical-printer
    // посмотри тут про печать
    public void printFile(File file) {
        PrintService printService = getPrinterByProperties(new DocumentProperties(file));



    }


}
