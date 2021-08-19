import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String startUp = " Hello! I'm Duke\n"
                + " What can I do for you?";
        ArrayList<Task> list = new ArrayList<>();
        Scanner myObj = new Scanner(System.in);

        msgTemplate(startUp);

        while(true) {
            String input = myObj.nextLine();

            if (input.startsWith("todo")) {
                String item = input.substring(5);
                list.add(new Todo(item));
                msgTemplate(" Got it. I've added this task:\n" + "  " + list.get(list.size() - 1) + System.lineSeparator() + " Now you have " + list.size() + " tasks in the list.");
            } else if (input.startsWith("deadline")) {
                String item = input.substring(9, input.indexOf("/by ") - 1);
                String date = input.substring(input.indexOf("/by ") + 4);
                list.add(new Deadline(item, date));
                msgTemplate(" Got it. I've added this task:\n" + "  " + list.get(list.size() - 1) + System.lineSeparator() + " Now you have " + list.size() + " tasks in the list.");
            } else if (input.startsWith("event")) {
                String item = input.substring(6, input.indexOf("/at ") - 1);
                String date = input.substring(input.indexOf("/at ") + 4);
                list.add(new Event(item, date));
                msgTemplate(" Got it. I've added this task:\n" + "  " + list.get(list.size() - 1) + System.lineSeparator() + " Now you have " + list.size() + " tasks in the list.");
            } else if (input.startsWith("done")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                list.get(index).setDone();
                msgTemplate(" Nice! I've marked this task as done:\n" + "  " + list.get(index));
            } else if (input.startsWith("delete")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                Task task = list.get(index);
                list.remove(index);
                msgTemplate(" Noted. I've removed this task:\n" + "  " + task + System.lineSeparator() + " Now you have " + list.size() + " tasks in the list.");
            } else if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(" " + (i + 1) + "." + list.get(i));
                }
                System.out.println("____________________________________________________________");
            } else if (input.equals("bye")) {
                msgTemplate(" Bye. Hope to see you again soon!");
                break;
            } else {
                msgTemplate(" No such command.");
            }
        }
    }

    public static void msgTemplate(String msg){
        String topLine = "____________________________________________________________\n";
        String bottomLine = "____________________________________________________________";
        System.out.println(topLine + msg + System.lineSeparator() + bottomLine);
    }
}
