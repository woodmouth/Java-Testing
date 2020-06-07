package com.edwin;

public class ThreadSafetySample {
    private int sharedState;

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetySample sample = new ThreadSafetySample();
        Thread threadA = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sample.nonSafeAction();
            }
        };
        Thread threadB = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sample.nonSafeAction();
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }

    public void nonSafeAction() {
        while (sharedState < 100000) {
//            synchronized (this) {
//                int former = sharedState++;
//                int latter = sharedState;
//                if (former != latter - 1) {
//                    System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
//                }
//            }
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
            }
        }
    }
}
