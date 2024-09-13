package demos.advanced.multithreading;

public class SimpleWorker implements Runnable {
    private String name;
    private static Account account = new Account();
    public SimpleWorker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String key = "key";
        synchronized (key) {
            System.out.println("SimpleWorker '" + name + "' doing its thing");
            final int toWithdraw = 15;
            if (account.canWithdraw(toWithdraw)) {
                try {
                    //simulating a forced change of thread execution
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                account.withdraw(toWithdraw);
            }
            System.out.println("balance = " + account.balance);
        }
    }

    static class Account {
        int balance;

        public Account() {
            this.balance = 100;
        }
        boolean canWithdraw(int amount) {
            return balance - amount >= 0;
        }

        void withdraw(int amount) {
            this.balance -= amount;
            if (this.balance < 0) throw new IllegalStateException("Balance is negative: " + this.balance + '!');
        }
    }
}
