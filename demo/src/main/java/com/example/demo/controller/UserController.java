package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.data.repository.UserRepository;
import java.util.List;
import com.example.demo.data.entity.User;
import org.springframework.ui.Model;
import com.example.demo.form.UserForm;


@Controller
public class UserController {

  // userRepositoryを使えるようにする
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/newuser")
  public String getNewUser(Model model){

    UserForm userForm = new UserForm();
    model.addAttribute("userForm", userForm);
    return "newuser";
  }

  // ユーザの新規登録をする
  @PostMapping("/newuser")
  // HTMLのimputタグで入力した値をUserFormとして受け取る
  public String registerUser(UserForm userForm){

    // 受け取った値をデータベースに保存するためEntiryにセットする
    // lombokの@Dataはsetter/getterメソッドで呼び出せるっぽい
    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());
    // 受け取った値をデータベースに保存する
    // save()はUserRepositoryのメソッドらしい=>save()だけでデータベースに登録できる
    userRepository.save(user);

    // usersテンプレートを表示する(redirectを記述する理由は不明..いらないのでは？)
    return "redirect:/users";
  }

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