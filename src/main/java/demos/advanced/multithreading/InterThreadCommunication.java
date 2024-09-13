package demos.advanced.multithreading;

/**
 * This class is a demo for interthread communication.
 */
class InterThreadCommunication {
    private static final long WAIT_TIME = 200;

    public static void main(String[] args) {
        Chat m = new Chat();
        new ChatClientThread(m, "Question", new String[]{"Hi", "How are you ?", "I am also doing fine!"});
        new ChatClientThread(m, "Answer", new String[]{"Hello", "I am good, what about you?", "Great!"});
    }

    static class Chat {
        boolean questionAnswerToggle = false;

        public synchronized void question(String clientName, String msg) {
            if (questionAnswerToggle) {
                try {
                    System.out.println("[" + clientName + "] waiting...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[" + clientName + "] " + msg);
            questionAnswerToggle = true;
            try {
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }

        public synchronized void answer(String clientName, String msg) {
            if (!questionAnswerToggle) {
                try {
                    System.out.println("[" + clientName + "] waiting...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[" + clientName + "] " + msg);
            questionAnswerToggle = false;
            try {
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            notify();
        }
    }

    static class ChatClientThread implements Runnable {
        private final String name;
        private final Chat m;
        private final String[] messages;

        public ChatClientThread(Chat chat, String name, String[] messages) {
            this.m = chat;
            this.name = name;
            this.messages = messages;
            new Thread(this, name).start();
        }

        public void run() {
            for (int i = 0; i < messages.length; i++) {
                if (this.name.equalsIgnoreCase("Question")) {
                    m.question(name, messages[i]);
                } else {
                    m.answer(name, messages[i]);
                }
            }
        }
    }

}
