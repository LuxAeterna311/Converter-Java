package ru.currency.converter.repository;

import org.springframework.data.repository.CrudRepository;

import ru.currency.converter.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
