package com.blogadmin.kafka.config;

import org.apache.kafka.clients.consumer.RoundRobinAssignor;
import org.apache.kafka.clients.consumer.internals.AbstractPartitionAssignor;

public class CustomPartitionAssignor extends RoundRobinAssignor {
    // You can customize this class if needed
    // For now, you can keep it empty
}
