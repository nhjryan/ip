package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {

    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.printTemplate(" Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
