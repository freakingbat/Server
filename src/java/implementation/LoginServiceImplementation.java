/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import diets.api.LoginService;
import diets.objects.DietBase;
import diets.objects.User;
import org.hibernate.Session;

/**
 *В этом классе происходит реализация методов из Loginervice
 * @author Bat
 */
public class LoginServiceImplementation implements LoginService{

   @Override
    public void newUser(User user) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setWord(BCrypt.hashpw(user.getWord(), BCrypt.gensalt()));
        session.save(user);
        session.getTransaction().commit();
    }
    }

     @Override
    public User getUser(String login) {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      User user = (User)session.createQuery("SELECT E FROM user E WHERE E.login = :login").uniqueResult();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return user;
     
    }
    
    @Override
    public String logIn(String login, String pass) {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login = :login")
                .setParameter("login", login)
                .uniqueResult();
        
        if(user!=null){
            if(pass == null ? user.getPassword() == null : BCrypt.checkpw(pass, user.getPassword())){
                return "грусть";
            } else {
                throw new VerifyError("Неверный пароль");
            }
        } else {
            throw new VerifyError("Не существует пользователя с таким логином.");
        }
    }

    @Override
    public String Check(String login, String word) {
         Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login = :login")
                .setParameter("login", login)
                .uniqueResult();
        
        if(user!=null){
            if(word == null ? user.getWord() == null : BCrypt.checkpw(word, user.getWord())){
                return "грусть";
            } else {
                throw new VerifyError("Неверный пароль");
            }
        } else {
            throw new VerifyError("Не существует пользователя с таким логином.");
        }
    }
}


