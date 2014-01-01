package my.sample.command;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;


/**
 * @author mohammad shamsi <m.h.shams@gmail.com>
 */
@Command(scope = "my", name = "list", description = "a sample command")
public class ListCommand extends OsgiCommandSupport {

    @Argument(index = 0, name = "arg", description = "a sample argument", required = false, multiValued = false)
    private String arg = null;

    protected Object doExecute() throws Exception {
         System.out.println("Executing command: ListCommand");

         return new String[] {"Given parameter: ", arg == null ? "<not given>" : arg};
    }
}