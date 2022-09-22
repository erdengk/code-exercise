package dailyExercise.Lock;

/**
 * @ClassName: TestCreatLock
 * @Description:
 * @author: dk
 * @date: 2022/9/22 16:56
 */

public class TestCreatLock {
    private static CreateLock createLock = new CreateLock();

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            testLock();
            while (true) {

            }
        });
        Thread B = new Thread(() -> {
            testLock();
        });

        //  只有 A 能拿到锁，因为加锁限制了线程名字
        A.setName("AQS-Lock");
        B.setName("Lock");

        A.start();
        B.start();
    }

    private static void testLock() {
        createLock.lock();
        try {
            System.out.println("当前获取到锁的线程名称是："
                    + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            createLock.unlock();
        }
    }
}
