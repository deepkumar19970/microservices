package com.xb.rsc_api_gateway.repo;

import com.xb.rsc_api_gateway.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Mono;

@EnableMongoRepositories
public interface UserRepository extends ReactiveMongoRepository<User,Long> {

    Mono<User> findByUsername(String username);

}
