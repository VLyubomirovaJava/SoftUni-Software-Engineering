package StacksAndQueues;

import java.util.*;

public class HotPotatoAlternative {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
                 String[] kids = scanner.nextLine().split("\\s+");
                ArrayDeque<String> kidsQueue = new ArrayDeque<>();
                for (String kid : kids) {
                    kidsQueue.offer(kid);
                }

                int n = Integer.parseInt(scanner.nextLine());
                while (kidsQueue.size() > 1) {
                    for (int i = 1; i < n; i++) {
                        String currentChild = kidsQueue.poll();
                        kidsQueue.offer(currentChild);
                    }
                    String childToRemove = kidsQueue.poll();
                    System.out.println("Removed " + childToRemove);
                }

                //for (String s : kidsQueue) {
                System.out.println("Last is " + kidsQueue.poll());
                //}


            }
        }

/*    The names of the children are read from the user as a single line of input and stored in a String array called kids, using the split method to split the input string into an array of strings based on the delimiter "\s+". This delimiter is a regular expression that represents one or more whitespace characters, so it will split the input string wherever there is one or more consecutive whitespace characters.

    An ArrayDeque called kidsQueue is created and initialized with the names of the children using a for loop. For each kid in the kids array, the offer method is called on the kidsQueue to add the kid to the back of the queue.

    The value of n is read from the user as a single line of input using the nextLine method, and is then parsed to an int using the parseInt method of the Integer class.

    A while loop is used to repeat the following process until there is only one child left in the queue:
        A for loop is used to remove the front n-1 children from the queue and add them to the back. The loop runs n-1 times, and on each iteration it removes the front child from the queue using the poll method, and then adds the child to the back of the queue using the offer method.
        The nth child is removed from the front of the queue using the poll method, and their name is printed using the println method.

    The last child in the queue is removed using the poll method, and their name is printed using the println method.

This solution works by simulating the game of Hot Potato, where every nth child is removed from the circle, and the game continues until there is only one child left. The kidsQueue is used to represent the circle of children, and the poll and offer methods are used to remove and add children to the queue, respectively. The while loop is used to repeat the process of removing the nth child from the front of the queue until there is only one child left, and the for loop is used to move the other children to the back of the queue for consideration in the next iteration.*\

 */