package com.sentinels.manage.domain.Users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    static final String UPDATE_USERS_LAST_LOGIN = "UPDATE Users SET LAST_LOGIN_TIME = : lastLoginTime WHERE USERID = : userId";

    @Transactional
    @Modifying
    @Query(value = UPDATE_USERS_LAST_LOGIN, nativeQuery = true)
    public int updateUsersLastLogin(@Param("userId") String userId, @Param("lastLoginTime")LocalDateTime lastLoginTime);

    public Users findByUserid(String userId);
}
