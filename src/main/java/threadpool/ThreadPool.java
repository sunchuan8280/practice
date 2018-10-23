package threadpool;

public interface ThreadPool<Job extends Runnable> {
    void excute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();
}
