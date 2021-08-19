import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String topLine = "____________________________________________________________\n";
        String bottomLine = "____________________________________________________________";
        String startUp = "Hello! I'm Duke\n"
                + "What can I do for you?\n";
        Task[] list = new Task[100];
        int count = 0;
        Scanner myObj = new Scanner(System.in);

        System.out.println(topLine + startUp + bottomLine);

        while(true) {
            String input = myObj.nextLine();

            if (input.startsWith("todo")) {
                String item = input.substring(5);
                list[count] = new Todo(item);
                count++;
                System.out.println(topLine + " Got it. I've added this task:\n" + " " + list[count - 1] + System.lineSeparator() + " Now you have " + count + " tasks in the list.\n" + bottomLine);
            } else if (input.startsWith("deadline")) {
                String item = input.substring(9, input.indexOf("/by ") - 1);
                String date = input.substring(input.indexOf("/by ") + 4);
                list[count] = new Deadline(item, date);
                count++;
                System.out.println(topLine + " Got it. I've added this task:\n" + " " + list[count - 1] + System.lineSeparator() + " Now you have " + count + " tasks in the list.\n" + bottomLine);
            } else if (input.startsWith("event")) {
                String item = input.substring(6, input.indexOf("/at ") - 1);
                String date = input.substring(input.indexOf("/at ") + 4);
                list[count] = new Event(item, date);
                count++;
                System.out.println(topLine + " Got it. I've added this task:\n" + " " + list[count - 1] + System.lineSeparator() + " Now you have " + count + " tasks in the list.\n" + bottomLine);
            } else if (input.startsWith("done")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                list[index].setDone();
                System.out.println(topLine + "Nice! I've marked this task as done:\n" + list[index] + System.lineSeparator() + bottomLine);
                continue;
            } else if (input.equals("list")) {
                System.out.print(topLine);
                for (int i = 0; i < list.length; i++) {
                    if (list[i] == null) {
                        break;
                    }
                    System.out.println(" " + (i + 1) + ". " + list[i]);
                }
                System.out.print(topLine);
                continue;
            } else if (input.equals("bye")) {
                System.out.println(topLine + "Bye. Hope to see you again soon!" + System.lineSeparator() + bottomLine);
                break;
            } else {
                System.out.println(topLine + "No such command.\n" + bottomLine);
                continue;
            }




        }
    }
}
