package com.itsgifty.user.service;

import com.itsgifty.user.VO.Department;
import com.itsgifty.user.VO.ResponseTemplateVO;
import com.itsgifty.user.entity.User;
import com.itsgifty.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("inside save user of user service");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartmentId(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        log.info("inside save user of user service");
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
