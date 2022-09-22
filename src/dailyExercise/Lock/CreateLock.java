package dailyExercise.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: CreateLock
 * @Description:
 * @author: dk
 * @date: 2022/9/22 16:55
 */

public class CreateLock implements Lock {

    /**
     * 3. 重写 aqs 里面的方法，完成需求
     * aqs 里只有五个方法可以被重写
     * tryAcquire tryRelease  排他锁 加锁、解锁
     * tryAcquireShared  tryReleaseShared  共享锁 加锁 解锁
     * isHeldExclusively  当前线程是否被线程独占的方法
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        // 加锁
        protected boolean tryAcquire(int arg) {
            // 线程名字必须是 AQS-Lock 才能加锁
            if (!Thread.currentThread().getName().equals("AQS-Lock")) {
                return false;
            }
            if (compareAndSetState(0, arg)) {
                // 设置为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 解锁
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalStateException();
            }
            // 此处不用cas的原因是，既然要调用解锁，那自然是自身持有锁，有锁，代表自己有一个单独的私人线程
            // 所以不涉及多线程问题，无需cas
            setState(0);
            return true;
        }

        Condition getCondition(){
            return  new ConditionObject();
        }
    }

    private Sync sync = new Sync();

    @Override
    public void lock() {
        // 使用的是  AbstractQueuedSynchronizer 的acquire 方法
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return sync.getCondition();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }


}
