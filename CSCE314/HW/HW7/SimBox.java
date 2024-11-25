
/* Written by Hyunyoung Lee for CSCE 314 Students Homework 7 Problem 3
   First, study how this class should work with the test code in SimMain.java
   carefully!

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: Stack Overflow, GeeksforGeeks, Classnotes
*/

import java.util.*;

class SimBox implements Runnable {
  static final int MAX_SIZE = 10;

  class Message {
    String sender;
    String recipient;
    String msg;
    Message(String sender, String recipient, String msg) {
      this.sender = sender;
      this.recipient = recipient;
      this.msg = msg;
    }
  }

  private final LinkedList<Message> messages;
  private final LinkedList<Message> myMessages;
  private String myId;
  private boolean stop = false;

  public SimBox(String myId) {
    messages = new LinkedList<Message>();
    this.myId = myId;
    this.myMessages = new LinkedList<Message>();
    new Thread(this).start();
  }

  public SimBox(String myId, SimBox s) {
    this.messages = s.messages;
    this.myId = myId;
    this.myMessages = new LinkedList<Message>();
    new Thread(this).start();
  }

  public String getId() { return myId; }

  public void stop() {
    synchronized (this) {
      stop = true;
    }
  }

  /**
   * Sends a message to the specified recipient.
   *
   * <p>This method adds a message to the shared message queue. The message queue
   * is synchronized to ensure thread safety.</p>
   *
   * @param recipient the recipient of the message
   * @param msg the message content to be sent
   */
  public void send(String recipient, String msg) {
    // add a message to the shared message queue (messages)
    // you will have to synchronize the message queue
    synchronized (messages) {
      messages.add(new Message(myId, recipient, msg));
    }
  }

  public List<String> retrieve() {
    // return the contents of myMessages
    // and empty myMessages
    // you will have to synchronize myMessages
    // each message should be in the following format:
    //   From (the sender) to (the recipient) (actual message)
    synchronized (myMessages) {
      List<String> result = new ArrayList<>();
      for (Message m : myMessages) {
        result.add("From " + m.sender + " to " + m.recipient + ": " + m.msg);
      }
      myMessages.clear();
      return result;
    }
  }

  /**
   * Continuously processes messages for the mailbox.
   * 
   * This method runs indefinitely, performing the following tasks approximately once every second:
   * 1. Moves all messages addressed to this mailbox from the shared message queue to the private myMessages queue.
   *    - Synchronizes access to both messages and myMessages.
   *    - Uses an iterator to traverse the messages queue.
   *    - If a message's recipient matches myId, the message is moved to myMessages and removed from messages.
   * 2. Ensures the size of the messages queue does not exceed MAX_SIZE.
   *    - If the queue size exceeds MAX_SIZE, the oldest messages are removed until the size is at most MAX_SIZE.
   * 
   * The method will stop processing if the stop flag is set to true.
   * 
   * Note: The method includes a try-catch block to handle InterruptedException during the sleep interval.
   */
  public void run() {
  // loop forever
  // 1. Approximately once every second move all messages
  //    addressed to this mailbox from the shared message queue
  //    to the private myMessages queue
  //    To do so, you need to synchronize messages and myMessages.
  //    Furthermore, you need to explicitly use the iterator() of messages
  //    with a while loop.  A for-each loop will not work here.
  // 2. Also approximately once every second, if the message
  //    queue has more than MAX_SIZE messages, delete oldest messages
  //    so that size is at most MAX_SIZE. This part of code is provided
  //    below.

    for(;;) { // loop forever
      // synchronize messages and myMessages

      // have the iterator of messages referred by iter of
      // type Iterator<Message>

      // while there is more to access on iter, access the message

      // if the message's recipient is equal to myId, then remove the
      // message from messages and add the message to myMessages
      synchronized (messages) {
        synchronized (myMessages) {
          Iterator<Message> iter = messages.iterator();
          while (iter.hasNext()) {
            Message m = iter.next();
            if (m.recipient.equals(myId)) {
              myMessages.add(m);
              iter.remove();
            }
          }
        }
      }
      // end of synchronized myMessages
      while (messages.size() > MAX_SIZE) { messages.removeFirst(); }
      // end of synchronized messages
      if (stop) return;
      try { Thread.sleep(1000); } catch (InterruptedException e) {}
    } // endfor
  } // end run()
} // end SimBox


