/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import diets.api.DataService;
import diets.objects.Advice;
import diets.objects.DietBase;
import diets.objects.Gym;
import diets.objects.Shop;
import diets.objects.Shop1;
import diets.objects.RecipeDessert;
import diets.objects.RecipeDrink;
import diets.objects.RecipeMain;
import diets.objects.RecipeMeat;
import diets.objects.RecipeSoup;
import java.util.List;
import org.hibernate.Session;
/**
 * В этом классе происходит реализация методов из DataService
 * @author User
 */
public class DataServiceImplementation implements DataService {

  
    
    
       
    @Override
    public List<DietBase> getDietBases() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<DietBase> diets = session.createQuery("SELECT E FROM dietBase E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return diets;
     
    }
    
    @Override
    public DietBase getDiet(String name) {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      DietBase diet = (DietBase)session.createQuery("SELECT E FROM dietBase E WHERE E.name = :name").uniqueResult();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return diet;
     
    }

     @Override
    public void newDiet(DietBase diet) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(diet);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<Shop> getShop() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<Shop> shops = session.createQuery("SELECT E FROM PP E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return shops;
     
    }
    @Override
    public void newShop(Shop shop) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(shop);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<Shop1> getShop1() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<Shop1> shops1 = session.createQuery("SELECT E FROM Veg E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return shops1;
    }
     

    @Override
    public void newShop1(Shop1 shop1) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(shop1);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<Gym> getGym() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<Gym> gyms = session.createQuery("SELECT E FROM gym E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return gyms;
    }
     

    @Override
    public void newGym(Gym gym) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(gym);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<RecipeMeat> getRecipeMeat() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<RecipeMeat> meats = session.createQuery("SELECT E FROM recipeMeat E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return meats;
    }

    @Override
    public void newRecipeMeat(RecipeMeat meat) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(meat);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<RecipeMain> getRecipeMain() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<RecipeMain> mains = session.createQuery("SELECT E FROM recipeMain E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return mains;
    }
    @Override
    public void newRecipeMain(RecipeMain main) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(main);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<RecipeDrink> getRecipeDrink() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<RecipeDrink> drinks = session.createQuery("SELECT E FROM recipeDrink E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return drinks;
    }

    @Override
    public void newRecipeDrink(RecipeDrink drink) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(drink);
        session.getTransaction().commit();
    }
    }
    @Override
    public List<RecipeSoup> getRecipeSoup() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<RecipeSoup> soups = session.createQuery("SELECT E FROM recipeSoup E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return soups;
    }
    @Override
    public void newRecipeSoup(RecipeSoup soup) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(soup);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<RecipeDessert> getRecipeDessert() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<RecipeDessert> desserts = session.createQuery("SELECT E FROM recipeDessert E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return desserts;
    }

    @Override
    public void newRecipeDessert(RecipeDessert dessert) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(dessert);
        session.getTransaction().commit();
    }
    }

  @Override
    public List<Advice> getAdvice() {
      Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<Advice> advices = session.createQuery("SELECT E FROM advice E").getResultList();
      session.getTransaction().commit();
      if (session.isOpen()){
          session.close();
      }
     return advices;
    }
   @Override
    public void newAdvice(Advice advice) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.save(advice);
        session.getTransaction().commit();
    }
    }

    @Override
    public void updateDietBase(DietBase diet, Long id) {
       Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       DietBase updiet = (DietBase) session.createQuery("SELECT E FROM dietBase E WHERE E.id =:id").uniqueResult();
       session.update(diet);
       session.getTransaction().commit();
       if (session.isOpen()){
          session.close();
      }
    }
    

    
}

