package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.data.repository.UserRepository;
import java.util.List;
import com.example.demo.data.entity.User;
import org.springframework.ui.Model;


@Controller
public class UserController {

  // userRepositoryを使えるようにする
  @Autowired
  private UserRepository userRepository;

  // httpメソッドのGETメソッドのみ受け付けて/usersが指定されたら実行するっぽい
  // @RequestMapping(path = "/user", method = RequestMethod.GET)の省略形
  @GetMapping("/users")
  public String getUsers(Model model){

    // userRepositoryを使ってユーザのリストを取得する
    List<User> users = userRepository.findAll();

    // 取得したリストをテンプレートに渡す
    // modelクラスはHTMLテンプレートとjava側処理のデータ受け渡しをする
    // 第一引数には、テンプレート上で呼び出す時の名称を記述する
    // 第二引数には、valueを記述する。
    model.addAttribute("users", users);

    // users.htmlテンプレートを表示する
    return "users";
  }
  
}