package service;

import entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User loginByNameAndPassword(String name,String password);

}