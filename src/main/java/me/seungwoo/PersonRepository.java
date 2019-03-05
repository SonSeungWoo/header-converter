package me.seungwoo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 15:22
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
