package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootTest
@EnableScheduling
class DemoApplicationTests {
	private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

	@Scheduled(initialDelay = 0, fixedRate = Long.MAX_VALUE)
	public void addValue() {
		blockingQueue.add(0);
	}

	@Test
	public void test() throws InterruptedException {
		assertEquals(0, blockingQueue.take());
	}
}
