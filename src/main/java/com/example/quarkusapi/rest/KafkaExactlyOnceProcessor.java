package com.example.quarkusapi.rest;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.MutinyEmitter;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.Duration;
import java.util.Random;

@Singleton
public class KafkaExactlyOnceProcessor {

    @Inject
    Producer<String, Message> producer;

    @Inject
    Consumer<String, Message> consumer;



    public void send() {

        quoteRequestEmitter.send("dqwd");
    }

    private final Random random = new Random();

    @Outgoing("another-topic")
    public Multi<Double> generate() {
        // Build an infinite stream of random prices
        // It emits a price every second
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .map(x -> random.nextDouble());
    }
}
