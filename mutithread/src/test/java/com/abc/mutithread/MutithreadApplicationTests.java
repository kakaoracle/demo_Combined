package com.abc.mutithread;

import java.util.LinkedList;


class MutithreadApplicationTests {

    // 野怪活动的野区
    private static final LinkedList<String> wildMonsterArea = new LinkedList<String>();

    public static void main(String[] args) {
        Thread wildMonsterProducerThread = new Thread(new WildMonsterProducer());
        Thread lanLingWangThread = new Thread(new LanLingWang());

        wildMonsterProducerThread.start();
        lanLingWangThread.start();
    }


    // 野怪投放【生产者】
    public static class WildMonsterProducer implements Runnable {
        public void run() {
            try {
                createWildMonster();
            } catch (InterruptedException e) {
                System.out.println("野怪投放被中断");
            }
        }

        //投放野怪，每1秒检查一次
        public void createWildMonster() throws InterruptedException {
            for (int i = 0;; i++) {
                synchronized(wildMonsterArea) {
                    if (wildMonsterArea.size() == 0) {
                        wildMonsterArea.add("野怪" + i);
                        System.out.println(wildMonsterArea.getLast());
                        wildMonsterArea.notify();
                    }
                }
                Thread.sleep(1000);
            }
        }
    }


    // 兰陵王，打野英雄
    public static class LanLingWang implements Runnable {
        public void run() {
            try {
                attackWildMonster();
            } catch (InterruptedException e) {
                System.out.println("兰陵王打野被中断");
            }
        }

        // 打野，如果没有则进行等待
        public void attackWildMonster() throws InterruptedException {
            while (true) {
                synchronized(wildMonsterArea) {
                    if (wildMonsterArea.size() == 0) {
                        wildMonsterArea.wait();
                    }
                    String wildMonster = wildMonsterArea.getLast();
                    wildMonsterArea.remove(wildMonster);
                    System.out.println("收获野怪：" + wildMonster);
                }
            }
        }
    }
}




