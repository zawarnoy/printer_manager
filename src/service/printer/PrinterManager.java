package src.service.printer;

import org.springframework.stereotype.Service;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

@Service
public class PrinterManager {

    // тут получаем принтеры
    public PrintService[] getPrinters() {
        return PrintServiceLookup.lookupPrintServices(null, null);
    }
}
