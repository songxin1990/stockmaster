package com.songxin.stock.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Scheduler {

	final private Logger logger = LoggerFactory.getLogger(getClass());

	final AtomicLong threadId = new AtomicLong(0);

	final ScheduledThreadPoolExecutor executor;

	final String baseThreadName;

	public Scheduler(int numThreads, final String baseThreadName,
			final boolean isDaemon) {
		this.baseThreadName = baseThreadName;
		executor = new ScheduledThreadPoolExecutor(numThreads,
				new ThreadFactory() {

					public Thread newThread(Runnable r) {
						Thread t = new Thread(r, baseThreadName
								+ threadId.getAndIncrement());
						t.setDaemon(isDaemon);
						return t;
					}
				});
		executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
		executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
	}

	public ScheduledFuture<?> scheduleWithRate(Runnable command, long delayMs,
			long periodMs) {
		return executor.scheduleAtFixedRate(command, delayMs, periodMs,
				TimeUnit.MILLISECONDS);
	}

	public void shutdownNow() {
		executor.shutdownNow();
		logger.info("ShutdownNow scheduler {} with {} threads.",
				baseThreadName, threadId.get());
	}

	public void shutdown() {
		executor.shutdown();
		logger.info("Shutdown scheduler {} with {} threads.", baseThreadName,
				threadId.get());
	}
}
