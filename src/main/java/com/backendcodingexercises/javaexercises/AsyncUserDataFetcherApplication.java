package com.backendcodingexercises.javaexercises;

import java.util.concurrent.CompletableFuture;

public class AsyncUserDataFetcherApplication {
    // Simulate a remote service call
    public static CompletableFuture<String> fetchUserData(long userId) {
        return CompletableFuture.supplyAsync(() -> {
            if (userId % 2 == 0) { // Simulate failure for even IDs
                throw new RuntimeException("Failed to fetch data for user " + userId);
            }
            return "UserData for " + userId;
        });
    }

    // Fetch data for two user IDs concurrently and combine results
    public static CompletableFuture<String> fetchAndCombineUserData(long userId1, long userId2) {
        var future1 = fetchUserData(userId1)
                .exceptionally(ex -> "Error1: " + ex.getMessage());

        var future2 = fetchUserData(userId2)
                .exceptionally(ex -> "Error2: " + ex.getMessage());

        return future1.thenCombine(future2,
                (data1, data2) -> "Data1: [" + data1 + "], Data2: [" + data2 + "]");
    }

    public static void main(String[] args) throws Exception {
        var combinedFuture = fetchAndCombineUserData(1L, 2L);
        System.out.println(combinedFuture.get()); // blocking for demo
    }
}
