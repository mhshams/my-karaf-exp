package my.sample.bactv;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

/**
 * @author mohammad shamsi <m.h.shams@gmail.com>
 */
public class MyBundleActivator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        log(context, "Starting Bundle: (" + getInfo(context.getBundle()) + ")");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        log(context, "Stopping Bundle: (" + getInfo(context.getBundle()) + ")");
    }

    private void log(BundleContext context, String message) {
        ServiceReference ref = context.getServiceReference(LogService.class.getName());

        if (ref != null) {
            LogService log = (LogService) context.getService(ref);
            log.log(LogService.LOG_INFO, message);

        } else {
            System.out.println(message);
        }
    }

    private String getInfo(Bundle bundle) {
        return bundle.getSymbolicName() + ": " + bundle.getVersion().toString();
    }
}